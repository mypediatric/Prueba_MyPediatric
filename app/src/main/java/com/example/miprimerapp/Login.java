package com.example.miprimerapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void MainActivity(View view){
        Intent mainactivity = new Intent(this,MainActivity.class);
        startActivity(mainactivity);
    }

    public void Proximo(View view){
        Toast.makeText(this, "Proximamente", Toast.LENGTH_SHORT).show();
    }

}