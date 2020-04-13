package com.example.mypediatric;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    FirebaseAuth fAuth;
    EditText txtUser, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fAuth = FirebaseAuth.getInstance();
        txtUser = findViewById(R.id.txtUser);
        txtPassword = findViewById(R.id.txtPassword);

        if (fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
    }

    public void MainActivity(View view) {
        Intent mainactivity = new Intent(this, MainActivity.class);
        startActivity(mainactivity);
    }

    public void Proximo(View view) {
        Toast.makeText(this, "Proximamente", Toast.LENGTH_SHORT).show();
    }

    public void LoggedIn() {
        Toast.makeText(this, "Sesion iniciada", Toast.LENGTH_SHORT).show();
    }

    public void Registrar(View view) {
        Intent registro = new Intent(this, Registro.class);
        startActivity(registro);
    }

    public void Registrokid(View view) {
        Intent registro = new Intent(this, Regist_Kid.class);
        startActivity(registro);
    }

    public void MainMaster(View view) {
        Intent Mainmaster = new Intent(this, Mainmaster.class);
        startActivity(Mainmaster);
    }

    public void actionLogin(View view){

        String User = txtUser.getText().toString();
        String Password = txtPassword.getText().toString();

        if (TextUtils.isEmpty(User)){
            txtUser.setError("Ingrese usuario");
            return;
        }

        if (TextUtils.isEmpty(Password)){
            txtPassword.setError("Ingrese Contraseña");
        }

        fAuth = FirebaseAuth.getInstance();
        fAuth.signInWithEmailAndPassword(User,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    LoggedIn();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }
            }
        });

    }
}