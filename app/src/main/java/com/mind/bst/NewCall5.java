package com.mind.bst;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.v7.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class NewCall5 extends AppCompatActivity {
    private static final String TAG = "NewCall5";
    private FirebaseAuth mAuth;
    FirebaseUser user;

    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;
    DatabaseReference databasependingReference;
    TextView username,t1,t2,t3,t4,tinput;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    public static EditText e3,e4,e6,e7,e8;
    Button b1,b2;
    public static TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    public static CheckBox c1,c2,c3;
    public static Spinner s1,s2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_call5);
        getSupportActionBar().setTitle("Status and Payment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        e3=(EditText)findViewById(R.id.e3) ;


        mDisplayDate = (TextView) findViewById(R.id.e5);
        e6=(EditText)findViewById(R.id.e6) ;
        e7=(EditText)findViewById(R.id.e7) ;
        e8=(EditText)findViewById(R.id.e8) ;
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        t4=(TextView)findViewById(R.id.t4);
        tinput=(TextView)findViewById(R.id.tinput);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);

        e4=(EditText)findViewById(R.id.e4);
        s1 = (Spinner) findViewById(R.id.s1);
        s2 = (Spinner) findViewById(R.id.s2);
        c1=(CheckBox)findViewById(R.id.c1);
        c2=(CheckBox)findViewById(R.id.c2);
        c3=(CheckBox)findViewById(R.id.c3);


        final String nameofservengg=getIntent().getStringExtra(Retrievedatasample.nameofserviceengineer);
        final String regionofservengg=getIntent().getStringExtra(Retrievedatasample.regionofserviceengineer);
        final String cityofservice=getIntent().getStringExtra(Retrievedatasample.cityofservice);
        final String custname=getIntent().getStringExtra(Retrievedatasample.customername);
        final String custrepname=getIntent().getStringExtra(Retrievedatasample.customerrepname);
        final String custemail=getIntent().getStringExtra(Retrievedatasample.customeremailid);



        final String custadd=getIntent().getStringExtra(Retrievedatasample.customeraddress);
        final String gstnumber=getIntent().getStringExtra(Retrievedatasample.gstin);
        final String custcity=getIntent().getStringExtra(Retrievedatasample.customercity);


        final String custstate=getIntent().getStringExtra(Retrievedatasample.customerstate);
        final String custcountry=getIntent().getStringExtra(Retrievedatasample.customercountry);



        final String spinnerprocat=getIntent().getStringExtra(Retrievedatasample.productcategory);




        final String spinnerprodesc=getIntent().getStringExtra(Retrievedatasample.productdescription);
        final String calllogdate=getIntent().getStringExtra(Retrievedatasample.calllogdate);


        final String callassignedto=getIntent().getStringExtra(Retrievedatasample.callassignedto);
        final String callvisitingdate=getIntent().getStringExtra(Retrievedatasample.callvisitingdate);
        final String callassignedby=getIntent().getStringExtra(Retrievedatasample.callassignedby);
//tinput.setText(callassignedby);


        databaseReference = db.getReference("Calls Generated");
        databasependingReference = db.getReference("Calls Pending");









        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.tag_arrays2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);





        final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this, R.array.tag_arrays3, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter1);


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

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mPreferences = getSharedPreferences("tabian.com.sharedpreferencestest", Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();

        checkSharedPreferences();

        final String date = mDisplayDate.getText().toString();

        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



           String spinnerValue = s1.getSelectedItem().toString();



               if (spinnerValue.equals("Completed"))

                {
                    b2.setVisibility(View.VISIBLE);

                    t1.setVisibility(View.GONE);
                    e4.setVisibility(View.GONE);

                    t2.setVisibility(View.GONE);
                    mDisplayDate.setVisibility(View.GONE);



                }



                else if (spinnerValue.equals("Needs to be visited again"))

                {
                    b2.setVisibility(View.GONE);
                    t1.setVisibility(View.GONE);
                    e4.setVisibility(View.GONE);

                    t2.setVisibility(View.VISIBLE);
                    mDisplayDate.setVisibility(View.VISIBLE);




                }



                else if (spinnerValue.equals("Under-Repaired"))

                {
                    b2.setVisibility(View.GONE);
                    t1.setVisibility(View.GONE);
                    e4.setVisibility(View.GONE);

                    t2.setVisibility(View.VISIBLE);
                    mDisplayDate.setVisibility(View.VISIBLE);


                }



                else if (spinnerValue.equals("Spare part Required"))

                {
                    b2.setVisibility(View.GONE);
                    t1.setVisibility(View.GONE);
                    e4.setVisibility(View.GONE);

                    t2.setVisibility(View.VISIBLE);
                    mDisplayDate.setVisibility(View.VISIBLE);

                }



                else if (spinnerValue.equals("System sent to factory for repair"))

                {
                    b2.setVisibility(View.GONE);
                    t1.setVisibility(View.GONE);
                    e4.setVisibility(View.GONE);

                    t2.setVisibility(View.VISIBLE);
                    mDisplayDate.setVisibility(View.VISIBLE);


                }


                else if (spinnerValue.equals("Other"))

                {
                    t1.setVisibility(View.VISIBLE);
                    e4.setVisibility(View.VISIBLE);


                    b2.setVisibility(View.GONE);


                }



               else if (spinnerValue.equals("Select"))

               {
                   t1.setVisibility(View.GONE);
                   e4.setVisibility(View.GONE);

                   t2.setVisibility(View.GONE);
                   mDisplayDate.setVisibility(View.GONE);

                   b2.setVisibility(View.GONE);


               }






                //String spinnerValue = s2.getSelectedItem().toString();

          /*for(int i=0;i<5;i++)
                    if(s2.equals(s2.getItemAtPosition(i).toString())){
                        s2.setSelection(i);
                        break;
                    }*/
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){


            }
        });


