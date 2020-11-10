package com.shathamurish.myschool2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.shathamurish.myschool2.User.AcivitiesStudentActivity;
import com.shathamurish.myschool2.User.UserDashboard;

public class RequirmentActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requirment);




    }



    public void backarrowaction(View view) {

        Intent intent = new Intent(RequirmentActivity.this, UserDashboard.class);
        startActivity(intent);
    }

}