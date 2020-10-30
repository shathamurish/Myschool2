package com.shathamurish.myschool2.Help.HomeAdapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shathamurish.myschool2.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {


    ArrayList<NewsHelper> newslocation;

    public NewsAdapter(ArrayList<NewsHelper> newslocation) {
        this.newslocation = newslocation;
    }

    @NonNull
    @NotNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_design_card,viewGroup,false);
     //   View view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.annos_layout,viewGroup,false);
       NewsViewHolder newsViewHolder=new NewsViewHolder(view);
        //NewsViewHolder newsViewHolder2=new NewsViewHolder(view2);

        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NewsAdapter.NewsViewHolder newsViewHolder, int i) {

        NewsHelper newsHelper =newslocation.get(i);
        newsViewHolder.image.setImageResource(newsHelper.getImage());
        newsViewHolder.title.setText(newsHelper.getTitle());
       // newsViewHolder.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }

    @Override
    public int getItemCount() {
        return newslocation.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        public NewsViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);


            //hooks
            image=itemView.findViewById(R.id.news_image);
            title=itemView.findViewById(R.id.news_title);
        }
    }


}
