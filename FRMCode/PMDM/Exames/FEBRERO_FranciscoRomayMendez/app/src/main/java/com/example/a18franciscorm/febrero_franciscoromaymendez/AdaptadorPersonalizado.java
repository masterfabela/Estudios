package com.example.a18franciscorm.febrero_franciscoromaymendez;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by a18franciscorm on 14/02/2019.
 */

public class AdaptadorPersonalizado extends ArrayAdapter<String>{
    private Activity context;
    private ArrayList<Alumno> alumnos;

    public AdaptadorPersonalizado(Activity context, ArrayList alumnos) {
        super(context,R.layout.alumno_layout, alumnos);
        this.context=context;
        this.alumnos=alumnos;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflador=context.getLayoutInflater();
        View fila=inflador.inflate(R.layout.alumno_layout,null);
        TextView nome=(TextView)fila.findViewById(R.id.nome);
        nome.setText(alumnos.get(position).getNome());
        TextView curso=(TextView)fila.findViewById(R.id.curso);
        curso.setText(alumnos.get(position).getCurso());
        TextView ciclo=(TextView)fila.findViewById(R.id.ciclo);
        ciclo.setText(alumnos.get(position).getCiclo());
        return fila;
    }
}
