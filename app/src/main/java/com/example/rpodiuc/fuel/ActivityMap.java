package com.example.rpodiuc.fuel;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class ActivityMap extends FragmentActivity implements OnMapReadyCallback{
    Context context;
    GoogleMap mMap; // Might be null if Google Play services APK is not available.
    GPSTracker gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = super.getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_map);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            //this stuff doesn't make any sense...should work but does not
            // Check if we were successful in obtaining the map.
      /*if (mMap != null) {
         setUpMap();
      }*/
            gps = new GPSTracker(context, mMap);
            if (gps.CanGetLocation()) {
                //do nothing
            } else {
                gps.showSettingsAlert();
            }
            setUpMap();
        }

    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near HOme.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(gps.getLatitude(), gps.getLongitude())).title("Home"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(gps.getLatitude(), gps.getLongitude()), 16));

        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(21.291, -157.821))  // Hawaii
                .add(new LatLng(gps.getLatitude(), gps.getLongitude())));  // Mountain View

        mMap.addMarker(new MarkerOptions().position(new LatLng(21.291, -157.821)).title("Aloha!"));
        Location l = gps.getLocation();


        //gps.showSettingsAlert();



    }


    //this code is dead!
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(gps.getLatitude(), gps.getLongitude()), 14));
        gps.showSettingsAlert();

        mMap.addMarker(new MarkerOptions().position(new LatLng(gps.getLatitude(), gps.getLongitude())).title("Home"));

        // Polylines are useful for marking paths and routes on the map.
        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(21.291, -157.821))  // Hawaii
                .add(new LatLng(37.423, -122.091))  // Mountain View
        );
    }
}
