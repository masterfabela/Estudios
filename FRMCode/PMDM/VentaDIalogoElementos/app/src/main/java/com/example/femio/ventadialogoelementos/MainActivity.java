package com.example.femio.ventadialogoelementos;

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
    final String[] colores={"Vermello","Verde","Azul","Amarelo"};
    private final static int MENSAXE_DIALOG=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog venta=onCreateDialog(MENSAXE_DIALOG);
                venta.show();
            }
        });
    }

//    @Override
//    protected Dialog onCreateDialog(int id) {
//        AlertDialog.Builder venta=new AlertDialog.Builder(MainActivity.this);
//        venta.setTitle("Alerta");
//        venta.setIcon(R.mipmap.ic_launcher);
//        venta.setItems(colores,new DialogInterface.OnClickListener(){
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this,"Eleccion: "+colores[which].toString(),Toast.LENGTH_SHORT).show();
//            }
//        });
//        return venta.create();
//    }
//@Override
//    protected Dialog onCreateDialog(int id) {
//        AlertDialog.Builder venta=new AlertDialog.Builder(MainActivity.this);
//        venta.setTitle("Alerta");
//        venta.setIcon(R.mipmap.ic_launcher);
//        venta.setSingleChoiceItems(colores,0,new DialogInterface.OnClickListener(){
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this,"Eleccion: "+colores[which].toString(),Toast.LENGTH_SHORT).show();
//            }
//        });
//        return venta.create();
//    }
@Override
protected Dialog onCreateDialog(int id) {
    AlertDialog.Builder venta=new AlertDialog.Builder(MainActivity.this);
    venta.setTitle("Alerta");
    venta.setIcon(R.mipmap.ic_launcher);
    venta.setMultiChoiceItems(colores,null,new DialogInterface.OnMultiChoiceClickListener(){
        @Override
        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
        }
    });
    return venta.create();
}

}
