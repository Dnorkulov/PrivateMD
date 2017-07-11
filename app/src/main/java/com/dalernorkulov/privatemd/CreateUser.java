package com.dalernorkulov.privatemd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CreateUser extends AppCompatActivity {
    private SharedPreferences savednotes;
    private Button confirm;
    private EditText username;
    ArrayList<String> users = new ArrayList<String>();
    String fileName = "Users.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        confirm = (Button) findViewById(R.id.confirm);
        username = (EditText) findViewById(R.id.username);
        //savednotes = getSharedPreferences("notes", 0);
        //username.setText(savednotes.getString("tag", "Default Value"));
        confirm.setOnClickListener(saveButtonListener);

    }

   // private void makeTag(String tag) {
        //String or = savednotes.getString(tag, null);
     //   SharedPreferences.Editor preferencesEditor = savednotes.edit();
     //   preferencesEditor.putString("tag", tag);
     //   preferencesEditor.commit();}

    public View.OnClickListener saveButtonListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
           // if (username.getText().length() > 0) {
            //    makeTag(username.getText().toString());
             //   ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(username
                 //       .getWindowToken(), 0);
           // }
            Intent saveInfo = new Intent(CreateUser.this, MainActivity.class);
            saveInfo.putExtra("location", username.getText().toString());
            saveFile(fileName, username.getText().toString());
            if(MainActivity.counter < MainActivity.MAXUSERS ){
                String x = username.getText().toString();
                MainActivity.users.add(new User(x));
                MainActivity.counter++;
            }
            startActivity(saveInfo);
        }
    };

    public void saveFile(String file, String text) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(text);
            printWriter.close();
            Toast.makeText(CreateUser.this, "User Saved", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
           // Toast.makeText(CreateUser.this, "Error saving information", Toast.LENGTH_SHORT).show();
        }
    }
}
