package com.example.femio.provinciaselocalidades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spiner;
    AutoCompleteTextView entrada;
    String[]arrayP,coruña,ponte,ourense,lugo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spiner=(Spinner)findViewById(R.id.spiner);
        entrada=(AutoCompleteTextView)findViewById(R.id.entrada);
        arrayP=getResources().getStringArray(R.array.Provincias);
        coruña=getResources().getStringArray(R.array.CidadesCoruña);
        ponte=getResources().getStringArray(R.array.CidadesPonte);
        ourense=getResources().getStringArray(R.array.CidadesOurense);
        lugo=getResources().getStringArray(R.array.CidadesLugo);
        final ArrayAdapter adaptPonte=new ArrayAdapter(this,android.R.layout.simple_list_item_1,ponte);
        final ArrayAdapter adaptCour=new ArrayAdapter(this,android.R.layout.simple_list_item_1,coruña);
        final ArrayAdapter adaptOu=new ArrayAdapter(this,android.R.layout.simple_list_item_1,ourense);
        final ArrayAdapter adaptProv=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayP);
        final ArrayAdapter adaptLugo=new ArrayAdapter(this,android.R.layout.simple_list_item_1,lugo);
        entrada.setAdapter(adaptProv);
        entrada.setThreshold(1);
        entrada.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).toString().equals("Ourense")){
                    spiner.setAdapter(adaptOu);
                }
                if (parent.getItemAtPosition(position).toString().equals("Pontevedra")){
                    spiner.setAdapter(adaptPonte);
                }
                if (parent.getItemAtPosition(position).toString().equals("Lugo")){
                    spiner.setAdapter(adaptLugo);
                }
                if (parent.getItemAtPosition(position).toString().equals("A Coruña")){
                    spiner.setAdapter(adaptCour);
                }
            }
        });
    }
}
