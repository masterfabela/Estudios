package com.example.a18franciscorm.toastpersonalizadas;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but1,but2,but3;
        but1=(Button)findViewById(R.id.but1);
        but2=(Button)findViewById(R.id.but2);
        but3=(Button)findViewById(R.id.but3);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Hola",Toast.LENGTH_LONG).show();
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t1=Toast.makeText(MainActivity.this,"Hola",Toast.LENGTH_LONG);
                t1.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.TOP,0,150);
                t1.show();
            }
        });
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflador=getLayoutInflater();
                LinearLayout llToast=(LinearLayout)findViewById(R.id.layout);
                View vista=inflador.inflate(R.layout.omeutoast,llToast);
                TextView texto=(TextView)vista.findViewById(R.id.texto);
                texto.setGravity(Gravity.CENTER);
                texto.setText("Boas");
                Toast t2=new Toast(MainActivity.this);
                t2.setDuration(Toast.LENGTH_SHORT);
                t2.setView(vista);
                t2.show();
            }
        });
    }
}
