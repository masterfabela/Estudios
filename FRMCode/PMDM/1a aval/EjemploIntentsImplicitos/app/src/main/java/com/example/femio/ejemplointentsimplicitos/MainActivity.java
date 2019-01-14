package com.example.femio.ejemplointentsimplicitos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5;
    private final int PERMISO_LLAMADA=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.but1);
        b2=(Button)findViewById(R.id.but2);
        b3=(Button)findViewById(R.id.but3);
        b4=(Button)findViewById(R.id.but4);
        b5=(Button)findViewById(R.id.but5);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW,ContactsContract.Contacts.CONTENT_URI);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                    String[] permisos = {Manifest.permission.CALL_PHONE};
                    ActivityCompat.requestPermissions(MainActivity.this,permisos, PERMISO_LLAMADA);
                } else {
                    Intent i= new Intent(Intent.ACTION_CALL,Uri.parse("tel:658587003"));
                    startActivity(i);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+34)658587003"));
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.steampowered.com"));
                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent();
                i.setClassName("com.android.settings","com.android.settings.Settings");
                startActivity(i);
            }
        });
    }
}
