package com.shathamurish.myschool2.User;

//
//import android.app.Activity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.shathamurish.myschool2.Common.SendMailTask;
//import com.shathamurish.myschool2.R;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class ContactusActivity extends Activity {
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_contactus);
//        final Button send = (Button) this.findViewById(R.id.button1);
//
//        send.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//                Log.i("SendMailActivity", "Send Button Clicked.");
//
//                String fromEmail = ((TextView) findViewById(R.id.editText1))
//                        .getText().toString();
//                String fromPassword = ((TextView) findViewById(R.id.editText2))
//                        .getText().toString();
//                String toEmails = ((TextView) findViewById(R.id.editText3))
//                        .getText().toString();
//                List<String> toEmailList = Arrays.asList(toEmails
//                        .split("\\s*,\\s*"));
//                Log.i("SendMailActivity", "To List: " + toEmailList);
//                String emailSubject = ((TextView) findViewById(R.id.editText4))
//                        .getText().toString();
//                String emailBody = ((TextView) findViewById(R.id.editText5))
//                        .getText().toString();
//                new SendMailTask(ContactusActivity.this).execute(fromEmail,
//                        fromPassword, toEmailList, emailSubject, emailBody);
//            }
//        });
//    }
//}

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.airbnb.lottie.LottieAnimationView;
import com.shathamurish.myschool2.R;

//
public class ContactusActivity extends AppCompatActivity {
    //
    String email = "info@hmss-edu.com";
    LottieAnimationView sendemail;
//      String email ="shady.fahme@gmail.com";
    EditText subject, messag, phoneno;
    Button sendmessag;
    //
//    GMailSender sender;
    String epassword = "shathah123";
    String user = "shatha.murish@gmail.com";
    String sb, bd, ph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contactus);
        subject = findViewById(R.id.subject_contact);
        messag = findViewById(R.id.messg_contact);
        sendmessag = findViewById(R.id.button_send);
        phoneno = findViewById(R.id.textphone);
      sendemail=findViewById(R.id.sendmail);

//        sender = new GMailSender(user, epassword);

       sendmessag.setOnClickListener(new View.OnClickListener() {
          @SuppressLint("IntentReset")
          @Override
           public void onClick(View view) {
//                sb = subject.getText().toString();
//                bd = messag.getText().toString();
//               ph = phoneno.getText().toString();
//
//                new MyAsyncClass().execute();
//              sendemail.setSpeed(1);
//              sendemail.playAnimation();
//              sendemail.setRepeatCount(5);


              String meg=messag.getText().toString().trim();
              Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
//              emailIntent.setType("message/rfc822");

              emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
              emailIntent.putExtra(Intent.EXTRA_TEXT,meg);

              startActivity(emailIntent);
              startActivity(Intent.createChooser(emailIntent,"Choose Mail App"));


//
            }
        });}

//   class MyAsyncClass extends AsyncTask<Void, Void, Void> {
////
//        ProgressDialog pDialog;
//
//        @Override
//        protected void onPreExecute() {
//
//            super.onPreExecute();
//            pDialog = new ProgressDialog(ContactusActivity.this);
//            pDialog.setMessage("Please wait...");
//            pDialog.show();
//
//        }
//
//        @Override
//
//        protected Void doInBackground(Void... mApi) {
//            try {
//
//                // Add subject, Body, your mail Id, and receiver mail Id.
//                sender.sendMail(sb, bd, user, email);
//                Log.d("send", "done");
//            }
//            catch (Exception ex) {
//                Log.d("exceptionsending", ex.toString());
//            }
//            return null;
//        }
//
//        @Override
//
//        protected void onPostExecute(Void result) {
//
//            super.onPostExecute(result);
//            pDialog.cancel();
//
//            Toast.makeText(ContactusActivity.this, "mail send", Toast.LENGTH_SHORT).show();
//
//        }
    }


//    public void actionsend(View view) {
//       sendmessag.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
////
////                Properties properties=new Properties();
////                properties.put("mail.smtp.auth","true");
////                properties.put("mail.smtp.starttls.enable","true");
////                properties.put("mail.smtp.host","smtp.gmail.com");
////                properties.put("mail.smtp.port","587");
////
////
////                Session session=Session.getInstance(properties, new Authenticator() {
////                    @Override
////                    protected PasswordAuthentication getPasswordAuthentication() {
////
////                        return new PasswordAuthentication(semail,epassword);
////                    }
////                });
////
////
////                try {
////                 Message mimeMessage = new MimeMessage(session);
////
////                    mimeMessage.setFrom(new InternetAddress(semail));
////                    mimeMessage.setRecipients(Message.RecipientType.TO,
////                            InternetAddress.parse(email));
////                    mimeMessage.setSubject(subject.getText().toString().trim());
////                    mimeMessage.setText(messag.getText().toString().trim());
////                    mimeMessage.setText(phoneno.getText().toString().trim());
////
////                    new SendMail().execute(mimeMessage);
////                } catch (MessagingException e) {
////                    e.printStackTrace();
////                }
////
////
////            }
////                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
////                emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
////                emailIntent.putExtra(Intent.EXTRA_TITLE,messag.getText().toString());
////
////                startActivity(emailIntent);
////                startActivity(Intent.createChooser(emailIntent,"Choose Mail App"));
////
////        });
////    }
////    }
//
////}
//
////
////    private class SendMail  extends AsyncTask<Message,String,String> {
////        private ProgressDialog progressDialog;
//////        String userName = AppConfigManager.getProperty("SENDER-EMAIL-SMTP-USERNAME");
//////        String password = AppConfigManager.getProperty("SENDER-EMAIL-SMTP-PASSWORD");
////
////        @Override
////        protected void onPreExecute() {
////            super.onPreExecute();
////
////            progressDialog=ProgressDialog.show(ContactusActivity.this,"pleas wait","send mail...",
////                    true,false);
////        }
////
////        @Override
////        protected String doInBackground(Message... messages) {
////            try {
////                Transport.send(messages[0]);
////                return "success";
////            } catch (MessagingException e) {
////                e.printStackTrace();
////                return "error";
////            }
////
////        }
////
////        @Override
////        protected void onPostExecute(String s) {
////            super.onPostExecute(s);
////
////            progressDialog.dismiss();
////            if(s.equals("success")) {
////
////                AlertDialog.Builder builder = new AlertDialog.Builder(ContactusActivity.this);
////                builder.setCancelable(false);
////                builder.setTitle(Html.fromHtml("<font color'#82B1FF'>success</font>"));
////                builder.setMessage("Mail send successfully");
////                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////                        dialogInterface.dismiss();
////                        subject.setText("");
////                        messag.setText("");
////                        phoneno.setText("");
////                    }
////                });
////                builder.show();
////            }else
////                Toast.makeText(getApplicationContext(),"some this went wrrong",Toast.LENGTH_SHORT).show();
////            }
////        }
////    }
