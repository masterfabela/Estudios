package com.example.a18franciscorm.notificacions;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    final int ALERTA_NOTIF=1;
    Button b;
    NotificationCompat.Builder ncb;
    NotificationManager nm;
    Notification n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationCompat.Builder ncb= new NotificationCompat.Builder(this);
        ncb.setSmallIcon(android.R.drawable.ic_dialog_alert);
        ncb.setTicker("Hi!!!");
        Bitmap icono= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        ncb.setLargeIcon(icono);
        ncb.setContentText("Isto e a proba de Notificacion");
        ncb.setContentTitle("Proba");
        PendingIntent pi= PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class),0);
        ncb.setContentIntent(pi);
        nm=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        n = ncb.build();
        b=(Button)findViewById(R.id.boton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nm.notify(ALERTA_NOTIF,n);
            }
        });
        //Buscar o metodo de cortar a notificacion.


    }
}
