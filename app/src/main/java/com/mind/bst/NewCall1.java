package com.mind.bst;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Calendar;

public class NewCall1 extends AppCompatActivity {

    private static final String TAG = "NewCall1";

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;


    //private static final String TAG = "SecondActivity";
    //public static EditText e1, e2;
    public static TextView e5;
    public static EditText mVisitDate;

    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    TextView username;
    //private FirebaseAuth mAuth;

    //String URL= "http://192.168.0.27/callgen/index.php";

    // JSONParser jsonParser=new JSONParser();
    //int i=0;


    Button b1;
    public static Spinner s1,s2,s3,s4;
    TimePickerDialog picker;

    public static TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

//public static TextView mDisplayTime;
    //private TimePickerDialog.OnTimeSetListener mTimeSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_call1);

        getSupportActionBar().setTitle("Call Assigned");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //  e1 = (EditText) findViewById(R.id.e1);
        // e2 = (EditText) findViewById(R.id.e2);
        mDisplayDate = (TextView) findViewById(R.id.e3);
        mVisitDate=(EditText)findViewById(R.id.e6);
        // mDisplayTime = (TextView) findViewById(R.id.e4);
        e5=(TextView)findViewById(R.id.e5);

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



                  /*  case R.id.visits:
                        Intent j=new Intent(getApplicationContext(),ViewProfile.class);
                        startActivity(j);
                        break;*/
                }
                return true;
            }
        });

        s1 = (Spinner) findViewById(R.id.s1);
        s2 = (Spinner) findViewById(R.id.s2);
        s3 = (Spinner) findViewById(R.id.s3);
        s4 = (Spinner) findViewById(R.id.s4);
        b1 = (Button) findViewById(R.id.b1);


        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.tag_arraysup1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);


        final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this, R.array.print_inspection_plus_proddesc, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter1);




        final ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this, R.array.print_inspection_plus_prodname, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter2);



        final ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
                this, R.array.automation_plus_proddesc, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter3);



        final ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(
                this, R.array.automation_plus_prodname, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter4);


        final ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(
                this, R.array.defect_detection_plus_proddesc, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter5);


        final ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(
                this, R.array.defect_detection_plus_prodname, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter6);



        final ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(
                this, R.array.density_thickness_plus_proddesc, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter7);


        final ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(
                this, R.array.density_thickness_plus_prodname, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter8);


        final ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(
                this, R.array.mirror_image_plus_proddesc, android.R.layout.simple_spinner_item);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter9);



        final ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(
                this, R.array.mirror_image_plus_prodname, android.R.layout.simple_spinner_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter10);




        final ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(
                this, R.array.register_viscocity_plus_proddesc, android.R.layout.simple_spinner_item);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter11);


        final ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(
                this, R.array.register_viscocity_plus_prodname, android.R.layout.simple_spinner_item);
        adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter12);



        final ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(
                this, R.array.register_control_plus_proddesc, android.R.layout.simple_spinner_item);
        adapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter13);


        final ArrayAdapter<CharSequence> adapter14 = ArrayAdapter.createFromResource(
                this, R.array.register_control_plus_prodname, android.R.layout.simple_spinner_item);
        adapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter14);




        final ArrayAdapter<CharSequence> adapter15 = ArrayAdapter.createFromResource(
                this, R.array.special_purpose_plus_proddesc, android.R.layout.simple_spinner_item);
        adapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter15);


        final ArrayAdapter<CharSequence> adapter16 = ArrayAdapter.createFromResource(
                this, R.array.special_purpose_plus_prodname, android.R.layout.simple_spinner_item);
        adapter16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter16);



        final ArrayAdapter<CharSequence> adapter17 = ArrayAdapter.createFromResource(
                this, R.array.surface_inspection_plus_proddesc, android.R.layout.simple_spinner_item);
        adapter17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter17);


        final ArrayAdapter<CharSequence> adapter18 = ArrayAdapter.createFromResource(
                this, R.array.surface_inspection_plus_prodname, android.R.layout.simple_spinner_item);
        adapter18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter18);


        final ArrayAdapter<CharSequence> adapter19 = ArrayAdapter.createFromResource(
                this, R.array.web_guiding_plus_proddesc, android.R.layout.simple_spinner_item);
        adapter19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter19);



        final ArrayAdapter<CharSequence> adapter20 = ArrayAdapter.createFromResource(
                this, R.array.web_guiding_plus_prodname, android.R.layout.simple_spinner_item);
        adapter20.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter20);



        final ArrayAdapter<CharSequence> adapter21 = ArrayAdapter.createFromResource(
                this, R.array.web_tension_plus_proddesc, android.R.layout.simple_spinner_item);
        adapter21.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter21);



        final ArrayAdapter<CharSequence> adapter22 = ArrayAdapter.createFromResource(
                this, R.array.web_tension_plus_prodname, android.R.layout.simple_spinner_item);
        adapter22.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter22);




        final ArrayAdapter<CharSequence> adapter23 = ArrayAdapter.createFromResource(
                this, R.array.web_video_proddesc, android.R.layout.simple_spinner_item);
        adapter23.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter23);




        final ArrayAdapter<CharSequence> adapter24 = ArrayAdapter.createFromResource(
                this, R.array.web_video_prodname, android.R.layout.simple_spinner_item);
        adapter24.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter24);





       /* final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this, R.array.print_inspection, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter1);




        final ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this, R.array.automation, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter2);





        final ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
                this, R.array.defect_detection, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter3);




        final ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(
                this, R.array.density_thickness, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter4);


        final ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(
                this, R.array.mirror_image, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter5);



        final ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(
                this, R.array.register_viscocity, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter6);



        final ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(
                this, R.array.register_control, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter7);



        final ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(
                this, R.array.special_purpose, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter8);

        final ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(
                this, R.array.surface_inspection, android.R.layout.simple_spinner_item);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter9);



        final ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(
                this, R.array.web_guiding, android.R.layout.simple_spinner_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter10);



        final ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(
                this, R.array.web_tension, android.R.layout.simple_spinner_item);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter11);



        final ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(
                this, R.array.web_video, android.R.layout.simple_spinner_item);
        adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter12);




        final ArrayAdapter<CharSequence> adaptersub1 = ArrayAdapter.createFromResource(
                this, R.array.default_common, android.R.layout.simple_spinner_item);
        adaptersub1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s4.setAdapter(adaptersub1);








        final ArrayAdapter<CharSequence> adaptersub2 = ArrayAdapter.createFromResource(
                this, R.array.register_control_eltromat, android.R.layout.simple_spinner_item);
        adaptersub2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s4.setAdapter(adaptersub2);


        final ArrayAdapter<CharSequence> adaptersub3 = ArrayAdapter.createFromResource(
                this, R.array.web_guiding_sub, android.R.layout.simple_spinner_item);
        adaptersub3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s4.setAdapter(adaptersub3);




        final ArrayAdapter<CharSequence> adaptersub4 = ArrayAdapter.createFromResource(
                this, R.array.web_tension_sub, android.R.layout.simple_spinner_item);
        adaptersub4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s4.setAdapter(adaptersub4);


        final ArrayAdapter<CharSequence> adaptersub5 = ArrayAdapter.createFromResource(
                this, R.array.web_video_sub, android.R.layout.simple_spinner_item);
        adaptersub5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s4.setAdapter(adaptersub5);*/








        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mPreferences = getSharedPreferences("tabian.com.sharedpreferencestest", Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();


        mAuth = FirebaseAuth.getInstance(); // important Call
        if(mAuth.getCurrentUser() == null)
        {
            //User NOT logged In
            this.finish();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }

        checkSharedPreferences();









        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String spinnerValue = s1.getSelectedItem().toString();
                //String spinnerValue1 = s3.getSelectedItem().toString();

                if (spinnerValue.equals("100% Print Inspection"))

                {

                    s3.setAdapter(adapter1);
                    s4.setAdapter(adapter2);


                }

                else if (spinnerValue.equals("Automation"))
                {

                    s3.setAdapter(adapter3);
                    s4.setAdapter(adapter4);

                }



                else if (spinnerValue.equals("Defect Detection System"))
                {
                    s3.setAdapter(adapter5);
                    s4.setAdapter(adapter6);


                }



                else if (spinnerValue.equals("Density and thickness measurement"))


                {
                    s3.setAdapter(adapter7);
                    s4.setAdapter(adapter8);

                }



                else if (spinnerValue.equals("Mirror Image Registration"))
                {
                    s3.setAdapter(adapter9);
                    s4.setAdapter(adapter10);

                }




                else if (spinnerValue.equals("Register and Viscosity Control"))
                {
                    s3.setAdapter(adapter11);
                    s4.setAdapter(adapter12);

                }



                else if (spinnerValue.equals("Register Control (eltromat)"))
                {
                    s3.setAdapter(adapter13);
                    s4.setAdapter(adapter14);

                }



                else if (spinnerValue.equals("Special Purpose Machine"))
                {
                    s3.setAdapter(adapter15);
                    s4.setAdapter(adapter16);

                }


                else if (spinnerValue.equals("Surface Inspection"))
                {
                    s3.setAdapter(adapter17);
                    s4.setAdapter(adapter18);

                }


                else if (spinnerValue.equals("Web Guiding"))
                {
                    s3.setAdapter(adapter19);
                    s4.setAdapter(adapter20);

                }



                else if (spinnerValue.equals("Web Tension Control"))
                {
                    s3.setAdapter(adapter21);
                    s4.setAdapter(adapter22);

                }

                else if (spinnerValue.equals("Web Video Inspection"))
                {
                    s3.setAdapter(adapter23);
                    s4.setAdapter(adapter24);
                }





                /*for(int i=0;i<5;i++)
                    if(s1.equals(s1.getItemAtPosition(i).toString())){
                        s1.setSelection(i);
                        break;
                    }*/
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){}
        });














        s4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



                //String spinnerValue = s1.getSelectedItem().toString();
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



        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



                //String spinnerValue = s1.getSelectedItem().toString();
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



        /*s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String spinnerValue = s3.getSelectedItem().toString();
                if (spinnerValue.equals("Default / Common"))

                {

                }

                else if (spinnerValue.equals("Register Control (eltromat)"))
                {

                }


                else if (spinnerValue.equals("Web Guiding"))
                {

                }


                else if (spinnerValue.equals("Web Tension Control"))
                {

                }



                else if (spinnerValue.equals("Web Video Inspection"))
                {

                }




            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){}
        });*/


        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();

        String city = mPreferences.getString(getString(R.string.city), "");
        String name = mPreferences.getString(getString(R.string.name), "");

        String client = mPreferences.getString(getString(R.string.client), "");
        String add = mPreferences.getString(getString(R.string.add), "");
        final String date = mDisplayDate.getText().toString();
        //final String time = mDisplayTime.getText().toString();



        databaseReference = db.getReference("Calls Generated");

        b1.setOnClickListener(new View.OnClickListener() {
            boolean valid = true;
            @Override
            public void onClick(View v) {


               /* if (e1.getText().toString().trim().length() == 0) {
                    e1.setError("Contact not entered");
                    e1.requestFocus();
                }

                else if (e2.getText().toString().trim().length() == 0) {
                    e2.setError("Email not Generated");
                    e2.requestFocus();
                }


                else if (date.isEmpty() ) {
                    mDisplayDate.setError("Set date");
                    valid = false;
                }


                else if (time.isEmpty() ) {
                    mDisplayTime.setError("Set time");
                    valid = false;
                }*/





                //sendData();
                   /* AttemptLogin attemptLogin= new AttemptLogin();
                    attemptLogin.execute(
                            e1.getText().toString(),
                            e2.getText().toString(),

                            "");*/
                //save contact
                //String cont = e1.getText().toString();
                //mEditor.putString(getString(R.string.cont), cont);
                // mEditor.commit();


                //save email
                // String email = e2.getText().toString();
                // mEditor.putString(getString(R.string.email), email);
                // mEditor.commit();

                //save date
                String date = mDisplayDate.getText().toString();
                mEditor.putString(getString(R.string.date), date);
                mEditor.commit();



                /*int selectedPosition = s1.getSelectedItemPosition();
                mEditor.putInt("spinnerSelection", selectedPosition);
                mEditor.apply();



                int selectedPosition1 = s2.getSelectedItemPosition();
                mEditor.putInt("spinnerSelection1", selectedPosition1);
                mEditor.apply();


                int selectedPosition2 = s3.getSelectedItemPosition();
                mEditor.putInt("spinnerSelection2", selectedPosition2);
                mEditor.apply();


                int selectedPosition3 = s4.getSelectedItemPosition();
                mEditor.putInt("spinnerSelection3", selectedPosition3);
                mEditor.apply();*/













                Intent i = new Intent(NewCall1.this, NewCall2.class);
                startActivity(i);


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
                        NewCall1.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
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


           /* mDisplayTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calendar cal = Calendar.getInstance();
                    int hour = cal.get(Calendar.HOUR_OF_DAY);
                    int minutes = cal.get(Calendar.MINUTE);


                    picker = new TimePickerDialog(NewCall1.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                    mDisplayTime.setText(sHour + ":" + sMinute);
                                }
                            }, hour, minutes, true);


                    picker.show();


                }

            });*/


    }

    private void checkSharedPreferences() {


        String cont = mPreferences.getString(getString(R.string.cont), "");
        String email = mPreferences.getString(getString(R.string.email), "");


        String date = mPreferences.getString(getString(R.string.date), "");
        String time = mPreferences.getString(getString(R.string.time), "");
        String spinner = mPreferences.getString(getString(R.string.spinner), "");






        FirebaseUser user = mAuth.getCurrentUser();
        Log.d("LOGGED", "FirebaseUser: " + user);
        // e1.setText(cont);
        // e2.setText(email);
        mDisplayDate.setText(date);
        e5.setText(user.getDisplayName());

        s1.setSelection(mPreferences.getInt("spinnerSelection",0));
        //s2.setSelection(mPreferences.getInt("spinnerSelection1",0));
        s3.setSelection(mPreferences.getInt("spinnerSelection2",0));
        s4.setSelection(mPreferences.getInt("spinnerSelection3",0));
        // mDisplayTime.setText(time);
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

   /* public void sendData(){
        //String e5Text=e1.getText().toString();
       // String e6Text=e2.getText().toString();



    String id=databaseReference.push().getKey();

        if(!TextUtils.isEmpty(e5Text) && (!TextUtils.isEmpty(e6Text)))
        {
            DataDetail1 data=new DataDetail1(id,e5Text,e6Text);
            databaseReference.child(id).setValue(data);
            Toast.makeText(this, "Call generated Successfully", Toast.LENGTH_SHORT).show();

        }


    }*/


}


    /*private class AttemptLogin extends AsyncTask<String, String, JSONObject> {

        @Override

        protected void onPreExecute() {

            super.onPreExecute();

        }

        @Override

        protected JSONObject doInBackground(String... args) {






            String cust_contact_no= args[0];

            String cust_email_id= args[1];







            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();


            params.add(new BasicNameValuePair("cust_contact_no", cust_contact_no));
            params.add(new BasicNameValuePair("cust_email_id", cust_email_id));




            JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params);


            return json;

        }

        protected void onPostExecute(JSONObject result) {



            try {
                if (result != null) {
                    //Toast.makeText(TestPhp.this, "success", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),result.getString("message"),Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Saved successfully", Toast.LENGTH_LONG).show();
                    Intent i=new Intent(NewCall1.this,NewCall2.class);
                    startActivity(i);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

    }*/




