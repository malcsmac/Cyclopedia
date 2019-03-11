package com.example.huriyah.mobilehci;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button lv = (Button) findViewById(R.id.listView);
        lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CyclingClubs.class);
                startActivity(intent);
            }
        });


        FloatingActionButton qmark = (FloatingActionButton) findViewById(R.id.qmark);
        qmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Help.class);
                startActivity(intent);
            }
        });




    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Glasgow and move the camera
        LatLng glasgow = new LatLng(55.86515, -4.25763);
        mMap.addMarker(new MarkerOptions().position(glasgow).title("City Cyclists - Beginner Level.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(glasgow, 8));

        // Add a marker in Glasgow and move the camera
        LatLng bearsden = new LatLng(55.9217, -4.3355);
        mMap.addMarker(new MarkerOptions().position(bearsden).title("Suburb Cyclists - Beginner Level.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bearsden, 8));

        LatLng stirling = new LatLng(56.1164, -3.9364);
        mMap.addMarker(new MarkerOptions().position(stirling).title("Stirling Cyclists - Beginner Level.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(stirling, 8));

        // Add a marker in Glasgow and move the camera
        LatLng ek = new LatLng(55.7644, -4.1770);
        mMap.addMarker(new MarkerOptions().position(ek).title("Community Cyclists - Beginner Level.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ek, 8));

        // Add a marker in Glasgow and move the camera
        LatLng paisley = new LatLng(55.8473, -4.4401);
        mMap.addMarker(new MarkerOptions().position(paisley).title("Paisley Cyclists - Beginner Level.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(paisley, 8));

        // Add a marker in Glasgow and move the camera
        LatLng mugdock = new LatLng(55.9632, -4.3107);
        mMap.addMarker(new MarkerOptions().position(mugdock).title("Country Park Cyclists - Intermediate Level.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mugdock, 8));

        // Add a marker in Glasgow and move the camera
        LatLng woodland = new LatLng(56.0674234, -4.3689438);
        mMap.addMarker(new MarkerOptions().position(woodland).title("Woodland Cyclists - Intermediate Level.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(woodland, 8));


        // Add a marker in Glasgow and move the camera
        LatLng loch = new LatLng(55.8766, -4.1798);
        mMap.addMarker(new MarkerOptions().position(loch).title("Loch Cyclists - Intermediate Level.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loch, 8));


        // Add a marker in Glasgow and move the camera
        LatLng clyde = new LatLng(55.9001, -4.4048);
        mMap.addMarker(new MarkerOptions().position(clyde).title("Clyde Cyclists - Intermediate Level.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(clyde, 8));


        // Add a marker in Glasgow and move the camera
        LatLng lanark = new LatLng(55.884720, -3.838309);
        mMap.addMarker(new MarkerOptions().position(lanark).title("Lanark Cyclists - Intermediate Level.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lanark, 8));


        // Add a marker in Glasgow and move the camera
        LatLng ll = new LatLng(56.1114, -4.6289);
        mMap.addMarker(new MarkerOptions().position(ll).title("Loch Lomond Cyclists - Expert Level.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ll, 8));


        // Add a marker in Glasgow and move the camera
        LatLng lennoxtown = new LatLng(55.9743, -4.2029);
        mMap.addMarker(new MarkerOptions().position(lennoxtown).title("Lennoxtown Cyclists - Expert Level.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lennoxtown, 8));

        // Add a marker in Glasgow and move the camera
        LatLng bonny = new LatLng(55.999215, -3.9040264);
        mMap.addMarker(new MarkerOptions().position(bonny).title("Bonnybridge Cyclists - Expert Level.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bonny, 8));



        // Add a marker in Glasgow and move the camera
        LatLng forest = new LatLng(55.668613, -4.257803);
        mMap.addMarker(new MarkerOptions().position(forest).title("Forest Cyclists - Expert Level.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(forest, 8));


        // Add a marker in Glasgow and move the camera
        LatLng scp = new LatLng(55.7853, -4.0148);
        mMap.addMarker(new MarkerOptions().position(scp).title("University Cyclists - Expert Level.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(scp, 8));

    }
}
