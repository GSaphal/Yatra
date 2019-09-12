package com.saphal.yatra;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.saphal.yatra.models.HomeFragment;
import com.saphal.yatra.models.FlightFragment;
import com.saphal.yatra.models.ProfileFragment;
import com.saphal.yatra.models.TransportFragment;
import com.saphal.yatra.models.UserFragment;
import com.saphal.yatra.utils.FirebaseHelper;


public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                    new HomeFragment()).commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                            new HomeFragment()).commit();

                    return true;
                case R.id.navigation_hotel:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                            new FlightFragment()).commit();
                    return true;
                case R.id.navigation_transport:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                            new TransportFragment()).commit();
                    return true;
                case R.id.navigation_profile:
                     getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                                new ProfileFragment()).commit();
                    return true;
            }
            return false;
        }
    };


}
