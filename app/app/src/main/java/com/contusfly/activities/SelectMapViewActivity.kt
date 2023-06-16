package com.contusfly.activities

import android.content.Intent
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.R
import com.contusfly.utils.LocationFinder
import com.contusfly.utils.LocationUtils
import com.contusfly.utils.UserInterfaceUtils
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMapClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.io.IOException
import java.util.*

class SelectMapViewActivity : BaseActivity(), View.OnClickListener, OnMapReadyCallback, OnMapClickListener, LocationFinder.LocationCallback {
    /**
     * The latitude of the selected location
     */
    private var latitude = 0.0

    /**
     * The longitude of the selected location
     */
    private var longitude = 0.0

    /**
     * Map fragment to load map
     */
    private var mapFragment: SupportMapFragment? = null

    /**
     * The instance of the LatLng
     */
    private var location: LatLng? = null

    /**
     * Loaded google map reference
     */
    private var googleMap: GoogleMap? = null
    private var addressLine1: TextView? = null
    private var addressLine2: TextView? = null
    private var geocoder: Geocoder? = null

    /**
     * Location finder to find user current location.
     */
    private var locationFinder: LocationFinder? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_map_view)
        geocoder = Geocoder(this, Locale.getDefault())
    }

    override fun onStop() {
        super.onStop()
        locationFinder!!.stop()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        UserInterfaceUtils.setUpToolBar(this, toolbar, supportActionBar, getString(R.string.title_user_location))
        addressLine1 = findViewById(R.id.address_line_1)
        addressLine2 = findViewById(R.id.address_line_2)
        val imgSend = findViewById<ImageView>(R.id.location_send)
        imgSend.setOnClickListener(this)
        locationFinder = LocationUtils.getLocationFinder(this)
        locationFinder?.getCurrentLocation(this)
        /**
         * Get the map instance
         */
        mapFragment = supportFragmentManager.findFragmentById(R.id.view_map) as SupportMapFragment?
    }

    override fun onClick(v: View) {
        if (v.id == R.id.location_send) {
            val result = Intent()
            result.putExtra(Constants.LATITUDE, latitude)
            result.putExtra(Constants.LONGITUDE, longitude)
            setResult(RESULT_OK, result)
            finish()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        try {
            this.googleMap = googleMap
            googleMap.setOnMapClickListener(this)
            setMapView(googleMap, location)
        } catch (ex: Exception) {
            LogMessage.e(ex)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        locationFinder!!.requestLocation()
    }
    //    @Override
    //    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    //        locationFinder.onActivityResult(requestCode,resultCode,data);
    //    }
    /**
     * Set up the map view
     *
     * @param map      Instance of the Google map
     * @param location Instance of LatLng
     */
    private fun setMapView(map: GoogleMap?, location: LatLng?) {
        map!!.addMarker(MarkerOptions().position(location).draggable(true)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_small)))
        val cameraPosition = CameraPosition.Builder().target(location).zoom(18f).bearing(360f).tilt(15f)
                .build()

        /**
         * Display the camera position of the map marker to zoom in
         */
        map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
        address
    }

    override fun onMapClick(latLng: LatLng) {
        try {
            googleMap!!.clear()
            latitude = latLng.latitude
            longitude = latLng.longitude
            setMapView(googleMap, latLng)
        } catch (ex: Exception) {
            LogMessage.e(ex)
        }
    }

    private val address: Unit
        get() {
            var addresses: List<Address?>? = ArrayList()
            try {
                addresses = geocoder!!.getFromLocation(latitude, longitude, 1)
            } catch (e: IOException) {
                LogMessage.e(e)
            }
            if (addresses != null && !addresses.isEmpty()) {
                val address = addresses[0]
                if (address != null) {
                    val ad = address.getAddressLine(0)
                    val values = ad.split(",".toRegex()).toTypedArray()
                    val list: ArrayList<*> = ArrayList<Any?>(listOf(*values))
                    val listSize = list.size
                    if (listSize >= 3) {
                        val address1 = list[0].toString() + "," + list[1] + "," + list[2]
                        val address2 = list[listSize - 3].toString().trim { it <= ' ' } + ", " + address.adminArea + ", " + address.postalCode
                        addressLine1!!.text = address1
                        addressLine2!!.text = address2
                    } else {
                        addressLine1!!.text = getString(R.string.message_location_not_found)
                        addressLine2!!.text = getString(R.string.message_can_send_location)
                    }
                }
            }
        }

    override fun onCurrentLocationFound(locationData: Location) {
        latitude = locationData.latitude
        longitude = locationData.longitude
        location = LatLng(latitude, longitude)
        mapFragment!!.getMapAsync(this)
    }

    override fun onLocationFixFailed(whatHappened: String) {
        //Have to implement.
    }
}