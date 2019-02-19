package com.example.femio.adaptadores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spiner=(Spinner)findViewById(R.id.spiner);
        ArrayList<String> planetas= new ArrayList<String>();
        planetas.add("Mercurio");
        planetas.add("Venus");
        planetas.add("Terra");
        planetas.add("Marte");
        planetas.add("Xupiter");
        planetas.add("Saturno");
        planetas.add("Urano");
        planetas.add("Neptuno");
        //Duas opcions de visualizacion:
        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,planetas);
        //ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,planetas);
        spiner.setAdapter(adaptador);
        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Seleccion: "+parent.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this,"Nada seleccionado.",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
