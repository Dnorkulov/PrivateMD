package com.dalernorkulov.privatemd;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import java.util.ArrayList;
public class MainActivity extends CreateUser {
    ArrayList<User> users = new ArrayList<User>();

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

        Intent intent = getIntent();
        String str = intent.getStringExtra("location");

        users.add(new User());
        users.get(0).setUserName(str);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.users);
        Button[] butt = new Button[users.size()];
        for (int i = 0; i < users.size(); i++) {
            butt[i] = new Button(this);
            butt[i].setText(users.get(i).getUserName());
            butt[i].setTextColor(Color.WHITE);
            butt[i].setGravity(Gravity.CENTER);
            butt[i].setBackgroundResource(R.drawable.roundedbutton);
            linearLayout.addView(butt[i]);
            butt[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent mamba = new Intent(MainActivity.this, Action.class);
                    startActivity(mamba);
                }
            });
        }
    }
}
