package com.example.a18franciscorm.act_calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton=(Button)findViewById(R.id.Boton);
        Button boton2=(Button)findViewById(R.id.Boton2);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setClassName("com.android.calculator2","com.android.calculator2.Calculator");
                startActivity(i);
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setClassName("com.android.settings","com.android.settings.Settings");
                startActivity(i);
            }
        });
        Button boton3=(Button)findViewById(R.id.Boton3);
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setClassName("com.android.camera","com.android.camera.Camera");
                startActivity(i);
            }
        });
    }
}
