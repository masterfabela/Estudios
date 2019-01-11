package com.example.a18franciscorm.autocompletartexto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] arrayNombres;
    AutoCompleteTextView entrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayNombres=getResources().getStringArray(R.array.nombres);
        entrada=(AutoCompleteTextView)findViewById(R.id.entrada);
        final ArrayAdapter adaptador= new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayNombres);
        entrada.setAdapter(adaptador);
        entrada.setThreshold(1);
        entrada.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Elixiches o elemento "+(position+1),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
