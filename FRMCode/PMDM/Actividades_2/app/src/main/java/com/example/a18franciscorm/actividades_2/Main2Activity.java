package com.example.a18franciscorm.actividades_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i2=getIntent();
        String mensaxeRec = i2.getStringExtra("mensaxe");
        TextView texMensaxe=(TextView)findViewById(R.id.texMensaxe);
        texMensaxe.setText(mensaxeRec);
        Button botonVolver=(Button)findViewById(R.id.butvolver);
        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaxeRetorno="Foi falar";
                Intent i=new Intent();
                i.putExtra("Mensaxe",mensaxeRetorno);
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}
