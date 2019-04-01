package com.example.a18franciscorm.proxecto;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IMCActivity extends AppCompatActivity {
    Button b1;
    EditText et1,et2;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        b1=(Button)findViewById(R.id.calcularIMC);
        et1=(EditText)findViewById(R.id.entradaAlturaIMC);
        et2=(EditText)findViewById(R.id.entradaPesoIMC);
        tv1=(TextView)findViewById(R.id.resultadoIMC);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().isEmpty()||et2.getText().toString().isEmpty()){
                    Toast.makeText(IMCActivity.this,R.string.error,Toast.LENGTH_SHORT).show();
                }else{
                    float resultado = (Float.parseFloat(et2.getText().toString())/(Float.parseFloat(et1.getText().toString())*Float.parseFloat(et1.getText().toString())));
                    if(resultado<16f){
                        tv1.setText("Estado: Desnutrición Grave");
                    }else{
                        if(resultado<17f){
                            tv1.setText("Estado: Desnutrición Moderada");
                        }else{
                            if(resultado<19f){
                                tv1.setText("Estado:Desnutricion Leve");
                            }else{
                                if(resultado<25f){
                                    tv1.setText("Estado: Normapeso");
                                }else{
                                    if(resultado<30f){
                                        tv1.setText("Estado:Sobrepeso");
                                    }else{
                                        if(resultado<34.9f){
                                            tv1.setText("Estado:Sobrepeso Tipo 1");
                                        }else{
                                            if(resultado<39.9f) {
                                                tv1.setText("Estado: Sobrepeso Tipo 2");
                                            }else{
                                                tv1.setText("Estado: Obesidade Mórbida");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                et1.setText("");
                et2.setText("");
            }
        });
    }
}
