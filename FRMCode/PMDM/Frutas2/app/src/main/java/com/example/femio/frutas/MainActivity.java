package com.example.femio.frutas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> listaFroitas=new ArrayList();
    Button b1,b2;
    EditText entrada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.engadir);
        b2=(Button)findViewById(R.id.rematar);
        entrada=(EditText)findViewById(R.id.entrada);
        entrada.setText("");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(entrada.getText().equals("")){
                    Toast.makeText(MainActivity.this,"Erro na entrada",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Engadese "+entrada.getText().toString(),Toast.LENGTH_SHORT).show();
                    listaFroitas.add(entrada.getText().toString());
                    entrada.setText("");
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,Main2Activity.class);
                Bundle b=new Bundle();
                b.putStringArrayList("lista",listaFroitas);
                i.putExtras(b);
                startActivity(i);
            }
        });
    }
}
