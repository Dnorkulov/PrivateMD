package com.dalernorkulov.privatemd;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class CreateUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        Button create = (Button) findViewById(R.id.confirm);
        create.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent createIntent = new Intent(CreateUser.this, MainActivity.class);
            startActivity(createIntent);
        }
    });
    }
}
