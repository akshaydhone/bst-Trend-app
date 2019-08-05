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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class NewCall3 extends AppCompatActivity {
    private static final String TAG = "NewCall3";
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
   public static EditText e1,e2,e3,e4;
    Button b1;
    private FirebaseAuth mAuth;
    TextView username;
   // public static Spinner s1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_call3);

       getSupportActionBar().setTitle("Identify Problem and solution");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);

        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);



        b1=(Button)findViewById(R.id.b1);

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
                this, R.array.tag_arrays2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);*/





        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mPreferences = getSharedPreferences("tabian.com.sharedpreferencestest", Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();

        checkSharedPreferences();


        /*s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences( getBaseContext());
                SharedPreferences.Editor prefEditor = prefs.edit();
                prefEditor.putString("spinner1",s1.getSelectedItem().toString());

                String savedValue=PreferenceManager
                        .getDefaultSharedPreferences(getApplicationContext())
                        .getString("spinner1","");


                for(int i=0;i<7;i++)
                    if(savedValue.equals(s1.getItemAtPosition(i).toString())){
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

                else if(e2.getText().toString().trim().length()==0)
                {
                    e2.setError("Please fill the details");
                    e2.requestFocus();
                }



               else if(e3.getText().toString().trim().length()==0)
                {
                    e3.setError("Please fill the details");
                    e3.requestFocus();
                }


                else if(e4.getText().toString().trim().length()==0)
                {
                    e4.setError("Please fill the details");
                    e4.requestFocus();
                }






                else{


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
                    mEditor.commit();

                   /* SharedPreferences prefs;
                    prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor prefEditor = prefs.edit();
                    prefEditor.putString("spinner1",s1.getSelectedItem().toString());
                    prefEditor.commit();*/



                    Intent i=new Intent(NewCall3.this,NewCall4.class);
                    startActivity(i);

                }
            }
        });


    }

    private void checkSharedPreferences() {

        String observation = mPreferences.getString(getString(R.string.observation), "");
        String remark = mPreferences.getString(getString(R.string.remark), "");

        String nature = mPreferences.getString(getString(R.string.nature), "");
        String details = mPreferences.getString(getString(R.string.details), "");

        e1.setText(observation);
        e2.setText(remark);
        e3.setText(nature);
        e4.setText(details);
    }
}
