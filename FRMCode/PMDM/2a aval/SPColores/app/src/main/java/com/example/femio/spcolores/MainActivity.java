package com.example.femio.spcolores;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg1;
    RadioButton azul,rojo;
    TextView texto;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.butGardar);
        rg1=(RadioGroup)findViewById(R.id.grupo);
        azul=(RadioButton)findViewById(R.id.azul);
        rojo=(RadioButton)findViewById(R.id.verlello);
        texto=(TextView)findViewById(R.id.texto);
        SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String color=sp.getString("Color","nada");
        switch(color){
            case "azul":texto.setTextColor(Color.BLUE);
                break;
            case "rojo":texto.setTextColor(Color.RED);
                break;
            default:texto.setTextColor(Color.GRAY);
                break;
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor=sp.edit();
                if(rg1.getCheckedRadioButtonId()==azul.getId()){
                    editor.putString("Color","azul");
                    editor.commit();
                }else{if(rg1.getCheckedRadioButtonId()==rojo.getId()){
                    editor.putString("Color","rojo");
                    editor.commit();
                }else{
                    System.out.println("Nada seleccionado.");
                    editor.clear();
                    editor.commit();
                }
                }

            }
        });
    }
}
