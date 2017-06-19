package com.dalernorkulov.privatemd;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class CreateUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        EditText name = (EditText) findViewById(R.id.name);
        setName(this,name.getText().toString());
        Button create = (Button) findViewById(R.id.confirm);
        create.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent createIntent = new Intent(CreateUser.this, MainActivity.class);
            startActivity(createIntent);
        }
    });
    }

    public static void setName(Context context, String name) {
        SharedPreferences prefs = context.getSharedPreferences("myAppPackage", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("name", name);
        editor.commit();
    }
    public static String getName(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("myAppPackage", 0);
        return prefs.getString("name", "");

    }
}
