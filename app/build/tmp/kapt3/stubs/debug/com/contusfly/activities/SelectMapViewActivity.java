package com.contusfly.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010\'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0015H\u0016J\u0010\u0010)\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010*\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010,H\u0007J\u0012\u0010-\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J-\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u0002002\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020&022\u0006\u00103\u001a\u000204H\u0016\u00a2\u0006\u0002\u00105J\b\u00106\u001a\u00020\bH\u0016J\b\u00107\u001a\u00020\bH\u0016J\u001c\u00108\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lcom/contusfly/activities/SelectMapViewActivity;", "Lcom/contusfly/activities/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "Lcom/google/android/gms/maps/GoogleMap$OnMapClickListener;", "Lcom/contusfly/utils/LocationFinder$LocationCallback;", "()V", "address", "", "getAddress", "()Lkotlin/Unit;", "addressLine1", "Landroid/widget/TextView;", "addressLine2", "geocoder", "Landroid/location/Geocoder;", "googleMap", "Lcom/google/android/gms/maps/GoogleMap;", "latitude", "", "location", "Lcom/google/android/gms/maps/model/LatLng;", "locationFinder", "Lcom/contusfly/utils/LocationFinder;", "longitude", "mapFragment", "Lcom/google/android/gms/maps/SupportMapFragment;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCurrentLocationFound", "locationData", "Landroid/location/Location;", "onLocationFixFailed", "whatHappened", "", "onMapClick", "latLng", "onMapReady", "onMessageEvent", "messageEvent", "Lcom/contusfly/models/PrivateChatAuthenticationModel;", "onPostCreate", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onStart", "onStop", "setMapView", "map", "app_debug"})
public final class SelectMapViewActivity extends com.contusfly.activities.BaseActivity implements android.view.View.OnClickListener, com.google.android.gms.maps.OnMapReadyCallback, com.google.android.gms.maps.GoogleMap.OnMapClickListener, com.contusfly.utils.LocationFinder.LocationCallback {
    
    /**
     * The latitude of the selected location
     */
    private double latitude = 0.0;
    
    /**
     * The longitude of the selected location
     */
    private double longitude = 0.0;
    
    /**
     * Map fragment to load map
     */
    private com.google.android.gms.maps.SupportMapFragment mapFragment;
    
    /**
     * The instance of the LatLng
     */
    private com.google.android.gms.maps.model.LatLng location;
    
    /**
     * Loaded google map reference
     */
    private com.google.android.gms.maps.GoogleMap googleMap;
    private android.widget.TextView addressLine1;
    private android.widget.TextView addressLine2;
    private android.location.Geocoder geocoder;
    
    /**
     * Location finder to find user current location.
     */
    private com.contusfly.utils.LocationFinder locationFinder;
    private java.util.HashMap _$_findViewCache;
    
    public SelectMapViewActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onStop() {
    }
    
    @java.lang.Override
    protected void onPostCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.NotNull
    android.view.View v) {
    }
    
    @java.lang.Override
    public void onMapReady(@org.jetbrains.annotations.NotNull
    com.google.android.gms.maps.GoogleMap googleMap) {
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    /**
     * Set up the map view
     *
     * @param map      Instance of the Google map
     * @param location Instance of LatLng
     */
    private final void setMapView(com.google.android.gms.maps.GoogleMap map, com.google.android.gms.maps.model.LatLng location) {
    }
    
    @java.lang.Override
    public void onMapClick(@org.jetbrains.annotations.NotNull
    com.google.android.gms.maps.model.LatLng latLng) {
    }
    
    private final kotlin.Unit getAddress() {
        return null;
    }
    
    @java.lang.Override
    public void onCurrentLocationFound(@org.jetbrains.annotations.NotNull
    android.location.Location locationData) {
    }
    
    @java.lang.Override
    public void onLocationFixFailed(@org.jetbrains.annotations.NotNull
    java.lang.String whatHappened) {
    }
    
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onMessageEvent(@org.jetbrains.annotations.Nullable
    com.contusfly.models.PrivateChatAuthenticationModel messageEvent) {
    }
    
    @java.lang.Override
    public void onStart() {
    }
}