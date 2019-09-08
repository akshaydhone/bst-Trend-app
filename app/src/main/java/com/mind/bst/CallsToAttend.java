package com.mind.bst;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
public class CallsToAttend extends AppCompatActivity {




    ListView listViewClients;
    public ArrayAdapter mAdapter;

    Intent intent = getIntent();
    //Toolbar mToolbar;

    //here data is a java class name
    List<Total> clients;
    // ArrayAdapter<Total> artistAdapter;
    TextView mEmptyView;

    //selecting a database ref
    DatabaseReference databaseClients;
    FirebaseUser user;
    String uid;
    public static String key;






    public static final String Region = "com.mind.bst.region";
    public static final String clientname = "com.mind.bst.clientname";
    public static final String clientaddress = "com.mind.bst.address";
    public static final String custcont = "com.mind.bst.custcont";
    public static final String custemail = "com.mind.bst.custemail";
    public static final String clienturl = "com.mind.bst.url";
    public static final String clientremark = "com.mind.bst.remark";
    public static final String date = "com.mind.bst.date";


    public static final String detailofcomplaint = "com.mind.bst.detailofcomplaint";
    public static final String enggname = "com.mind.bst.enggname";
    public static final String enggobs = "com.mind.bst.enggobs";
    public static final String natureofcomplaint = "com.mind.bst.natureofcomplaint";



    public static final String payment = "com.mind.bst.payment";
    public static final String proname = "com.mind.bst.proname";
    public static final String prosrno = "com.mind.bst.prosrno";
    public static final String statusofcomplaint = "com.mind.bst.statusofcomplaint";
    public static final String time = "com.mind.bst.time";





    public static final String nameofserviceengineer = "com.mind.bst.nameofserviceengineer";
    public static final String regionofserviceengineer = "com.mind.bst.regionofserviceengineer";
    public static final String customerrepname = "com.mind.bst.customerrepname";
    public static final String customeremailid = "com.mind.bst.customeremailid";
    public static final String calllogdate = "com.mind.bst.calllogdate";
    public static final String cityofservice = "com.mind.bst.cityofservice";
    public static final String productserialno = "com.mind.bst.productserialno";
    public static final String gstin = "com.mind.bst.gstin";
    public static final String productcategory = "com.mind.bst.productcategory";
    public static final String engineerobservation = "com.mind.bst.engineerobservation";
    //public static final String clientremark = "com.mind.bst.remark";
    // public static final String natureofcomplaint = "com.mind.bst.natureofcomplaint";
    //public static final String detailofcomplaint = "com.mind.bst.detailofcomplaint";
    public static final String customername = "com.mind.bst.customername";
    public static final String customeraddress = "com.mind.bst.customeraddress";
    public static final String customercity = "com.mind.bst.customercity";
    public static final String customerstate = "com.mind.bst.customerstate";
    public static final String customercountry = "com.mind.bst.customercountry";
    public static final String productdescription = "com.mind.bst.productdescription";

