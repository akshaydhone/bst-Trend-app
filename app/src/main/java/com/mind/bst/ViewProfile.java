package com.mind.bst;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class ViewProfile extends AppCompatActivity {

    private Activity context;
    List<UserInformation> clients;
    FirebaseUser user;


    ImageView t2;
    String key;
    ImageView profile;
    TextView profile_name, profile_email, profile_phone, profile_address, profile_region;


    DatabaseReference databaseClients;
    private FirebaseAuth mAuth;
    String uid;
    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        getSupportActionBar().setTitle("View Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();


        user=FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();


        databaseClients = FirebaseDatabase.getInstance().getReference("Users");


        profile = (ImageView) findViewById(R.id.profile);
        profile_name = (TextView) findViewById(R.id.profile_name);
        profile_email = (TextView) findViewById(R.id.profile_email);
        profile_phone = (TextView) findViewById(R.id.profile_phone);
        profile_address = (TextView)findViewById(R.id.profile_address);
        profile_region = (TextView) findViewById(R.id.profile_region);



        profile_name.setText(intent.getStringExtra(Retrievedatasample.custcont));
        profile_email.setText(intent.getStringExtra(Retrievedatasample.custcont));
        profile_phone.setText(intent.getStringExtra(Retrievedatasample.custcont));
        profile_address.setText(intent.getStringExtra(Retrievedatasample.custcont));
        profile_region.setText(intent.getStringExtra(Retrievedatasample.custcont));
        //Picasso.with(context).load(data.getImage_Url().toString()).into(profile);



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