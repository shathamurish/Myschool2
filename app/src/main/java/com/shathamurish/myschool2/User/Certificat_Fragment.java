package com.shathamurish.myschool2.User;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.shathamurish.myschool2.R;

public class Certificat_Fragment extends Fragment {



    public Certificat_Fragment()  {



    }


    public void onStart() {
        super.onStart();

        ImageView facebook=getActivity().findViewById(R.id.facebook);
       // TextView textView = getActivity().findViewById(R.id.link1);
        facebook.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/hmss.edu/"));
//                startActivity(in);
//                in.setPackage("com.facebook.katana");

                startActivity(in);

            }


        });

        ImageView instgram=getActivity().findViewById(R.id.instgram);
        //TextView textView2 = getActivity().findViewById(R.id.textView11);
        instgram.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.instagram.com/hmss_edu/"));
//                Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/hmss_edu"));
////                startActivity(in);
//                in.setPackage("com.instagram.android");

                startActivity(i);

            }


        });


        ImageView web=getActivity().findViewById(R.id.web);
        //TextView textView2 = getActivity().findViewById(R.id.textView11);
        web.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.hmss-edu.com/home1.php/"));
//                Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/hmss_edu"));
////                startActivity(in);
//                in.setPackage("com.instagram.android");

                startActivity(i);

            }


        });
        ImageView emaill=getActivity().findViewById(R.id.emailll);
       // TextView textView3 = getActivity().findViewById(R.id.link2);
        String email = "shady.fahme@gmail.com";

        emaill.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));

                startActivity(emailIntent);
            }


        });

        ImageView call=getActivity().findViewById(R.id.call);

       // TextView textView4 = getActivity().findViewById(R.id.textView13);
        call.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                String phone = "+01 423 692";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);


//                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "01 423 692"));
//                startActivity(intent);

            }


        });
        ImageView telegram=getActivity().findViewById(R.id.telegram);

        //TextView textView6 = getActivity().findViewById(R.id.textView12);
        telegram.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                Intent i = new Intent(Intent.ACTION_VIEW , Uri.parse("https://telegram.me/hmss_edu"));
//                Intent i = new Intent(Intent.ACTION_SENDTO);
//                i.setData(Uri.parse("http://telegram.me/hmss_edu"));
//                i.setPackage("org.telegram.messenger");
                startActivity(i);
            }


        });

        ImageView whatsapp=getActivity().findViewById(R.id.whatsapp);
       // TextView textView5 = getActivity().findViewById(R.id.textView10);
        whatsapp.setOnClickListener(new View.OnClickListener() {

            String smsNumber = "+967776779292";

            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse("smsto:" + smsNumber);
                Intent i = new Intent(Intent.ACTION_SENDTO, uri);

                i.setPackage("com.whatsapp");
                startActivity(i);

//
//                String formattedNumber = Util.formatPhone(smsNumber);
//                try {
//                    Intent sendIntent = new Intent("android.intent.action.MAIN");
//                    sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
//                    sendIntent.setAction(Intent.ACTION_SEND);
//
//                    sendIntent.setPackage("com.whatsapp");
//                    startActivity(sendIntent);
//                } catch (Exception e) {
//                    Toast.makeText(getActivity(),"Error/n" + e.toString(), Toast.LENGTH_SHORT).show();
//                }
//
            }
//

        });
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_certificat_, container, false);

//        TextView.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Intent in=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.twitter.com/"));
//                startActivity(in);
//            }
//
//        });
    }
}