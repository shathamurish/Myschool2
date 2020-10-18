package com.shathamurish.myschool2.User;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.shashank.sony.fancytoastlib.FancyToast;
import com.shathamurish.myschool2.R;

public class StudentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);


//        registerHandler();
    }


    public void actionlogin(View view) {


        Intent intent = new Intent(getApplicationContext(), AcivitiesStudentActivity.class);
        startActivity(intent);
    }
}

//    private void registerHandler() {
//        imgIconLikee.setOnClickListener(new View.OnClickListener() {
//            boolean isAnimated=false;
//            @Override
//            public void onClick(View v) {
//                if (!isAnimated){ imgIconLikee.setSpeed(3f); isAnimated=true; imgIconLikee.playAnimation();}
//                else { imgIconLikee.setSpeed(-1F);
//                isAnimated=false;
//                imgIconLikee.playAnimation();}

//            }
//        });
//   }

