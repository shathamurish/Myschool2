package com.shathamurish.myschool2.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.shathamurish.myschool2.Help.HomeAdapter.NewsAdapter;
import com.shathamurish.myschool2.Help.HomeAdapter.NewsHelper;
import com.shathamurish.myschool2.R;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    LottieAnimationView sendimage;
    RecyclerView newrecycler;
    RecyclerView annocrecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        //hooks
        newrecycler=findViewById(R.id.new_recycler);
        annocrecycler=findViewById(R.id.Anno_recycler);

        sendimage = findViewById(R.id.sendicon);
        newrecycler();

        registerHandler();

        annocrecycler();
    }

    private void annocrecycler() {


        annocrecycler.setHasFixedSize(true);
        annocrecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<NewsHelper> newslocation=new ArrayList<>();
        newslocation.add(new NewsHelper(R.drawable.a,"hello from home of modern science school"));
        newslocation.add(new NewsHelper(R.drawable.b,"hello from home of modern science school"));
        newslocation.add(new NewsHelper(R.drawable.c,"hello from home of modern science school"));
        newslocation.add(new NewsHelper(R.drawable.d,"hello from home of modern science school"));
        newslocation.add(new NewsHelper(R.drawable.b,"hello from home of modern science school"));
        newslocation.add(new NewsHelper(R.drawable.c,"hello from home of modern science school"));
        adapter =new NewsAdapter(newslocation);
        annocrecycler.setAdapter(adapter);
    }

    private void registerHandler() {
        sendimage.setOnClickListener(new View.OnClickListener() {
            boolean isAnimated=false;
            @Override
            public void onClick(View v) {
                if (!isAnimated){ sendimage.setSpeed(3f); isAnimated=true; sendimage.playAnimation();}
                else { sendimage.setSpeed(-1F);
                    isAnimated=false;
                    sendimage.playAnimation();}

            }
        });
    }

    private void newrecycler() {

        newrecycler.setHasFixedSize(true);
        newrecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<NewsHelper> newslocation=new ArrayList<>();
        newslocation.add(new NewsHelper(R.drawable.schoolimage1,"hello from home of modern science school"));
        newslocation.add(new NewsHelper(R.drawable.schoolimage3,"hello from home of modern science school"));
        newslocation.add(new NewsHelper(R.drawable.schoolimage4,"hello from home of modern science school"));
        newslocation.add(new NewsHelper(R.drawable.schoolimage2,"hello from home of modern science school"));
        newslocation.add(new NewsHelper(R.drawable.bb,"hello from home of modern science school"));
        newslocation.add(new NewsHelper(R.drawable.cc,"hello from home of modern science school"));
        adapter =new NewsAdapter(newslocation);
        newrecycler.setAdapter(adapter);



    }


}