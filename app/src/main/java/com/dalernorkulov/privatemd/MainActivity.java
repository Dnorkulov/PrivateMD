package com.dalernorkulov.privatemd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.dalernorkulov.privatemd.CreateUser.getName;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button create = (Button) findViewById(R.id.create);
        TextView guestName = (TextView) findViewById(R.id.guestName);
        guestName.setText(getName(this));
        create.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent createIntent = new Intent(MainActivity.this, CreateUser.class);
                startActivity(createIntent);
            }
        });}
}

