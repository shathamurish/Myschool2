package com.shathamurish.myschool2.Help;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.shathamurish.myschool2.R;

import org.jetbrains.annotations.NotNull;

public class SliderAdapter extends PagerAdapter{

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }
     int images[] ={

             R.drawable.aa,
             R.drawable.dd,
             R.drawable.cc,
             R.drawable.bb
     };
    int heading[]={
            R.string.titlss,
            R.string.titlss,
            R.string.titlss,
            R.string.titlss
    };

    @Override
    public int getCount() {
        return heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull @org.jetbrains.annotations.NotNull View view, @NonNull @org.jetbrains.annotations.NotNull Object o) {
        return view == (ConstraintLayout)o;
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
       layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
       View view=layoutInflater.inflate(R.layout.slides_layout,container,false);


       //hooks
        ImageView imageView =view.findViewById(R.id.slider_images);
        TextView  textView=view.findViewById(R.id.heading_text);


        imageView.setImageResource(images[position]);
        textView.setText(heading[position]);

        container.addView( view);




        return  view;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
