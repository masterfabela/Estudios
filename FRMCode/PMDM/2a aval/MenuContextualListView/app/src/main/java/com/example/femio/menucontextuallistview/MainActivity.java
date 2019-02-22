package com.example.femio.menucontextuallistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int eliminador;
    final ArrayList<String> listaPlanetas=new ArrayList();
    ArrayAdapter<String>adaptador;
    ListView lista;
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.eliminar:
                listaPlanetas.remove(eliminador);
                adaptador=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,listaPlanetas);
                lista.setAdapter(adaptador);
            break;
            case R.id.opcion2:
                Toast.makeText(MainActivity.this,item.getTitle(),Toast.LENGTH_SHORT).show();
            break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflador=getMenuInflater();
        inflador.inflate(R.menu.menucontex,menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista=(ListView)findViewById(R.id.lista);
        listaPlanetas.add("Mercurio");
        listaPlanetas.add("Venus");
        listaPlanetas.add("Terra");
        listaPlanetas.add("Marte");
        listaPlanetas.add("Xupiter");
        listaPlanetas.add("Saturno");
        listaPlanetas.add("Urano");
        listaPlanetas.add("Neptuno");
        adaptador=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,listaPlanetas);
        lista.setAdapter(adaptador);
        registerForContextMenu(lista);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                eliminador=position;
                Toast.makeText(MainActivity.this,listaPlanetas.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
