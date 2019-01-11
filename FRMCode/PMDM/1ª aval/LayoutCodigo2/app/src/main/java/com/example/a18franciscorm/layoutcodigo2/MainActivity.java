package com.example.a18franciscorm.layoutcodigo2;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        // Se sustituye la linea anterior por las  siguientes
        // --- parámetros para las vistas
        // --- se crea un objeto LayoutParams para especificar los parámetros
        // --- de diseño que se pueden utilizar para las vistas
        LayoutParams parametros = new LinearLayout.LayoutParams


        (LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        // --- crear un objeto LinearLayout como contenedor de todas las vistas
        // --- en esta actividad
        LinearLayout miLayout = new LinearLayout(this);
        miLayout.setOrientation(LinearLayout.VERTICAL);
        // --- Crear una instancia de la clase TextView
        TextView etiqueta1 = new TextView(this);
        // Establecemos el texto
        etiqueta1.setText("TextView desde código");
        etiqueta1.setLayoutParams(parametros);
        // --- Crear una instancia de la clase Button
        Button boton1 = new Button(this);
        // Establecemos el texto
        boton1.setText("Botón desde código");
        boton1.setLayoutParams(parametros);
        // --- Añadir ambas vistas al objeto Layout
        miLayout.addView(etiqueta1);   miLayout.addView(boton1);
        // --- Añadir el objeto LinearLayout a la actividad
        this.addContentView(miLayout, parametros);  } }
