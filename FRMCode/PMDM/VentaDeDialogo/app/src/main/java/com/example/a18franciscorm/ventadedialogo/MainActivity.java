package com.example.a18franciscorm.ventadedialogo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.boton1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ventana=new AlertDialog.Builder(MainActivity.this);
                ventana.setTitle("Attention");
                ventana.setMessage("All vessels must fire inmediately.");
                ventana.setIcon(android.R.drawable.ic_dialog_alert);
                ventana.show();
            }
        });
        b2=(Button)findViewById(R.id.boton2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ventana2=new AlertDialog.Builder(MainActivity.this);
                ventana2.setTitle("Attention");
                ventana2.setMessage("All vessels must fire inmediately.");
                ventana2.setIcon(android.R.drawable.ic_dialog_alert);
                ventana2.setCancelable(false);
                ventana2.setPositiveButton("On its way!!!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                ventana2.show();
            }
        });
        b3=(Button)findViewById(R.id.boton3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ventana2=new AlertDialog.Builder(MainActivity.this);
                ventana2.setTitle("Attention");
                ventana2.setMessage("Shut your mouth and fire back.");
                ventana2.setIcon(android.R.drawable.ic_dialog_alert);
                ventana2.setCancelable(false);
                ventana2.setPositiveButton("On its way!!!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Toast.makeText(MainActivity.this,"Thats the right attitude!", Toast.LENGTH_SHORT).show();
                    }
                });
                ventana2.setNegativeButton("No way!!!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Toast.makeText(MainActivity.this,"What???", Toast.LENGTH_SHORT).show();
                    }
                });
                ventana2.setNeutralButton("I dont give a fuck!,I´m out", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Toast.makeText(MainActivity.this,"Get in here inmediately!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                ventana2.show();
            }
        });

    }
}
