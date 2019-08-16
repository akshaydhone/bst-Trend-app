package com.mind.bst;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class NewCall5 extends AppCompatActivity {
    private FirebaseAuth mAuth;
    TextView username,t1,t2,t3,t4;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    EditText e3,e4,e5,e6,e7;
    Button b1,b2;
    public static CheckBox c1,c2,c3;
    public static Spinner s1,s2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_call5);
        getSupportActionBar().setTitle("Status and Payment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        e3=(EditText)findViewById(R.id.e3) ;


        e5=(EditText)findViewById(R.id.e5) ;
        e6=(EditText)findViewById(R.id.e6) ;
        e7=(EditText)findViewById(R.id.e7) ;
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        t4=(TextView)findViewById(R.id.t4);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);

        e4=(EditText)findViewById(R.id.e4);
        s1 = (Spinner) findViewById(R.id.s1);
        s2 = (Spinner) findViewById(R.id.s2);
        c1=(CheckBox)findViewById(R.id.c1);
        c2=(CheckBox)findViewById(R.id.c2);
        c3=(CheckBox)findViewById(R.id.c3);








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
                    e5.setVisibility(View.GONE);



                }



                else if (spinnerValue.equals("Needs to be visited again"))

                {
                    b2.setVisibility(View.GONE);
                    t1.setVisibility(View.GONE);
                    e4.setVisibility(View.GONE);

                    t2.setVisibility(View.VISIBLE);
                    e5.setVisibility(View.VISIBLE);




                }



                else if (spinnerValue.equals("Under-Repaired"))

                {
                    b2.setVisibility(View.GONE);
                    t1.setVisibility(View.GONE);
                    e4.setVisibility(View.GONE);

                    t2.setVisibility(View.VISIBLE);
                    e5.setVisibility(View.VISIBLE);


                }



                else if (spinnerValue.equals("Spare part Required"))

                {
                    b2.setVisibility(View.GONE);
                    t1.setVisibility(View.GONE);
                    e4.setVisibility(View.GONE);

                    t2.setVisibility(View.VISIBLE);
                    e5.setVisibility(View.VISIBLE);

                }



                else if (spinnerValue.equals("System sent to factory for repair"))

                {
                    b2.setVisibility(View.GONE);
                    t1.setVisibility(View.GONE);
                    e4.setVisibility(View.GONE);

                    t2.setVisibility(View.VISIBLE);
                    e5.setVisibility(View.VISIBLE);


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
                   e5.setVisibility(View.GONE);

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
}
);

    }

    private void checkSharedPreferences() {


        s1.setSelection(mPreferences.getInt("spinnerSelection5",0));
        s2.setSelection(mPreferences.getInt("spinnerSelection6",0));
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