    public static final String callassignedto = "com.mind.bst.callassignedto";
    public static final String callassignedby = "com.mind.bst.callassignedby";
    public static final String callvisitingdate = "com.mind.bst.callvisitingdate";
    public static final String productname = "com.mind.bst.productname";
    public static final String engineerintime = "com.mind.bst.engineerintime";
    public static final String callattendingdate = "com.mind.bst.callattendingdate";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calls_to_attend);
        getSupportActionBar().setTitle("Client Upcoming  Visits");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //getting the root name database table
        mEmptyView = (TextView) findViewById(R.id.emptyView);

        databaseClients = FirebaseDatabase.getInstance().getReference("Calls to be Attended");
        //listViewClients = (ListView) findViewById(R.id.listViewClients);
        listViewClients=(ListView)findViewById(R.id.listViewClients);

        // mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(mToolbar);
        user= FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();


        key = databaseClients.child("Calls Generated").push().getKey();

        clients = new ArrayList<>();



        listViewClients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                   @Override
                                                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {




                                                       Total data = clients.get(position);

                                                       //creating an intent
                                                       Intent intent = new Intent(getApplicationContext(), FilledPageData.class);

                                                       //putting artist name and id to intent
                                                       intent.putExtra(Region, data.getName_of_service_engineer());
                                                       intent.putExtra(clientname, data.getCustomer_rep_name());
                                                       intent.putExtra(clientaddress, data.getCustomer_Email_Id());
                                                       intent.putExtra(custcont, data.getCust_cont());
                                                       intent.putExtra(custemail, data.getCustomer_name());



                                                       intent.putExtra(clienturl, data.getNature_of_comp());
                                                       intent.putExtra(clientremark, data.getClient_remark());
                                                       intent.putExtra(date, data.getCall_log_date());
                                                       // intent.putExtra(detailofcomplaint, data.getDetails_of_complaint());
                                                       intent.putExtra(enggname, data.getRegion_of_service_engineer());
                                                       intent.putExtra(enggobs, data.getEngineer_observation());
                                                       //intent.putExtra(natureofcomplaint, data.getNature_of_complaint());
                                                       // intent.putExtra(payment, data.getPayment_via());
                                                       // intent.putExtra(proname, data.getProduct_name());


                                                       //intent.putExtra(statusofcomplaint, data.getStatus_of_complaint());

                                                       intent.putExtra(prosrno, data.getProduct_serial_no());
                                                       //intent.putExtra(time, data.getTime());





                                                       intent.putExtra(nameofserviceengineer, data.getName_of_service_engineer());
                                                       intent.putExtra(regionofserviceengineer, data.getRegion_of_service_engineer());
                                                       intent.putExtra(customerrepname, data.getCustomer_rep_name());
                                                       intent.putExtra(customeremailid, data.getCustomer_Email_Id());
                                                       intent.putExtra(calllogdate, data.getCall_log_date());
                                                       intent.putExtra(cityofservice, data.getCity_of_service());
                                                       intent.putExtra(productserialno, data.getProduct_serial_no());
                                                       intent.putExtra(gstin, data.getGstin());
                                                       intent.putExtra(productcategory, data.getProduct_category());
                                                       intent.putExtra(engineerobservation, data.getEngineer_observation());
                                                       intent.putExtra(clientremark, data.getClient_remark());
                                                       intent.putExtra(natureofcomplaint, data.getNature_of_comp());
                                                       intent.putExtra(detailofcomplaint, data.getDetails_of_comp());
                                                       intent.putExtra(customername, data.getCustomer_name());
                                                       intent.putExtra(customeraddress, data.getCustomer_address());
                                                       intent.putExtra(customercity, data.getCustomer_city());
                                                       intent.putExtra(customerstate, data.getCustomer_state());
                                                       intent.putExtra(customercountry, data.getCustomer_country());
                                                       intent.putExtra(productdescription, data.getProduct_description());
                                                       intent.putExtra(callassignedto, data.getCall_assigned_to());
                                                       intent.putExtra(callvisitingdate, data.getCall_visiting_date());
                                                       intent.putExtra(productname, data.getProduct_name());
                                                       intent.putExtra(engineerintime, data.getEngineer_in_time());
                                                       intent.putExtra(callattendingdate, data.getCall_attending_date());
                                                       intent.putExtra(callassignedby, data.getCall_assigned_by());


                                                       //starting the activity with intent
                                                       startActivity(intent);


                                                   }
                                               }
        );


    }



    @Override
    protected void onStart() {

        super.onStart();
        //attaching value event listener
        databaseClients.addValueEventListener(new ValueEventListener() {
            @Override


            //when a data is changed reflect it into the database
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                clients.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //gettingclients
                    Total data = postSnapshot.getValue(Total.class);
                    //adding clients to the list
                    clients.add(data);

                }



                //creating adapter

                ViewCallsToAttendImg artistAdapter = new ViewCallsToAttendImg(CallsToAttend.this, clients);
                //attaching adapter to the listview

                //adapter = new ArrayAdapter(this, R.layout.activity_prev_actual);

                // mAdapter = new ArrayAdapter<Total>(PrevActual.this,android.R.layout.simple_list_item_1);
                mAdapter=artistAdapter;
                listViewClients.setAdapter(mAdapter);

            }


            //providing error if data not matched or database error
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        listViewClients.setEmptyView(mEmptyView);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.searchmenu,menu);
        final MenuItem searchItem =menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView)searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                // databaseClients = FirebaseDatabase.getInstance().getReference("Calls Generated").child("client");
                //Query queryfilter = FirebaseDatabase.getInstance()
                //.getReference("Calls Generated")
                //.child("client").startAt(s).endAt(s+"\uf8ff");


                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //databaseClients=FirebaseDatabase.getInstance().getReference("");

               /*mAdapter.getFilter().filter(s);
                mAdapter.notifyDataSetChanged();*/
                search(s);

                return true;
            }
        });
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        // int profile=item.getItemId();


        //signout function



        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }



        return true;






    }







    public void search(String str){
        List<Total> myclients=new ArrayList<>();
        for(Total object:clients)
        {
            if(object.getCustomer_rep_name().toLowerCase().contains(str.toLowerCase()))

            {
                myclients.add(object);

            }
        }





        ViewClientCallsImg artistAdapter = new ViewClientCallsImg(CallsToAttend.this, myclients);
        //attaching adapter to the listview

        //adapter = new ArrayAdapter(this, R.layout.activity_prev_actual);

        // mAdapter = new ArrayAdapter<Total>(PrevActual.this,android.R.layout.simple_list_item_1);
        mAdapter=artistAdapter;
        listViewClients.setAdapter(mAdapter);

    }





}
