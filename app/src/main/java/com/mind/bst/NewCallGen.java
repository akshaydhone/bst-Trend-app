package com.mind.bst;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;




import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.RemoteInput;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.transform.Result;

public class NewCallGen extends AppCompatActivity {


    private static final String TAG = "NewCallGen";

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;


    Button b1,b2;

  public static TextView e2,e5;

   public static EditText e1;
   public static AutoCompleteTextView e6,e3,e4,e7,e8;

   public static CheckBox c1,c2,c3;

private Long suggestion;
    static String LoggedIn_User_Email;
    TextView username;
    private FirebaseAuth mAuth;
    public static String id;

public static String abc;
    public SharedPreferences savedData;

    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;



    //String URL= "http://192.168.0.27/callgen1/index.php";

    //JSONParser jsonParser=new JSONParser();
    // int i=0;





    public static final String NOTIFICATION_REPLY = "NotificationReply";
    public static final String CHANNNEL_ID = "SimplifiedCodingChannel";
    public static final String CHANNEL_NAME = "SimplifiedCodingChannel";
    public static final String CHANNEL_DESC = "This is a channel for Simplified Coding Notifications";

    public static final String KEY_INTENT_MORE = "keyintentmore";
    public static final String KEY_INTENT_HELP = "keyintenthelp";

