package com.example.a18franciscorm.listaspersonalizadas;

import android.app.Activity;
import android.widget.ArrayAdapter;

/**
 * Created by a18franciscorm on 22/01/2019.
 */
public class AdaptadorPersonalizado extends ArrayAdapter<String> {
    private Activity context;
    private Animal[] animales;


    //constructor por finalizar
    public AdaptadorPersonalizado(Activity context, Animal[] animales) {
        super(context, R.layout.layoutfilas, animales);
        this.context = context;
        this.animales = animales;

    }
}
