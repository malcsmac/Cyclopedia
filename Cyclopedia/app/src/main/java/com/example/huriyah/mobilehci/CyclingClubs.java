package com.example.huriyah.mobilehci;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class CyclingClubs extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private Beginner beginnerFragment;
    private Intermediate intermediateFragment;
    private Expert expertFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycling_clubs);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        beginnerFragment = new Beginner();
        intermediateFragment = new Intermediate();
        expertFragment = new Expert();

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.nav_beginner:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(beginnerFragment);
                        return true;

                    case R.id.nav_intermediate:
                        mMainNav.setItemBackgroundResource(R.color.colorOrange);
                        setFragment(intermediateFragment);
                        return true;

                    case R.id.nav_expert:
                        mMainNav.setItemBackgroundResource(R.color.colorRed);
                        setFragment(expertFragment);
                        return true;

                    default:
                        return false;
                }
            }

            private void setFragment(Fragment fragment) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.main_frame, fragment);
                fragmentTransaction.commit();
            }
        });
    }
}