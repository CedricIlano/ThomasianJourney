package com.example.cedri_000.thomasianjourney;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ActivationEmail extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_activation);
    }

    public void Cancel (View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void Verify (View v) {
        Intent intent = new Intent(this, homepage.class);
        startActivity(intent);
    }


}
