/*
 *  @category SuchApp
 *  @copyright Copyright (C) 2018 Contus. All rights reserved.
 *  @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contusfly.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.contusfly.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.Task;
import com.mirrorflysdk.activities.FlyBaseActivity;
import com.mirrorflysdk.helpers.PermissionHelper;
import com.mirrorflysdk.helpers.Permissions;
import com.mirrorflysdk.helpers.ResourceHelper;

import static com.google.android.gms.location.LocationServices.API;
import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;
import static com.google.android.gms.location.LocationServices.getSettingsClient;

/**
 * This class is responsible for getting a fix on user's current location using Google Fused location API.
 * It also handles checking the location settings, and requesting the user to change any settings if necessary.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class LocationFinder extends LocationCallback implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private static final int SETTINGS_RESOLUTION_REQUEST = 0xF101;

    private static final int CONNECTION_FAILURE_RESOLUTION_REQUEST = 0xF100;

    private FlyBaseActivity mActivityContext;

    private GoogleApiClient mGoogleApiClient;

    private LocationCallback locationCallback;

    private LocationRequest mLocationRequest;

    private FusedLocationProviderClient fusedLocationProviderClient;

    /**
     * The public constructor used to instantiate the location finder.
     *
     * @param activityContext The context needed by this class, that will be used to request permissions.
     */
    LocationFinder(@NonNull FlyBaseActivity activityContext) {
        this.mActivityContext = activityContext;
        fusedLocationProviderClient = getFusedLocationProviderClient(mActivityContext);
        start();
    }

    private LocationFinder() {
        //To prevent outside instantiation. Has to be used with LocationUtils.getLocationFinder().
    }

    private void start() {
        if (mGoogleApiClient == null || !mGoogleApiClient.isConnected()) {
            mGoogleApiClient = new GoogleApiClient.Builder(mActivityContext)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(API)
                    .build();

            mGoogleApiClient.connect();
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        checkSettings();
    }

    private void checkSettings() {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(getLocationRequest())
                .setAlwaysShow(true);

        Task<LocationSettingsResponse> result =
                getSettingsClient(mActivityContext).checkLocationSettings(builder.build());

        result.addOnSuccessListener(locationSettingsResponse -> getLastLocation());
        result.addOnFailureListener(e -> {
            int statusCode = ((ApiException) e).getStatusCode();
            switch (statusCode) {
                case LocationSettingsStatusCodes.SUCCESS:
                    getLastLocation();
                    break;
                case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                    promptToEnableGps(e);
                    break;
                case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                    notifyLocationFixFail(ResourceHelper
                            .getString(R.string.fly_message_cannot_launch_location_settings));
                    // Location settings are not satisfied. However, we have no way
                    // to fix the settings so we won't show the dialog.
                    break;
                default:
                    break;
            }
        });
    }

    private LocationRequest getLocationRequest() {
        if (mLocationRequest == null) {
            mLocationRequest = LocationRequest.create()
                    .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                    .setInterval(10 * 1000L)        // 10 seconds, in milliseconds
                    .setFastestInterval(1000L); // 1 second, in milliseconds
        }

        return mLocationRequest;
    }

    private void getLastLocation() {
        mActivityContext.requestPermissions(Permissions.getGPSPermission(mActivityContext),
                new PermissionHelper.PermissionCallback() {
                    @Override
                    public void onAllPermissionsGranted() {
                        requestLocation();
                    }

                    @Override
                    public void onSomePermissionsDenied() {
                        notifyLocationFixFail(ResourceHelper.getString(R.string.fly_error_permission_denied));
                    }
                });
    }

    /**
     * This method is used to avoid multiple dialog boxes while asking permissions.
     */
    private void getLastLocationInCallBack(){

        mActivityContext.locationPermissionRequest(new PermissionHelper.PermissionCallback() {
            @Override
            public void onAllPermissionsGranted() {
                requestLocation();
            }

            @Override
            public void onSomePermissionsDenied() {
                notifyLocationFixFail(ResourceHelper.getString(R.string.fly_error_permission_denied));
            }
        });
    }

    private void promptToEnableGps(Exception exception) {
        // Location settings are not satisfied, but this can be fixed
        // by showing the user a dialog.
        try {
            // Show the dialog by calling startResolutionForResult(),
            // and check the result in onActivityResult().
            ResolvableApiException resolvable = (ResolvableApiException) exception;
            resolvable.startResolutionForResult(
                    mActivityContext,
                    SETTINGS_RESOLUTION_REQUEST);
        } catch (IntentSender.SendIntentException e) {
            notifyLocationFixFail(ResourceHelper.getString(R.string.fly_message_cannot_launch_location_settings));
        }
    }

    private void notifyLocationFixFail(String error) {
        if (locationCallback != null)
            locationCallback.onLocationFixFailed(error);
    }

    public void requestLocation() {

        if (mGoogleApiClient == null || !mGoogleApiClient.isConnected()) {
            //If google client has not connected by this time, probably there is no google play services.
            notifyLocationFixFail(ResourceHelper.getString(R.string.fly_error_cannot_find_location));
            return;
        }

        if (ActivityCompat.checkSelfPermission(mActivityContext,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(mActivityContext,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(location -> {
            if (location != null) {
                handleLocation(location);
            } else {
                if (ActivityCompat.checkSelfPermission(mActivityContext, Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mActivityContext,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                getFusedLocationProviderClient(mActivityContext).requestLocationUpdates
                        (getLocationRequest(), this, null);
                requestLocation();
            }
        });
    }

    private void handleLocation(final Location location) {
        if (locationCallback != null)
            locationCallback.onCurrentLocationFound(location);
    }

    @Override
    public void onConnectionSuspended(int i) {
        // Called when Google API client connection is suspended.
    }

    /**
     * The delegate method that has to be called from the activity that uses the location finder class.
     * {@link Activity#onActivityResult(int, int, Intent)} will be called after the location settings dialog is
     * shown, and that has to be handled. So, the calling activity must delegate the call to this method.
     *
     * @param requestCode The request code used to launch the settings dialog.
     * @param resultCode  The result code returned by the settings.
     * @param resultData  The result intent.
     */
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        if (requestCode == SETTINGS_RESOLUTION_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                requestLocation();
            } else {
                notifyLocationFixFail(ResourceHelper.getString(R.string.fly_error_permission_denied));
            }
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            try {
                connectionResult.startResolutionForResult(mActivityContext,
                        CONNECTION_FAILURE_RESOLUTION_REQUEST);
            } catch (IntentSender.SendIntentException e) {
                Log.d("onConnectionFailed", String.valueOf(e));
            }
        } else {
            // Either there is something wrong with play services, or we're dealing with outdated play services.
            // Worst case, no play services at all.
            notifyLocationFixFail(ResourceHelper.getString(R.string.fly_error_cannot_connect_to_play_services));
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        handleLocation(location);
        stopGPS();
    }

    /**
     * Stops listening to location updates.
     */
    public void stopGPS() {
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected())
            removeUpdates();
    }

    private void removeUpdates() {
        getFusedLocationProviderClient(mActivityContext).removeLocationUpdates(this);
    }

    /**
     * This method is used to stop the location finder. It removes any
     * update listeners attached to it, and also disconnects the Google API client. This has to be called after using
     * the location services to preserve battery.
     */
    public void stop() {
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            removeUpdates();
            mGoogleApiClient.disconnect();
        }
    }

    /**
     * This method will request the Fused location api for any last known location fixes. If found, it will be
     * returned or a new location request will be made. The location request is asynchronous, and the location result
     * will be passed to {@link LocationCallback} interface methods.
     *
     * @param callback The callback that will be used to post the location results.
     */
    public void getCurrentLocation(LocationCallback callback) {
        this.locationCallback = callback;
        getLastLocationInCallBack();
    }

    /**
     * This is the callback interface whose method will be used to notify the location fix, or errors if none are found.
     */
    public interface LocationCallback {

        /**
         * This method will be called when a location fix has been found.
         *
         * @param location The location fix returned by the fusion API.
         */
        void onCurrentLocationFound(Location location);

        /**
         * This method will be called when the fusion api cannot get a fix on the location, or any other errors.
         *
         * @param whatHappened The string describing the problem.
         */
        void onLocationFixFailed(String whatHappened);
    }

}