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
        TextView nome=(TextView)fila.findViewById(R.id.nome);
        nome.setText(animais.get(position).getNome().toString().replace('_',' '));
        TextView tipo=(TextView)fila.findViewById(R.id.tipo);
        tipo.setText(animais.get(position).getTipo().toString().replace('_',' '));
        ImageView img1,img2,img3,imgres;
        img1=(ImageView)fila.findViewById(R.id.azucares);
        img2=(ImageView)fila.findViewById(R.id.grasas);
        img3=(ImageView)fila.findViewById(R.id.sodio);
        imgres=(ImageView)fila.findViewById(R.id.resultado);
        String stringTipo=animais.get(position).getTipo().toString();
        float azucre = Float.parseFloat(animais.get(position).getAzucares());
        float graxa = Float.parseFloat(animais.get(position).getGrasas());
        float sodio = Float.parseFloat(animais.get(position).getSodio());
        boolean azucreVerde,azucreLaranxa,azucreRojo,graxaVerde,graxaLaranxa,graxaRojo,sodioVerde,sodioLaranxa,sodioRojo;
        azucreVerde=azucre<5f;
        azucreLaranxa=azucre<10f;
        azucreRojo=azucre>=10f;
        graxaVerde=graxa<3f;
        graxaLaranxa=graxa<20f;
        graxaRojo=graxa>=20f;
        sodioVerde=sodio<120f;
        sodioLaranxa=sodio<600f;
        sodioRojo=sodio>=600f;
        if(stringTipo.equalsIgnoreCase("Froita")){
            img1.setImageResource(R.drawable.color_green_peque);
            img2.setImageResource(R.drawable.color_green_peque);
            img3.setImageResource(R.drawable.color_green_peque);
        }else{

            if(azucreVerde){
                img1.setImageResource(R.drawable.color_green_peque);
            }else{
                if(azucreLaranxa){
                    img1.setImageResource(R.drawable.color_orange_peque);
                }else{
                    if(azucreRojo){
                        img1.setImageResource(R.drawable.color_red_peque);
                    }
                }
            }
            if(graxaVerde){
                img2.setImageResource(R.drawable.color_green_peque);
            }else{
                if(graxaLaranxa){
                    img2.setImageResource(R.drawable.color_orange_peque);
                }else{
                    if(graxaRojo){
                        img2.setImageResource(R.drawable.color_red_peque);
                    }
                }
            }
            if(sodioVerde){
                img3.setImageResource(R.drawable.color_green_peque);
            }else{
                if(sodioLaranxa){
                    img3.setImageResource(R.drawable.color_orange_peque);
                }else{
                    if(sodioRojo){
                        img3.setImageResource(R.drawable.color_red_peque);
                    }
                }
            }
        }
        if(azucreVerde && graxaVerde && sodioVerde){
            imgres.setImageResource(R.drawable.color_green_grande);
        }else{
            if((azucreLaranxa && graxaLaranxa && sodioLaranxa)
                    ||(azucreVerde&&graxaVerde&&sodioLaranxa)||(azucreVerde&&graxaLaranxa&&sodioVerde)||(azucreLaranxa&&graxaVerde&&sodioVerde)
                    ||(azucreVerde&&graxaLaranxa&&sodioLaranxa)||(azucreLaranxa&&graxaLaranxa&&sodioVerde)||(azucreLaranxa&&graxaVerde&&sodioLaranxa)
                    ||(azucreVerde&&graxaVerde&&sodioRojo)||(azucreVerde&&graxaRojo&&sodioVerde)||(azucreRojo&&graxaVerde&&sodioVerde)){
                imgres.setImageResource(R.drawable.color_orange_grande);
            }else{
                if((azucreRojo && graxaRojo && sodioRojo)
                        ||(azucreVerde && graxaRojo && sodioRojo)||(azucreRojo && graxaVerde && sodioRojo)||(azucreRojo && graxaRojo && sodioVerde)
                        ||(azucreLaranxa&&graxaLaranxa&&sodioRojo)||(azucreLaranxa&&graxaRojo&&sodioLaranxa)||(azucreRojo&&graxaLaranxa&&sodioLaranxa)
                        ||(azucreLaranxa&&graxaRojo&&sodioRojo)||(azucreRojo&&graxaLaranxa&&sodioRojo)||(azucreRojo && graxaRojo && sodioLaranxa)
                        ||(azucreVerde && graxaLaranxa && sodioRojo)||(azucreLaranxa&&graxaRojo&&sodioVerde)||(azucreRojo&&graxaVerde&&sodioLaranxa)){
                    imgres.setImageResource(R.drawable.color_red_grande);
                }else{
                    imgres.setImageResource(R.drawable.color_orange_grande);
                }
            }
        }

        return fila;
    }
}
