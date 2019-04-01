package com.example.femio.bdsqlitebasica;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConsultaM extends AppCompatActivity {
    Button b1,b2;
    TextView t;
    DB db=new DB(this,"DBXogos",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_m);
        t=(TextView)findViewById(R.id.saidaTotal);
        b1=(Button)findViewById(R.id.listarCM);
        b2=(Button)findViewById(R.id.cancelarCM);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase operador=db.getWritableDatabase();
                Cursor c=operador.rawQuery("Select * from videoxogos;",null);
                String s="";
                if(c.moveToFirst()){
                    System.out.println(c.getCount());
                    do {
                        System.out.println("Codigo: " + c.getString(0).toString() + ", Nome: " + c.getString(1).toString());
                    }
                    while(c.moveToNext());
                    t.setText(s);
                }else{
                    System.out.println("Non hay nada.");
                }
                operador.close();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
