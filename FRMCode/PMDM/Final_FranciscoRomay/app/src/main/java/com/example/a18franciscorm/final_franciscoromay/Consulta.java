package com.example.a18franciscorm.final_franciscoromay;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Consulta extends AppCompatActivity {
    DB db=new DB(this,"DBXogos",null,1);
    LinearLayout ls,le;
    EditText et;
    Button b1;
    String formula;
    RadioGroup rg;
    RadioButton rb1,rb2;
    Button bc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        et=(EditText)findViewById(R.id.entradaFormula);
        ls=(LinearLayout)findViewById(R.id.layoutSaida);
        le=(LinearLayout)findViewById(R.id.layoutEntrada);
        b1=(Button)findViewById(R.id.butComprobar);
        rg=(RadioGroup)findViewById(R.id.rg);
        rb1=(RadioButton)findViewById(R.id.rbSi);
        rb2=(RadioButton)findViewById(R.id.rbNo);
        bc=(Button)findViewById(R.id.botonContinuar);
        final Bundle b=getIntent().getExtras();
        final String codigo=b.getString("seleccion");
        et.setHint(codigo);
        Intent i=new Intent();
        final Bundle b2=getIntent().getExtras();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et.getText().toString().isEmpty()){
                    Toast.makeText(Consulta.this,R.string.faltandatos,Toast.LENGTH_SHORT).show();
                }else{
                    SQLiteDatabase operador=db.getReadableDatabase();
                    Cursor c = operador.rawQuery("select formula from Compostos where nome='"+codigo+"';",null);
                    if(c.moveToFirst()){
                        formula=c.getString(0).toString();
                        ls.setVisibility(View.VISIBLE);
                        le.setVisibility(View.GONE);
                    }
                    if(et.getText().toString().equalsIgnoreCase(formula)){
                        Toast.makeText(Consulta.this,R.string.acerto,Toast.LENGTH_SHORT).show();
                        b2.putInt("acertos",b.getInt("acertos")+1);
                    }else{
                        Toast.makeText(Consulta.this,R.string.fallo,Toast.LENGTH_SHORT).show();
                        b2.putInt("fallos",b.getInt("fallos")+1);
                    }
                }

            }
        });
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rg.getCheckedRadioButtonId()==rb1.getId()){
                    Intent i=new Intent();
                    setResult(RESULT_OK,i);
                    i.putExtras(b2);
                    finish();
                }else{
                    Intent i=new Intent();
                    setResult(RESULT_CANCELED,i);
                    i.putExtras(b2);
                    finish();
                }
            }
        });


    }
}
