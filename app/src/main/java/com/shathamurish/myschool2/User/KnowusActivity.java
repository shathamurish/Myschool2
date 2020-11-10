package com.shathamurish.myschool2.User;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.tabs.TabLayout;
import com.shathamurish.myschool2.Help.ViewPagerAdapter;
import com.shathamurish.myschool2.R;

public class KnowusActivity extends FragmentActivity implements OnMapReadyCallback {

    TabLayout tabLayout;
    ViewPager viewPager1;
    GoogleMap map;
    LottieAnimationView icon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowus);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        tabLayout = findViewById(R.id.tabLayout3);
        viewPager1 = findViewById(R.id.view_pager2);
//        icon = findViewById(R.id.icon2);
//
//        icon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(KnowusActivity.this, UserDashboard.class);
//                startActivity(intent);
//
//            }
//        });


//        setContentView(R.layout.activity_knowus);

        setViewPager(viewPager1);
        tabLayout.setupWithViewPager(viewPager1);

    }
        private void setViewPager(ViewPager viewPager1){
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            adapter.addFragment(new About_Fragment(), "About Us");
            adapter.addFragment(new Certificat_Fragment(), " Certificat");

            viewPager1.setAdapter(adapter);

        }


        //set adapter



    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng school = new LatLng(15.311525, 44.198586);
        map.addMarker(new MarkerOptions().position(school).title("Home Of Modern Science School"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(school, 13));

    }
    public void backarrowaction(View view) {

        Intent intent = new Intent(KnowusActivity.this, UserDashboard.class);
        startActivity(intent);
    }

}