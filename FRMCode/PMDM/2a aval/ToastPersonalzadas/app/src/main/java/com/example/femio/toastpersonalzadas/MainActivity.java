package com.example.femio.toastpersonalzadas;

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
    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Isto e unha Toast por defecto.",Toast.LENGTH_SHORT).show();
            }
        });
        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t1=Toast.makeText(MainActivity.this,"isto e unha toast desprazada.",Toast.LENGTH_SHORT);
                t1.setGravity(Gravity.CENTER,0,0);
                t1.show();

            }
        });
        b3 = (Button) findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t1=new Toast(MainActivity.this);
                LayoutInflater inflador=getLayoutInflater();
                LinearLayout layout=(LinearLayout)findViewById(R.id.layout);
                View vista=inflador.inflate(R.layout.laout_toast,layout);
                TextView texto=(TextView)vista.findViewById(R.id.textoToast);
                ImageView imaxe=(ImageView)vista.findViewById(R.id.ImaxeToast);
                texto.setText("Toast Personalizada.");
                imaxe.setImageResource(R.mipmap.ic_launcher);
                t1.setDuration(Toast.LENGTH_SHORT);
                t1.setView(vista);
                t1.show();
            }
        });
    }
}