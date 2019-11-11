package com.example.mypediatric;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.mypediatric.Models.Pediatra;

public class PediatrasFound extends AppCompatActivity {

    TextView Name, Address, Phone, description;
    Pediatra found = Pediatras.pediatraFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pediatras_found);

        Name=findViewById(R.id.txtFPName);
        Address=findViewById(R.id.txtFPDireccion);
        Phone=findViewById(R.id.txtFPTelefono);
        description=findViewById(R.id.txtFPDescripcion);

        Name.setText(found.getNombre()+" "+found.getApellido());
        Address.setText("Direccion: "+found.getUbicacion());
        Phone.setText("Tel: "+found.getTelefono());
        description.setText(found.getDescripcion());
    }

    public void MainActivity(View view) {
        Intent mainactivity = new Intent(this, MainActivity.class);
        startActivity(mainactivity);
    }
}
