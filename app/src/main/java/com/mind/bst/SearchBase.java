package com.mind.bst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.SearchView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchBase extends AppCompatActivity {
    DatabaseReference ref;
    ArrayList<Deal>list;
    RecyclerView recyclerView;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_base);

        ref= FirebaseDatabase.getInstance().getReference().child("Calls Generated");
        recyclerView=findViewById(R.id.rv);
        searchView=findViewById(R.id.searchView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(ref!=null)
        {
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists())
                    {
                        list=new ArrayList<>();
                        for(DataSnapshot ds:dataSnapshot.getChildren())
                        {
                          list.add(ds.getValue(Deal.class));
                        }
                        AdapterClass adapterClass=new AdapterClass(list);
                        recyclerView.setAdapter(adapterClass);
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(SearchBase.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        if(searchView!=null){
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return true;
                }
            });
        }
    }

    public void search(String str){
        ArrayList<Deal> myList=new ArrayList<>();
        for(Deal object:list)
        {
            if(object.getClient().toLowerCase().contains(str.toLowerCase()))

            {
                myList.add(object);

            }
        }
        AdapterClass adapterClass=new AdapterClass(myList);
        recyclerView.setAdapter(adapterClass);

    }
}
