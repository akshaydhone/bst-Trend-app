package com.mind.bst;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
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
import java.util.Calendar;


public class NewCall2 extends AppCompatActivity {

    private static final String TAG = "NewCall2";
//step1
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    public static EditText e1,e4,e5;
    //public static Spinner s1;
    Button b1;
    TimePickerDialog picker;

    public static TextView mDisplayTime;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;


    public static TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    ArrayAdapter<String>adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_call2);


      getSupportActionBar().setTitle("Call Attend");
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);





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

                    case R.id.visits:
                        Intent j=new Intent(getApplicationContext(),ViewProfile.class);
                        startActivity(j);
                        break;
                }
                return true;
            }
        });

  //s1 = (Spinner) findViewById(R.id.s1);


       /* final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.tag_arrays1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);*/






        e1=(EditText)findViewById(R.id.e1);
       // e2=(EditText)findViewById(R.id.e2);
        //e3=(EditText)findViewById(R.id.e3);
        mDisplayTime = (TextView) findViewById(R.id.e4);
        mDisplayDate = (TextView) findViewById(R.id.e5);
        b1=(Button)findViewById(R.id.b1);
         //step2
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mPreferences = getSharedPreferences("tabian.com.sharedpreferencestest", Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();

        checkSharedPreferences();

     // String check= s1.getText().toString();
        final String time = mDisplayTime.getText().toString();
        final String date = mDisplayDate.getText().toString();








       /* s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences( getBaseContext());
                SharedPreferences.Editor prefEditor = prefs.edit();
                prefEditor.putString("spinner",s1.getSelectedItem().toString());

                String spinner=PreferenceManager
                        .getDefaultSharedPreferences(getApplicationContext())
                        .getString("spinner","");


                for(int i=0;i<5;i++)
                    if(spinner.equals(s1.getItemAtPosition(i).toString())){
                        s1.setSelection(i);
                        break;
                    }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){}
        });*/





        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(e1.getText().toString().trim().length()==0)
                {
                    e1.setError("Please fill the details");
                    e1.requestFocus();
                }




                else{

                      //save the pserial
                    String pserial = e1.getText().toString();
                    mEditor.putString(getString(R.string.pserial), pserial);
                    mEditor.commit();

                    //save the nature






                    String time =mDisplayTime.getText().toString();
                     mEditor.putString(getString(R.string.time), time);
                    mEditor.commit();



                    String date = mDisplayDate.getText().toString();
                    mEditor.putString(getString(R.string.attenddate), date);
                    mEditor.commit();


                    //save the spinner...//step3
                    //String spinner = s1.toString();
                   // mEditor.putString(getString(R.string.spinner), spinner);
                    //mEditor.commit();


                    /*SharedPreferences prefs;
                    prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor prefEditor = prefs.edit();
                    prefEditor.putString("spinner",s1.getSelectedItem().toString());
                    prefEditor.commit();*/



                    Intent i=new Intent(NewCall2.this,NewCall3.class);
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
                        NewCall2.this,
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

 mDisplayTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calendar cal = Calendar.getInstance();
                    int hour = cal.get(Calendar.HOUR_OF_DAY);
                    int minutes = cal.get(Calendar.MINUTE);


                    picker = new TimePickerDialog(NewCall2.this,
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








   //s1.();

        e1.setText(pserial);


    }


}

