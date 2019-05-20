package com.example.miprimerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {
    CarouselView carouselView;
    int image[]={R.drawable.doctor,R.drawable.bebe,R.drawable.farmacia, R.drawable.centro,R.drawable.punto, R.drawable.ajustes};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        carouselView=(CarouselView)findViewById(R.id.carusiel);

        carouselView.setPageCount(image.length);
        carouselView.setImageListener(imageListener);

    }
    ImageListener imageListener = new ImageListener(){
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(image[position]);
        }
    };



    public void Ingresar(View view){
        Intent ingresar = new Intent(this,Login.class);
        startActivity(ingresar);
    }

    public void Registro(View view){
        Intent registro = new Intent(this,Registro.class);
        startActivity(registro);
    }

    public void Pediatras(View view){
        Intent pediatras = new Intent(this,Pediatras.class);
        startActivity(pediatras);
    }

    public void Proximo(View view){
        Toast.makeText(this, "Proximamente", Toast.LENGTH_SHORT).show();
    }


}
