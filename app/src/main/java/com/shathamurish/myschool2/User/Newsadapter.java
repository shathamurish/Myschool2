package com.shathamurish.myschool2.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shathamurish.myschool2.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

class Newsadapter extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView textView;
    ImageView imageView2;
    TextView textView2;
    public Newsadapter(@NonNull @NotNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.news_image);
        textView=itemView.findViewById(R.id.news_title);
        imageView2=itemView.findViewById(R.id.non_image);
        textView2=itemView.findViewById(R.id.non_title);
    }
}
