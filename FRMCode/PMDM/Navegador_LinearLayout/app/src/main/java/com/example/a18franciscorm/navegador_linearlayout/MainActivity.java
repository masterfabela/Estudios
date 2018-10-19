package com.example.a18franciscorm.navegador_linearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private TextView lblmostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblmostrar = (TextView) findViewById(R.id.texMostrar);
    }


    public void onClickSi(View v){
        lblmostrar.setText("Clicaches en Si.");
    }
}
