package com.shathamurish.myschool2.User;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityOptions;

import android.content.Intent;
import android.content.pm.PackageManager;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.preference.Preference;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;
import com.shathamurish.myschool2.Help.RegisterDonActivity;
import com.shathamurish.myschool2.Help.UserHelperClass;
import com.shathamurish.myschool2.R;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.asList;
import static java.util.Arrays.parallelSetAll;


public class Signup2Activity extends AppCompatActivity {

    Spinner spinner;
    LottieAnimationView backbutton;
    LottieAnimationView imgIconLikee;
    LottieAnimationView doneupload;
    Button next, login, filepicker;
    TextView textView;
    Uri file;
    TextInputLayout phoneno;
    boolean isCkecked = false;

//    String  spinner1;
    FirebaseStorage storage;
    FirebaseDatabase firebaseDatabase;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1001);
        }


        spinner = findViewById(R.id.spinerr);
        filepicker = findViewById(R.id.picker);
        textView = findViewById(R.id.textfilechoose);
        imgIconLikee = findViewById(R.id.imgIconLike);
        backbutton = findViewById(R.id.back_login);
        next = findViewById(R.id.button_next);
        login = findViewById(R.id.button_login);
        phoneno = findViewById(R.id.phoneeeee);
//        Button button=findViewById(R.id.bu);


        storage = FirebaseStorage.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();


//        button.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View view) {
//              uploadfile(file);
//          }
//
//                                     });


        doneupload = findViewById(R.id.doneupload);
        doneupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isCkecked) {
                    doneupload.setSpeed(-1);
                    doneupload.playAnimation();
                    isCkecked = false;
                } else {
                    doneupload.setSpeed(1);
                    doneupload.playAnimation();

                    uploadfile(file);
                    isCkecked = true;






                }
            }
        });

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.arraylist, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

//                spinner1 =spinner.getSelectedItem().toString();

                // An item was selected. You can retrieve the selected item using
                // parent.getItemAtPosition(pos)
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });


        filepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ContextCompat.checkSelfPermission(Signup2Activity.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    selectfile();
                } else
                    ActivityCompat.requestPermissions(Signup2Activity.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 9);


            }
        });


//        .setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//             intent  =new Intent(Intent.ACTION_GET_CONTENT);
//             intent.setType("*/*");
//             startActivityForResult(intent ,10);
//
////
//            }
//        });
    }

    private void uploadfile(Uri file) {

       file = Uri.fromFile(new File("path/to/news/"));
        StorageReference riversRef = storage.getReference().child("news/.pdf");

        riversRef.putFile(file)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        Task<Uri> downloadUrl = taskSnapshot.getStorage().getDownloadUrl();
                        Toast.makeText(Signup2Activity.this, " file successfuly uploaded", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        Toast.makeText(Signup2Activity.this, "file not successfuly uploaded", Toast.LENGTH_SHORT).show();
                        // ...
                    }
                });
    }

