/*
 * @category ContusFly
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contusfly.utils;

import com.google.android.gms.maps.model.LatLng;
import com.mirrorflysdk.activities.FlyBaseActivity;


/**
 * Location utilities class. This class has all the methods related to location processing.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class LocationUtils {

    /**
     * Private constructor to prevent instantiation.
     */
    private LocationUtils() {
    }

    /**
     * Used to check if a given LatLng object has valid values.
     *
     * @param latLng The LatLng object to be validated.
     * @return True if valid.
     */
    public static boolean isValidLatLng(LatLng latLng) {
        return (latLng.latitude > -90 && latLng.latitude < 90) && (latLng.longitude > -180 && latLng.longitude <
                180);
    }

    /**
     * Returns the zoom factor required for the map to show the area that covers the given radius.
     *
     * @param radiusInMeters The radius to be covered in the map.
     * @return Returns the correct zoom level to cover the given radius, in map.
     */
    public static float getZoomLevel(int radiusInMeters) {

        double scale = (double) radiusInMeters / 500;
        return (float) (16 - Math.log(scale) / Math.log(2));
    }

    /**
     * Creates and returns an instance of {@link LocationFinder} class.
     *
     * @param activity The reference of {@link FlyBaseActivity} to be used by the location finder.
     * @return A new instance of {@link LocationFinder}.
     */
    public static LocationFinder getLocationFinder(FlyBaseActivity activity) {
        if (activity == null)
            throw new IllegalStateException("Activity instance cannot be null.");

        return new LocationFinder(activity);
    }
}
