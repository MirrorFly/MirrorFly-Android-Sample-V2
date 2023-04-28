package com.fxn.utility;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.View;

import com.fxn.interfaces.WorkFinish;
import com.fxn.pix.Options;
import com.fxn.pix.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/**
 * Created by akshay on 11/14/16.
 */

public abstract class PermUtil {

    public static final int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 9921;
/*
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void checkForPermissions(final FragmentActivity activity) {
        List<String> permissionsNeeded = new ArrayList<String>();
        final List<String> permissionsList = new ArrayList<String>();
        if (!addPermission(permissionsList, Manifest.permission.CAMERA, activity))
            permissionsNeeded.add("CAMERA");
        if (!addPermission(permissionsList, android.Manifest.permission.WRITE_EXTERNAL_STORAGE, activity))
            permissionsNeeded.add("WRITE_EXTERNAL_STORAGE");
        if (!addPermission(permissionsList, android.Manifest.permission.ACCESS_FINE_LOCATION, activity))
            permissionsNeeded.add("ACCESS_FINE_LOCATION");
        if (!addPermission(permissionsList, android.Manifest.permission.ACCESS_COARSE_LOCATION, activity))
            permissionsNeeded.add("ACCESS_COARSE_LOCATION");
        if (permissionsList.size() > 0) {
            activity.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                    REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
        }
    }*/

    @RequiresApi(api = Build.VERSION_CODES.M)
    private static boolean addPermission(List<String> permissionsList, String permission, Activity ac) {
        if (ac.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
            // Check for Rationale Option
            return ac.shouldShowRequestPermissionRationale(permission);
        }
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private static boolean addWritePermission(List<String> permissionsList, String permission, Activity ac) {
        if (ac.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED && Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            permissionsList.add(permission);
            // Check for Rationale Option
            return ac.shouldShowRequestPermissionRationale(permission);
        }
        return true;
    }

    public static void checkForAudioRecordPermissions(final FragmentActivity activity, final Options option, WorkFinish workFinish) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            workFinish.onWorkFinish(true);
        } else {
            final List<String> permissionsList = new ArrayList<String>();
            addPermission(permissionsList, Manifest.permission.RECORD_AUDIO, activity);
            if (!permissionsList.isEmpty()) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.RECORD_AUDIO)) {
                     /*
                         If the user has denied the permission previously your code will come to this block
                         Here you can explain why you need this permission Explain here why you need this
                         permission
                         */
                    Snackbar.make(activity.findViewById(android.R.id.content), R.string.audio_record_permission_label, Snackbar.LENGTH_INDEFINITE)
                            .setAction(R.string.ok_label, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    showPermissionPopUpForAudioRecord(activity, option, permissionsList);
                                }
                            }).show();
                } else if (option.getAudioPermissionAsked()){
                    openSettingsForPermission(activity, activity.getString(R.string.audio_record_permission_label));
                } else
                    showPermissionPopUpForAudioRecord(activity, option, permissionsList);
            } else {
                workFinish.onWorkFinish(true);
            }
        }
    }

    private static void openSettingsForPermission(final FragmentActivity activity, String message) {
        Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.ok_label, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package", activity.getPackageName(), null));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                        activity.startActivity(intent);
                    }
                }).show();
    }

    private static void showPermissionPopUpForAudioRecord(FragmentActivity activity, Options option, List<String> permissionsList) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            option.setAudioPermissionAsked(true);
            activity.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                    REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
        }
    }

    public static void checkForCamaraWritePermissions(final FragmentActivity activity, WorkFinish workFinish) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            workFinish.onWorkFinish(true);
        } else {
            List<String> permissionsNeeded = new ArrayList<String>();
            final List<String> permissionsList = new ArrayList<String>();
            if (!addPermission(permissionsList, Manifest.permission.CAMERA, activity))
                permissionsNeeded.add("CAMERA");
            if (!addWritePermission(permissionsList, Manifest.permission.WRITE_EXTERNAL_STORAGE, activity))
                permissionsNeeded.add("WRITE_EXTERNAL_STORAGE");
            if (permissionsList.size() > 0) {
                activity.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
            } else {
                workFinish.onWorkFinish(true);
            }
        }
    }


    public static void checkForCamaraWritePermissions(final Fragment fragment, WorkFinish workFinish) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            workFinish.onWorkFinish(true);
        } else {
            List<String> permissionsNeeded = new ArrayList<String>();
            final List<String> permissionsList = new ArrayList<String>();
            if (!addPermission(permissionsList, Manifest.permission.CAMERA, fragment.getActivity()))
                permissionsNeeded.add("CAMERA");
            if (!addWritePermission(permissionsList, Manifest.permission.WRITE_EXTERNAL_STORAGE, fragment.getActivity()))
                permissionsNeeded.add("WRITE_EXTERNAL_STORAGE");
            if (permissionsList.size() > 0) {
                fragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
            } else {
                workFinish.onWorkFinish(true);
            }
        }
    }

}
