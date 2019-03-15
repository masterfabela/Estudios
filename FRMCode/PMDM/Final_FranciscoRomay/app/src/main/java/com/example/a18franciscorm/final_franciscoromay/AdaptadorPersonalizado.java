package com.example.a18franciscorm.final_franciscoromay;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by a18franciscorm on 14/03/2019.
 */

public class AdaptadorPersonalizado extends ArrayAdapter<String> {
    private Activity context;
    private ArrayList<String> nomes;

    public AdaptadorPersonalizado(Activity context, ArrayList<String> nomes) {
        super(context, R.layout.fila,nomes);
        this.nomes=nomes;
        this.context=context;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflador=context.getLayoutInflater();
        View fila=inflador.inflate(R.layout.fila,null);
        TextView nome=(TextView)fila.findViewById(R.id.textoFila);
        nome.setText(nomes.get(position).toString());
        return fila;
    }
}
