package com.example.a18franciscorm.provinciasv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import java.sql.Array;


public class MainActivity extends AppCompatActivity {
    Spinner cidades;
    AutoCompleteTextView provincias;
    private String[] arrayProv,arrayC,arrayP,arrayO,arrayL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        provincias=(AutoCompleteTextView)findViewById(R.id.provincias);
        arrayProv=getResources().getStringArray(R.array.Provincias);
        System.out.println(arrayProv[3]);
        cidades=(Spinner)findViewById(R.id.cidades);
        final ArrayAdapter adaptadorProv= new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayProv);
        arrayP=getResources().getStringArray(R.array.CidadesPontevedra);
        arrayC=getResources().getStringArray(R.array.CidadesCoruña);
        arrayO=getResources().getStringArray(R.array.CidadesOurense);
        arrayL=getResources().getStringArray(R.array.CidadesLugo);
        final ArrayAdapter adaptadorPonte= new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayP);
        final ArrayAdapter adaptadorOu= new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayO);
        final ArrayAdapter adaptadorLu= new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayL);
        final ArrayAdapter adaptadorCo= new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayC);
        provincias.setAdapter(adaptadorProv);
        provincias.setThreshold(1);
        provincias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position)==arrayProv[3]){
                    cidades.setAdapter(adaptadorPonte);
                    System.out.println(R.array.Provincias);
                }
                if(parent.getItemAtPosition(position).toString().equals("Ourense")){
                    cidades.setAdapter(adaptadorOu);
                }
                if(parent.getItemAtPosition(position).toString().equals("A Coruña")){
                    cidades.setAdapter(adaptadorCo);
                }
                if(parent.getItemAtPosition(position).toString().equals("Lugo")){
                    cidades.setAdapter(adaptadorLu);
                }
            }
        });

    }
}
