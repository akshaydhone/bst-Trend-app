package com.mind.bst;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GeneratedList extends ArrayAdapter<Total> {
    private Activity context;
    List<Total> clients;
    private FirebaseAuth mAuth;

    public GeneratedList(Activity context, List<Total> clients) {
        super(context, R.layout.activity_generated_list, clients);
        this.context = context;
        this.clients = clients;


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_generated_list, null, true);

        TextView textViewRegion = (TextView) listViewItem.findViewById(R.id.textRegion);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textName);

        TextView textViewAdd = (TextView) listViewItem.findViewById(R.id.textAdd);
        TextView textViewCont = (TextView) listViewItem.findViewById(R.id.textCont);

        TextView textViewEmail = (TextView) listViewItem.findViewById(R.id.textEmail);
     ImageView textViewUrl=(ImageView) listViewItem.findViewById(R.id.textclientimgurl);
        //textViewUrl.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textViewRemark = (TextView) listViewItem.findViewById(R.id.textclientremark);



        TextView textViewDate = (TextView) listViewItem.findViewById(R.id.textclientdate);
        TextView textViewComplaint = (TextView) listViewItem.findViewById(R.id.textdetailofcomplaint);

        TextView textViewEnggName = (TextView) listViewItem.findViewById(R.id.textenggname);

        TextView textViewEnggObs = (TextView) listViewItem.findViewById(R.id.textenggobservation);
        TextView textViewNatureOfComp = (TextView) listViewItem.findViewById(R.id.textnatureofcomplaint);







        TextView textViewPayment = (TextView) listViewItem.findViewById(R.id.textpaymentvia);
        TextView textViewProductName = (TextView) listViewItem.findViewById(R.id.textproductname);

        TextView textViewProductSrNo = (TextView) listViewItem.findViewById(R.id.productserialno);
        TextView textViewStatus = (TextView) listViewItem.findViewById(R.id.statusofcomplaint);

        TextView textViewTime = (TextView) listViewItem.findViewById(R.id.time);


        mAuth = FirebaseAuth.getInstance(); // important Call
        //Again check if the user is Already Logged in or Not




        Total data = clients.get(position);
        FirebaseUser user = mAuth.getCurrentUser();
        Log.d("LOGGED", "FirebaseUser: " + user);

        textViewRegion.setText(data.getName_of_service_engineer());
        textViewEnggName.setText(data.getRegion_of_service_engineer());
        textViewName.setText(data.getCustomer_rep_name());
        textViewAdd.setText(data.getCustomer_Email_Id());
        textViewCont.setText(data.getCust_cont());
        textViewEmail.setText(data.getCustomer_name());
        textViewDate.setText(data.getCall_log_date());
       // textViewTime.setText(data.getTime());
        textViewProductSrNo.setText(data.getProduct_serial_no());
        //textViewNatureOfComp.setText(data.getNature_of_complaint());
        //textViewComplaint.setText(data.getDetails_of_complaint());
        textViewEnggObs.setText(data.getEngineer_observation());
        textViewRemark.setText(data.getClient_remark());
        //textViewProductName.setText(data.getProduct_name());
       // textViewStatus.setText(data.getStatus_of_complaint());
        //textViewPayment.setText(data.getPayment_via());
       // textViewUrl.setText(data.getClient_image_url());
        Picasso.with(context).load(data.getNature_of_comp().toString()).into(textViewUrl);





        return listViewItem;
    }
}