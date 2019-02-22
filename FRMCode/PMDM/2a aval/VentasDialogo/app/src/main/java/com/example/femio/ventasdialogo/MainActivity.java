package com.example.femio.ventasdialogo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    public static final int DIALOGO_MENSAXE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.boton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog venta=onCreateDialog(DIALOGO_MENSAXE);
                showDialog(DIALOGO_MENSAXE);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder venta= new AlertDialog.Builder(MainActivity.this);
        venta.setTitle("Attention");
        venta.setMessage("This is not a drill");
        venta.setIcon(android.R.drawable.ic_dialog_alert);
        venta.setCancelable(false);
        venta.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Toast.makeText(MainActivity.this,"Benvido",Toast.LENGTH_SHORT).show();
            }
        });
        venta.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                finish();
            }
        });
        return venta.create();
    }
}
