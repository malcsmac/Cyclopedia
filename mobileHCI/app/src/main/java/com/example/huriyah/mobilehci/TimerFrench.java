package com.example.huriyah.mobilehci;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import java.text.DecimalFormat;

public class TimerFrench extends AppCompatActivity {

    private Chronometer chronometer;
    private long pauseOffset;
    private boolean operational;
    private LocationManager locationManager = null;
    static int status = 0;
    static double distance = 0.0;

    private double longitude, latitude, prevLongitude, prevLatitude;

    TextView distanceView, speedView, calorieView;

    private static DecimalFormat df2 = new DecimalFormat(".##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_french);

        chronometer = findViewById(R.id.chronometer);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        distanceView = (TextView) findViewById(R.id.distanceText);
        speedView = (TextView) findViewById(R.id.speedText);
        calorieView = (TextView) findViewById(R.id.calorieText);
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
                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                    perm = true;
                }
            }
            if (perm && checkGPS()) {
                locationManager.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER, 2,
                        1, locationListenerGPS);
            }
        }
    }

    public void stopChronometer(View v) {
        if (operational) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            operational = false;
            locationManager.removeUpdates(locationListenerGPS);
            calorieView.setText("Calories Brûlées\n: 20 kcal");
            double time = SystemClock.elapsedRealtime() - chronometer.getBase();
            double speed = distance / ((time/1000)/3600);
            speedView.setText("La Vitesse: " + df2.format(speed) + " mph");
        }
    }

    public void clearChronometer(View v) {
        if (!operational) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            pauseOffset = 0;
            distance = 0;
            distanceView.setText("Distance: x");
            speedView.setText("La Vitesse: x");
            calorieView.setText("Les Calories: x");
        }
    }

    protected void alertbox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your Device's GPS is disabled, you won't be able to view your speed! " +
                "If you wish to view your speed please enable GPS and ")
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
        if (!isLocationEnabled()) {
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
            long time = 0;
            if (status == 0) {
                prevLatitude = location.getLatitude();
                prevLongitude = location.getLongitude();
            } else if ((status % 2) != 0) {
                longitude = location.getLongitude();
                latitude = location.getLatitude();
                distance += distanceBetweenTwoPoint(prevLatitude, prevLongitude, latitude, longitude);
                time = 2;
            } else if ((status % 2) == 0) {
                prevLatitude = location.getLatitude();
                prevLongitude = location.getLongitude();
                distance += distanceBetweenTwoPoint(latitude, longitude, prevLatitude, prevLongitude);
                time = 3;
            }
            status++;

            distanceView.setText("Distance: " + df2.format(distance) + " miles");

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

        double distanceBetweenTwoPoint(double srcLat, double srcLng, double desLat, double desLng) {
            double earthRadius = 6371;
            double dLat = Math.toRadians(desLat - srcLat);
            double dLng = Math.toRadians(desLng - srcLng);
            double a = Math.pow(Math.sin(dLat / 2), 2)
                    + Math.cos(Math.toRadians(srcLat))
                    * Math.cos(Math.toRadians(desLat)) * Math.pow(Math.sin(dLng / 2), 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double dist = earthRadius * c;

            return c * earthRadius;
        }
    };
}
