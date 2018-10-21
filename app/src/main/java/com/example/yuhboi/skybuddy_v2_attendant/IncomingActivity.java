package com.example.yuhboi.skybuddy_v2_attendant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class IncomingActivity extends AppCompatActivity {
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
    public static ArrayList<String> itemNames = new ArrayList<>();
    public static ArrayList<String> list = new ArrayList<String>();
    private String seatNumber;
    private String order = "", name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incoming);
        read();
        //generate list
        //instantiate custom adapter
        CustomAdapter adapter = new CustomAdapter(this, list);
        //handle listview and assign adapter
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }

    private void read() {
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    String temp = "";
                    order = "";
                    System.out.println("SN: " + messageSnapshot.child("seatNumber").getValue());
                    System.out.println("SHOPPING: " + messageSnapshot.child("shoppingCart").getValue());
                    seatNumber = messageSnapshot.child("seatNumber").getValue().toString();
                    for (DataSnapshot newSnapshot : messageSnapshot.child("shoppingCart").getChildren()) {
                        if (!newSnapshot.exists()){
                            temp = newSnapshot.child("name").getValue().toString();
                            order += temp + "\n";
                            System.out.println("ORDER IN LOOP: " + order);
                        }
                    }
                    order = seatNumber + ":\n" + order;
                    System.out.println("ORDER AFTER LOOP: " + order);
                    list.add(order);
                }
                System.out.println(list.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //handle databaseError
            }
        });
    }
}

