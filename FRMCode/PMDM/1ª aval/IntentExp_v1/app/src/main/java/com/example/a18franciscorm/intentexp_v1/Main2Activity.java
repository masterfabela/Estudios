package com.example.a18franciscorm.intentexp_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView texto2=(TextView)findViewById(R.id.texto2);
        Intent i2=getIntent();
        texto2.setText(i2.getStringExtra("Dato"));
        Button cambio2 =(Button)findViewById(R.id.btn2);
        cambio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclo_vida", "Se ejecuta el método onStart 2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclo_vida", "Se ejecuta el método onStop 2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclo_vida", "Se ejecuta el método onResume 2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclo_vida", "Se ejecuta el método onDestroy 2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclo_vida", "Se ejecuta el método onPause 2");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclo_vida", "Se ejecuta el método onPause 2");

    }
}


