package com.example.a18franciscorm.listaspersonalizadas;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by a18franciscorm on 22/01/2019.
 */
public class AdaptadorAnimal extends ArrayAdapter {
    private Activity context;
    private Animal[] animales;
    //constructor por finalizar
    public AdaptadorAnimal(Activity context, Animal[] animales) {
        super(context,R.layout.layoutfilas,animales);
        this.context = context;
        this.animales = animales;
    }
    public View getView(int posicion, View convertView, ViewGroup parent){
        LayoutInflater inflador= context.getLayoutInflater();
        View item=inflador.inflate(R.layout.layoutfilas,null);
        TextView nomeView=(TextView)item.findViewById(R.id.nombre);
        nomeView.setText(animales[posicion].getNombre());
        TextView descView= (TextView)item.findViewById(R.id.descripcion);
        descView.setText(animales[posicion].getDescripcion());
        ImageView imaxe=(ImageView)item.findViewById(R.id.imagen);
        imaxe.setImageResource(animales[posicion].getIdFoto());
        ImageView cor=(ImageView)item.findViewById(R.id.color);
        cor.setImageResource(animales[posicion].getIdColor());
        if(posicion%2==0){
            nomeView.setTextColor(Color.BLUE);
        }else{
            item.setBackgroundColor(Color.CYAN);
        }
        return item;
    }
}
