package com.dalernorkulov.privatemd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button guest = (Button) findViewById(R.id.guest);
        guest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent createIntent = new Intent(MainActivity.this, Guest.class);
                startActivity(createIntent);
            }
        });
        Button create = (Button) findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent createIntent = new Intent(MainActivity.this, CreateUser.class);
                startActivity(createIntent);
            }
        });
        Button user1 = (Button) findViewById(R.id.user1);
        user1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent createIntent = new Intent(MainActivity.this, Action.class);
                startActivity(createIntent);
            }
        });


    }

}

