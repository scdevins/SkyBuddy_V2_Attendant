package com.example.yuhboi.skybuddy_v2_attendant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button incomingButton = findViewById(R.id.incoming),
                completeButton = findViewById(R.id.complete);
        addListenerOnIncoming(incomingButton);
        addListenerOnComplete(completeButton);
    }

    private void addListenerOnIncoming(Button incomingButton) {
        incomingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent incomingActivity = new Intent(MainActivity.this, IncomingActivity.class);
                startActivity(incomingActivity);
            }
        });
    }

    private void addListenerOnComplete(Button completeButton) {
        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent completeActivity = new Intent(MainActivity.this, CompleteActivity.class);
                startActivity(completeActivity);
            }
        });
    }
}
