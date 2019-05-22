package com.example.mypediatric;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PediatrasFound extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pediatras_found);
    }

    public void MainActivity(View view) {
        Intent mainactivity = new Intent(this, MainActivity.class);
        startActivity(mainactivity);
    }
}
