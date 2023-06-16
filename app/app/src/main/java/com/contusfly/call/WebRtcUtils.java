package com.contusfly.call;
import com.mirrorflysdk.flycommons.SharedPreferenceManager;
import com.mirrorflysdk.flycall.webrtc.Logger;
import com.mirrorflysdk.models.Turn;
import com.mirrorflysdk.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;
import org.webrtc.PeerConnection;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * This class contains utility functions for WebRtc
 *
 * @author ContusTeam <developers@contus.in>
 * @version 2.0
 */
public class WebRtcUtils {

    /**
     * Log tag
     */
    private static final String TAG = WebRtcUtils.class.getSimpleName();

    private WebRtcUtils() {
    }

    /**
     * This method returns the list of ICE servers.
     *
     * @return list of {@link PeerConnection.IceServer} objects
     */
    public static List<PeerConnection.IceServer> getIceServers() {

        List<PeerConnection.IceServer> iceServers = new ArrayList<>();
        List<String> iceServersList;
        List<Turn> turnServerList;
        iceServersList = getStunServersFromPreference();
        turnServerList = getTurnServersFromPreference();
        /* Adding ICE(STUN,TURN) servers */
        for (String iceServer : iceServersList) {
            iceServers.add(PeerConnection.IceServer.builder(iceServer).createIceServer());
        }

        for (Turn turn : turnServerList) {
            iceServers.add(PeerConnection.IceServer
                    .builder(turn.getTurnServer())
                    .setUsername(turn.getTurnUserName())
                    .setPassword(turn.getTurnPassword())
                    .createIceServer());
        }

        return iceServers;
    }


    private static ArrayList<String> getStunServersFromPreference() {
        String stunServersFromPreference =
                SharedPreferenceManager.instance.getString(SharedPreferenceManager.STUNS);
        Type collectionType = new TypeToken<ArrayList<String>>() {
        }.getType();
        ArrayList<String> stunServers = new Gson().fromJson(stunServersFromPreference, collectionType);
        if (stunServers == null) {
            stunServers = new ArrayList<>();
        }
        Logger.d(TAG, "getStunServersFromPreference: " + stunServers.toString());
        return stunServers;

    }

    private static List<Turn> getTurnServersFromPreference() {
        String turnServersFromPreference =
                Utils.returnEmptyStringIfNull(SharedPreferenceManager.instance.getString(SharedPreferenceManager.TURNS));
        Type collectionType = new TypeToken<ArrayList<Turn>>() {
        }.getType();
        ArrayList<Turn> turnList = new Gson().fromJson(turnServersFromPreference,
                collectionType);
        if (turnList == null) {
            turnList = new ArrayList<>();
        }
        for (Turn turn : turnList) {
            Logger.d(TAG, turn.getTurnServer());
        }
        return turnList;

    }


    @NotNull
    public static List<PeerConnection.IceServer> getTempIceServers() {
        List<PeerConnection.IceServer> iceServers = new ArrayList<>();
        iceServers.add(PeerConnection.IceServer.builder("stun:stun.l.google.com:19302").createIceServer());
        iceServers.add(PeerConnection.IceServer.builder("stun:stun1.l.google.com:19302").createIceServer());
        iceServers.add(PeerConnection.IceServer.builder("turn:stun.contus.us:3478")
                .setUsername("contus")
                .setPassword("SAE@admin")
                .createIceServer());
        return iceServers;
    }
}
