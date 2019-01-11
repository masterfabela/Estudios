package com.example.a18franciscorm.navegador_linearlayout;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private TextView lblmostrar;
    int angulo=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblmostrar = (TextView) findViewById(R.id.mostrar);
    }


    public void onClickSaudar(View v){

        lblmostrar.setText("Boaaaas");
        lblmostrar.setBackgroundColor(Color.CYAN);
        angulo=angulo+45;
        lblmostrar.setRotation(angulo);

    }
}
