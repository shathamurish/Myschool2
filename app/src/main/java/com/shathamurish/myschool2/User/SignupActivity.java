package com.shathamurish.myschool2.User;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.shathamurish.myschool2.R;

import java.util.Calendar;

public class SignupActivity extends AppCompatActivity {
    LottieAnimationView backbutton;
    LottieAnimationView imgIconLikee;
    Button next, login;
    RadioGroup radioGroup;
    RadioButton selectgender;
   DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        imgIconLikee = findViewById(R.id.imgIconLike);
        backbutton = findViewById(R.id.back_login);
        next = findViewById(R.id.button_next);
        login = findViewById(R.id.button_login);
        radioGroup=findViewById(R.id.radiogroup);
        datePicker=findViewById(R.id.age_picker);


    }

    public void actionprev(View view) {

        Intent intent = new Intent(getApplicationContext(), RegisteronlineActivity.class);
        startActivity(intent);
//        Pair[]  pairs=new Pair[1];
//
//        pairs[0]=new Pair<View,String>()
    }

    public void actionnext(View view) {

        if(!validateGender() | ! validateAge()  ) {
            return;
        }

        selectgender=findViewById(radioGroup.getCheckedRadioButtonId());
        String _gender= selectgender.getText().toString();

        int day =datePicker.getDayOfMonth();
        int month =datePicker.getMonth();
        int year =datePicker.getYear();

        String _date=day+"/"+month+"/"+year;

        String _fullname=getIntent().getStringExtra("fullname");
        Log.e("name",_fullname);
        String _address=getIntent().getStringExtra("address");
        String _phoneno=getIntent().getStringExtra("phoneno");
//        String _password=getIntent().getStringExtra("password");
        String _city=getIntent().getStringExtra("city");










        Intent intent2 = new Intent(getApplicationContext(), Signup2Activity.class);


        intent2.putExtra("fullname",_fullname);
        intent2.putExtra("address",_address);
        intent2.putExtra("phoneno",_phoneno);
//        intent2.putExtra("password",_password);
        intent2.putExtra("city",_city);
        intent2.putExtra("date",_date);
        intent2.putExtra("gender",_gender);



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

    private boolean validateGender() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validateAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        //int isAgeValid = currentYear - userAge;

//        if (isAgeValid < 14) {
//            Toast.makeText(this, "You are not eligible to apply", Toast.LENGTH_SHORT).show();
//            return false;
//        } else
            return true;
    }
}