b2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        sendData();
        //Toast.makeText(NewCall5.this, "Call Generated Successfully", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(NewCall5.this,HomeActivity.class);
        startActivity(i);
    }

});


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //sendPendingData();
                Intent i=new Intent(NewCall5.this,HomeActivity.class);
                startActivity(i);
                //Toast.makeText(NewCall5.this, "Call Generated Successfully", Toast.LENGTH_SHORT).show();
                //Intent i=new Intent(NewCall5.this,HomeActivity.class);
                //startActivity(i);
            }
        });




        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        NewCall5.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                dialog.show();


            }
        });


        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyy: " + day + "/" + month + "/" + year);

                String date = day + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



                String spinnerValue = s2.getSelectedItem().toString();


                if (spinnerValue.equals("Cheque Payment"))

                {
                    t4.setVisibility(View.VISIBLE);

                }

               else if (spinnerValue.equals("Bank Transfer:NEFT,RTGS,IMPS"))

                {
                    t4.setVisibility(View.VISIBLE);

                }



                else if (spinnerValue.equals("Cash Payment"))

                {
                    t4.setVisibility(View.GONE);

                }


                else if (spinnerValue.equals("Select"))

                {
                    t4.setVisibility(View.GONE);

                }

                /*t4.postDelayed(new Runnable() {
                    public void run() {
                        t4.setVisibility(View.GONE);
                    }
                }, 3000);*/







                //String spinnerValue = s2.getSelectedItem().toString();

          /*for(int i=0;i<5;i++)
                    if(s2.equals(s2.getItemAtPosition(i).toString())){
                        s2.setSelection(i);
                        break;
                    }*/
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){}
        });



        c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                               @Override
                                               public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {


                                                   if(c3.isChecked()){
                                                       t3.setVisibility(View.GONE);
                                                       s2.setVisibility(View.GONE);
                                                       e6.setVisibility(View.VISIBLE);
                                                       c3.setChecked(true);
                                                   }
                                                   else{
                                                       t3.setVisibility(View.VISIBLE);
                                                       s2.setVisibility(View.VISIBLE);
                                                      e6.setVisibility(View.GONE);
                                                   }



                                               }
                                           }
        );

        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                          @Override
                                          public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {


                                              if(c2.isChecked()){
                                                  e7.setVisibility(View.VISIBLE);
                                                  c2.setChecked(true);
                                              }
                                              else{
                                                  e7.setVisibility(View.GONE);
                                              }



                                          }
                                      }
        );




        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                          @Override
                                          public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {


                                              if(c1.isChecked()){
                                                  e8.setVisibility(View.VISIBLE);
                                                  c1.setChecked(true);
                                              }
                                              else{
                                                  e8.setVisibility(View.GONE);
                                              }



                                          }
                                      }
        );





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
}
);

    }

    private void checkSharedPreferences() {


        s1.setSelection(mPreferences.getInt("spinnerSelection5",0));
        s2.setSelection(mPreferences.getInt("spinnerSelection6",0));
    }




    private void sendData() {

        final String nameofservengg=getIntent().getStringExtra(Retrievedatasample.nameofserviceengineer);
        final String regionofservengg=getIntent().getStringExtra(Retrievedatasample.regionofserviceengineer);
        final String cityofservice=getIntent().getStringExtra(Retrievedatasample.cityofservice);
        final String custname=getIntent().getStringExtra(Retrievedatasample.customername);
        final String custrepname=getIntent().getStringExtra(Retrievedatasample.customerrepname);
        final String custemail=getIntent().getStringExtra(Retrievedatasample.customeremailid);



        final String custadd=getIntent().getStringExtra(Retrievedatasample.customeraddress);
        //final String gstnumber=getIntent().getStringExtra(Retrievedatasample.gstin);
        final String custcity=getIntent().getStringExtra(Retrievedatasample.customercity);


        final String custstate=getIntent().getStringExtra(Retrievedatasample.customerstate);
        final String custcountry=getIntent().getStringExtra(Retrievedatasample.customercountry);



        final String spinnerprocat=getIntent().getStringExtra(Retrievedatasample.productcategory);




        final String spinnerprodesc=getIntent().getStringExtra(Retrievedatasample.productdescription);
        final String calllogdate=getIntent().getStringExtra(Retrievedatasample.calllogdate);


        final String callassignedto=getIntent().getStringExtra(Retrievedatasample.callassignedto);
        //final String callvisitingdate=getIntent().getStringExtra(Retrievedatasample.callvisitingdate);
        final String callassignedby=getIntent().getStringExtra(Retrievedatasample.callassignedby);





        String e29Text=NewCall2.s4.getSelectedItem().toString();
        String e30Text=NewCall2.mDisplayTime.getText().toString();

        String e31Text=NewCall2.mDisplayDate.getText().toString();

        String e33Text=NewCall2.mReschdeuledDate.getText().toString();

        String e34Text=NewCall3.e3.getText().toString();
        String e35Text=NewCall5.s1.getSelectedItem().toString();



        //String e36Text=NewCall5.e6.getText().toString();
        //String e37Text=NewCall5.e5.getText().toString();












        //String e5Text=NewCall1.e1.getText().toString();
        // String e6Text=NewCall1.e2.getText().toString();

        // String e8Text=NewCall1.mDisplayTime.getText().toString();


        String e9Text=NewCall2.e1.getText().toString();
        // String e10Text=NewCall2.e2.getText().toString();
        //String e11Text=NewCall2.e3.getText().toString();

        String e12Text=NewCall3.e1.getText().toString();
        String e13Text=NewCall3.e2.getText().toString();

        String e14Text=NewCall3.s1.getSelectedItem().toString();

        String e15Text=NewCall3.e4.getText().toString();
        // String e16Text=NewCall4.s1.getSelectedItem().toString();
        String e17Text=NewCall4.url.getText().toString();
        // String e14Text=NewCall2.s1.getSelectedItem().toString();



        // FirebaseUser user = mAuth.getCurrentUser();
        //Log.d("LOGGED", "FirebaseUser: " + user);
        // String id=user.getDisplayName();
        String id=databaseReference.push().getKey();


        if(!TextUtils.isEmpty(nameofservengg) && (!TextUtils.isEmpty(regionofservengg)) &&(!TextUtils.isEmpty(custrepname))&& (!TextUtils.isEmpty(custemail))  &&(!TextUtils.isEmpty(custname)) && (!TextUtils.isEmpty(e9Text)) && (!TextUtils.isEmpty(e12Text)) && (!TextUtils.isEmpty(e13Text)) && (!TextUtils.isEmpty(e14Text)) && (!TextUtils.isEmpty(e15Text))&& (!TextUtils.isEmpty(e17Text)) && (!TextUtils.isEmpty(custadd))&& (!TextUtils.isEmpty(spinnerprocat))&& (!TextUtils.isEmpty(cityofservice))&& (!TextUtils.isEmpty(custcity))&& (!TextUtils.isEmpty(custstate))&& (!TextUtils.isEmpty(custcountry))&& (!TextUtils.isEmpty(spinnerprodesc))&& (!TextUtils.isEmpty(callassignedto))&&  (!TextUtils.isEmpty(callassignedby))&& (!TextUtils.isEmpty(e29Text))&& (!TextUtils.isEmpty(e30Text))&& (!TextUtils.isEmpty(e31Text))&& (!TextUtils.isEmpty(calllogdate))&& (!TextUtils.isEmpty(e33Text))&& (!TextUtils.isEmpty(e34Text))&& (!TextUtils.isEmpty(e35Text)))
        {
            Total data=new Total(id,nameofservengg,regionofservengg,custrepname,custemail,custname,e9Text,e12Text,e13Text,e14Text,e15Text,e17Text,custadd,spinnerprocat,cityofservice,custcity,custstate,custcountry,spinnerprodesc,callassignedto,callassignedby,e29Text,e30Text,e31Text,calllogdate,e33Text,e34Text,e35Text);
            databaseReference.child(id).setValue(data);
            Toast.makeText(this, "Call generated Successfully", Toast.LENGTH_SHORT).show();

        }

    }


   /* private void sendPendingData() {

        String e1Text=NewCallGen.e2.getText().toString();
        String e2Text=NewCallGen.e5.getText().toString();
        String e3Text=NewCallGen.e10.getText().toString();
        String e4Text=NewCallGen.e3.getText().toString();


        String e18Text=NewCallGen.searchableSpinner.getSelectedItem().toString();
        String e19Text=NewCallGen.e4.getText().toString();
        String e20Text=NewCallGen.e9.getText().toString();


        String e21Text=NewCall1.s1.getSelectedItem().toString();

        String e22Text=NewCallGen.e1.getText().toString();
        String e23Text=NewCallGen.e7.getText().toString();



        String e24Text=NewCallGen.e11.getText().toString();
        String e25Text=NewCallGen.e8.getText().toString();

        String e26Text=NewCall1.s3.getSelectedItem().toString();

        String e27Text=NewCall1.e5.getText().toString();
        String e28Text=NewCall1.mVisitDate.getText().toString();
        String e29Text=NewCall2.s4.getSelectedItem().toString();
        String e30Text=NewCall2.mDisplayTime.getText().toString();

        String e31Text=NewCall2.mDisplayDate.getText().toString();
        String e32Text=NewCall1.e7.getText().toString();

        String e33Text=NewCall2.mReschdeuledDate.getText().toString();

        String e34Text=NewCall3.e3.getText().toString();
        String e35Text=NewCall5.s1.getSelectedItem().toString();



        //String e36Text=NewCall5.e6.getText().toString();
        //String e37Text=NewCall5.e5.getText().toString();












        //String e5Text=NewCall1.e1.getText().toString();
        // String e6Text=NewCall1.e2.getText().toString();
        String e7Text=NewCall1.mDisplayDate.getText().toString();
        // String e8Text=NewCall1.mDisplayTime.getText().toString();


        String e9Text=NewCall2.e1.getText().toString();
        // String e10Text=NewCall2.e2.getText().toString();
        //String e11Text=NewCall2.e3.getText().toString();

        String e12Text=NewCall3.e1.getText().toString();
        String e13Text=NewCall3.e2.getText().toString();

        String e14Text=NewCall3.s1.getSelectedItem().toString();

        String e15Text=NewCall3.e4.getText().toString();
        // String e16Text=NewCall4.s1.getSelectedItem().toString();
        String e17Text=NewCall4.url.getText().toString();
        // String e14Text=NewCall2.s1.getSelectedItem().toString();



        // FirebaseUser user = mAuth.getCurrentUser();
        //Log.d("LOGGED", "FirebaseUser: " + user);
        // String id=user.getDisplayName();
        String id=databasependingReference.push().getKey();


        if(!TextUtils.isEmpty(e1Text) && (!TextUtils.isEmpty(e2Text)) &&(!TextUtils.isEmpty(e3Text))&& (!TextUtils.isEmpty(e4Text))  &&(!TextUtils.isEmpty(e7Text)) && (!TextUtils.isEmpty(e9Text)) && (!TextUtils.isEmpty(e12Text)) && (!TextUtils.isEmpty(e13Text)) && (!TextUtils.isEmpty(e14Text)) && (!TextUtils.isEmpty(e15Text))&& (!TextUtils.isEmpty(e17Text)) && (!TextUtils.isEmpty(e18Text))&& (!TextUtils.isEmpty(e19Text))&& (!TextUtils.isEmpty(e20Text))&& (!TextUtils.isEmpty(e21Text))&& (!TextUtils.isEmpty(e22Text))&& (!TextUtils.isEmpty(e23Text))&& (!TextUtils.isEmpty(e24Text))&& (!TextUtils.isEmpty(e25Text))&& (!TextUtils.isEmpty(e26Text))&& (!TextUtils.isEmpty(e27Text))&& (!TextUtils.isEmpty(e28Text))&& (!TextUtils.isEmpty(e29Text))&& (!TextUtils.isEmpty(e30Text))&& (!TextUtils.isEmpty(e31Text))&& (!TextUtils.isEmpty(e32Text))&& (!TextUtils.isEmpty(e33Text))&& (!TextUtils.isEmpty(e34Text))&& (!TextUtils.isEmpty(e35Text)))
        {
            Total data=new Total(id,e1Text,e2Text,e3Text,e4Text,e7Text,e9Text,e12Text,e13Text,e14Text,e15Text,e17Text,e18Text,e19Text,e20Text,e21Text,e22Text,e23Text,e24Text,e25Text,e26Text,e27Text,e28Text,e29Text,e30Text,e31Text,e32Text,e33Text,e34Text,e35Text);
            databasependingReference.child(id).setValue(data);
            Toast.makeText(this, "Call Saved in Pending List", Toast.LENGTH_SHORT).show();

        }

    }*/
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

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return true;
    }

}
