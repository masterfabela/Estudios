package com.example.a18franciscorm.saudopersonalizado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView saudo;
    private EditText nome;
    private Button accion;
    private RadioGroup rg1,rg2;
    private CheckBox despedida;
    private String mensaxe=null;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saudo=(TextView)findViewById(R.id.saudo);
        accion= (Button)findViewById(R.id.accion);
        nome= (EditText)findViewById(R.id.nome);
        rg1= (RadioGroup)findViewById(R.id.rg1);
        despedida=(CheckBox)findViewById(R.id.despedida);
        accion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nome.getText().toString().isEmpty()){
                    mensaxe="Introduza un nome";
                }else if(rg1.getCheckedRadioButtonId()==R.id.M) {
                    mensaxe = "Hola, " +"Señor "+ nome.getText()+".";
                }else
                    mensaxe = "Hola, " +"Señora "+ nome.getText()+".";
                if (!despedida.isChecked())
                    mensaxe+="\nAdeus.";
                saudo.setText(mensaxe);
            }
        });

    }

}
