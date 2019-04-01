package com.example.femio.bdsqlitebasica;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Insercion extends AppCompatActivity {
    Button b1,b2;
    EditText cod,nome;
    DB db=new DB(this,"DBXogos",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insercion);
        cod=(EditText)findViewById(R.id.entCodigoI);
        nome=(EditText)findViewById(R.id.entnomeI);
        b1=(Button)findViewById(R.id.butInserir);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cod.getText().toString().isEmpty()||nome.getText().toString().isEmpty()){
                    Toast.makeText(Insercion.this,"Faltan datos",Toast.LENGTH_SHORT).show();
                }else{
                    SQLiteDatabase operador=db.getWritableDatabase();
                    operador.execSQL("insert into videoxogos (codigo,nome) values('"+Integer.parseInt(cod.getText().toString())+"','"+nome.getText().toString()+"')");
                    operador.close();
                }
            }
        });
        b2=(Button)findViewById(R.id.cancelarI);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
