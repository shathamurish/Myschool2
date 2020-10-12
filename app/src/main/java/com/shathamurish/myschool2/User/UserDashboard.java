package com.shathamurish.myschool2.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.denzcoskun.imageslider.constants.ScaleTypes;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;


import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;
import com.shathamurish.myschool2.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
  // ArrayList<SlideModel> imageList =new  ArrayList<SlideModel>();
// drawer menu varibles

    static final float END_SCALE= 0.7f;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    ScrollView contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        //imageslider
        ImageSlider imageSlider=findViewById(R.id.image_slider);

        //dashboard hooks
        menuIcon=findViewById(R.id.menuicon);
        contentView =findViewById(R.id.content1);

       final List<SlideModel>imageList=new ArrayList<>();
//       imageList.add(new SlideModel("https://bit.ly/2YoJ77H\"));
//       imageList.add(new SlideModel("https://bit.ly/2YoJ77H\"));
//       imageList.add(new SlideModel("https://bit.ly/2YoJ77H\"));
//       imageList.add(new SlideModel("https://bit.ly/2YoJ77H\"));
        imageList.add(new SlideModel(R.drawable.sch10_1, "شوشو",ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.sch9,"شزا" ,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.sch5, "مرحبا",ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.sch6,"hello", ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.sch11_1,"hi", ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.libraryicon,"hi", ScaleTypes.FIT));

         imageSlider.setImageList(imageList,ScaleTypes.FIT);

         //menu hooks
        drawerLayout =findViewById(R.id.drawer_layout);
        navigationView =findViewById(R.id.navigation_view);


        navigationDrawer();

    }

    private void navigationDrawer() {


        //naviagion drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
                }
        });

        animateNaviagtionDrawer();

    }

    private void animateNaviagtionDrawer() {

        drawerLayout.setScrimColor(getResources().getColor(R.color.blue));
       drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
           @Override
           public void onDrawerSlide(@NonNull @NotNull View view, float v) {
               final float diffScaledOffset =v * (1 - END_SCALE);
               final float offsetScale =1- diffScaledOffset;
               contentView.setScaleX(offsetScale);
               contentView.setScaleY(offsetScale);
               final float xOffset=view.getWidth() *v;
               final float xOffsetDiff =contentView.getWidth() *diffScaledOffset/2;
               final float xTranslation =xOffset-xOffsetDiff;
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
        if (drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem menuItem) {
        return true;
    }
}
