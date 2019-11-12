package com.example.mypediatric;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mypediatric.Models.Kids;
import com.example.mypediatric.Models.Paciente;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;


public class Regist_Kid extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    EditText txtNombreK, txtApellidK, txtPesoK, txtEstaturaK;
    Spinner spinGenK, spinRHK, spinEdadK;
    Button btnRegistarK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrokids);


        //spinner genero
        spinGenK = findViewById(R.id.spinGenK);
        ArrayAdapter<CharSequence> adapterG = ArrayAdapter.createFromResource(this, R.array.spinGenK, android.R.layout.simple_spinner_item);
        spinGenK.setAdapter(adapterG);
        //spinner RH
        spinGenK = findViewById(R.id.spinRHK);
        ArrayAdapter<CharSequence> adapterH = ArrayAdapter.createFromResource(this, R.array.spinRHK, android.R.layout.simple_spinner_item);
        spinGenK.setAdapter(adapterH);
        //spinner Edad
        spinGenK = findViewById(R.id.spinEdadK);
        ArrayAdapter<CharSequence> adapterE = ArrayAdapter.createFromResource(this, R.array.spinEdadK, android.R.layout.simple_spinner_item);
        spinGenK.setAdapter(adapterE);

        txtNombreK = (EditText) findViewById(R.id.txtNombreK);
        txtApellidK = (EditText) findViewById(R.id.txtApellidK);
        txtPesoK = (EditText) findViewById(R.id.txtPesoK);
        txtEstaturaK = (EditText) findViewById(R.id.txtEstaturaK);
        spinGenK = (Spinner) findViewById(R.id.spinGenK);
        spinEdadK = (Spinner) findViewById(R.id.spinEdadK);
        spinRHK = (Spinner) findViewById(R.id.spinRHK);
        btnRegistarK = (Button) findViewById(R.id.btnRegistarK);

        InitializeFirebase();

    }
    private void InitializeFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void Registrar(View view) {
        String NombreK = txtNombreK.getText().toString();
        String ApellidoK = txtApellidK.getText().toString();
        String GenK=spinGenK.getSelectedItem().toString();
        String EdadK=spinEdadK.getSelectedItem().toString();
        String RHK=spinRHK.getSelectedItem().toString();
        String PesoK = txtPesoK.getText().toString();
        String EstaturaK = txtEstaturaK.getText().toString();
        if (NombreK.equals("") || ApellidoK.equals("") || GenK.equals("") || EdadK.equals("") || RHK.equals("")|| PesoK.equals("") || EstaturaK.equals("")) {
            Validate();
        } else {
            Kids p = new Kids();
            p.setUid(UUID.randomUUID().toString());
            p.setNombresK(NombreK);
            p.setApellidosK(ApellidoK);
            p.setGenK(GenK);
            p.setEdadK(EdadK);
            p.setRHK(RHK);
            p.setPesoK(PesoK);
            p.setEstaturaK(EstaturaK);
            databaseReference.child("Nino").child(p.getUid()).setValue(p);
            Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();
            Limpiar();
        }
    }

    private void Limpiar() {
        txtNombreK.setText("");
        txtApellidK.setText("");
        spinGenK.equals("");
        spinEdadK.equals("");
        spinRHK.equals("");
        txtPesoK.setText("");
        txtEstaturaK.setText("");
    }

    private void Validate() {
        String NombreK = txtNombreK.getText().toString();
        String ApellidoK = txtApellidK.getText().toString();
        String GenK=spinGenK.getSelectedItem().toString();
        String EdadK=spinEdadK.getSelectedItem().toString();
        String RHK=spinRHK.getSelectedItem().toString();
        String PesoK = txtPesoK.getText().toString();
        String EstaturaK = txtEstaturaK.getText().toString();

        if (NombreK.equals("")) {
            txtNombreK.setError("Required");
        } else if (ApellidoK.equals("")) {
            txtApellidK.setError("Required");
        } else if (GenK.equals("")) {
            spinGenK.equals("Required");
        } else if (EdadK.equals("")) {
            spinEdadK.equals("Required");
        } else if (RHK.equals("")) {
            spinRHK.equals("Required");
        }
    }




    }


