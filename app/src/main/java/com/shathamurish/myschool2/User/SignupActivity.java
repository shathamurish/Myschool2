package com.shathamurish.myschool2.User;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.shathamurish.myschool2.R;

public class SignupActivity extends AppCompatActivity {
    LottieAnimationView backbutton;
    LottieAnimationView imgIconLikee;
    Button next, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        imgIconLikee = findViewById(R.id.imgIconLike);
        backbutton = findViewById(R.id.back_login);
        next = findViewById(R.id.button_next);
        login = findViewById(R.id.button_login);
    }

    public void actionlogin(View view) {

        Intent intent = new Intent(getApplicationContext(), RegisteronlineActivity.class);
        startActivity(intent);
//        Pair[]  pairs=new Pair[1];
//
//        pairs[0]=new Pair<View,String>()
    }

    public void actionnext(View view) {
        Intent intent2 = new Intent(getApplicationContext(), Signup2Activity.class);

        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(imgIconLikee, "transition_image_btn");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        pairs[2] = new Pair<View, String>(backbutton, "transition_back_arrow_btn");
        pairs[3] = new Pair<View, String>(login, "transition_login_btn");

        ActivityOptions options = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            options = ActivityOptions.makeSceneTransitionAnimation(SignupActivity.this, pairs);

            startActivity(intent2, options.toBundle());
        } else {
            startActivity(intent2);
        }

    }

    public void backlayout(View view) {
        Intent intent = new Intent(getApplicationContext(),RegisteronlineActivity.class);
        startActivity(intent);

    }
}