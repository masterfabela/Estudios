package com.example.a14damianld.ciclo_de_vida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFinalizar = (Button)findViewById(R.id.btn_finalizar);
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Se pulso el botón de finalizar", Toast.LENGTH_LONG).show();
                Log.i("ciclo_vida", "Se pulso el botón de finalizar");
                finish();

            }
        });

        Toast.makeText(this, "Se ejecuta el método onCreate", Toast.LENGTH_LONG).show();
        Log.i("ciclo_vida", "Se ejecuta el método onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Se ejecuta el método onStart", Toast.LENGTH_LONG).show();
        Log.i("ciclo_vida", "Se ejecuta el método onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Se ejecuta el método onStop", Toast.LENGTH_LONG).show();
        Log.i("ciclo_vida", "Se ejecuta el método onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Se ejecuta el método onResume", Toast.LENGTH_LONG).show();
        Log.i("ciclo_vida", "Se ejecuta el método onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Se ejecuta el método onDestroy", Toast.LENGTH_LONG).show();
        Log.i("ciclo_vida", "Se ejecuta el método onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Se ejecuta el método onPause", Toast.LENGTH_LONG).show();
        Log.i("ciclo_vida", "Se ejecuta el método onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Se ejecuta el método onRestart", Toast.LENGTH_LONG).show();
    }
}

