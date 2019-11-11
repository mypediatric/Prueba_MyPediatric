package com.example.mypediatric;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class Pediatras extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private List<Pediatra> ListPediatras = new ArrayList<Pediatra>();
    ArrayAdapter<Pediatra> arrayAdapterPediatra;
    ListView ListVPersonas;
    Pediatra pediatraSelected;
    public static Pediatra pediatraFound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pediatras);

        ListVPersonas = findViewById(R.id.ListPediatras);
        InitializeFirebase();
        listarDatos();

        ListVPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pediatraSelected=(Pediatra) parent.getItemAtPosition(position);
                pediatraFound=pediatraSelected;
                pediatrasFound(view);
            }
        });
    }

    private void listarDatos() {
        databaseReference.child("Pediatra").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ListPediatras.clear();
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()){
                    Pediatra p = objSnapshot.getValue(Pediatra.class);
                    ListPediatras.add(p);

                    arrayAdapterPediatra = new ArrayAdapter<Pediatra>(Pediatras.this, android.R.layout.simple_list_item_1, ListPediatras);
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

    public void Proximo(View view) {
        Toast.makeText(this, "Proximamente", Toast.LENGTH_SHORT).show();
    }

    public void pediatrasFound(View view) {
        Intent PediatrasFound = new Intent(this, PediatrasFound.class);
        startActivity(PediatrasFound);
    }
}
