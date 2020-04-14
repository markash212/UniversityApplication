package com.university.application;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout timetable;
    LinearLayout external_link;
    LinearLayout library;
    LinearLayout floor_map;

    TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        timetable = (LinearLayout) findViewById(R.id.timetable);
        external_link = (LinearLayout) findViewById(R.id.external_link);
        library = (LinearLayout) findViewById(R.id.library);
        floor_map = (LinearLayout) findViewById(R.id.floor_map);
        logout = (TextView) findViewById(R.id.logout);
        logout.setOnClickListener(this);
        timetable.setOnClickListener(this);
        external_link.setOnClickListener(this);
        library.setOnClickListener(this);
        floor_map.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.timetable) {
            startActivity(new Intent(getApplicationContext(), TimeTableActivity.class));
        } else if (v.getId() == R.id.external_link) {
            Utility.openBrower(this, "https://www.google.com");

        } else if (v.getId() == R.id.library) {
            startActivity(new Intent(getApplicationContext(), LibraryActivity.class));
        } else if (v.getId() == R.id.logout) {
            showPopup();
        } else if (v.getId() == R.id.floor_map) {
            startActivity(new Intent(getApplicationContext(), FloorMapActivity.class));
        }
    }

    // first step helper function
    private void showPopup() {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setMessage("Are you sure you want to logout?")
                .setPositiveButton("Logout", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        FirebaseAuth.getInstance().signOut();
                        startActivity(new Intent(getApplicationContext(), Login.class));
                        finish();

                    }
                }).setNegativeButton("Cancel", null);

        AlertDialog alert1 = alert.create();
        alert1.show();
    }
}