package com.example.a18franciscorm.intentexp_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText texto= (EditText)findViewById(R.id.et1);
        final String auxiliar=texto.getText().toString();
        Button cambio =(Button)findViewById(R.id.btn1);
        cambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("Dato",auxiliar);
                startActivity(i);
            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclo_vida", "Se ejecuta el método onStart 1");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclo_vida", "Se ejecuta el método onStop 1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclo_vida", "Se ejecuta el método onResume 1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclo_vida", "Se ejecuta el método onDestroy 1");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclo_vida", "Se ejecuta el método onPause 1");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclo_vida", "Se ejecuta el método onPause 1");

    }
}
