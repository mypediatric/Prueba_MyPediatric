package com.example.mypediatric;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {

    CarouselView carouselView;
    int image[] = {R.drawable.centroleyenda, R.drawable.farmaciasleyenda, R.drawable.profesionalesleyenda, R.drawable.bebeleyenda};
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(image[position]);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carouselView = (CarouselView) findViewById(R.id.carusiel);

        carouselView.setPageCount(image.length);
        carouselView.setImageListener(imageListener);

    }

    public void Ingresar(View view) {
        Intent ingresar = new Intent(this, Login.class);
        startActivity(ingresar);
    }

    public void Registro(View view) {
        Intent registro = new Intent(this, Registro.class);
        startActivity(registro);
    }

    /*public void Pediatras(View view) {
        Intent pediatras = new Intent(this, Pediatras.class);
        startActivity(pediatras);
    }*/


    public void Link1 (View view){
        Intent LinkIntent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://mypediatric.com.co"));
        startActivity(LinkIntent);
    }

    /*public void OcultPediatr(View view) {
        Intent OcultPediatr = new Intent(this, pediatras_create.class);
        startActivity(OcultPediatr);
    }*/
}