    public static final int REQUEST_CODE_MORE = 100;
    public static final int REQUEST_CODE_HELP = 101;
    public static final int NOTIFICATION_ID = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_call_gen);
        getSupportActionBar().setTitle("New  Call Generation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       e1=(EditText) findViewById(R.id.e1);
        e2 = (TextView) findViewById(R.id.e2);
        e3 = (AutoCompleteTextView)findViewById(R.id.e3);
         e4 = (AutoCompleteTextView) findViewById(R.id.e4);
         c1=(CheckBox)findViewById(R.id.c1);
         c2=(CheckBox)findViewById(R.id.c2);
         c3=(CheckBox)findViewById(R.id.c3);
         e5=(TextView)findViewById(R.id.e5);

         e6=(AutoCompleteTextView) findViewById(R.id.e6);
         e7=(AutoCompleteTextView) findViewById(R.id.e7);
         e8=(AutoCompleteTextView) findViewById(R.id.e8);
         b2=(Button)findViewById(R.id.b2);


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


        mAuth = FirebaseAuth.getInstance(); // important Call
        if(mAuth.getCurrentUser() == null)
        {
            //User NOT logged In
            this.finish();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }





         /*if (user != null) {
            e2.setText("Welcome, " + user.getEmail());



    LoginActivity.LoggedIn_User_Email =user.getEmail();




        }*/




        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mPreferences = getSharedPreferences("tabian.com.sharedpreferencestest", Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();

        checkSharedPreferences();


        //final ArrayAdapter<String> autoComplete = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        //final ArrayAdapter<String> a1 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        /*final ArrayAdapter<String> a2 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        final ArrayAdapter<String> a3 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        final ArrayAdapter<String> a4 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);*/
        //database.child("Engineers").addValueEventListener(new ValueEventListener() {
            //@Override
           // public void onDataChange(DataSnapshot dataSnapshot) {
                //Basically, this says "For each DataSnapshot *Data* in dataSnapshot, do what's inside the method.
                //for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()){
                    //Get the suggestion by childing the key of the string you want to get.
                   // String region = suggestionSnapshot.child("region").getValue(String.class);
                    //Add the retrieved string to the list
                    //autoComplete.add(region);


                   // String name = suggestionSnapshot.child("name").getValue(String.class);
                    //Add the retrieved string to the list
                   // a1.add(name);

                    /*String client = suggestionSnapshot.child("client").getValue(String.class);
                    //Add the retrieved string to the list
                    a3.add(client);

                    String add = suggestionSnapshot.child("add").getValue(String.class);
                    //Add the retrieved string to the list
                    a4.add(add);*/

               // }
            //}

           // @Override
            //public void onCancelled(DatabaseError databaseError) {

          //  }
       // });







        //final ArrayAdapter<String> a3 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
       // final ArrayAdapter<String> a4 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
       // database.child("Clients").addValueEventListener(new ValueEventListener() {
          //  @Override
           // public void onDataChange(DataSnapshot dataSnapshot) {
                //Basically, this says "For each DataSnapshot *Data* in dataSnapshot, do what's inside the method.
                //for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()){
                    //Get the suggestion by childing the key of the string you want to get.
                    //String name = suggestionSnapshot.child("name").getValue(String.class);
                    //Add the retrieved string to the list
                    //a3.add(name);


                   // String region = suggestionSnapshot.child("region").getValue(String.class);
                    //Add the retrieved string to the list
                   // a4.add(region);

                    /*String client = suggestionSnapshot.child("client").getValue(String.class);
                    //Add the retrieved string to the list
                    a3.add(client);

                    String add = suggestionSnapshot.child("add").getValue(String.class);
                    //Add the retrieved string to the list
                    a4.add(add);*/

               // }
            //}

           // @Override
            //public void onCancelled(DatabaseError databaseError) {

           // }
        //});

       //final AutoCompleteTextView e1= (AutoCompleteTextView) findViewById(R.id.e1);
       // e1.setAdapter(autoComplete);

       // AutoCompleteTextView ACTV= (AutoCompleteTextView) findViewById(R.id.actv);
        //ACTV.setAdapter(autoComplete);

  //final AutoCompleteTextView     e2 = (AutoCompleteTextView) findViewById(R.id.e2);
   //e2.setAdapter(a1);

       //final AutoCompleteTextView     e2 = (AutoCompleteTextView) findViewById(R.id.e2);
        //e2.setAdapter(a2);


     // final  AutoCompleteTextView     e3 = (AutoCompleteTextView) findViewById(R.id.e3);
       // e3.setAdapter(a3);


    // final    AutoCompleteTextView     e4 = (AutoCompleteTextView) findViewById(R.id.e4);
       // e4.setAdapter(a4);



        //e2 = (EditText) findViewById(R.id.e2);
    //e3 = (AutoCompleteTextView) findViewById(R.id.e3);
       // e4 = (AutoCompleteTextView) findViewById(R.id.e4);


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(CHANNNEL_ID, CHANNEL_NAME, importance);
            mChannel.setDescription(CHANNEL_DESC);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            mNotificationManager.createNotificationChannel(mChannel);
        }




        b1 = (Button) findViewById(R.id.b1);
        savedData= PreferenceManager.getDefaultSharedPreferences(this);

        databaseReference=db.getReference("Calls Generated");





        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                          @Override
                                          public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {


                                              if(c1.isChecked()){
                                                 Toast.makeText(NewCallGen.this, "Service selected", Toast.LENGTH_SHORT).show();
                                              }
                                              else{

                                                 // Toast.makeText(NewCallGen.this, "Select atleast one type of service call", Toast.LENGTH_SHORT).show();
                                              }



                                          }
                                      }
        );





        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                          @Override
                                          public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {


                                              if(c2.isChecked()){
                                                  Toast.makeText(NewCallGen.this, "Repair ", Toast.LENGTH_SHORT).show();

                                              }
                                              else{

                                                  //Toast.makeText(NewCallGen.this, "Select atleast one type of service call", Toast.LENGTH_SHORT).show();



                                              }



                                          }
                                      }
        );





        c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                          @Override
                                          public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {


                                              if(c3.isChecked()){
                                                  Toast.makeText(NewCallGen.this, "Installation commissioning ", Toast.LENGTH_SHORT).show();

                                              }
                                              else{

                                                 // Toast.makeText(NewCallGen.this, "Select atleast one type of service call", Toast.LENGTH_SHORT).show();



                                              }



                                          }
                                      });




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    //String checkboxvalue1 = c1.getText().toString();
                   //String checkboxvalue2 = c2.getText().toString();
                    //String checkboxvalue3 = c3.getText().toString();


                    if (e1.getText().toString().trim().length() == 0) {
                        e1.setError("City not entered");
                        e1.requestFocus();
                    } else if (e2.getText().toString().trim().length() == 0) {
                        e2.setError("Name not entered");
                        e2.requestFocus();
                    } else if (e3.getText().toString().trim().length() == 0) {
                        e3.setError("Client's Name not entered");
                        e3.requestFocus();
                    } else if (e4.getText().toString().trim().length() == 0) {
                        e4.setError("Address not entered");
                        e4.requestFocus();
                    } else if (e6.getText().toString().trim().length() == 0) {
                        e6.setError("Customer Name not entered");
                        e6.requestFocus();
                    } else if (e7.getText().toString().trim().length() == 0) {
                        e7.setError("Client's Contact No not entered");
                        e7.requestFocus();
                    } else if (e8.getText().toString().trim().length() == 0) {
                        e8.setError("Client's Email not entered");
                        e8.requestFocus();
                    }













                    else {
                        //sendData();
                        //displayNotification();
                        //Save the edit text

                        //save the name
                   /* String city = e1.getText().toString();
                    mEditor.putString(getString(R.string.city), city);
                    mEditor.commit();




                    String name = e2.getText().toString();
                    mEditor.putString(getString(R.string.name), name);
                    mEditor.commit();

                    String client = e3.getText().toString();
                    mEditor.putString(getString(R.string.client), client);
                    mEditor.commit();

                    String add = e4.getText().toString();
                    mEditor.putString(getString(R.string.add), add);
                    mEditor.commit();



                    String cust_name = e6.getText().toString();
                    mEditor.putString(getString(R.string.cust_name), cust_name);
                    mEditor.commit();



                    String cust_cont = e7.getText().toString();
                    mEditor.putString(getString(R.string.cust_cont), cust_cont);
                    mEditor.commit();



                    String cust_email = e8.getText().toString();
                    mEditor.putString(getString(R.string.cust_email), cust_email);
                    mEditor.commit();




                    String service = c1.getText().toString();
                    mEditor.putString(getString(R.string.service), service);
                    mEditor.commit();

                    String repair = c2.getText().toString();
                    mEditor.putString(getString(R.string.repair), repair);
                    mEditor.commit();


                    String installation = c3.getText().toString();
                    mEditor.putString(getString(R.string.installation), installation);
                    mEditor.commit();*/


                        Intent i = new Intent(NewCallGen.this, NewCall1.class);
                        startActivity(i);
                   /* AttemptLogin attemptLogin= new AttemptLogin();
                    attemptLogin.execute(
                            e1.getText().toString(),
                            e2.getText().toString(),
                            e3.getText().toString(),
                            e4.getText().toString(),
                            "");*/


                    }

                }

        }
        );


    b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                e1.setText("");

                e3.setText("");
                e4.setText("");
                e6.setText("");

                e7.setText("");
                e8.setText("");




            }
        });






        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        //Create a new ArrayAdapter with your context and the simple layout for the dropdown menu provided by Android
        final ArrayAdapter<String> autoComplete = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        //Child the root before all the push() keys are found and add a ValueEventListener()
        database.child("Clients").addValueEventListener(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                                //Basically, this says "For each DataSnapshot *Data* in dataSnapshot, do what's inside the method.
                                                                for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()){
                                                                    //Get the suggestion by childing the key of the string you want to get.
                                                                    String suggestion = suggestionSnapshot.child("PartyName").getValue(String.class);
                                                                    //Add the retrieved string to the list
                                                                    autoComplete.add(suggestion);
                                                                }
                                                            }

                                                            @Override
                                                            public void onCancelled(DatabaseError databaseError) {

                                                            }
                                                        }
        );
        AutoCompleteTextView ACTV= (AutoCompleteTextView)findViewById(R.id.e6);
        ACTV.setAdapter(autoComplete);







        DatabaseReference database1 = FirebaseDatabase.getInstance().getReference();
        //Create a new ArrayAdapter with your context and the simple layout for the dropdown menu provided by Android
        final ArrayAdapter<String> autoComplete1 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        //Child the root before all the push() keys are found and add a ValueEventListener()
        database1.child("Clients").addValueEventListener(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                                //Basically, this says "For each DataSnapshot *Data* in dataSnapshot, do what's inside the method.
                                                                for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()){
                                                                    //Get the suggestion by childing the key of the string you want to get.
                                                                    String suggestion = suggestionSnapshot.child("PersonName").getValue(String.class);
                                                                    //Add the retrieved string to the list
                                                                    autoComplete1.add(suggestion);
                                                                }
                                                            }

                                                            @Override
                                                            public void onCancelled(DatabaseError databaseError) {

                                                            }
                                                        }
        );
        AutoCompleteTextView ACTV1= (AutoCompleteTextView)findViewById(R.id.e3);
        ACTV1.setAdapter(autoComplete1);








        DatabaseReference database2 = FirebaseDatabase.getInstance().getReference();

        //Create a new ArrayAdapter with your context and the simple layout for the dropdown menu provided by Android
        final ArrayAdapter<String> autoComplete2 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        //Child the root before all the push() keys are found and add a ValueEventListener()
        database2.child("Clients").addValueEventListener(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                                //Basically, this says "For each DataSnapshot *Data* in dataSnapshot, do what's inside the method.
                                                                for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()){
                                                                    //Get the suggestion by childing the key of the string you want to get.
                                                                    String suggestion = suggestionSnapshot.child("Address").getValue(String.class);
                                                                    //Add the retrieved string to the list
                                                                    autoComplete2.add(suggestion);
                                                                }
                                                            }

                                                            @Override
                                                            public void onCancelled(DatabaseError databaseError) {

                                                            }
                                                        });
        AutoCompleteTextView ACTV2= (AutoCompleteTextView)findViewById(R.id.e4);
        ACTV2.setAdapter(autoComplete2);






   /* DatabaseReference database3 = FirebaseDatabase.getInstance().getReference();
        //Create a new ArrayAdapter with your context and the simple layout for the dropdown menu provided by Android
        final ArrayAdapter<String> autoComplete3 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        //Child the root before all the push() keys are found and add a ValueEventListener()
        database.child("Clients").addValueEventListener(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                                //Basically, this says "For each DataSnapshot *Data* in dataSnapshot, do what's inside the method.
                                                                for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()){
                                                                    //Get the suggestion by childing the key of the string you want to get.
                                                             //String suggestion = suggestionSnapshot.child("MobNo").getValue(String.class);

                                                                    String suggestion=suggestionSnapshot.child("MobNo").getValue(String.class);
                                                                    //Add the retrieved string to the list
                                                                    autoComplete3.add(suggestion);
                                                                }
                                                            }

                                                            @Override
                                                            public void onCancelled(DatabaseError databaseError) {

                                                            }
                                                        }
        );
        AutoCompleteTextView ACTV3= (AutoCompleteTextView)findViewById(R.id.e7);
        ACTV3.setAdapter(autoComplete3);*/





    DatabaseReference database4 = FirebaseDatabase.getInstance().getReference();
        //Create a new ArrayAdapter with your context and the simple layout for the dropdown menu provided by Android
        final ArrayAdapter<String> autoComplete4 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        //Child the root before all the push() keys are found and add a ValueEventListener()
        database4.child("Clients").addValueEventListener(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                                //Basically, this says "For each DataSnapshot *Data* in dataSnapshot, do what's inside the method.
                                                                for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()){
                                                                    //Get the suggestion by childing the key of the string you want to get.

                                                             String suggestion = suggestionSnapshot.child("EmailID").getValue(String.class);
                                                                    //Add the retrieved string to the list
                                                                    autoComplete4.add(suggestion);
                                                                }
                                                            }

                                                            @Override
                                                            public void onCancelled(DatabaseError databaseError) {

                                                            }
                                                        }
        );
        AutoCompleteTextView ACTV4= (AutoCompleteTextView)findViewById(R.id.e8);
        ACTV4.setAdapter(autoComplete4);



    }

    private void checkSharedPreferences() {

        String city = mPreferences.getString(getString(R.string.city), "");
        String name = mPreferences.getString(getString(R.string.name), "");

        String client = mPreferences.getString(getString(R.string.client), "");
        String add = mPreferences.getString(getString(R.string.add), "");

        String service = mPreferences.getString(getString(R.string.service), "");
        String repair = mPreferences.getString(getString(R.string.repair), "");
        String installation = mPreferences.getString(getString(R.string.installation), "");

        String cust_name = mPreferences.getString(getString(R.string.cust_name), "");
        String cust_cont = mPreferences.getString(getString(R.string.cust_cont), "");
        String cust_email = mPreferences.getString(getString(R.string.cust_email), "");

        FirebaseUser user = mAuth.getCurrentUser();
        Log.d("LOGGED", "FirebaseUser: " + user);
        e1.setText(city);
        e2.setText(user.getDisplayName());
        e3.setText(client);
        e4.setText(add);
        e6.setText(cust_name);
        e7.setText(cust_cont);
        e8.setText(cust_email);
        c1.setChecked(Boolean.parseBoolean(service.toString()));
        c2.setChecked(Boolean.parseBoolean(repair.toString()));
        c3.setChecked(Boolean.parseBoolean(installation.toString()));
    }


    public void displayNotification() {


        // Toast.makeText(this, "Current Recipients is : user1@gmail.com ( Just For Demo )", Toast.LENGTH_SHORT).show();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                int SDK_INT = android.os.Build.VERSION.SDK_INT;
                if (SDK_INT > 8) {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    String send_email;


                    //This is a Simple Logic to Send Notification different Device Programmatically....
                    if (LoginActivity.LoggedIn_User_Email.equals("rajesh@gmail.com")) {
                        send_email = "ajay@gmail.com";
                    } else {
                        send_email = "rajesh@gmail.com";
                    }

                    try {
                        String jsonResponse;

                        URL url = new URL("https://onesignal.com/api/v1/notifications");
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setUseCaches(false);
                        con.setDoOutput(true);
                        con.setDoInput(true);

                        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                        con.setRequestProperty("Authorization", "Basic NmQ5MjFkMTktMTFmZS00M2EyLWEwZTYtZDI5Zjg2NWNhMWZi");
                        con.setRequestMethod("POST");

                        String strJsonBody = "{"
                                + "\"app_id\": \"ba781941-0da4-4b18-95f7-cd4fe988bf54\","

                                + "\"filters\": [{\"field\": \"tag\", \"key\": \"User_ID\", \"relation\": \"=\", \"value\": \"" + send_email + "\"}],"

                                + "\"data\": {\"foo\": \"bar\"},"
                                + "\"contents\": {\"en\": \"Call generated \"}"
                                + "}";


                        System.out.println("strJsonBody:\n" + strJsonBody);

                        byte[] sendBytes = strJsonBody.getBytes("UTF-8");
                        con.setFixedLengthStreamingMode(sendBytes.length);

                        OutputStream outputStream = con.getOutputStream();
                        outputStream.write(sendBytes);

                        int httpResponse = con.getResponseCode();
                        System.out.println("httpResponse: " + httpResponse);

                        if (httpResponse >= HttpURLConnection.HTTP_OK
                                && httpResponse < HttpURLConnection.HTTP_BAD_REQUEST) {
                            Scanner scanner = new Scanner(con.getInputStream(), "UTF-8");
                            jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                            scanner.close();
                        } else {
                            Scanner scanner = new Scanner(con.getErrorStream(), "UTF-8");
                            jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                            scanner.close();
                        }
                        System.out.println("jsonResponse:\n" + jsonResponse);

                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
            }
        });
    }




    public void sendData(){



        String e1Text=e1.getText().toString();
        String e2Text=e2.getText().toString();
        String e3Text=e3.getText().toString();
        String e4Text=e4.getText().toString();

        //String e5Text=e5.getText().toString();

//String abc[]={e1Text,e2Text,e3Text,e4Text};





     String id=databaseReference.push().getKey();

        if(!TextUtils.isEmpty(e1Text) && (!TextUtils.isEmpty(e2Text)) && (!TextUtils.isEmpty(e3Text))   && (!TextUtils.isEmpty(e4Text)))
        {
            DataDetail data=new DataDetail(id,e1Text,e2Text,e3Text,e4Text);
            databaseReference.child(id).setValue(data);
            Toast.makeText(this, "Call generated Successfully", Toast.LENGTH_SHORT).show();

        }









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


   /* private class AttemptLogin extends AsyncTask<String, String, JSONObject> {

        @Override

        protected void onPreExecute() {

            super.onPreExecute();

        }

        @Override

        protected JSONObject doInBackground(String... args) {




            String city_of_service= args[0];
            String service_engg_name= args[1];
            String cust_name= args[2];
            String cust_address= args[3];








            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();


            params.add(new BasicNameValuePair("city_of_service", city_of_service));
            params.add(new BasicNameValuePair("service_engg_name", service_engg_name));
            params.add(new BasicNameValuePair("cust_name", cust_name));
            params.add(new BasicNameValuePair("cust_address", cust_address));





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
                    Intent i=new Intent(NewCallGen.this,NewCall1.class);
                    startActivity(i);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

    }*/

