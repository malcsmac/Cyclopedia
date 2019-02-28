package com.example.huriyah.mobilehci;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

public class Timer extends AppCompatActivity {

    private Chronometer chronometer;
    private long pauseOffset;
    private boolean operational;
    private LocationManager locationManager = null;

    private double longitude, latitude;

    TextView longitudeView, latitudeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        chronometer = findViewById(R.id.chronometer);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        longitudeView = (TextView) findViewById(R.id.longitudeText);
        latitudeView = (TextView) findViewById(R.id.latitudeText);

    }

    public void startChronometer(View v) {
        if (!operational) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            operational = true;

            boolean perm = false;
            // implement GPS to start here

            // check if permission is given, if not then ask.
            if (ContextCompat.checkSelfPermission(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                    PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this,
                            android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                            PackageManager.PERMISSION_GRANTED) {
                perm = true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION},
                        0);

                int permissionCheck = ContextCompat.checkSelfPermission(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if (permissionCheck == PackageManager.PERMISSION_GRANTED){
                    perm = true;
                }
            }
            if (perm && checkGPS()) {
                locationManager.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER, 1,
                        0, locationListenerGPS);
            } else {
                alertbox();
            }

        }
        }

    public void stopChronometer(View v) {
        if (operational) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            operational = false;
            locationManager.removeUpdates(locationListenerGPS);
        }
    }

    public void clearChronometer(View v) {
        if (!operational) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            pauseOffset = 0;
        }
    }

    protected void alertbox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your Device's GPS is disabled, you won't be able to view your speed!")
                .setCancelable(false)
                .setTitle("GPS Disabled")
                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private boolean checkGPS() {
        if (!isLocationEnabled()){
            alertbox();
        }
        return isLocationEnabled();
    }

    private boolean isLocationEnabled() {
        //locationManager.checkPermission
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }


    private final LocationListener locationListenerGPS = new LocationListener() {
        public void onLocationChanged(Location location) {
            longitude = location.getLongitude();
            latitude = location.getLatitude();

            String strLongitude = Double.toString(longitude);
            String strLatitude = Double.toString(latitude);

            longitudeView.setText(strLongitude);
            latitudeView.setText(strLatitude);
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };
}

