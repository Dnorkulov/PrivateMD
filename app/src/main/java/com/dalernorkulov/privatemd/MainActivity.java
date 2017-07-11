package com.dalernorkulov.privatemd;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends CreateUser {
    static final int MAXUSERS = 3;
    static ArrayList<User> users = new ArrayList<>(MAXUSERS);
    private String m_Text = "";
    static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button guest = (Button) findViewById(R.id.guest);
        guest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent createIntent = new Intent(MainActivity.this, Guest.class);
                startActivity(createIntent);
            }
        });
        Button create = (Button) findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent createIntent = new Intent(MainActivity.this, CreateUser.class);
                startActivity(createIntent);

            }
        });
        setMargins(guest,0,50,0,50);
        setMargins(create,0,50,0,50);
        Intent intent = getIntent();
        String str = intent.getStringExtra("location");
        LinearLayout ll = (LinearLayout)findViewById(R.id.users);
        Button[] button = new Button[users.size()];
        int j = 0;
        while(j<users.size()){
            //users.get(j).setUserName(users);
            button[j] = new Button(this);
            button[j].setText(users.get(j).getUserName());
            button[j].setTextColor(Color.WHITE);
            button[j].setGravity(Gravity.CENTER);
            button[j].setBackgroundResource(R.drawable.roundedbutton);
            setMargins(button[j],0,0,0,50);
            ll.addView(button[j]);
            button[j].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent mamba = new Intent(MainActivity.this, Action.class);
                    startActivity(mamba);

                }
            });
            j++;

        }
    }

    public static void setMargins (View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
        }
    }
    public void addUser(String name) {
        Button user = new Button(this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.users);
        user.setText(name);
        user.setTextColor(Color.WHITE);
        user.setGravity(Gravity.CENTER);
        user.setBackgroundResource(R.drawable.roundedbutton);
        linearLayout.addView(user);
        user.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Please enter your password");

// Set up the input
                final EditText input = new EditText(MainActivity.this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                builder.setView(input);

// Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_Text = input.getText().toString();
                        if (m_Text.equals(users.get(0).getUserName())) {
                            Intent mamba = new Intent(MainActivity.this, Action.class);
                            startActivity(mamba);
                        }

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();

            }
        });
    }
}




