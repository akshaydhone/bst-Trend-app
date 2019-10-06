package com.mind.bst;

import android.Manifest;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static com.mind.bst.NewCallGen.e1;

public class NewCall4 extends AppCompatActivity {

    private FirebaseAuth mAuth;
    TextView username;
    FirebaseUser user;
    public static final String PUSHKEY = "pushkey";



    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;
    Button select_image,b1,b2;
    ImageView user_image,user_image1,user_image2,user_image3;
    public static TextView url;
    public static final int READ_EXTERNAL_STORAGE = 0;
    private static final int GALLERY_INTENT = 2;
    private static final int GALLERY_INTENT1 = 3;
    private static final int GALLERY_INTENT2 = 4;
    private static final int GALLERY_INTENT3 = 5;

    private ProgressDialog progressDialog;
    //private Firebase mRoofRef;
    private StorageReference mStorage;
    Intent intent ;
    public  static final int RequestPermissionCode  = 1 ;


    private static final String TAG = "NewCall4";
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    // public static Spinner s1;




    public static final String NOTIFICATION_REPLY = "NotificationReply";
    public static final String CHANNNEL_ID = "SimplifiedCodingChannel";
    public static final String CHANNEL_NAME = "SimplifiedCodingChannel";
    public static final String CHANNEL_DESC = "This is a channel for Simplified Coding Notifications";

    public static final String KEY_INTENT_MORE = "keyintentmore";
    public static final String KEY_INTENT_HELP = "keyintenthelp";

    public static final int REQUEST_CODE_MORE = 100;
    public static final int REQUEST_CODE_HELP = 101;
    public static final int NOTIFICATION_ID = 200;

    //step1
//    BitmapDrawable drawable = (BitmapDrawable) user_image.getDrawable();
    //Bitmap bitmap = drawable.getBitmap();



    //private static final int GALLERY_INTENT = 2;
    //public static final int READ_EXTERNAL_STORAGE = 0,MULTIPLE_PERMISSIONS = 10;


    // private String pictureImagePath = "";
    //final CharSequence[] options = {"Camera", "Gallery"};
    //String[] permissions= new String[]{
    //  Manifest.permission.READ_EXTERNAL_STORAGE,
    //Manifest.permission.CAMERA,};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_call4);
        getSupportActionBar().setTitle("Product Photo");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        select_image = (Button)findViewById(R.id.select_image);
        user_image = (ImageView) findViewById(R.id.user_image);
        user_image1 = (ImageView) findViewById(R.id.user_image1);
        user_image2 = (ImageView) findViewById(R.id.user_image2);
        user_image3 = (ImageView) findViewById(R.id.user_image3);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        url=(TextView)findViewById(R.id.url) ;

        username=(TextView)findViewById(R.id.username) ;




        final String callassignedby=getIntent().getStringExtra(Retrievedatasample.callassignedby);
        final String callassignedto=getIntent().getStringExtra(Retrievedatasample.callassignedto);
        String callattendingdate=getIntent().getStringExtra(Retrievedatasample.callattendingdate);
        final String calllogdate=getIntent().getStringExtra(Retrievedatasample.calllogdate);
        String callrescheduleddate=getIntent().getStringExtra(Retrievedatasample.callrescheduleddate);
        final String callvisitingdate=getIntent().getStringExtra(Retrievedatasample.callvisitingdate);
        final String cityofservice=getIntent().getStringExtra(Retrievedatasample.cityofservice);
        String clientremark=getIntent().getStringExtra(Retrievedatasample.clientremark);
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
        String enggobservation=getIntent().getStringExtra(Retrievedatasample.enggobs);
        final String gstnumber=getIntent().getStringExtra(Retrievedatasample.gstin);
        String invoiceno=getIntent().getStringExtra(Retrievedatasample.invoiceno);
        final String nameofservengg=getIntent().getStringExtra(Retrievedatasample.nameofserviceengineer);
        String natureofcomp=getIntent().getStringExtra(Retrievedatasample.natureofcomplaint);
        String prodname=getIntent().getStringExtra(Retrievedatasample.productname);
        String prodserialno=getIntent().getStringExtra(Retrievedatasample.productserialno);
        final String regionofservengg=getIntent().getStringExtra(Retrievedatasample.regionofserviceengineer);
        String statusofcomp=getIntent().getStringExtra(Retrievedatasample.statusofcomplaint);
        final String spinnerprocat=getIntent().getStringExtra(Retrievedatasample.productcategory);
        final String spinnerprodesc=getIntent().getStringExtra(Retrievedatasample.productdescription);
        final String pushkey=getIntent().getStringExtra(NewCall1.PUSHKEY);
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



