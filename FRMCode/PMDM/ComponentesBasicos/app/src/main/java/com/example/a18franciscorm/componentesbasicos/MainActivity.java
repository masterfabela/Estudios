package com.example.a18franciscorm.componentesbasicos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rg1;
    private RadioButton rb1,rb2;
    private EditText valor;
    private Button cambiar;
    private TextView mostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg1=(RadioGroup) findViewById(R.id.rg1);
        valor=(EditText)findViewById(R.id.valor);
        cambiar=(Button) findViewById(R.id.cambiar);
        mostrar=(TextView) findViewById(R.id.mostrar);
        cambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!valor.getText().toString().isEmpty()) {
                    if (rg1.getCheckedRadioButtonId() == R.id.rb1) {
                        mostrar.setText(String.valueOf(Float.parseFloat(valor.getText().toString()) / 166.386));
                    } else {
                        mostrar.setText(String.valueOf(String.valueOf(Float.parseFloat(valor.getText().toString()) * 166.386)));
                    }
                }else{
                    mostrar.setText("Introduce un dato válido");
                }
            }
        });


    }
}
