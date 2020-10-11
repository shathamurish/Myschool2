package com.shathamurish.myschool2.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.shathamurish.myschool2.R;
import com.shathamurish.myschool2.User.UserDashboard;


public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER =5000;
    //varibles
    Animation topanim,botanim;
    ImageView animationimages;
    TextView poweredby;
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        //animation
        topanim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        botanim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
         //hook
        animationimages =findViewById(R.id.animimg);
        poweredby =findViewById(R.id.powered_by_line);

        animationimages.setAnimation(topanim);
        poweredby.setAnimation(botanim);

        new Handler().postDelayed(() -> {

            onBoardingScreen =getSharedPreferences("onBoardingScreen",MODE_PRIVATE);



            boolean isFirstTime =onBoardingScreen.getBoolean("firstTime",true);

            if (isFirstTime){

                SharedPreferences.Editor editor=onBoardingScreen.edit();
                editor.putBoolean("firstTime",false);
                editor.commit();

                Intent intent =new Intent(SplashScreen.this, OnBording.class);
                startActivity(intent);
                finish();



            }
            else {
                Intent intent =new Intent(getApplicationContext(), UserDashboard.class);
                startActivity(intent);
                finish();

            }

        },SPLASH_TIMER);
    }
}