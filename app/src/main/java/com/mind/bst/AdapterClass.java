package com.mind.bst;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {
ArrayList<Deal>list;
    private Context mContext;

    //private ImageView clientimg;



    //private Activity context;
public  AdapterClass(ArrayList<Deal>list){
    this.list=list;


  //this.context=context;

}
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {




    View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_holder,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

    myViewHolder.id.setText(list.get(i).getClient());
    myViewHolder.desc.setText(list.get(i).getDate());
        //String context = AdapterClass.this;
      //Picasso.with(mContext).load(list.get(i).getClient_image_url().toString()).into(myViewHolder.clientimg);




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
    TextView id,desc;
    ImageView clientimg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.dealId);
            desc=itemView.findViewById(R.id.description);
            clientimg=itemView.findViewById(R.id.profile_pic);




        }
    }
}
