package com.example.femio.adicionatemporeal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> arrayplanetas=new ArrayList();
        final Spinner spiner=(Spinner)findViewById(R.id.spiner);
        Button b1,b2;
        final EditText entrada=(EditText)findViewById(R.id.entrada);
        b1=(Button)findViewById(R.id.engadir);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayplanetas.add(entrada.getText().toString());
            }
        });
        b2=(Button)findViewById(R.id.rematar);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<String> adaptador=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,arrayplanetas);
                spiner.setAdapter(adaptador);
            }
        });
    }
}
