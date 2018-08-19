package com.example.saurav.delenstask;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.saurav.delenstask.model.Entity;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private ChildEventListener childEventListener;
    //private Entity entity1;
    private ArrayList<Entity> l;
    private RecyclerView recyclerView;
    private OrderAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l=new ArrayList<Entity>();

//        TO insert Fake Data inside Firebase Database
//        setEntityValue();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("entity");
//        myRef.push().setValue(entity1);

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Entity e = dataSnapshot.getValue(Entity.class);
                Log.i(TAG, "onChildAdded: " + e.getId());
                l.add(e);
                orderAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        };
        myRef.addChildEventListener(childEventListener);

        recyclerView=(RecyclerView)findViewById(R.id.RVMyOrder);
        if (l!=null) {
            orderAdapter = new OrderAdapter(this, l);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(orderAdapter);
        }else {
            Log.i(TAG, "onCreate: Error in Fetching entity from firebase database");
            Toast.makeText(this, "Error in Fetching entity from firebase database", Toast.LENGTH_SHORT).show();
        }
    }


//    private void setEntityValue() {
//        entity1=new Entity();
//        entity1.setId("BN65715");
//        entity1.setJob_type("Beauty");
//        entity1.setAdress("5th Floor, West Block, Room No.1,2,3,4, Mahim,\n" +
//                "Mumbai-16");
//        entity1.setDelivered_date("Wed,Oct 25,4:25 PM");
//        entity1.setStatus("Cancelled");
//        entity1.setPerson_assigned("--");
//        entity1.setRate("Rs. 300-350 Per Hour");
//        entity1.setTax("null(SGCT)");
//        entity1.setDiscount("--");
//        entity1.setStart_time("--");
//        entity1.setEnd_time("--");
//        entity1.setPayment_status("Cancelled");
//
//        entity1.setServices_for("Mehnadi and Hair Cutting");
//        entity1.setService_place("Home");
//    }
}
