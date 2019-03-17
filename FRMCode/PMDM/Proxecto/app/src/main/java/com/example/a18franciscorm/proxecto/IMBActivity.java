package com.example.a18franciscorm.proxecto;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class IMBActivity extends AppCompatActivity {
    Button b1;
    EditText et1,et2,et3;
    TextView tv1;
    Spinner sexo;
    float resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imb);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        b1=(Button)findViewById(R.id.calcularIMB);
        et1=(EditText)findViewById(R.id.entradaAlturaIMB);
        et2=(EditText)findViewById(R.id.entradaPesoIMB);
        et3=(EditText)findViewById(R.id.entradaIdade);
        tv1=(TextView)findViewById(R.id.resultadoIMB);
        sexo=(Spinner)findViewById(R.id.sexo);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().isEmpty()||et2.getText().toString().isEmpty()||et3.getText().toString().isEmpty()){
                    Toast.makeText(IMBActivity.this,R.string.error,Toast.LENGTH_SHORT).show();
                }else {
                    if(sexo.getSelectedItem().equals("Home")){
                        resultado = 65f+(9.6f*Float.parseFloat(et2.getText().toString()) * (1.7f * Float.parseFloat(et1.getText().toString()))-4.7f*Float.parseFloat(et3.getText().toString()));
                    }else{
                        resultado = 66f+(13.7f*Float.parseFloat(et2.getText().toString()) * (5f * Float.parseFloat(et1.getText().toString()))-6.8f*Float.parseFloat(et3.getText().toString()));
                    }


                    tv1.setText("O seu Metabolismo Basal é: "+resultado);
                }
                et1.setText("");
                et2.setText("");
                et3.setText("");
            }
        });
    }
}
