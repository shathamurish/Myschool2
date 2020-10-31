package com.shathamurish.myschool2.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shathamurish.myschool2.R;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class NewsActivity extends AppCompatActivity {

     RecyclerView recyclerView1;
     RecyclerView recyclerView2;
     DatabaseReference databaseReference,databaseReference2;

  ArrayList<Newshelper> myarray;
    Newsadapter recylerAdapter;
   // private Context mcontext = NewsActivity.this;
    FirebaseRecyclerOptions<Newshelper> options;
    FirebaseRecyclerAdapter<Newshelper, Newsadapter>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        databaseReference = FirebaseDatabase.getInstance().getReference()
                .child("recyclerview");
        databaseReference2 =FirebaseDatabase.getInstance().getReference()
                .child("recyclerview2");
        //databaseReference.keepSynced(true);
        recyclerView1 = findViewById(R.id.new_recycler);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        recyclerView2=findViewById(R.id.Anno_recycler);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        myarray = new ArrayList<>();

//        GetDataFromFirease();
//        ClearAll();
        LoadData();
        Loaddata2();
        
    }

    private void Loaddata2() {
        options=new FirebaseRecyclerOptions.Builder<Newshelper>()
                .setQuery(databaseReference2,Newshelper.class).build();

        adapter=new FirebaseRecyclerAdapter<Newshelper, Newsadapter>(options) {
            @Override
            protected void onBindViewHolder(@NonNull @NotNull Newsadapter holder, int position, @NonNull @NotNull Newshelper model) {

                Picasso.get().load(model.getImage3()).into(holder.imageView2);
                holder.textView2.setText(model.getTitle3());

            }

            @NonNull
            @NotNull
            @Override
            public Newsadapter onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.annos_layout,parent,false);
                return new Newsadapter(v);
            }
        };

        adapter.startListening();
        recyclerView2.setAdapter(adapter);

    }


    private void LoadData() {

        options=new FirebaseRecyclerOptions.Builder<Newshelper>()
                .setQuery(databaseReference,Newshelper.class).build();

        adapter=new FirebaseRecyclerAdapter<Newshelper, Newsadapter>(options) {
            @Override
            protected void onBindViewHolder(@NonNull @NotNull Newsadapter holder, int position, @NonNull @NotNull Newshelper model) {

                Picasso.get().load(model.getImage2()).into(holder.imageView);
                holder.textView.setText(model.getTitle2());

            }

            @NonNull
            @NotNull
            @Override
            public Newsadapter onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
               View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_design_card,parent,false);
                return new Newsadapter(v);
            }
        };

        adapter.startListening();
        recyclerView1.setAdapter(adapter);

    }
}


//    private void GetDataFromFirease() {
//        Query query =databaseReference.child("recyclerview");
//        query.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
//                ClearAll();
//                for (DataSnapshot snapshot1:snapshot.getChildren()){
//                    Newshelper newshelper=new Newshelper();
//                    newshelper.setImage2(snapshot1.child("image2").getValue().toString());
//                    newshelper.setTitle2(snapshot1.child("title2").getValue().toString());
//                    myarray.add(newshelper);
//                }
//                recylerAdapter=new RecylerAdapter(getApplicationContext(),myarray);
//                recyclerView1.setAdapter(recylerAdapter);
//                recylerAdapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull @NotNull DatabaseError error) {
//
//            }
//        });
//
//
//
//    }
//
//    private void ClearAll(){
//        if(myarray !=null){
//
//
//            if(recylerAdapter!=null)
//            {
//               recylerAdapter.notifyDataSetChanged();
//            }
//        }
//        myarray=new ArrayList<>();
//    }
//}

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        FirebaseRecyclerAdapter<Newshelper, NewsAdapter> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Newshelper, NewsAdapter>
//                (Newshelper.class,R.layout.news_design_card, NewsAdapter.class,databaseReference) {
//            @Override
//            protected void onBindViewHolder(@NonNull @NotNull NewsAdapter holder, int position, @NonNull @NotNull Newshelper model) {
//
//                holder.setImage2(getApplicationContext(),model.getImage2());
//                holder.setTitle2(model.getTitle2());
//            }
//
//            @NonNull
//            @NotNull
//            @Override
//            public NewsAdapter onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
//                return null;
//            }
//        };
//        recyclerView1.setAdapter(firebaseRecyclerAdapter);
//    }
//
//    public static  class NewsAdapter extends RecyclerView.ViewHolder
//    {
//        View mview;
//        public NewsAdapter(View itemView)
//        {
//            super(itemView);
//            mview=itemView;
//
//        }
//
//        public void setTitle2(String title2){
//            TextView posttitle=mview.findViewById(R.id.news_title);
//            posttitle.setText(title2);
//        }
//        public void setImage2(Context cxt,String image2){
//            ImageView postimage=mview.findViewById(R.id.news_image);
//            Picasso.get(cxt).load(image2).into(postimage);
//        }
//    }
//}


