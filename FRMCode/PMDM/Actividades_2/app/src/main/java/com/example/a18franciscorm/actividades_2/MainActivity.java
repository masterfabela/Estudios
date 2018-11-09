package com.example.a18franciscorm.actividades_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final int CODIGO_LLAMADA=0;
    private TextView texto2;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            if (requestCode==CODIGO_LLAMADA){
                texto2.setText(data.getStringExtra("Mensaxe"));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button botonLanzar =(Button)findViewById(R.id.butlanzar);
        botonLanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto2=(TextView)findViewById(R.id.texto2);
                String mensaxe="Tonto el que lo lea.";
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("mensaxe",mensaxe);
                startActivityForResult(i,CODIGO_LLAMADA);
            }
        });

    }
}
