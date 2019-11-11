package com.example.mypediatric;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.DatabaseMetaData;

public class Regist_Kid extends AppCompatActivity {
EditText txtNombreK, txtApellidK,txtPesoK,txtEstaturaK;
Spinner spinGen,spinRH,spinEdad;
Button btnRegistarK;

private DatabaseReference RegistKid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrokids);
        //spinner genero
        spinGen= findViewById(R.id.spinGen);
        ArrayAdapter<CharSequence> adapterG=ArrayAdapter.createFromResource(this,R.array.spinGen,android.R.layout.simple_spinner_item);
        spinGen.setAdapter(adapterG);
        //spinner RH
        spinGen= findViewById(R.id.spinRH);
        ArrayAdapter<CharSequence> adapterH=ArrayAdapter.createFromResource(this,R.array.spinRH,android.R.layout.simple_spinner_item);
        spinGen.setAdapter(adapterH);
        //spinner Edad
        spinGen= findViewById(R.id.spinEdad);
        ArrayAdapter<CharSequence> adapterE=ArrayAdapter.createFromResource(this,R.array.spinEdad,android.R.layout.simple_spinner_item);
        spinGen.setAdapter(adapterE);
        RegistKid = FirebaseDatabase.getInstance().getReference("Clases_Reg_Kids");
        txtNombreK=(EditText) findViewById(R.id.txtNombreK);
        txtApellidK=(EditText) findViewById(R.id.txtApellidK);
        txtPesoK=(EditText) findViewById(R.id.txtPesoK);
        txtEstaturaK=(EditText) findViewById(R.id.txtEstaturaK);
        spinGen=(Spinner) findViewById(R.id.spinGen);
        spinRH=(Spinner) findViewById(R.id.spinRH);
        spinEdad=(Spinner) findViewById(R.id.spinEdad);
        btnRegistarK=(Button) findViewById(R.id.btnRegistarK);

    }
    public void RegistrKid(){
        String genero=spinGen.getSelectedItem().toString();
        String rh=spinRH.getSelectedItem().toString();
        String edad=spinEdad.getSelectedItem().toString();
        String nombre=txtNombreK.getText().toString();
        String apellido=txtApellidK.getText().toString();
        String peso=txtPesoK.getText().toString();
        String estatura=txtEstaturaK.getText().toString();
    }
    }
