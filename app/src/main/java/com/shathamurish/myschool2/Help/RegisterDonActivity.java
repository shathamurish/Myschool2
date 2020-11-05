package com.shathamurish.myschool2.Help;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shathamurish.myschool2.R;
import com.shathamurish.myschool2.User.AcivitiesStudentActivity;
import com.shathamurish.myschool2.User.RegisteronlineActivity;
import com.shathamurish.myschool2.User.Signup2Activity;
import com.shathamurish.myschool2.User.StudentActivity;

import org.jetbrains.annotations.NotNull;

public class RegisterDonActivity extends AppCompatActivity {
    String fullname, username,  email, password,  gender,phoneno,date;
    boolean isCkecked=false;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_don);


        fullname=getIntent().getStringExtra("fullname");
        Log.d("name",fullname);
        email=getIntent().getStringExtra("email");
        username=getIntent().getStringExtra("username");
       password=getIntent().getStringExtra("password");
        gender=getIntent().getStringExtra("gender");
      phoneno=getIntent().getStringExtra("phoneno");
        gender=getIntent().getStringExtra("gender");
        date=getIntent().getStringExtra("date");

        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeNewUserData();
                Toast.makeText(RegisterDonActivity.this,"this is done",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), AcivitiesStudentActivity.class);
                startActivity(intent);

            }
        });



//        LottieAnimationView done=findViewById(R.id.donereg);
//        done.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(isCkecked){
//                    done.setSpeed(-1);
//                    done.playAnimation();
//                    isCkecked =false;
//                }
//                else {
//                    done.setSpeed(1);
//                    done.playAnimation();
//                    isCkecked=true;
//
//                    storeNewUserData();
//
//                }
//            }
//        });
//
//        fullname=getIntent().getStringExtra("fullname");
//        email=getIntent().getStringExtra("email");
//        username=getIntent().getStringExtra("username");
//       password=getIntent().getStringExtra("password");
//        gender=getIntent().getStringExtra("gender");
//      // phoneno=getIntent().getStringExtra("phone");




    }






    private void storeNewUserData() {
        FirebaseDatabase rootnode =FirebaseDatabase.getInstance();
        DatabaseReference reference =rootnode.getReference("Username").push();


//      reference.setValue("shathais meee");

        UserHelperClass addNewUser = new UserHelperClass(fullname,username,email,password,gender,phoneno,date);
//        ظظaddNewUser.setFullname(fullname);
//        addNewUser.setEmail(email);
//        addNewUser.setUsername(username);
//        addNewUser.setPassowrd(password);
//        addNewUser.setGender(gender);sousout


        System.out.println(addNewUser.toString());
        Log.e("err",addNewUser.toString());

        addNewUser.setId(reference.getKey());
       reference .setValue(addNewUser).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<Void> task) {

                if(task.isSuccessful())
                    Toast.makeText(getApplicationContext(),"sucess",Toast.LENGTH_LONG).show();
                else {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show()
                    ;
                    Log.e("err ", task.getException().getMessage());
                }
            }
        });


    }


}