//    private void uploadfile(Uri file) {
//        String filenamefolder=System.currentTimeMillis()+"";
//        StorageReference storageReference=storage.getReference();
//        storageReference.child("Upload").child(filenamefolder).putFile(file).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//
//                String url=taskSnapshot.getStorage().getDownloadUrl().toString();
//                DatabaseReference reference=firebaseDatabase.getReference();
//
//
//        reference.child(filenamefolder).setValue(url).addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull @NotNull Task<Void> task) {
//                                if (task.isSuccessful()) {
////                                    doneupload.setSpeed(-1);
////                                    doneupload.playAnimation();
//
//                                    Toast.makeText(Signup2Activity.this, " file successfuly uploaded", Toast.LENGTH_SHORT).show();
//                                } else
//                                    Toast.makeText(Signup2Activity.this, "file not successfuly uploaded", Toast.LENGTH_SHORT).show();
//
//
//                            }
//                        });
//                    }
//
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull @NotNull Exception e) {
//                Toast.makeText(Signup2Activity.this, "file not successfuly uploaded", Toast.LENGTH_SHORT).show();
//
//
//
//            }
//        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onProgress(@NonNull @NotNull UploadTask.TaskSnapshot snapshot) {
////
////                doneupload.setSpeed(1);
////                doneupload.playAnimation();
//
//            }
//        });
//
//
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        if (requestCode == 9 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            selectfile();
        }else
            Toast.makeText(Signup2Activity.this,"please provid permission",Toast.LENGTH_SHORT).show();
    }




    private void selectfile() {

        Intent intent=new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,86);
    }

    @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 86 && resultCode == RESULT_OK && data != null) {
            file = data.getData();
            textView.setText("sucess"+data.getData().getLastPathSegment());



        } else
            Toast.makeText(Signup2Activity.this, "please selecct file", Toast.LENGTH_SHORT).show();


    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode) {
//
//            case 10:
//                if (resultCode == RESULT_OK) {
//
////                    String path = data.getData().getPath();
//                    String path= data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);
//                    textView.setText(path);
////                case REQUEST_PICK_FILE:
////                    if(data.hasExtra(FilePickerActivity.EXTRA_FILE_PATH)) {
////                        // Get the file path
////                        File f = new File(data.getStringExtra(FilePickerActivity.EXTRA_FILE_PATH));
////
////                        // Set the file path text view
////                        mFilePathTextView.setText(f.getPath());
////      }
//                }
//                break;
//        }
//
//   }
////    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
//      switch (requestCode){
//          case 1001:{
//              if(grantResults[0] == PackageManager.PERMISSION_GRANTED ){
//
//                 Toast.makeText(this,"permision granted",Toast.LENGTH_SHORT).show();
//              }
//              else {
//                  Toast.makeText(this,"permision granted",Toast.LENGTH_SHORT).show();
//                  finish();
//              }
//          }
//      }
//    }



    public void actionlogin(View view) {

        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
        startActivity(intent);
//        Pair[]  pairs=new Pair[1];
//
//        pairs[0]=new Pair<View,String>()
    }

    public void actionnext(View view) {

        if(!validatePhoneNumber()){
            return;
        }


        String _phoneno=phoneno.getEditText().getText().toString().trim();


        String _spinner =spinner.getSelectedItem().toString();


        String _fullname=getIntent().getStringExtra("fullname");
       Log.e("name",_fullname);
        String _email=getIntent().getStringExtra("email");
        String _username=getIntent().getStringExtra("username");
        String _password=getIntent().getStringExtra("password");
      String _date =getIntent().getStringExtra("date");
        String _gender=getIntent().getStringExtra("gender");




        Intent intent2 = new Intent(getApplicationContext(), RegisterDonActivity.class);



        intent2.putExtra("fullname",_fullname);
        intent2.putExtra("username",_username);
        intent2.putExtra("email",_email);
        intent2.putExtra("password",_password);
      intent2.putExtra("date",_date);
        intent2.putExtra("gender",_gender);
        intent2.putExtra("phoneno",_phoneno);
        intent2.putExtra("spinner",_spinner);


       // intent2.putExtra("spinner1",_spinner);




       

        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(imgIconLikee, "transition_image_btn");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        pairs[2] = new Pair<View, String>(backbutton, "transition_back_arrow_btn");
        pairs[3] = new Pair<View, String>(login, "transition_login_btn");

        ActivityOptions options = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            options = ActivityOptions.makeSceneTransitionAnimation(Signup2Activity.this, pairs);

            startActivity(intent2, options.toBundle());
        } else {
            startActivity(intent2);
        }

        
    }

//    private void storeNewUserData() {
//        FirebaseDatabase rootnode =FirebaseDatabase.getInstance();
//        DatabaseReference reference =rootnode.getReference("User");
//        reference.setValue("meme");
////        UserHelperClass addNewUser = new UserHelperClass(fullname, username, email, passowrd);
////        reference.child(username).setValue(addNewUser);
//
//
//    }

    public void backlayout(View view) {
        Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
        startActivity(intent);
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
}