package com.example.a18franciscorm.saudopers_v2;

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

        TextView textosaida =(TextView)findViewById(R.id.textosaida);
        Bundle b1=getIntent().getExtras();
        Button botvol=(Button)findViewById(R.id.butvolv);
        botvol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3= new Intent(Main2Activity.this,MainActivity.class);
                startActivity(i3);
            }
        });
        if (b1.getInt("idade")>=18)
            textosaida.setText("Hola, "+b1.getString("nome")+",és maior de idade.");
        else
            textosaida.setText("Hola, "+b1.getString("nome")+",és menor de idade.");
    }
}
