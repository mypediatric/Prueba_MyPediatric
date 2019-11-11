package com.example.mypediatric;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.mypediatric.Models.Paciente;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Registro extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    EditText txtDocType, txtDocNum, txtName, txtLastName, txtBirth, txtAdress, txtEmail, txtPass;
    RadioGroup radgChromosome23;
    RadioButton rbMale, rbFemale;
    CheckBox chkTandc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtAdress = findViewById(R.id.txtAdress);
        txtBirth = findViewById(R.id.txtBirth);
        txtDocNum = findViewById(R.id.txtDocNum);
        txtDocType = findViewById(R.id.txtDocType);
        txtEmail = findViewById(R.id.txtEmail);
        txtLastName = findViewById(R.id.txtLastName);
        txtName = findViewById(R.id.txtName);
        txtPass = findViewById(R.id.txtPass);
        radgChromosome23 = findViewById(R.id.radgChromosome23);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        chkTandc = findViewById(R.id.chkTandc);
        InitializeFirebase();
    }

    private void InitializeFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void Registrar(View view) {
        String DocT = txtDocType.getText().toString();
        String DocN = txtDocNum.getText().toString();
        String Name = txtName.getText().toString();
        String LastN = txtLastName.getText().toString();
        String Birth = txtBirth.getText().toString();
        String Genere="";
        String Adress = txtAdress.getText().toString();
        String Email = txtEmail.getText().toString();
        String Pass = txtPass.getText().toString();
        if (DocT.equals("") || DocN.equals("") || Name.equals("") || LastN.equals("") || Birth.equals("") || radgChromosome23.getCheckedRadioButtonId() == -1 || Adress.equals("") || Email.equals("") || Pass.equals("")) {
            Validate();
        } else {
            if (radgChromosome23.getCheckedRadioButtonId() == 0){
                Genere= "Masculino";
            } else if (radgChromosome23.getCheckedRadioButtonId() == 0){
                Genere= "Femenino";
            }
            Paciente p = new Paciente();
            p.setUid(UUID.randomUUID().toString());
            p.setTipoDeDocumento(DocT);
            p.setNumeroDeDocumento(DocN);
            p.setNombres(Name);
            p.setApellidos(LastN);
            p.setFechaDeNacimiento(Birth);
            p.setGenero(Genere);
            p.setDireccion(Adress);
            p.setCorreoElectronico(Email);
            p.setContraseña(Pass);
            databaseReference.child("Paciente").child(p.getUid()).setValue(p);
            Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();
            Ingresar();
        }

    }


    private void Validate() {
        String DocT = txtDocType.getText().toString();
        String DocN = txtDocNum.getText().toString();
        String Name = txtName.getText().toString();
        String LastN = txtLastName.getText().toString();
        String Birth = txtBirth.getText().toString();
        //genere
        String Adress = txtAdress.getText().toString();
        String Email = txtEmail.getText().toString();
        String Pass = txtPass.getText().toString();
        if (DocT.equals("")) {
            txtDocType.setError("Required");
        } else if (DocN.equals("")) {
            txtDocNum.setError("Required");
        } else if (Name.equals("")) {
            txtName.setError("Required");
        } else if (LastN.equals("")) {
            txtLastName.setError("Required");
        } else if (Birth.equals("")) {
            txtBirth.setError("Required");
        } else if (radgChromosome23.getCheckedRadioButtonId() == -1) {
            rbFemale.setError("Required");
        } else if (Adress.equals("")) {
            txtAdress.setError("Required");
        } else if (Email.equals("")) {
            txtEmail.setError("Required");
        } else if (Pass.equals("")) {
            txtPass.setError("Required");
        }
    }

    public void Proximo(View view) {
        Toast.makeText(this, "Proximamente", Toast.LENGTH_SHORT).show();
    }

    public void Ingresar() {
        Intent ingresar = new Intent(this, Login.class);
        startActivity(ingresar);
    }
}
