package com.example.miprimerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PediatrasSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pediatras_search);
    }

    public void PediatrasFound(View view){
        Intent pediatrasFound = new Intent(this,PediatrasFound.class);
        startActivity(pediatrasFound);
    }
}
