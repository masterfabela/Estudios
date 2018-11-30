package com.example.a18franciscorm.gardar_saudo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText entrada;
    TextView saida;
    Button boton;
    String cofre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrada=(EditText)findViewById(R.id.textoentrada);
        saida=(TextView)findViewById(R.id.textosaida);
        boton=(Button)findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cofre=entrada.getText().toString();
                saida.setText("Hola, "+cofre);
            }
        });
//        if(savedInstanceState!=null){
//            saida.setText("Hola, "+savedInstanceState.getString("texto"));
//        }
    }

    @Override
    protected void onSaveInstanceState(Bundle cofreagardar) {
        super.onSaveInstanceState(cofreagardar);
        cofreagardar.putString("texto",cofre);
    }
//Primeira forma:
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        saida.setText("Hola, "+savedInstanceState.getString("texto"));
    }
}
