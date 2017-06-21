package com.dalernorkulov.privatemd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;





public class Guest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        EditText guestName= (EditText)findViewById((R.id.guestName));
        Button confirm = (Button) findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent createIntent = new Intent(Guest.this, MainActivity.class);
                startActivity(createIntent);
            }
        });
    }
}
