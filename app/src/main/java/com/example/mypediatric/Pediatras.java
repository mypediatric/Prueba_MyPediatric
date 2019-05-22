package com.example.mypediatric;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Pediatras extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pediatras);
    }

    public void Proximo(View view) {
        Toast.makeText(this, "Proximamente", Toast.LENGTH_SHORT).show();
    }

    public void PediatrasSearch(View view) {
        Intent pediatrasSearch = new Intent(this, PediatrasSearch.class);
        startActivity(pediatrasSearch);
    }
}
