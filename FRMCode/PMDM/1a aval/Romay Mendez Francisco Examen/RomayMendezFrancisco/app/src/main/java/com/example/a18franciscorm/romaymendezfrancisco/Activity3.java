package com.example.a18franciscorm.romaymendezfrancisco;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity3 extends AppCompatActivity {
    private final int PERMISO_LLAMADA=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }
    public void onClickChamada(View v){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
            String[] permisos = {Manifest.permission.CALL_PHONE};
            ActivityCompat.requestPermissions(this,permisos, PERMISO_LLAMADA);
        } else {
            Intent i= new Intent(Intent.ACTION_CALL,Uri.parse("tel:(+34)986110011"));
            startActivity(i);
        }
    }

    public void onClickBusqueda(View v){
        Intent i= new Intent(Intent.ACTION_VIEW, Uri.parse("https://ingemecanica.com/tutoriales/areas.html"));
        startActivity(i);
    }
    public void onClickSair(View v){
        setResult(RESULT_OK);
        finish();

    }
    public void onClickFin(View v){
        setResult(RESULT_CANCELED);
        finish();

    }
}
