package com.shathamurish.myschool2.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.denzcoskun.imageslider.constants.ScaleTypes;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ScrollView;


import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shashank.sony.fancytoastlib.FancyToast;
import com.shathamurish.myschool2.LevelsActivity;
import com.shathamurish.myschool2.R;
import com.shathamurish.myschool2.RequirmentActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    // ArrayList<SlideModel> imageList =new  ArrayList<SlideModel>();
// drawer menu varibles

    static final float END_SCALE = 0.7f;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    ScrollView contentView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //imageslider
        ImageSlider imageSlider = findViewById(R.id.image_slider);

        //dashboard hooks
//        menuIcon=findViewById(R.id.menuicon);
        contentView = findViewById(R.id.content1);

        final List<SlideModel> imageList = new ArrayList<>();

        FirebaseDatabase.getInstance().getReference().child("slider")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        for(DataSnapshot data:snapshot.getChildren())
                            imageList.add(new SlideModel(data.child("image").getValue().toString(),data.child("title").getValue().toString(),ScaleTypes.FIT));
                        imageSlider.setImageList(imageList, ScaleTypes.FIT);
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });
//
        imageList.add(new SlideModel(R.drawable.sch10_1, "Quality of Education and Teacher efficiency", ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.sch5, "Computer Labs", ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.sch6, "Science Lab", ScaleTypes.FIT));
//        imageList.add(new SlideModel(R.drawable.sch6, "hello", ScaleTypes.FIT));
//        imageList.add(new SlideModel(R.drawable.sch11_1, "hi", ScaleTypes.FIT));
//        imageList.add(new SlideModel(R.drawable.libraryicon, "hi", ScaleTypes.FIT));
//
        imageSlider.setImageList(imageList, ScaleTypes.FIT);

        //menu hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.menu_re);


        navigationDrawer();

    }

    private void navigationDrawer() {


        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //naviagion drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
//
//        menuIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (drawerLayout.isDrawerVisible(GravityCompat.START))
//                    drawerLayout.closeDrawer(GravityCompat.START);
//                else drawerLayout.openDrawer(GravityCompat.START);
//                }
//        });

        animateNaviagtionDrawer();

    }

    private void animateNaviagtionDrawer() {

        //drawerLayout.setScrimColor(getResources().getColor(R.color.darkblueee));
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull @NotNull View view, float v) {
                final float diffScaledOffset = v * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);
                final float xOffset = view.getWidth() * v;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);

            }

            @Override
            public void onDrawerOpened(@NonNull @NotNull View view) {

            }

            @Override
            public void onDrawerClosed(@NonNull @NotNull View view) {

            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
    }


    //naviagtion drawer function
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.nav_home:

                break;
            case R.id.nav_library:

                Intent intent = new Intent(UserDashboard.this, LibraryActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_news:
//
                Intent intent2 = new Intent(UserDashboard.this, NewsActivity.class);
                startActivity(intent2);
                break;

            case R.id.nav_activity:
                Intent intent3 = new Intent(UserDashboard.this, AcivitiesStudentActivity.class);
                startActivity(intent3);

                break;
            case R.id.nav_knowus:

                Intent intent4 = new Intent(UserDashboard.this, KnowusActivity.class);
                startActivity(intent4);
                break;
            case R.id.nav_contactus:
//
                Intent intent5 = new Intent(UserDashboard.this, ContactusActivity.class);
                startActivity(intent5);
                break;

            case R.id.nav_student:
//
                Intent intent6 = new Intent(UserDashboard.this, StudentActivity.class);
                startActivity(intent6);
                break;

//
            case R.id.nav_register:
//
                Intent intent7= new Intent(UserDashboard.this, RegisteronlineActivity.class);
                startActivity(intent7);

                FancyToast.makeText(this,"Online Registeration !",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                break;


            case R.id.nav_5:
//
                Intent intent8= new Intent(UserDashboard.this, RequirmentActivity.class);
                startActivity(intent8);

                FancyToast.makeText(this,"Online Registeration Requirment !",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                break;

            case R.id.nav_4:
//
                Intent intent9= new Intent(UserDashboard.this, LevelsActivity.class);
                startActivity(intent9);

                FancyToast.makeText(this,"levels of school !",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                break;
//

        }
        drawerLayout.closeDrawer(GravityCompat.START);


        return true;

    }

    public void actionlogin(View view) {

        Intent intent = new Intent(UserDashboard.this, StudentActivity.class);

        Pair[]  pairs=new Pair[1];
//
     pairs[0]=new Pair<View,String>(findViewById(R.id.login),"transition_login");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(UserDashboard.this,pairs);
        startActivity(intent ,options.toBundle());
        }
        else {
            startActivity(intent);
        }
    }

    public void actionlibrary(View view) {
        Intent intent = new Intent(UserDashboard.this, LibraryActivity.class);

        Pair[]  pairs=new Pair[1];
//
        pairs[0]=new Pair<View,String>(findViewById(R.id.library),"transition_login");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(UserDashboard.this,pairs);
            startActivity(intent ,options.toBundle());
        }
        else {
            startActivity(intent);
        }
    }

    public void actionnews(View view) {
        Intent intent = new Intent(UserDashboard.this, NewsActivity.class);

        Pair[]  pairs=new Pair[1];
//
        pairs[0]=new Pair<View,String>(findViewById(R.id.news),"transition_login");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(UserDashboard.this,pairs);
            startActivity(intent ,options.toBundle());
        }
        else {
            startActivity(intent);
        }
    }

    public void actionactivity(View view) {
        Intent intent = new Intent(UserDashboard.this, AcivitiesStudentActivity.class);

        Pair[]  pairs=new Pair[1];
//
        pairs[0]=new Pair<View,String>(findViewById(R.id.activity),"transition_login");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(UserDashboard.this,pairs);
            startActivity(intent ,options.toBundle());
        }
        else {
            startActivity(intent);
        }
    }

    public void actionregister(View view) {
        Intent intent = new Intent(UserDashboard.this, RegisteronlineActivity.class);

        Pair[]  pairs=new Pair[1];
//
        pairs[0]=new Pair<View,String>(findViewById(R.id.onlineregister),"transition_login");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(UserDashboard.this,pairs);
            startActivity(intent ,options.toBundle());
        }
        else {
            startActivity(intent);
        }
    }

    public void actioncontact(View view) {
        Intent intent = new Intent(UserDashboard.this, ContactusActivity.class);

        Pair[]  pairs=new Pair[1];
//
        pairs[0]=new Pair<View,String>(findViewById(R.id.knowus),"transition_login");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(UserDashboard.this,pairs);
            startActivity(intent ,options.toBundle());
        }
        else {

            startActivity(intent);
        }
    }

    public void actionknowus(View view) {

        Intent intent = new Intent(UserDashboard.this, KnowusActivity.class);

        Pair[]  pairs=new Pair[1];
//
        pairs[0]=new Pair<View,String>(findViewById(R.id.a),"transition_login");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(UserDashboard.this,pairs);
            startActivity(intent ,options.toBundle());
        }
        else {

            startActivity(intent);
        }
    }

    public void actionlevel(View view) {

        Intent intent = new Intent(UserDashboard.this, LevelsActivity.class);

        Pair[]  pairs=new Pair[1];
//
        pairs[0]=new Pair<View,String>(findViewById(R.id.b),"transition_login");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(UserDashboard.this,pairs);
            startActivity(intent ,options.toBundle());
        }
        else {

            startActivity(intent);
        }
    }
}
