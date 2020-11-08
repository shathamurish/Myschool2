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
    TextInputLayout fullname,username,address,password,city,phoneno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeronline);
        imgIconLikee = findViewById(R.id.imgIconLike);
        backbutton = findViewById(R.id.back_login);
        next = findViewById(R.id.button_next);
        login = findViewById(R.id.button_login);

        fullname=findViewById(R.id.signupname);
//        username= findViewById(R.id.signupuser);
        address=findViewById(R.id.sigupemail);
//        password=findViewById(R.id.signuppass);
        city=findViewById(R.id.signupcity);
        //        Button button=findViewById(R.id.bu);
        phoneno = findViewById(R.id.phoneeeee);

    }

    public void actionlogin(View view) {

        Intent intent = new Intent(getApplicationContext(), AcivitiesStudentActivity.class);
        startActivity(intent);
//        Pair[]  pairs=new Pair[1];
//
//        pairs[0]=new Pair<View,String>()
    }

    public void actionnext(View view) {
        if(!validateFullname() | !validateCity() | !validateaddress() |!validatePhoneNumber()){
         return;
        }

        String _fullname=fullname.getEditText().getText().toString().trim();
        String _address=address.getEditText().getText().toString().trim();
        String _phoneno=phoneno.getEditText().getText().toString().trim();
//      String _username=username.getEditText().getText().toString().trim();;
//        String _password=password.getEditText().getText().toString().trim();
        String _city=city.getEditText().getText().toString().trim();


        Intent intent2 = new Intent(getApplicationContext(), SignupActivity.class);



        intent2.putExtra("fullname",_fullname);
       intent2.putExtra("phoneno",_phoneno);
        intent2.putExtra("email",_address);
//        intent2.putExtra("password",_password);
        intent2.putExtra("city",_city);


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

    private  boolean validateCity(){
        String val = city.getEditText().getText().toString().trim();
//        String checkspaces ="\\A\\w{1,20}\\z";
        if (val.isEmpty()) {
            city.setError("Field Can Not Be empty");
        } else {
            city.setError(null);
            city.setErrorEnabled(false);

            }
            return true;
//        }else if(val.length()>20){
//            username.setError("Username is too large!");
//            return false;
//        }
//        else if(!val.matches(checkspaces)){
//            username.setError("NO White Spaces Are allowed");
//
//            return false;


    }

    private  boolean validateaddress(){
        String val = address.getEditText().getText().toString().trim();
        String checkemail ="[a-zA-Z0-9._-]+@[a-z]+\\.+[a+z]+";
        if (val.isEmpty()) {
            address.setError("Field Can Not Be empty");
            return false;
        }
//        else if(!val.matches(checkemail)){
//            email.setError("Invalid Email!");
//
//            return false;
//        }
        else {
            address.setError(null);
            address.setErrorEnabled(false);
            return true;
        }

    }
    private boolean validatePhoneNumber() {
        String val = phoneno.getEditText().getText().toString().trim();
        String checkspaces = "Aw{1,20}z";
        if (val.isEmpty()) {
            phoneno.setError("Enter valid phone number");
            return false;
        }
//        else if (!val.matches(checkspaces)) {
//            phonenum.setError("No White spaces are allowed!");
//            return false;
//        }


        else {
            phoneno.setError(null);
            phoneno.setErrorEnabled(false);
            return true;
        }
    }

//    private  boolean validatepass(){
//        String val = password.getEditText().getText().toString().trim();
//        String checkpass ="^" +
//                //"(?=.*[0-9])" +         //at least 1 digit
//                //"(?=.*[a-z])" +         //at least 1 lower case letter
//                //"(?=.*[A-Z])" +         //at least 1 upper case letter
//                "(?=.*[a-zA-Z])" +      //any letter
//                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
//                "(?=S+$)" +           //no white spaces
//                ".{4,}" +               //at least 4 characters
//                "$";
//
//        if (val.isEmpty()) {
//            password.setError("Field Can Not Be empty");
//            return false; }
////        else if(!val.matches(checkpass)){
////            password.setError("Password should contain 4 characters!");
////
////            return false;
////        }
//        else {
//            password.setError(null);
//            password.setErrorEnabled(false);
//            return true;
//        }
//
//    }
}