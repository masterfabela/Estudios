package com.example.femio.listaspersonalizadas;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Femio on 13/02/2019.
 */

public class AdaptadorPersonalizado extends ArrayAdapter{
    private Activity context;
    private ArrayList<Animais> animais;
    public AdaptadorPersonalizado(Activity context,ArrayList<Animais>animais){
            super(context,R.layout.layoutfila,animais);
        this.animais=animais;
        this.context=context;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflador=context.getLayoutInflater();
        View fila=inflador.inflate(R.layout.layoutfila,null);
        TextView nome=(TextView)fila.findViewById(R.id.texto);
        nome.setText(animais.get(position).getNome().toString());
        ImageView imaxe=(ImageView)fila.findViewById(R.id.imaxe);
        imaxe.setImageResource(animais.get(position).getImaxe());
        return fila;
    }
}
