package com.example.a18franciscorm.proxecto;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Femio on 27/02/2019.
 */

public class AdaptadorPersonalizadp extends ArrayAdapter {
    private Activity context;
    private ArrayList<Alimento> animais;

    public AdaptadorPersonalizadp(Activity a,ArrayList<Alimento>al) {
        super(a, R.layout.fila,al);
        this.animais=al;
        this.context=a;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflador=context.getLayoutInflater();
        View fila=inflador.inflate(R.layout.fila,null);
        TextView tipo=(TextView)fila.findViewById(R.id.tipo);
        tipo.setText("Tipo: "+animais.get(position).getTipo().toString());
        TextView nome=(TextView)fila.findViewById(R.id.nome);
        nome.setText("Nome:"+animais.get(position).getNome().toString());
        ImageView img1,img2,img3;
        img1=(ImageView)fila.findViewById(R.id.azucares);
        img2=(ImageView)fila.findViewById(R.id.grasas);
        img3=(ImageView)fila.findViewById(R.id.sodio);
        String stringTipo=animais.get(position).getTipo().toString();
        if(stringTipo.equalsIgnoreCase("Froita")){
            img1.setImageDrawable("");
        }
        return fila;
    }
}