        mAuth = FirebaseAuth.getInstance(); // important Call
        if(mAuth.getCurrentUser() == null)
        {
            //User NOT logged In
            this.finish();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }


        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mPreferences = getSharedPreferences("tabian.com.sharedpreferencestest", Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();


        progressDialog = new ProgressDialog(NewCall4.this);
        EnableRuntimePermission();






        // s1 = (Spinner) findViewById(R.id.s1);



        /*final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.tag_arrays3, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);*/





        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mPreferences = getSharedPreferences("tabian.com.sharedpreferencestest", Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
        checkSharedPreferences();

        //String UserID=user.getDisplayName().replace("@","").replace(".","");
        //DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();


        databaseReference = db.getReference("Calls Generated");




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







        /*s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences( getBaseContext());
                SharedPreferences.Editor prefEditor = prefs.edit();
                prefEditor.putString("payment",s1.getSelectedItem().toString());

                String savedValue=PreferenceManager
                        .getDefaultSharedPreferences(getApplicationContext())
                        .getString("payment","");


                for(int i=0;i<5;i++)
                    if(savedValue.equals(s1.getItemAtPosition(i).toString())){
                        s1.setSelection(i);
                        break;


                    }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){


            }
        });*/




        //Select Image From External Storage..
       /* select_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Check for Runtime Permission
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(getApplicationContext(), "Call for Permission", Toast.LENGTH_SHORT).show();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    {
                        requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_EXTERNAL_STORAGE);
                    }
                }
                else
                {
                    callgalary();
                }
            }


        });*/



        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
               /* SharedPreferences prefs;
                prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor prefEditor = prefs.edit();

                prefEditor.commit();*/
                                      if(user_image.getDrawable() == null && user_image1.getDrawable() == null && user_image2.getDrawable() == null && user_image3.getDrawable() == null ){

                                          Toast.makeText(NewCall4.this, "Upload Atleast one Image", Toast.LENGTH_SHORT).show();
                                      }
                                      else{
                                          //sendData();
                                          Intent i=new Intent(NewCall4.this,NewCall5.class);
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
                                          i.putExtra(PUSHKEY,pushkey);
                                          startActivity(i);
                                      }







                                  }
                              }
        );


       /* b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               // final String mName = title.getText().toString().trim();


                 sendData();
                displayNotification();
                Intent i=new Intent(NewCall4.this,SuccessActivity.class);
                startActivity(i);

                //String city = NewCallGen.e1.getText().toString();
                //mEditor.putString(getString(R.string.city), city);
                mEditor.clear();
                mEditor.commit();



            }
        });*/



      /*  select_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(NewCall4.this);
                //builder.setMessage("Select Photo");
                builder.setTitle("Select From");

                builder.setCancelable(true);

                builder.setPositiveButton("Gallery", new DialogInterface
                        .OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which)
                    {

                        // When the user click yes button
                        // then app will close
                        //Check for Runtime Permission
                        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                                != PackageManager.PERMISSION_GRANTED)
                        {
                            Toast.makeText(getApplicationContext(), "Call for Permission", Toast.LENGTH_SHORT).show();
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                            {
                                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_EXTERNAL_STORAGE);
                            }
                        }
                        else
                        {
                            callgalary();
                        }

                    }
                });



                builder
                        .setNegativeButton(
                                "Camera",
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which)
                                    {

                                        // If user click no
                                        // then dialog box is canceled.
                                        intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                                        startActivityForResult(intent, 7);

                                    }
                                });

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();

                // Show the Alert Dialog box
                alertDialog.show();

            }
        }
        );*/









        user_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(NewCall4.this);
                //builder.setMessage("Select Photo");
                builder.setTitle("Select From");

                builder.setCancelable(true);

                builder.setPositiveButton("Gallery", new DialogInterface
                        .OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which)
                    {

                        // When the user click yes button
                        // then app will close
                        //Check for Runtime Permission
                        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                                != PackageManager.PERMISSION_GRANTED)
                        {
                            Toast.makeText(getApplicationContext(), "Call for Permission", Toast.LENGTH_SHORT).show();
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                            {
                                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_EXTERNAL_STORAGE);
                            }
                        }
                        else
                        {
                            callgalary();
                        }

                    }
                });



                builder
                        .setNegativeButton(
                                "Camera",
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which)
                                    {

                                        // If user click no
                                        // then dialog box is canceled.
                                        intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                                        startActivityForResult(intent, 7);

                                    }
                                });

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();

                // Show the Alert Dialog box
                alertDialog.show();

            }
        });






        user_image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(NewCall4.this);
                //builder.setMessage("Select Photo");
                builder.setTitle("Select From");

                builder.setCancelable(true);

                builder.setPositiveButton("Gallery", new DialogInterface
                        .OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which)
                    {

                        // When the user click yes button
                        // then app will close
                        //Check for Runtime Permission
                        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                                != PackageManager.PERMISSION_GRANTED)
                        {
                            Toast.makeText(getApplicationContext(), "Call for Permission", Toast.LENGTH_SHORT).show();
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                            {
                                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_EXTERNAL_STORAGE);
                            }
                        }
                        else
                        {
                            callgalaryu1();
                        }

                    }
                });



                builder
                        .setNegativeButton(
                                "Camera",
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which)
                                    {

                                        // If user click no
                                        // then dialog box is canceled.
                                        intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                                        startActivityForResult(intent, 8);

                                    }
                                });

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();

                // Show the Alert Dialog box
                alertDialog.show();

            }
        });









        user_image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(NewCall4.this);
                //builder.setMessage("Select Photo");
                builder.setTitle("Select From");

                builder.setCancelable(true);

                builder.setPositiveButton("Gallery", new DialogInterface
                        .OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which)
                    {

                        // When the user click yes button
                        // then app will close
                        //Check for Runtime Permission
                        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                                != PackageManager.PERMISSION_GRANTED)
                        {
                            Toast.makeText(getApplicationContext(), "Call for Permission", Toast.LENGTH_SHORT).show();
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                            {
                                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_EXTERNAL_STORAGE);
                            }
                        }
                        else
                        {
                            callgalaryu2();
                        }

                    }
                });



                builder
                        .setNegativeButton(
                                "Camera",
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which)
                                    {

                                        // If user click no
                                        // then dialog box is canceled.
                                        intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                                        startActivityForResult(intent, 9);

                                    }
                                });

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();

                // Show the Alert Dialog box
                alertDialog.show();

            }
        });









        user_image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(NewCall4.this);
                //builder.setMessage("Select Photo");
                builder.setTitle("Select From");

                builder.setCancelable(true);

                builder.setPositiveButton("Gallery", new DialogInterface
                        .OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which)
                    {

                        // When the user click yes button
                        // then app will close
                        //Check for Runtime Permission
                        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                                != PackageManager.PERMISSION_GRANTED)
                        {
                            Toast.makeText(getApplicationContext(), "Call for Permission", Toast.LENGTH_SHORT).show();
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                            {
                                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_EXTERNAL_STORAGE);
                            }
                        }
                        else
                        {
                            callgalaryu3();
                        }

                    }
                });



                builder
                        .setNegativeButton(
                                "Camera",
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which)
                                    {

                                        // If user click no
                                        // then dialog box is canceled.
                                        intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                                        startActivityForResult(intent, 10);

                                    }
                                });

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();

                // Show the Alert Dialog box
                alertDialog.show();

            }
        });
        mStorage = FirebaseStorage.getInstance().getReferenceFromUrl("gs://uidesignbsteltromat.appspot.com/");


        //im1=(Button) findViewById(R.id.im1);



       /* im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(NewCall4.this);
                builder.setTitle("Choose Source ");
                builder.setItems(options, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (options[item].equals("Camera"))
                        {
                            if (checkPermissions())
                            {
                                callCamera();
                            }
                        }
                        if(options[item].equals("Gallery"))
                        {
                            if (ContextCompat.checkSelfPermission(NewCall4.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
                            {
                                ActivityCompat.requestPermissions(NewCall4.this,
                                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_EXTERNAL_STORAGE);
                            }
                            else
                            {
                                callgalary();
                            }
                        }
                    }
                });

                builder.show();


            }
        });*/
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
                    if (LoginActivity.LoggedIn_User_Email.equals("rahul@gmail.com")) {
                        send_email = "rajesh@gmail.com";
                    } else {
                        send_email = "rahul@gmail.com";
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

                        FirebaseUser user = mAuth.getCurrentUser();
                        Log.d("LOGGED", "FirebaseUser: " + user);
                        String mesaage_user= user.getDisplayName();
                        String strJsonBody = "{"
                                + "\"app_id\": \"ba781941-0da4-4b18-95f7-cd4fe988bf54\","

                                + "\"filters\": [{\"field\": \"tag\", \"key\": \"User_ID\", \"relation\": \"=\", \"value\": \"" + send_email + "\"}],"

                                + "\"data\": {\"foo\": \"bar\"},"
                                + "\"contents\": {\"en\": \"Call generated by "+mesaage_user+" \"}"
                                + "}";


                        System.out.println("strJsonBody:\n" + strJsonBody  );

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

    /*private void sendData() {

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
        String id=databaseReference.push().getKey();


        if(!TextUtils.isEmpty(e1Text) && (!TextUtils.isEmpty(e2Text)) &&(!TextUtils.isEmpty(e3Text))&& (!TextUtils.isEmpty(e4Text))  &&(!TextUtils.isEmpty(e7Text)) && (!TextUtils.isEmpty(e9Text)) && (!TextUtils.isEmpty(e12Text)) && (!TextUtils.isEmpty(e13Text)) && (!TextUtils.isEmpty(e14Text)) && (!TextUtils.isEmpty(e15Text))&& (!TextUtils.isEmpty(e17Text)) && (!TextUtils.isEmpty(e18Text))&& (!TextUtils.isEmpty(e19Text))&& (!TextUtils.isEmpty(e20Text))&& (!TextUtils.isEmpty(e21Text))&& (!TextUtils.isEmpty(e22Text))&& (!TextUtils.isEmpty(e23Text))&& (!TextUtils.isEmpty(e24Text))&& (!TextUtils.isEmpty(e25Text))&& (!TextUtils.isEmpty(e26Text))&& (!TextUtils.isEmpty(e27Text))&& (!TextUtils.isEmpty(e28Text))&& (!TextUtils.isEmpty(e29Text))&& (!TextUtils.isEmpty(e30Text))&& (!TextUtils.isEmpty(e31Text)))
        {
            Total data=new Total(id,e1Text,e2Text,e3Text,e4Text,e7Text,e9Text,e12Text,e13Text,e14Text,e15Text,e17Text,e18Text,e19Text,e20Text,e21Text,e22Text,e23Text,e24Text,e25Text,e26Text,e27Text,e28Text,e29Text,e30Text,e31Text);
            databaseReference.child(id).setValue(data);
            Toast.makeText(this, "Call generated Successfully", Toast.LENGTH_SHORT).show();

        }

    }*/

    private void checkSharedPreferences() {
    }


    private void callgalary() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, GALLERY_INTENT);



    }
    private void callgalaryu1() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, GALLERY_INTENT1);



    }


    private void callgalaryu2() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, GALLERY_INTENT2);



    }


    private void callgalaryu3() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, GALLERY_INTENT3);



    }





    public void EnableRuntimePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(NewCall4.this,
                Manifest.permission.CAMERA))
        {

            Toast.makeText(NewCall4.this,"CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(NewCall4.this,new String[]{
                    Manifest.permission.CAMERA}, RequestPermissionCode);

        }
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK) {

            final Uri mImageUri = data.getData();
            user_image.setImageURI(mImageUri);
            final StorageReference filePath = mStorage.child("User_Images").child(mImageUri.getLastPathSegment());

            progressDialog.setMessage("Uploading Image....");
            progressDialog.show();


            filePath.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                                                 @Override
                                                                 public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                                                     Uri downloadUri = taskSnapshot.getDownloadUrl();  //Ignore This error

                                                                     //mRoofRef.child("Image_URL").setValue(downloadUri.toString());

                                                                     Glide.with(getApplicationContext())
                                                                             .load(downloadUri)
                                                                             .crossFade()
                                                                             .placeholder(R.drawable.loading)
                                                                             .diskCacheStrategy(DiskCacheStrategy.RESULT)
                                                                             .into(user_image);

                                                                     Toast.makeText(getApplicationContext(), "Updated.", Toast.LENGTH_SHORT).show();
                                                                     progressDialog.dismiss();
                                                                     //String abc= taskSnapshot.getDownloadUrl().toString();
                                                                     //url.setText(abc);

                                                                 }
                                                             }
            );


            /*url.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(NewCall4.this, "download " +filePath.getDownloadUrl(), Toast.LENGTH_SHORT).show();
                    //filePath.getDownloadUrl();
                   // mStorage.getDownloadUrl();
                }
            });*/
        }







        if (requestCode == GALLERY_INTENT1 && resultCode == RESULT_OK) {

            final Uri mImageUri = data.getData();
            user_image1.setImageURI(mImageUri);
            final StorageReference filePath = mStorage.child("User_Images").child(mImageUri.getLastPathSegment());

            progressDialog.setMessage("Uploading Image....");
            progressDialog.show();


            filePath.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                                                 @Override
                                                                 public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                                                     Uri downloadUri = taskSnapshot.getDownloadUrl();  //Ignore This error

                                                                     //mRoofRef.child("Image_URL").setValue(downloadUri.toString());

                                                                     Glide.with(getApplicationContext())
                                                                             .load(downloadUri)
                                                                             .crossFade()
                                                                             .placeholder(R.drawable.loading)
                                                                             .diskCacheStrategy(DiskCacheStrategy.RESULT)
                                                                             .into(user_image1);

                                                                     Toast.makeText(getApplicationContext(), "Updated.", Toast.LENGTH_SHORT).show();
                                                                     progressDialog.dismiss();
                                                                     String abc= taskSnapshot.getDownloadUrl().toString();
                                                                     //url.setText(abc);

                                                                 }
                                                             }
            );


            /*url.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(NewCall4.this, "download " +filePath.getDownloadUrl(), Toast.LENGTH_SHORT).show();
                    //filePath.getDownloadUrl();
                   // mStorage.getDownloadUrl();
                }
            });*/
        }










        if (requestCode == GALLERY_INTENT2 && resultCode == RESULT_OK) {

            final Uri mImageUri = data.getData();
            user_image2.setImageURI(mImageUri);
            final StorageReference filePath = mStorage.child("User_Images").child(mImageUri.getLastPathSegment());

            progressDialog.setMessage("Uploading Image....");
            progressDialog.show();


            filePath.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                                                 @Override
                                                                 public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                                                     Uri downloadUri = taskSnapshot.getDownloadUrl();  //Ignore This error

                                                                     //mRoofRef.child("Image_URL").setValue(downloadUri.toString());

                                                                     Glide.with(getApplicationContext())
                                                                             .load(downloadUri)
                                                                             .crossFade()
                                                                             .placeholder(R.drawable.loading)
                                                                             .diskCacheStrategy(DiskCacheStrategy.RESULT)
                                                                             .into(user_image2);

                                                                     Toast.makeText(getApplicationContext(), "Updated.", Toast.LENGTH_SHORT).show();
                                                                     progressDialog.dismiss();
                                                                     String abc= taskSnapshot.getDownloadUrl().toString();
                                                                     //url.setText(abc);

                                                                 }
                                                             }
            );


            /*url.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(NewCall4.this, "download " +filePath.getDownloadUrl(), Toast.LENGTH_SHORT).show();
                    //filePath.getDownloadUrl();
                   // mStorage.getDownloadUrl();
                }
            });*/
        }






        if (requestCode == GALLERY_INTENT3 && resultCode == RESULT_OK) {

            final Uri mImageUri = data.getData();
            user_image3.setImageURI(mImageUri);
            final StorageReference filePath = mStorage.child("User_Images").child(mImageUri.getLastPathSegment());

            progressDialog.setMessage("Uploading Image....");
            progressDialog.show();


            filePath.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                                                 @Override
                                                                 public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                                                     Uri downloadUri = taskSnapshot.getDownloadUrl();  //Ignore This error

                                                                     //mRoofRef.child("Image_URL").setValue(downloadUri.toString());

                                                                     Glide.with(getApplicationContext())
                                                                             .load(downloadUri)
                                                                             .crossFade()
                                                                             .placeholder(R.drawable.loading)
                                                                             .diskCacheStrategy(DiskCacheStrategy.RESULT)
                                                                             .into(user_image3);

                                                                     Toast.makeText(getApplicationContext(), "Updated.", Toast.LENGTH_SHORT).show();
                                                                     progressDialog.dismiss();
                                                                     String abc= taskSnapshot.getDownloadUrl().toString();
                                                                     //url.setText(abc);

                                                                 }
                                                             }
            );


            /*url.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(NewCall4.this, "download " +filePath.getDownloadUrl(), Toast.LENGTH_SHORT).show();
                    //filePath.getDownloadUrl();
                   // mStorage.getDownloadUrl();
                }
            });*/
        }
        if (requestCode == 7 && resultCode == RESULT_OK) {

            //Uri mImageUri = data.getData();
            //user_image.setImageURI(mImageUri);

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

                user_image.setImageBitmap(bitmap);

            }

            //StorageReference filePath = mStorage.child("User_Images").child("gs://uidesignbsteltromat.appspot.com/");







        if (requestCode == 8 && resultCode == RESULT_OK) {

            //Uri mImageUri = data.getData();
            //user_image.setImageURI(mImageUri);

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            user_image1.setImageBitmap(bitmap);
            //StorageReference filePath = mStorage.child("User_Images").child("gs://uidesignbsteltromat.appspot.com/");

        }





        if (requestCode == 9 && resultCode == RESULT_OK) {

            //Uri mImageUri = data.getData();
            //user_image.setImageURI(mImageUri);
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            user_image2.setImageBitmap(bitmap);
            //StorageReference filePath = mStorage.child("User_Images").child("gs://uidesignbsteltromat.appspot.com/");

        }





        if (requestCode == 10 && resultCode == RESULT_OK) {

            //Uri mImageUri = data.getData();
            //user_image.setImageURI(mImageUri);

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            user_image3.setImageBitmap(bitmap);
            //StorageReference filePath = mStorage.child("User_Images").child("gs://uidesignbsteltromat.appspot.com/");

        }



        /*if (requestCode == 7 && resultCode == RESULT_OK) {

            //Uri mImageUri = data.getData();
            //user_image.setImageURI(mImageUri);

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            user_image.setImageBitmap(bitmap);
            //StorageReference filePath = mStorage.child("User_Images").child("gs://uidesignbsteltromat.appspot.com/");







        }*/




    }





    /*private  boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p:permissions) {
            result = ContextCompat.checkSelfPermission(getApplicationContext(),p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),MULTIPLE_PERMISSIONS );
            return false;
        }
        return true;
    }*/
   /* private void callCamera() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = timeStamp + ".jpg";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        Log.d("LOGGED", "imageFileName :  "+ imageFileName);
        pictureImagePath = storageDir.getAbsolutePath() + "/" + imageFileName;


        File file = new File(pictureImagePath);

        Uri outputFileUri = FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getApplicationContext().getPackageName() + ".provider", file);

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
        cameraIntent.putExtra(Intent.EXTRA_RETURN_RESULT, true);
        cameraIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);


        Log.d("LOGGED", "pictureImagePath :  "+ pictureImagePath);
        Log.d("LOGGED", "outputFileUri :  "+ outputFileUri);

        startActivityForResult(cameraIntent, 5);

        //im1.setImageBitmap(BitmapFactory.decodeFile(pictureImagePath));
    }*/


   /* private void callgalary() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, GALLERY_INTENT);

    }*/



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {

            case READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    callgalary();
                return;
        }




        //Toast.makeText(getApplicationContext(), "...", Toast.LENGTH_SHORT).show();
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
