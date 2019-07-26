package com.mind.bst;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PrevImg extends ArrayAdapter<Total> {
    private Activity context;
    List<Total> clients;
    FirebaseUser user;
    DatabaseReference databaseClients;
    String uid;

    private FirebaseAuth mAuth;
    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    // FirebaseDatabase mDatabase;
//String key = mDatabase.child("Calls Generated").push().getKey();

    public PrevImg(Activity context, List<Total> clients) {
        super(context, R.layout.activity_prev_img, clients);
        this.context = context;
        this.clients = clients;


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_prev_img, null, true);

        TextView textViewRegion = (TextView) listViewItem.findViewById(R.id.textRegion);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textName);

        TextView textViewAdd = (TextView) listViewItem.findViewById(R.id.textAdd);
        TextView textViewCont = (TextView) listViewItem.findViewById(R.id.textCont);

        TextView textViewEmail = (TextView) listViewItem.findViewById(R.id.textEmail);
        ImageView textViewUrl=(ImageView) listViewItem.findViewById(R.id.textclientimgurl);
        //textViewUrl.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textViewRemark = (TextView) listViewItem.findViewById(R.id.textclientremark);



        TextView textViewDate = (TextView) listViewItem.findViewById(R.id.textclientdate);
        TextView textViewComplaint = (TextView) listViewItem.findViewById(R.id.textdetailofcomplaint);

        TextView textViewEnggName = (TextView) listViewItem.findViewById(R.id.textenggname);

        TextView textViewEnggObs = (TextView) listViewItem.findViewById(R.id.textenggobservation);
        TextView textViewNatureOfComp = (TextView) listViewItem.findViewById(R.id.textnatureofcomplaint);







        TextView textViewPayment = (TextView) listViewItem.findViewById(R.id.textpaymentvia);
        TextView textViewProductName = (TextView) listViewItem.findViewById(R.id.textproductname);

        TextView textViewProductSrNo = (TextView) listViewItem.findViewById(R.id.productserialno);
        TextView textViewStatus = (TextView) listViewItem.findViewById(R.id.statusofcomplaint);

        TextView textViewTime = (TextView) listViewItem.findViewById(R.id.time);


        mAuth = FirebaseAuth.getInstance(); // important Call
        //Again check if the user is Already Logged in or Not


        user=FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();

        Total data = clients.get(position);

      //FirebaseUser user = mAuth.getCurrentUser();
        //Log.d("LOGGED", "FirebaseUser: " + user);
//        String key = databaseClients.child("Calls Generated").push().getKey();




        textViewCont.setText(data.getCust_cont());
        textViewEmail.setText(data.getCust_email());
        textViewRegion.setText(data.getCity());

        textViewName.setText(data.getClient());
        textViewAdd.setText(data.getClient_add());
//        textViewDate.setText(data.getDate());
        textViewTime.setText(data.getTime());
        textViewProductSrNo.setText(data.getProduct_serial_no());
       textViewNatureOfComp.setText(data.getNature_of_complaint());
        textViewComplaint.setText(data.getDetails_of_complaint());
        textViewEnggObs.setText(data.getEngineer_observation());
        textViewRemark.setText(data.getClient_remark());
        textViewProductName.setText(data.getProduct_name());
        textViewStatus.setText(data.getStatus_of_complaint());
        textViewPayment.setText(data.getPayment_via());
        textViewEnggName.setText(data.getEngineer());
        // textViewUrl.setText(data.getClient_image_url());
        Picasso.with(context).load(data.getClient_image_url().toString()).into(textViewUrl);





        return listViewItem;
    }



}