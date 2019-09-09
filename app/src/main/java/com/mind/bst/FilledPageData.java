package com.mind.bst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
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

public class FilledPageData extends AppCompatActivity {


    private Activity context;
    List<TotalAttendedData> clients;
    FirebaseUser user;
    // TextView t1;
    ImageView t2;
    String key;

    Button b1;

    //public static final String gstin = "com.mind.bst.gstin";

    DatabaseReference databaseClients;
    private FirebaseAuth mAuth;
    String uid;
    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    // FirebaseDatabase mDatabase;
    //String key = mDatabase.child("Calls Generated").push().getKey();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filled_page_data);
        Intent intent = getIntent();
        getSupportActionBar().setTitle("Call Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        user=FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();
// key = databaseClients.child("Calls Generated").push().getKey();


        databaseClients = FirebaseDatabase.getInstance().getReference("Calls to be Attended");
        // listViewClients = (ListView) findViewById(R.id.listViewClients);
        // t1=(TextView)findViewById(R.id.textView);



       // t2=(ImageView)findViewById(R.id.textclientimgurl);

          b1=(Button)findViewById(R.id.b1);

          b1.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent i=new Intent(FilledPageData.this,NewCall2.class);
                  startActivity(i);

              }
          });


        TextView textViewName = (TextView)findViewById(R.id.t1);
        TextView textViewRegion = (TextView)findViewById(R.id.t2);
        TextView textViewCity = (TextView)findViewById(R.id.t3);
        TextView textViewCustname= (TextView)findViewById(R.id.t4);
        TextView textViewCustrepname= (TextView)findViewById(R.id.t5);
        TextView textViewCustEmail = (TextView) findViewById(R.id.t6);
        TextView textViewCustAdd = (TextView) findViewById(R.id.t7);
        TextView textViewCustGST = (TextView) findViewById(R.id.t8);
        TextView textViewCustCity = (TextView) findViewById(R.id.t9);
        TextView textViewCustState = (TextView) findViewById(R.id.t10);
        TextView textViewCustCountry = (TextView) findViewById(R.id.t11);
        TextView textViewProdCat= (TextView) findViewById(R.id.t12);
        TextView textViewProdDesc = (TextView) findViewById(R.id.t13);
        TextView textViewCallLogDate = (TextView) findViewById(R.id.t14);
        TextView textViewCallAssignedTo = (TextView) findViewById(R.id.t15);
        TextView textViewCallAssignedBy = (TextView) findViewById(R.id.t16);
        TextView textViewCallVisitDate = (TextView) findViewById(R.id.t17);



        textViewName.setText(intent.getStringExtra(Retrievedatasample.nameofserviceengineer));
        textViewRegion.setText(intent.getStringExtra(Retrievedatasample.regionofserviceengineer));
        textViewCity.setText(intent.getStringExtra(Retrievedatasample.cityofservice));
        textViewCustname.setText(intent.getStringExtra(Retrievedatasample.customername));
        textViewCustrepname.setText(intent.getStringExtra(Retrievedatasample.customerrepname));
        textViewCustEmail.setText(intent.getStringExtra(Retrievedatasample.customeremailid));
        textViewCustAdd.setText(intent.getStringExtra(Retrievedatasample.customeraddress));
        textViewCustGST.setText(intent.getStringExtra(Retrievedatasample.gstin));
        textViewCustCity.setText(intent.getStringExtra(Retrievedatasample.customercity));
        textViewCustState.setText(intent.getStringExtra(Retrievedatasample.customerstate));
        textViewCustCountry.setText(intent.getStringExtra(Retrievedatasample.customercountry));
        textViewProdCat.setText(intent.getStringExtra(Retrievedatasample.productcategory));
        textViewProdDesc.setText(intent.getStringExtra(Retrievedatasample.productdescription));
        textViewCallLogDate.setText(intent.getStringExtra(Retrievedatasample.calllogdate));
        textViewCallAssignedTo.setText(intent.getStringExtra(Retrievedatasample.callassignedto));
        textViewCallAssignedBy.setText(intent.getStringExtra(Retrievedatasample.callassignedby));
        textViewCallVisitDate.setText(intent.getStringExtra(Retrievedatasample.callvisitingdate));

        clients = new ArrayList<>();


        mAuth = FirebaseAuth.getInstance(); // important Call
        //Again check if the user is Already Logged in or Not

        if(mAuth.getCurrentUser() == null)
        {
            //User NOT logged In
            this.finish();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }





    }
}
