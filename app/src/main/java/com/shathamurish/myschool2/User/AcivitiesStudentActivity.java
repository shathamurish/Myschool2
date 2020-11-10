package com.shathamurish.myschool2.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shathamurish.myschool2.R;

public class AcivitiesStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acivities_student);
    }

    public void backarrowaction(View view) {

        Intent intent = new Intent(AcivitiesStudentActivity.this, UserDashboard.class);
        startActivity(intent);
    }
}