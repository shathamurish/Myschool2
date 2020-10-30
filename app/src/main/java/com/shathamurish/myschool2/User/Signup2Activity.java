package com.shathamurish.myschool2.User;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityOptions;

import android.content.Intent;
import android.content.pm.PackageManager;

import android.os.Build;
import android.os.Bundle;

import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;


import com.nbsp.materialfilepicker.ui.FilePickerActivity;
import com.shathamurish.myschool2.R;

import org.jetbrains.annotations.NotNull;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.asList;


public class Signup2Activity extends AppCompatActivity {

    Spinner spinner;
    LottieAnimationView backbutton;
    LottieAnimationView imgIconLikee;
    Button next, login,filepicker;
    TextView textView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1001);
        }


        spinner=findViewById(R.id.spinerr);
        filepicker = findViewById(R.id.picker);
        textView = findViewById(R.id.textfilechoose);
        imgIconLikee = findViewById(R.id.imgIconLike);
        backbutton = findViewById(R.id.back_login);
        next = findViewById(R.id.button_next);
        login = findViewById(R.id.button_login);


//        String[] value={"K.G1","K.G2","Level1","Level2","Level3","Level4",
               // "Level5","Level6","Level7","Level8","Level9"};
//        ArrayList<String> arrayList =new ArrayList<>(Arrays.asList(value));
        //ArrayAdapter<String>arrayAdapter=new ArrayAdapter<>(this,R.layout.style_spinner,arrayList);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
               R.array.arraylist, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                // An item was selected. You can retrieve the selected item using
                // parent.getItemAtPosition(pos)
            }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
        });


//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if (parent.getItemAtPosition(position).equals("Choose Level")){
//                }else {
//                    String item = parent.getItemAtPosition(position).toString();
//                    Toast.makeText(parent.getContext(),"Selected: " +item, Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });



        filepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


             intent  =new Intent(Intent.ACTION_GET_CONTENT);
             intent.setType("*/*");
             startActivityForResult(intent ,10);

//
//                switch(view.getId()) {
//                    case R.id.picker:
//                        // Create a new Intent for the file picker activity
//                        Intent intent = new Intent(this, FilePickerActivity.class);
//
//                        // Set the initial directory to be the sdcard
//                        //intent.putExtra(FilePickerActivity.EXTRA_FILE_PATH, Environment.getExternalStorageDirectory());
//
//                        // Show hidden files
//                        //intent.putExtra(FilePickerActivity.EXTRA_SHOW_HIDDEN_FILES, true);
//
//                        // Only make .png files visible
//                        //ArrayList<String> extensions = new ArrayList<String>();
//                        //extensions.add(".png");
//                        //intent.putExtra(FilePickerActivity.EXTRA_ACCEPTED_FILE_EXTENSIONS, extensions);
//
//                        // Start the activity
//                        startActivityForResult(intent, REQUEST_PICK_FILE);
//                        break;
//                }



            }


//            Public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
//
//                public void onItemSelected(AdapterView<?> parent, View view,
//                                           int pos, long id) {
//                    // An item was selected. You can retrieve the selected item using
//                     parent.getItemAtPosition(pos);
//                }
//
//                public void onNothingSelected(AdapterView<?> parent) {
//                    // Another interface callback
//                }
//            }
//             new MaterialFilePicker()
//                        // Pass a source of context. Can be:
//                        //    .withActivity(Activity activity)
//                        //    .withFragment(Fragment fragment)
//                        //    .withSupportFragment(androidx.fragment.app.Fragment fragment)
//                        .withActivity(Signup2Activity.this)
//                        // With cross icon on the right side of toolbar for closing picker straight away
//                        .withCloseMenu(true)
//                        // Entry point path (user will start from it)
//                        .withRequestCode(1000)
//                        // Root path (user won't be able to come higher than it)
//
//                        // Showing hidden files
//                        .withHiddenFiles(true)
//                        // Want to choose only jpg images
//                        .withFilter(Pattern.compile(".*\\.(jpg|jpeg)$"))
//                        // Don't apply filter to directories names
//                        .withFilterDirectories(false)
//                        .withTitle("Sample title")
////                        .start();
//                String path = String.valueOf(Environment.getExternalStorageDirectory());
//                File file = new File(path);
//                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                intent.setDataAndType(Uri.fromFile(file), "application/vnd.ms-excel");
//                    startActivityForResult(intent.createChooser(intent, "Select file"), 0);

        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {

            case 10:
                if (resultCode == RESULT_OK) {

//                    String path = data.getData().getPath();
                    String path= data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);
                    textView.setText(path);
//                case REQUEST_PICK_FILE:
//                    if(data.hasExtra(FilePickerActivity.EXTRA_FILE_PATH)) {
//                        // Get the file path
//                        File f = new File(data.getStringExtra(FilePickerActivity.EXTRA_FILE_PATH));
//
//                        // Set the file path text view
//                        mFilePathTextView.setText(f.getPath());
//      }
                }
                break;
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
      switch (requestCode){
          case 1001:{
              if(grantResults[0] == PackageManager.PERMISSION_GRANTED ){

                 Toast.makeText(this,"permision granted",Toast.LENGTH_SHORT).show();
              }
              else {
                  Toast.makeText(this,"permision granted",Toast.LENGTH_SHORT).show();
                  finish();
              }
          }
      }
    }

    public void actionlogin(View view) {

        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
        startActivity(intent);
//        Pair[]  pairs=new Pair[1];
//
//        pairs[0]=new Pair<View,String>()
    }

    public void actionnext(View view) {
        Intent intent2 = new Intent(getApplicationContext(), AcivitiesStudentActivity.class);

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

    public void backlayout(View view) {
        Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
        startActivity(intent);
    }


        }
