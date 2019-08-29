package com.mind.bst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.onesignal.OneSignal;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    CardView b1,b2,b3,b4,b5,b6;
    LinearLayout ll;
    TextView username;
    List<UserInformation> clients;
    private FirebaseAuth mAuth;


    public static final String Region = "com.mind.bst.region";
    public static final String Name = "com.mind.bst.name";
    public static final String Address = "com.mind.bst.address";
    public static final String Contact = "com.mind.bst.contact";
    public static final String Email = "com.mind.bst.email";
    public static final String Image_Url = "com.mind.bst.image_url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Dashboard");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ll=(LinearLayout)findViewById(R.id.ll);
        b1=(CardView)findViewById(R.id.b1);
        b2=(CardView)findViewById(R.id.b2);
        b3=(CardView)findViewById(R.id.b3);
        b4=(CardView)findViewById(R.id.b4);
        b5=(CardView)findViewById(R.id.b5);
        b6=(CardView)findViewById(R.id.b6);

        username=(TextView)findViewById(R.id.username) ;

        mAuth = FirebaseAuth.getInstance(); // important Call
        //Again check if the user is Already Logged in or Not






        if(mAuth.getCurrentUser() == null)
        {
            //User NOT logged In
            this.finish();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }


        //Fetch the Display name of current User
        FirebaseUser user = mAuth.getCurrentUser();
        Log.d("LOGGED", "FirebaseUser: " + user);

        if (user != null) {
            username.setText("Welcome, " + user.getDisplayName());



            LoginActivity.LoggedIn_User_Email =user.getDisplayName();




        }




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomeActivity.this,NewCallGen.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(HomeActivity.this,CallsToAttend.class);
                startActivity(i);


                // Intent i=new Intent(HomeActivity.this,PrevActual.class);
                //startActivity(i);
                //starting the intent for next activity
                // Intent i=new Intent(HomeActivity.this,PreviousCallGen.class);
                //startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //For getting the next activity
                Intent i=new Intent(HomeActivity.this,PendingCallAttend.class);
                //Intent i=new Intent(HomeActivity.this,SearchBase.class);
                startActivity(i);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //For getting the next activity
                // Intent i=new Intent(HomeActivity.this,ViewProfile.class);
                // startActivity(i);

                //UserInformation data = clients.get(position);

                Intent i=new Intent(HomeActivity.this,PrevActual.class);
                startActivity(i);


            }
        });





        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //For getting the next activity
                // Intent i=new Intent(HomeActivity.this,ViewProfile.class);
                // startActivity(i);

                //UserInformation data = clients.get(position);




            }
        });





        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              //  Intent j=new Intent(getApplicationContext(),ViewProfile.class);
               // startActivity(j);

                //For getting the next activity
                // Intent i=new Intent(HomeActivity.this,ViewProfile.class);
                // startActivity(i);

                //UserInformation data = clients.get(position);




            }
        });

//initializing the onesignal for notification
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        // int profile=item.getItemId();


        //signout function
        switch (id)
        {
            case R.id.signout:
                mAuth.signOut();
                finish();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));

        }



        return true;






    }
}
