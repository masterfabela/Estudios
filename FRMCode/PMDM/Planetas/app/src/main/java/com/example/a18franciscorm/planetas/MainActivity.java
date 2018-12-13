package com.example.a18franciscorm.planetas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView salida;
    Spinner spiner;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        salida=(TextView)findViewById(R.id.salida);
        spiner =  (Spinner)findViewById(R.id.spinner);
        boton= (Button)findViewById(R.id.boton);
        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                salida.setText(String.valueOf(position+1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Ping");
                salida.setText(spiner.getSelectedItem().toString());
            }
        });

    }
}
