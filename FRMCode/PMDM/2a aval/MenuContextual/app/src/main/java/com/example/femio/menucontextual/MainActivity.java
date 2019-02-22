package com.example.femio.menucontextual;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mensaxe=(TextView)findViewById(R.id.mensaxe);
        ImageView visor=(ImageView)findViewById(R.id.visor);
        registerForContextMenu(mensaxe);
        registerForContextMenu(visor);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId()==R.id.mensaxe){
            MenuInflater inflador=getMenuInflater();
            inflador.inflate(R.menu.menucontex,menu);
        }else{
            MenuInflater inflador=getMenuInflater();
            inflador.inflate(R.menu.menucontex2,menu);
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:Toast.makeText(MainActivity.this,"Texto:"+item.getTitle(),Toast.LENGTH_SHORT).show();;
            break;
            case R.id.item2:Toast.makeText(MainActivity.this,"Texto:"+item.getTitle(),Toast.LENGTH_SHORT).show();;
                break;
            case R.id.item3:Toast.makeText(MainActivity.this,"Texto:"+item.getTitle(),Toast.LENGTH_SHORT).show();;
                break;
            case R.id.item4:Toast.makeText(MainActivity.this,"Imaxe:"+item.getTitle(),Toast.LENGTH_SHORT).show();;
                break;
            case R.id.item5:Toast.makeText(MainActivity.this,"Imaxe:"+item.getTitle(),Toast.LENGTH_SHORT).show();;
                break;
            case R.id.item6:Toast.makeText(MainActivity.this,"Imaxe:"+item.getTitle(),Toast.LENGTH_SHORT).show();;
                break;
        }
        return super.onContextItemSelected(item);
    }


}
