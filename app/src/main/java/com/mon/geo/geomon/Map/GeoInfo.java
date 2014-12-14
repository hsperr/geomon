package com.mon.geo.geomon.Map;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.internal.lo;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mon.geo.geomon.R;

/**
 * Created by hsperr on 12/14/14.
 */
public class GeoInfo {

    private static GeoInfo instance = null;
    private LocationManager lm = null;
    private Location last_location = null;

    public GeoInfo(Context context){
        // Acquire a reference to the system Location Manager
        lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        last_location = lm.getLastKnownLocation(lm.GPS_PROVIDER);

        // Define a listener that responds to location updates
        LocationListener locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {
                last_location=location;
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        // Register the listener with the Location Manager to receive location updates
        long fiveMinutesInMs = 300000;
        long distanceInMeters = 20;

        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,fiveMinutesInMs, distanceInMeters, locationListener);
    }

    public String getLocationAsString(){
        String locationString = "";
        if(last_location!= null) {
            locationString = last_location.getLatitude() + "," + last_location.getLongitude();
        }
        return locationString;
    }
}
