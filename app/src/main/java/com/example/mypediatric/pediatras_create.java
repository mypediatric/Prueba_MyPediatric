package com.example.mypediatric;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mypediatric.Models.Pediatra;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class pediatras_create extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private List<Pediatra> ListPediatras = new ArrayList<Pediatra>();
    ArrayAdapter<Pediatra> arrayAdapterPediatra;
    TextInputEditText Nombre, Apellido, Telefono, Ubicacion, Descripcion;
    Button crear, actualizar, eliminar, hogar;
    ListView ListVPersonas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pediatras_create);

        Nombre = findViewById(R.id.txtNombre);
        Apellido = findViewById(R.id.txtApellido);
        Telefono = findViewById(R.id.txtTelefono);
        Ubicacion = findViewById(R.id.txtUbicacion);
        Descripcion = findViewById(R.id.txtDescripcion);

        crear = findViewById(R.id.btnCreate);
        actualizar = findViewById(R.id.btnUpdate);
        eliminar = findViewById(R.id.btnDelete);
        hogar = findViewById(R.id.btnHome);

        ListVPersonas = findViewById(R.id.ListPediatras);
        InitializeFirebase();
        listarDatos();
    }

    private void listarDatos() {
        databaseReference.child("Pediatra").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ListPediatras.clear();
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()){
                    Pediatra p = objSnapshot.getValue(Pediatra.class);
                    ListPediatras.add(p);

                    arrayAdapterPediatra = new ArrayAdapter<Pediatra>(pediatras_create.this, android.R.layout.simple_list_item_1, ListPediatras);
                    ListVPersonas.setAdapter(arrayAdapterPediatra);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void InitializeFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void MainActivity(View view) {
        Intent mainactivity = new Intent(this, MainActivity.class);
        startActivity(mainactivity);
    }

    private void Eliminar() {
    }

    private void Editar() {
    }

    public void Registrar(View view) {
        String Nombrev = Nombre.getText().toString();
        String Apellidov = Apellido.getText().toString();
        String Telefonov = Telefono.getText().toString();
        String Ubicacionv = Ubicacion.getText().toString();
        String Descripcionv = Descripcion.getText().toString();
        if (Nombrev.equals("")||Apellidov.equals("")||Telefonov.equals("")||Ubicacionv.equals("")||Descripcionv.equals("")) {
            Validate();
        } else {
            Pediatra p = new Pediatra();
            p.setUid(UUID.randomUUID().toString());
            p.setNombre(Nombrev);
            p.setApellido(Apellidov);
            p.setTelefono(Telefonov);
            p.setUbicacion(Ubicacionv);
            p.setDescripcion(Descripcionv);
            databaseReference.child("Pediatra").child(p.getUid()).setValue(p);
            Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();
            Clear();
        }
    }

    private void Clear() {
        Nombre.setText("");
        Apellido.setText("");
        Telefono.setText("");
        Ubicacion.setText("");
        Descripcion.setText("");
    }

    private void Validate() {
        String Nombrev = Nombre.getText().toString();
        String Apellidov = Apellido.getText().toString();
        String Telefonov = Telefono.getText().toString();
        String Ubicacionv = Ubicacion.getText().toString();
        String Descripcionv = Descripcion.getText().toString();

        if (Nombrev.equals("")) {
            Nombre.setError("Required");
        } else if (Apellidov.equals("")) {
            Apellido.setError("Required");
        } else if (Telefonov.equals("")) {
            Telefono.setError("Required");
        } else if (Ubicacionv.equals("")) {
            Ubicacion.setError("Required");
        } else if (Descripcionv.equals("")) {
            Descripcion.setError("Required");
        }
    }

    public void Proximo(View view) {
        Toast.makeText(this, "Proximamente", Toast.LENGTH_SHORT).show();
    }


}
