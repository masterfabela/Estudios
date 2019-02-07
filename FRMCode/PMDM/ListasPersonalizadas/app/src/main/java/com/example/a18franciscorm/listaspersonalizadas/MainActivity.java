package com.example.a18franciscorm.listaspersonalizadas;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Animal[] arrayAnimales=new Animal[]{
        new Animal(R.drawable.aguila,R.drawable.color_azul,"Aguila","Ave"),
        new Animal(R.drawable.ballena,R.drawable.color_blanco,"Ballena","Mamifero marino"),
        new Animal(R.drawable.caballo,R.drawable.color_negro,"Caballo","Porte majestuoso"),
        new Animal(R.drawable.canario,R.drawable.color_rosa,"Canario","Ave de canto apreciado")};
        final AdaptadorAnimal adaptadorAnim= new AdaptadorAnimal(this,arrayAnimales);
        final ListView listaElementos=(ListView)findViewById(R.id.listaElementos);
        listaElementos.setAdapter(adaptadorAnim);
        listaElementos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Seleccion: "+arrayAnimales[position].getNombre(),Toast.LENGTH_SHORT).show();
                ;
            }
        });

    }
}

