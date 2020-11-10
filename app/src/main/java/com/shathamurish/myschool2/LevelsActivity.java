package com.shathamurish.myschool2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.florent37.expansionpanel.ExpansionLayout;
import com.shathamurish.myschool2.User.AcivitiesStudentActivity;
import com.shathamurish.myschool2.User.UserDashboard;

public class LevelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);


        ExpansionLayout expansionLayout = findViewById(R.id.expansionLayout);
        expansionLayout.addListener(new ExpansionLayout.Listener() {
            @Override
            public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {

            }
        });


        ExpansionLayout expansionLayout2 = findViewById(R.id.expansionLayout2);
        expansionLayout2.addListener(new ExpansionLayout.Listener() {
            @Override
            public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {

            }
        });

        ExpansionLayout expansionLayout3 = findViewById(R.id.expansionLayout3);
        expansionLayout3.addListener(new ExpansionLayout.Listener() {
            @Override
            public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {

            }
        });

        ExpansionLayout expansionLayout4 = findViewById(R.id.expansionLayout4);
        expansionLayout4.addListener(new ExpansionLayout.Listener() {
            @Override
            public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {

            }
        });

        ExpansionLayout expansionLayout5 = findViewById(R.id.expansionLayout6);
        expansionLayout5.addListener(new ExpansionLayout.Listener() {
            @Override
            public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {

            }
        });
        ExpansionLayout expansionLayout6 = findViewById(R.id.expansionLayout7);
        expansionLayout6.addListener(new ExpansionLayout.Listener() {
            @Override
            public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {

            }
        });
        ExpansionLayout expansionLayout7 = findViewById(R.id.expansionLayout8);
        expansionLayout7.addListener(new ExpansionLayout.Listener() {
            @Override
            public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {

            }
        });
        ExpansionLayout expansionLayout8 = findViewById(R.id.expansionLayout9);
        expansionLayout8.addListener(new ExpansionLayout.Listener() {
            @Override
            public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {

            }
        });
        ExpansionLayout expansionLayout9 = findViewById(R.id.expansionLayout10);
        expansionLayout9.addListener(new ExpansionLayout.Listener() {
            @Override
            public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {

            }
        });
        ExpansionLayout expansionLayout10 = findViewById(R.id.expansionLayout11);
        expansionLayout10.addListener(new ExpansionLayout.Listener() {
            @Override
            public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {

            }
        });
        ExpansionLayout expansionLayout11 = findViewById(R.id.expansionLayout12);
        expansionLayout11.addListener(new ExpansionLayout.Listener() {
            @Override
            public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {

            }
        });






    }

    public void backarrowaction(View view) {

        Intent intent = new Intent(LevelsActivity.this, UserDashboard.class);
        startActivity(intent);
    }

}