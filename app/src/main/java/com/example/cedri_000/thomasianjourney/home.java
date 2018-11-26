package com.example.cedri_000.thomasianjourney;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

    }

    public void ViewEvents (View v) {
        Intent intent = new Intent(this, ViewEv.class);
        startActivity(intent);
    }

}
