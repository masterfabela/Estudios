package com.example.a18franciscorm.listaspersonalizadas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList arrayAnimales=new ArrayList();
        arrayAnimales.add(new Animal(R.drawable.aguila,R.drawable.color_azul,"Aguila","Ave"));
        arrayAnimales.add(new Animal(R.drawable.ballena,R.drawable.color_blanco,"Ballena","Mamifero marino"));
        arrayAnimales.add(new Animal(R.drawable.caballo,R.drawable.color_negro,"Caballo","Porte majestuoso"));
        arrayAnimales.add(new Animal(R.drawable.canario,R.drawable.color_rosa,"Canario","Ave de canto apreciado"));
    }
}
