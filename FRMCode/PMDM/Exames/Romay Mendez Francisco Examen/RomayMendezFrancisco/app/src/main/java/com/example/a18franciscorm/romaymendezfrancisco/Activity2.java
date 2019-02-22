package com.example.a18franciscorm.romaymendezfrancisco;

import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    Button bc;
    EditText e;
    RadioGroup rf;
    RadioGroup ro;
    RadioButton cuadrado;
    RadioButton circulo;
    RadioButton area;
    RadioButton perimetro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        bc=(Button)findViewById(R.id.botoncalculo);
        rf=(RadioGroup)findViewById(R.id.radiofigura);
        ro=(RadioGroup)findViewById(R.id.radiopcion);
        cuadrado=(RadioButton)findViewById(R.id.cuadrado);
        circulo=(RadioButton)findViewById(R.id.circulo);
        area=(RadioButton)findViewById(R.id.area);
        perimetro=(RadioButton)findViewById(R.id.perimetro);
        e=(EditText)findViewById(R.id.entrada);
    }
    public void onClickFuncionar(View v){
        if(bc.getText().equals("CONTINUAR")){
            bc.setText(R.string.mostrar);
            if(rf.getCheckedRadioButtonId()==R.id.cuadrado){
                e.setVisibility(View.VISIBLE);
                e.setHint("Lado");
            }else{
                e.setVisibility(View.VISIBLE);
                e.setHint("Radio");
            }
        }else{
            if(e.getText().toString().isEmpty()){
                Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
            }else{
                Intent i=new Intent();
                Bundle b=getIntent().getExtras();
                if(cuadrado.getId()==rf.getCheckedRadioButtonId()){
                    b.putString("Figura","Cuadrado");
                    if(area.getId()==ro.getCheckedRadioButtonId()){
                        b.putString("dato","Area");
                        double dato=Float.parseFloat(e.getText().toString());
                        b.putDouble("valor",(dato*dato)/2);
                    }else{
                        b.putString("dato","Perímetro");
                        double dato=Float.parseFloat(e.getText().toString());
                        b.putDouble("valor",dato*4);
                    }
                }else{
                    b.putString("Figura","Circulo");
                    if(area.getId()==ro.getCheckedRadioButtonId()){
                        b.putString("dato","Area");
                        double dato=Float.parseFloat(e.getText().toString());
                        b.putDouble("valor",(3.14*dato*dato));
                    }else{
                        b.putString("dato","Perímetro");
                        double dato=Float.parseFloat(e.getText().toString());
                        b.putDouble("valor",(2*dato*3.14));
                    }
                }
                System.out.println(b.getString("Figura"));
                setResult(RESULT_OK,i);
                i.putExtras(b);
                finish();
            }

        }

    }
}
