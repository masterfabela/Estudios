package com.example.a18franciscorm.romaymendezfrancisco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button butEmpezar;
    TextView mensajeBienvenida;
    private final int CODIGO=1;
    private final int CODIGO2=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butEmpezar=(Button)findViewById(R.id.butEmpezar);
        mensajeBienvenida= (TextView)findViewById(R.id.mensajeBienvenida);
        mensajeBienvenida.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent i= new Intent(MainActivity.this,Activity3.class);
                startActivityForResult(i,CODIGO);
                return false;
            }
        });
        butEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Activity2.class);
                Bundle b=new Bundle();
                i.putExtras(b);
                startActivityForResult(i,CODIGO2);
            }
        });
    }
    public void onClickEnd(View v){
        super.finish();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Salida",mensajeBienvenida.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mensajeBienvenida.setText(savedInstanceState.getString("Salida"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CODIGO){
            if(resultCode==RESULT_CANCELED){
                finish();
            }
        }
        if(requestCode==CODIGO2){
            Bundle b=data.getExtras();
            String forma=b.getString("Figura");
            String dato=b.getString("dato");
            double valor=b.getDouble("valor");
            mensajeBienvenida.setText(forma+"-"+dato+":\n"+valor);
        }

    }
}
