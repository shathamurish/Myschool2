package com.shathamurish.myschool2.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.shathamurish.myschool2.R;

public class ContactusActivity extends AppCompatActivity {

    String email ="shady.fahme@gmail.com";
    TextInputEditText subject ,messag;
    Button sendmessag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        subject=findViewById(R.id.subject_contact);
        messag=findViewById(R.id.messg_contact);
        sendmessag=findViewById(R.id.button_send);
    }

    public void actionsend(View view) {
        sendmessag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
                emailIntent.putExtra(Intent.EXTRA_TITLE,messag.getText().toString());
                emailIntent.setType("message/rfc822");
               // startActivity(emailIntent);
                startActivity(Intent.createChooser(emailIntent,"Choose Mail App"));
            }
        });
    }
}