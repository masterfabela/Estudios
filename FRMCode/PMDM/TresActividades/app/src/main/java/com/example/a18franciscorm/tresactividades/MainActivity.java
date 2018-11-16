package com.example.a18franciscorm.tresactividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int CODIGO_ACT2=2;
    private final int CODIGO_ACT3=3;
    Double valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button but1=(Button)findViewById(R.id.but1);
        Button but2=(Button)findViewById(R.id.but2);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this,Main2Activity.class);
                Bundle b1=new Bundle();
                b1.putString("Mensaxe","Saudos, Act2.");
                i1.putExtras(b1);
                startActivityForResult(i1,CODIGO_ACT2);
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(MainActivity.this,Main3Activity.class);
                Bundle b2=new Bundle();
                b2.putString("Mensaxe","Boas, Act3.");
                i2.putExtras(b2);
                startActivityForResult(i2,CODIGO_ACT3);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CODIGO_ACT2) {
            Toast.makeText(this, "A actividade 2 retornou: " + data.getExtras().getInt("Volta"), Toast.LENGTH_SHORT).show();
        }
        if (requestCode==CODIGO_ACT3) {
            valor = data.getExtras().getDouble("Volta");
            Toast.makeText(this, "A actividade 3 retornou: " + valor.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
