package com.example.a18franciscorm.navegador_relativelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mostrar = (TextView) findViewById(R.id.mostrar);
    }
    public void onClickbtn(View v){
        if(v.getId() == R.id.botsi){
            mostrar.setText("Si");
        }else if(v.getId() == R.id.botnon){
            mostrar.setText("Non");
        }else if(v.getId() == R.id.botveces){
            mostrar.setText("Aveces");
        }
        }

    }

