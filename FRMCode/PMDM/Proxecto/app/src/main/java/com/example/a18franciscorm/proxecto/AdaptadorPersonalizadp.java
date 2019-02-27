package com.example.a18franciscorm.proxecto;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
        TextView codigo=(TextView)fila.findViewById(R.id.codigo);
        codigo.setText(String.valueOf(animais.get(position).getCodigo()));
        TextView tipo=(TextView)fila.findViewById(R.id.tipo);
        tipo.setText(animais.get(position).getTipo().toString());
        TextView nome=(TextView)fila.findViewById(R.id.nome);
        nome.setText(animais.get(position).getNome().toString());
        TextView azucares=(TextView)fila.findViewById(R.id.azucares);
        azucares.setText(animais.get(position).getAzucares().toString());
        TextView grasas=(TextView)fila.findViewById(R.id.grasas);
        grasas.setText(animais.get(position).getGrasas().toString());
        TextView sodio=(TextView)fila.findViewById(R.id.sodio);
        sodio.setText(animais.get(position).getSodio().toString());
        return fila;
    }
}
