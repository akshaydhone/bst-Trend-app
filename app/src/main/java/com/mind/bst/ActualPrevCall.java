package com.mind.bst;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ActualPrevCall extends AppCompatActivity {
   //ListView listViewClients;
   private Activity context;
    List<Total> clients;
    FirebaseUser user;
   // TextView t1;
    ImageView t2;
    String key;

    DatabaseReference databaseClients;
    private FirebaseAuth mAuth;
    String uid;
    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    // FirebaseDatabase mDatabase;
   //String key = mDatabase.child("Calls Generated").push().getKey();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_prev_call);
        Intent intent = getIntent();
        getSupportActionBar().setTitle("Call Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        user=FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();
// key = databaseClients.child("Calls Generated").push().getKey();


        databaseClients = FirebaseDatabase.getInstance().getReference("Calls Generated");
     // listViewClients = (ListView) findViewById(R.id.listViewClients);
     // t1=(TextView)findViewById(R.id.textView);
        //t1.setText(intent.getStringExtra(Retrievedatasample.Region));
        t2=(ImageView)findViewById(R.id.textclientimgurl);



        TextView textViewRegion = (TextView)findViewById(R.id.textRegion);
        TextView textViewName = (TextView)findViewById(R.id.textName);

        TextView textViewAdd = (TextView) findViewById(R.id.textAdd);
        TextView textViewCont = (TextView) findViewById(R.id.textCont);

        TextView textViewEmail = (TextView) findViewById(R.id.textEmail);
        ImageView textViewUrl=(ImageView) findViewById(R.id.textclientimgurl);
        //textViewUrl.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textViewRemark = (TextView) findViewById(R.id.textclientremark);



        TextView textViewDate = (TextView) findViewById(R.id.textclientdate);
        TextView textViewComplaint = (TextView) findViewById(R.id.textdetailofcomplaint);

        TextView textViewEnggName = (TextView) findViewById(R.id.textenggname);

        TextView textViewEnggObs = (TextView) findViewById(R.id.textenggobservation);
        TextView textViewNatureOfComp = (TextView) findViewById(R.id.textnatureofcomplaint);







        TextView textViewPayment = (TextView) findViewById(R.id.textpaymentvia);
        TextView textViewProductName = (TextView) findViewById(R.id.textproductname);

        TextView textViewProductSrNo = (TextView) findViewById(R.id.productserialno);
        TextView textViewStatus = (TextView) findViewById(R.id.statusofcomplaint);

        TextView textViewTime = (TextView) findViewById(R.id.time);

        TextView textViewCallAssignedTo = (TextView) findViewById(R.id.textcallassignedto);

        TextView textViewCallVisitDate = (TextView) findViewById(R.id.textcallvisitdate);


        TextView textViewProName = (TextView) findViewById(R.id.productname);
        TextView textViewProSerialNo= (TextView) findViewById(R.id.proserialno);
        TextView textViewInTimeEngineer = (TextView) findViewById(R.id.intimeofengineer);
        TextView textViewCallAttendDate = (TextView) findViewById(R.id.callattendingdate);


        TextView textViewNop = (TextView) findViewById(R.id.nop);
        TextView textViewDop= (TextView) findViewById(R.id.dop);
        TextView textViewObsEngg = (TextView) findViewById(R.id.observationengg);
        TextView textViewRemarkClient = (TextView) findViewById(R.id.remarkclient);



        textViewCont.setText(intent.getStringExtra(Retrievedatasample.customername));
        textViewEmail.setText(intent.getStringExtra(Retrievedatasample.customerrepname));
        textViewRegion.setText(intent.getStringExtra(Retrievedatasample.regionofserviceengineer));

        textViewName.setText(intent.getStringExtra(Retrievedatasample.customername));
        textViewAdd.setText(intent.getStringExtra(Retrievedatasample.cityofservice));
//        textViewDate.setText(data.getDate());
        textViewTime.setText(intent.getStringExtra(Retrievedatasample.customeremailid));
        textViewProductSrNo.setText(intent.getStringExtra(Retrievedatasample.gstin));
        textViewNatureOfComp.setText(intent.getStringExtra(Retrievedatasample.customercity));
        textViewComplaint.setText(intent.getStringExtra(Retrievedatasample.customerstate));
        textViewEnggObs.setText(intent.getStringExtra(Retrievedatasample.productcategory));
        textViewRemark.setText(intent.getStringExtra(Retrievedatasample.productdescription));
        textViewProductName.setText(intent.getStringExtra(Retrievedatasample.customeraddress));
        textViewStatus.setText(intent.getStringExtra(Retrievedatasample.customercountry));
        textViewPayment.setText(intent.getStringExtra(Retrievedatasample.calllogdate));
        textViewEnggName.setText(intent.getStringExtra(Retrievedatasample.nameofserviceengineer));
        // textViewUrl.setText(data.getClient_image_url());
        textViewCallAssignedTo.setText(intent.getStringExtra(Retrievedatasample.callassignedto));
        textViewCallVisitDate.setText(intent.getStringExtra(Retrievedatasample.callvisitingdate));



        textViewProName.setText(intent.getStringExtra(Retrievedatasample.productname));
        textViewProSerialNo.setText(intent.getStringExtra(Retrievedatasample.productserialno));
        textViewInTimeEngineer.setText(intent.getStringExtra(Retrievedatasample.engineerintime));
        textViewCallAttendDate.setText(intent.getStringExtra(Retrievedatasample.callattendingdate));



        textViewNop.setText(intent.getStringExtra(Retrievedatasample.natureofcomplaint));
        textViewDop.setText(intent.getStringExtra(Retrievedatasample.detailofcomplaint));
        textViewObsEngg.setText(intent.getStringExtra(Retrievedatasample.engineerobservation));
        textViewRemarkClient.setText(intent.getStringExtra(Retrievedatasample.clientremark));
        Picasso.with(context).load(intent.getStringExtra(Retrievedatasample.clienturl).toString()).into(t2);



        clients = new ArrayList<>();


        mAuth = FirebaseAuth.getInstance(); // important Call
        //Again check if the user is Already Logged in or Not

        if(mAuth.getCurrentUser() == null)
        {
            //User NOT logged In
            this.finish();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }

       /* listViewClients.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });*/

    }



  /*  @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseClients.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                clients.clear();
                FirebaseUser user = mAuth.getCurrentUser();
                Log.d("LOGGED", "FirebaseUser: " + user);
                //postSnapshot.child(user.getUid());

                  //t1.setText(key);
                // Total city=dataSnapshot.child(uid).child("city").getValue(Total.class);
                // clients.add(city);

                //iterating through all the nodes
        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Total data = postSnapshot.getValue(Total.class);
                    //adding artist to the list
                    //clients.clear();
                    clients.add(data);


                }

                //creating adapter
                PrevImg artistAdapter = new PrevImg(ActualPrevCall.this, clients);
                //attaching adapter to the listview
                listViewClients.setAdapter(artistAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }*/
}
