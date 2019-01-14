package com.example.a18franciscorm.provinciasv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner cidades;
    AutoCompleteTextView provincias;
    private String[] arrayProv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        provincias=(AutoCompleteTextView)findViewById(R.id.provincias);
        arrayProv=getResources().getStringArray(R.array.Provincias);
        cidades=(Spinner)findViewById(R.id.cidades);
        final ArrayAdapter adaptadorProv= new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayProv);
        provincias.setAdapter(adaptadorProv);
        provincias.setThreshold(0);
        provincias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(provincias.getSele);
            }
        });

    }
}
