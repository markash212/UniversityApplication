package com.university.application;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class LibraryActivity extends AppCompatActivity {

    Toolbar toolbar;
    LinearLayout computing;
    LinearLayout maths;
    LinearLayout business;
    LinearLayout economics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        initView();
        initToolbar();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.library_toolbar);
        computing = (LinearLayout) findViewById(R.id.computing);
        maths = (LinearLayout) findViewById(R.id.maths);
        economics = (LinearLayout) findViewById(R.id.economics);
        business = (LinearLayout) findViewById(R.id.business);

        computing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.openBrower(LibraryActivity.this, "https://books.google.com.sg/books?id=f4IyDwAAQBAJ&source=gbs_ViewAPI&redir_esc=y");
            }
        });

        maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.openBrower(LibraryActivity.this, "https://books.google.co.uk/books?id=T3mzCAAAQBAJ&source=gbs_ViewAPI&redir_esc=y");

            }
        });

        economics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.openBrower(LibraryActivity.this, "https://books.google.co.uk/books?id=joTYBQAAQBAJ&printsec=frontcover&dq=economics&hl=en&sa=X&ved=0ahUKEwjdkffgqeDoAhUBuHEKHfoHBhwQ6wEILTAA#v=onepage&q=economics&f=false");

            }
        });

        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.openBrower(LibraryActivity.this, "https://books.google.co.uk/books?id=rE6MDwAAQBAJ&source=gbs_ViewAPI&redir_esc=y");

            }
        });
    }

    private void initToolbar() {

        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
