package com.example.femio.listaspersonalizadas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Animais>animais=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lista=(ListView)findViewById(R.id.lista);
        animais.add(new Animais("Cabalo",R.drawable.caballo));
        animais.add(new Animais("Balea",R.drawable.ballena));
        AdaptadorPersonalizado pers=new AdaptadorPersonalizado(this,animais);
        lista.setAdapter(pers);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Seleccion:"+animais.get(position).getNome(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}
