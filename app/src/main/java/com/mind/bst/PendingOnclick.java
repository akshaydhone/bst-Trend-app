package com.mind.bst;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;
import java.util.Collections;

public class PendingOnclick extends AppCompatActivity {
    private static final String TAG = "PendingOnclick";
    //step1

    public static EditText e7;

    public static TextView e4,e5,e6;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    Button b1;
    TimePickerDialog picker;
    private FirebaseAuth mAuth;
    TextView username;

    public static TextView mDisplayTime,s1;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;

    public static TextView mDisplayDate,mReschdeuledDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener,mDateSetListener1;

   // public static MultiSelectPendingSpinner s1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_onclick);

        getSupportActionBar().setTitle("Re-Generated Pending call");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        e7=(EditText)findViewById(R.id.e7);


        s1 = (TextView)findViewById(R.id.s1);




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


e7.setText(prodserialno);
s1.setText(prodname);


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
                                                                 }
        );


        mDisplayTime = (TextView) findViewById(R.id.e4);
        mDisplayTime.setText("Select Time");
        mDisplayDate = (TextView) findViewById(R.id.e5);
        mDisplayDate.setText("Select Date");
        mReschdeuledDate = (TextView) findViewById(R.id.e6);
        b1=(Button)findViewById(R.id.b1);
        //step2
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mPreferences = getSharedPreferences("tabian.com.sharedpreferencestest", Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
//e1.setText(prodserialno);
        checkSharedPreferences();


        final String time = mDisplayTime.getText().toString();
        final String date = mDisplayDate.getText().toString();


        final String rdate = mReschdeuledDate.getText().toString();

//        s4.setSelection(Collections.singletonList(prodname.toString()));



        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {


                                      //String spinnerValue1 = s4.getSelectedItem().toString();
                                      String displayDate=mDisplayDate.getText().toString();
                                      String displayRDate=mReschdeuledDate.getText().toString();
                                      String displayTime=mDisplayTime.getText().toString();


                                      if(e7.getText().toString().trim().length()==0)
                                      {
                                          e7.setError("Please fill the details");
                                          e7.requestFocus();
                                      }

               /* else if (spinnerValue1.equals("Select"))

                {
                    Toast.makeText(NewCall2.this, "Select at least one product name", Toast.LENGTH_SHORT).show();
                    //NewCall2.s4.setAdapter(adapter2);
                }*/
                                      else if (displayDate.equals("Enter Date"))

                                      {

                                          Toast.makeText(PendingOnclick.this, "Select Call attending Date", Toast.LENGTH_SHORT).show();
                                          //NewCall2.s4.setAdapter(adapter2);
                                      }


               /* else if (displayRDate.equals("Enter Date"))

                {

                    Toast.makeText(NewCall2.this, "Select Call Rescheduled Date", Toast.LENGTH_SHORT).show();
                    //NewCall2.s4.setAdapter(adapter2);
                }*/

                                      else if (displayTime.equals("Select Time"))

                                      {

                                          Toast.makeText(PendingOnclick.this, "Select Engineer's In-Time", Toast.LENGTH_SHORT).show();
                                          //NewCall2.s4.setAdapter(adapter2);
                                      }
                                      else{

                                          //save the pserial
                    /*String pserial = e1.getText().toString();
                    mEditor.putString(getString(R.string.pserial), pserial);
                    mEditor.commit();







                    String time =mDisplayTime.getText().toString();
                     mEditor.putString(getString(R.string.time), time);
                    mEditor.commit();



                    String date = mDisplayDate.getText().toString();
                    mEditor.putString(getString(R.string.attenddate), date);
                    mEditor.commit();*/



                                          String date = mDisplayDate.getText().toString( );
                                          String rdate = mReschdeuledDate.getText().toString( );


                                          Intent i=new Intent(PendingOnclick.this,PendingOnclick1.class);
                                          //i.putExtra(Retrievedatasample.productcategory,spinnerprocat);
                                          //i.putExtra(Retrievedatasample.productdescription,spinnerprodesc);
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
                              }

        );




        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        PendingOnclick.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                dialog.getDatePicker().setMaxDate(System.currentTimeMillis());
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






        mReschdeuledDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        PendingOnclick.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener1,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                dialog.show();
            }
        });


        mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyy: " + day + "/" + month + "/" + year);

                String date = day + "/" + month + "/" + year;
                mReschdeuledDate.setText(date);
            }
        };




        mDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minutes = cal.get(Calendar.MINUTE);


                picker = new TimePickerDialog(PendingOnclick.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                mDisplayTime.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);


                picker.show();


            }

        });

    }




    private void checkSharedPreferences() {


        String pserial = mPreferences.getString(getString(R.string.pserial), "");
        String nature = mPreferences.getString(getString(R.string.nature), "");
        String details = mPreferences.getString(getString(R.string.details), "");
        String spinner = mPreferences.getString(getString(R.string.spinner), "");
        String time = mPreferences.getString(getString(R.string.time), "");
        String date = mPreferences.getString(getString(R.string.attenddate), "");
        mDisplayTime.setText(time);
        mDisplayDate.setText(date);
        // s4.setSelection(mPreferences.getInt("spinnerSelection4",0));







        //s1.();

        //e7.setText(pserial);


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

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }



        return true;






    }

}
