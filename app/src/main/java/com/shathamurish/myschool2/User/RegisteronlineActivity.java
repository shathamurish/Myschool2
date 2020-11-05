package com.shathamurish.myschool2.User;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputLayout;
import com.shathamurish.myschool2.R;

public class RegisteronlineActivity extends AppCompatActivity {

    LottieAnimationView backbutton;
    LottieAnimationView imgIconLikee;
    Button next, login;
    TextInputLayout fullname,username,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeronline);
        imgIconLikee = findViewById(R.id.imgIconLike);
        backbutton = findViewById(R.id.back_login);
        next = findViewById(R.id.button_next);
        login = findViewById(R.id.button_login);

        fullname=findViewById(R.id.signupname);
        username= findViewById(R.id.signupuser);
        email=findViewById(R.id.sigupemail);
        password=findViewById(R.id.signuppass);
    }

    public void actionlogin(View view) {

        Intent intent = new Intent(getApplicationContext(), AcivitiesStudentActivity.class);
        startActivity(intent);
//        Pair[]  pairs=new Pair[1];
//
//        pairs[0]=new Pair<View,String>()
    }

    public void actionnext(View view) {
        if(!validateFullname() | !validateUsername() | !validateEmail() | !validatepass()){
         return;
        }

        String _fullname=fullname.getEditText().getText().toString().trim();
        String _email=email.getEditText().getText().toString().trim();
        String _username=username.getEditText().getText().toString().trim();;
        String _password=password.getEditText().getText().toString().trim();


        Intent intent2 = new Intent(getApplicationContext(), SignupActivity.class);



        intent2.putExtra("fullname",_fullname);
        intent2.putExtra("username",_username);
        intent2.putExtra("email",_email);
        intent2.putExtra("password",_password);

        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(imgIconLikee, "transition_image_btn");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        pairs[2] = new Pair<View, String>(backbutton, "transition_back_arrow_btn");
        pairs[3] = new Pair<View, String>(login, "transition_login_btn");

        ActivityOptions options = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            options = ActivityOptions.makeSceneTransitionAnimation(RegisteronlineActivity.this, pairs);

            startActivity(intent2, options.toBundle());
        }
        else
        {
            startActivity(intent2);
        }
    }

    public void backlayout(View view) {
        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
        startActivity(intent);
    }




    private  boolean validateFullname(){
        String val = fullname.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            fullname.setError("Field Can Not Be empty");
        } else {
            fullname.setError(null);
            fullname.setErrorEnabled(false);

        }
        return true;
    }

    private  boolean validateUsername(){
        String val = username.getEditText().getText().toString().trim();
        String checkspaces ="\\A\\w{1,20}\\z";
        if (val.isEmpty()) {
            username.setError("Field Can Not Be empty");
            return false;
        }else if(val.length()>20){
            username.setError("Username is too large!");
            return false;
        }
        else if(!val.matches(checkspaces)){
            username.setError("NO White Spaces Are allowed");

            return false;
        }
        else {
           username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }

    }

    private  boolean validateEmail(){
        String val = email.getEditText().getText().toString().trim();
        String checkemail ="[a-zA-Z0-9._-]+@[a-z]+\\.+[a+z]+";
        if (val.isEmpty()) {
            email.setError("Field Can Not Be empty");
            return false;
        }
//        else if(!val.matches(checkemail)){
//            email.setError("Invalid Email!");
//
//            return false;
//        }
        else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }

    }

    private  boolean validatepass(){
        String val = password.getEditText().getText().toString().trim();
        String checkpass ="^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (val.isEmpty()) {
            password.setError("Field Can Not Be empty");
            return false; }
//        else if(!val.matches(checkpass)){
//            password.setError("Password should contain 4 characters!");
//
//            return false;
//        }
        else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }

    }
}