package com.shathamurish.myschool2.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shathamurish.myschool2.Help.SliderAdapter;
import com.shathamurish.myschool2.R;
import com.shathamurish.myschool2.User.ContactusActivity;
import com.shathamurish.myschool2.User.UserDashboard;

public class OnBording extends AppCompatActivity {

    //varabils
    ViewPager viewPager;
    LinearLayout dots_layout;

    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button letsgetstarted;
    Animation  animation;
    int currentpos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_bording);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //hooks
        viewPager = findViewById(R.id.slider);
        dots_layout = findViewById(R.id.dots);
        letsgetstarted=findViewById(R.id.getstarted_btn);

        letsgetstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 Intent intent = new Intent(OnBording.this, UserDashboard.class);

            startActivity(intent);
        }



        });

        //calls adapter

        sliderAdapter = new SliderAdapter(this);

        viewPager.setAdapter(sliderAdapter);

        //dots
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);

    }

    public void skip(View view){

        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();
    }
    public void next(View view){

       viewPager.setCurrentItem(currentpos +1);
    }

    private void addDots(int ii) {

        dots = new TextView[4];
        dots_layout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);

           // dots[i].setTextColor(Color.parseColor("#283593"));

            dots_layout.addView(dots[i]);
        }

        if (dots.length>0){
            dots[ii].setTextColor(getResources().getColor(R.color.darkbluee));
        }
    }

    ViewPager.OnPageChangeListener changeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int ii, float v, int i1) {

        }

        @Override
        public void onPageSelected(int ii) {

            addDots(ii);
            currentpos =ii;
            if(ii==0){

                letsgetstarted.setVisibility(View.INVISIBLE);
            }
            else if (ii==1){
                letsgetstarted.setVisibility(View.INVISIBLE);
            }
            else if (ii==2){
                letsgetstarted.setVisibility(View.INVISIBLE);
            }
             else {
                 animation= AnimationUtils.loadAnimation(OnBording.this,R.anim.sidebottom_animation);
                 letsgetstarted.setAnimation(animation);
                letsgetstarted.setVisibility(View.VISIBLE);

            }

        }

        @Override
        public void onPageScrollStateChanged(int ii) {

        }
    };


}