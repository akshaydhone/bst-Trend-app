package com.mind.bst;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PendingOnclick1 extends AppCompatActivity {
    private static final String TAG = "PendingOnclick1";
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    public static EditText e2,e4,e3,e11;
    Button b1;
    //public static Spinner s1;
    private FirebaseAuth mAuth;
    TextView username;
    // public static Spinner s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_onclick1);

        getSupportActionBar().setTitle("Identify Problem and solution");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //e1=(EditText)findViewById(R.id.e1);
        e11=(EditText)findViewById(R.id.e11);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        //test=(TextView)findViewById(R.id.test);

        // e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
        //s1 = (Spinner) findViewById(R.id.s1);





        b1=(Button)findViewById(R.id.b1);



        final String callassignedby=getIntent().getStringExtra(Retrievedatasample.callassignedby);
        final String callassignedto=getIntent().getStringExtra(Retrievedatasample.callassignedto);
        String callattendingdate=getIntent().getStringExtra(Retrievedatasample.callattendingdate);
        final String calllogdate=getIntent().getStringExtra(Retrievedatasample.calllogdate);
        String callrescheduleddate=getIntent().getStringExtra(Retrievedatasample.callrescheduleddate);
        final String callvisitingdate=getIntent().getStringExtra(Retrievedatasample.callvisitingdate);
        final String cityofservice=getIntent().getStringExtra(Retrievedatasample.cityofservice);
        final String clientremark=getIntent().getStringExtra(Retrievedatasample.clientremark);
        String custcontact=getIntent().getStringExtra(Retrievedatasample.custcont);
        final String custadd=getIntent().getStringExtra(Retrievedatasample.customeraddress);
        final String custcity=getIntent().getStringExtra(Retrievedatasample.customercity);
        final String custcountry=getIntent().getStringExtra(Retrievedatasample.customercountry);
        final String custemail=getIntent().getStringExtra(Retrievedatasample.customeremailid);
        final String custname=getIntent().getStringExtra(Retrievedatasample.customername);
        final String custrepname=getIntent().getStringExtra(Retrievedatasample.customerrepname);
        final String custstate=getIntent().getStringExtra(Retrievedatasample.customerstate);
        String detailsofcomp=getIntent().getStringExtra(Retrievedatasample.detailofcomplaint);
        String enggintime=getIntent().getStringExtra(Retrievedatasample.engineerintime);
        final String enggobservation=getIntent().getStringExtra(Retrievedatasample.enggobs);
        final String gstnumber=getIntent().getStringExtra(Retrievedatasample.gstin);
        String invoiceno=getIntent().getStringExtra(Retrievedatasample.invoiceno);
        final String nameofservengg=getIntent().getStringExtra(Retrievedatasample.nameofserviceengineer);
        String natureofcomp=getIntent().getStringExtra(Retrievedatasample.natureofcomplaint);
        String prodname=getIntent().getStringExtra(Retrievedatasample.productname);
        final String prodserialno=getIntent().getStringExtra(Retrievedatasample.productserialno);
        final String regionofservengg=getIntent().getStringExtra(Retrievedatasample.regionofserviceengineer);
        String statusofcomp=getIntent().getStringExtra(Retrievedatasample.statusofcomplaint);


        final String spinnerprocat=getIntent().getStringExtra(Retrievedatasample.productcategory);
        final String spinnerprodesc=getIntent().getStringExtra(Retrievedatasample.productdescription);
        username=(TextView)findViewById(R.id.username) ;
        mAuth = FirebaseAuth.getInstance();



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
            username.setText("" + user.getDisplayName());



            LoginActivity.LoggedIn_User_Email =user.getDisplayName();




        }
        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch(menuItem.getItemId())
                {
                    case R.id.home:
                        Intent i=new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(i);
                        break;


                    case R.id.notification:
                        Intent j=new Intent(getApplicationContext(),PendingCallAttend.class);
                        startActivity(j);
                        break;

                    case R.id.visits:
                        Intent k=new Intent(getApplicationContext(),CallsToAttend.class);
                        startActivity(k);
                        break;


                  /*  case R.id.visits:
                        Intent j=new Intent(getApplicationContext(),ViewProfile.class);
                        startActivity(j);
                        break;*/
                }
                return true;
            }
        });


        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mPreferences = getSharedPreferences("tabian.com.sharedpreferencestest", Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
        checkSharedPreferences();
        e11.setText(enggobservation);
        e2.setText(clientremark);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String spinnerValue1 = s1.getSelectedItem().toString();

                if(e11.getText().toString().trim().length()==0)
                {
                    e11.setError("Please fill the details");
                    e11.requestFocus();
                }

                else if(e2.getText().toString().trim().length()==0)
                {
                    e2.setError("Please fill the details");
                    e2.requestFocus();
                }






                else if(e4.getText().toString().trim().length()==0)
                {
                    e4.setError("Please fill the details");
                    e4.requestFocus();
                }
                else if(e3.getText().toString().trim().length()==0)
                {
                    e3.setError("Please fill the details");
                    e3.requestFocus();
                }




                else{

/*
                    String observation = e1.getText().toString();
                    mEditor.putString(getString(R.string.observation), observation);
                    mEditor.commit();


                    String remark = e2.getText().toString();

                    mEditor.putString(getString(R.string.remark), remark);
                    mEditor.commit();





                    String nature = e3.getText().toString();
                    mEditor.putString(getString(R.string.nature), nature);
                    mEditor.commit();



                    String details = e4.getText().toString();
                    mEditor.putString(getString(R.string.details), details);
                    mEditor.commit();*/




                    Intent i=new Intent(PendingOnclick1.this,PendingOnclick2.class);
                    i.putExtra(Retrievedatasample.productcategory,spinnerprocat);
                    i.putExtra(Retrievedatasample.productdescription,spinnerprodesc);
                    i.putExtra(Retrievedatasample.nameofserviceengineer,nameofservengg);
                    i.putExtra(Retrievedatasample.regionofserviceengineer,regionofservengg);
                    i.putExtra(Retrievedatasample.cityofservice,cityofservice);
                    i.putExtra(Retrievedatasample.customername,custname);
                    i.putExtra(Retrievedatasample.customerrepname,custrepname);
                    i.putExtra(Retrievedatasample.customeremailid,custemail);
                    i.putExtra(Retrievedatasample.customeraddress,custadd);
                    i.putExtra(Retrievedatasample.gstin,gstnumber);
                    i.putExtra(Retrievedatasample.customercity,custcity);
                    i.putExtra(Retrievedatasample.customerstate,custstate);
                    i.putExtra(Retrievedatasample.customercountry,custcountry);
                    i.putExtra(Retrievedatasample.calllogdate,calllogdate);
                    i.putExtra(Retrievedatasample.callassignedto,callassignedto);
                    i.putExtra(Retrievedatasample.callassignedby,callassignedby);
                    i.putExtra(Retrievedatasample.callvisitingdate,callvisitingdate);
                    i.putExtra(Retrievedatasample.productserialno,prodserialno);
                    i.putExtra(Retrievedatasample.enggobs,enggobservation);
                    i.putExtra(Retrievedatasample.clientremark,clientremark);
                    startActivity(i);

                }
            }
        });
    }



    private void checkSharedPreferences() {

        String observation = mPreferences.getString(getString(R.string.observation), "");
        String remark = mPreferences.getString(getString(R.string.remark), "");

        // String nature = mPreferences.getString(getString(R.string.nature), "");
        String details = mPreferences.getString(getString(R.string.details), "");

        //e1.setText(observation);
        //e2.setText(remark);
        //e3.setText(nature);
        //e4.setText(details);

        //s1.setSelection(mPreferences.getInt("spinnerSelection4",0));
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

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }



        return true;






    }
}
