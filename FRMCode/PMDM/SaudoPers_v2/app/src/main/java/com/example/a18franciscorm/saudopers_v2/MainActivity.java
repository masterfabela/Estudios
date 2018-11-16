package com.example.a18franciscorm.saudopers_v2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int CODIGO_CHAMADA=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1=(Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etIdade=(EditText)findViewById(R.id.etIdade);
                EditText etNome=(EditText)findViewById(R.id.etNome);
                Bundle datos = new Bundle();
                Intent i= new Intent (MainActivity.this,Main2Activity.class);
                if (comprobaEdits(etIdade,etNome)){
                    Log.i("Cambios", "Chamouse á actividade");
                    datos.putString("nome",etNome.getText().toString());
                    datos.putInt("idade",Integer.parseInt(etIdade.getText().toString()));
                    i.putExtras(datos);
                    startActivityForResult(i,CODIGO_CHAMADA);}
            }
        });
    }
    public boolean comprobaEdits(EditText idade, EditText nome){
        if (idade.getText().toString().isEmpty() || nome.getText().toString().isEmpty()) {
            if (idade.getText().toString().isEmpty())
                idade.setHintTextColor(Color.RED);
            if (nome.getText().toString().isEmpty())
                nome.setHintTextColor(Color.RED);
            return false;
        }
        else return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CODIGO_CHAMADA){
            if (resultCode==RESULT_OK){
                Toast.makeText(this, data.getExtras().getString("Saudo"), Toast.LENGTH_LONG).show();
                Log.i("Cambios", "Rematou ben");}
            else{
                Log.i("Cambios", "Sen saudo");
            }
        }
    }
}
