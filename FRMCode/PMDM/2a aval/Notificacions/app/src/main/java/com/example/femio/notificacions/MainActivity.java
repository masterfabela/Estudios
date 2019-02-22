package com.example.femio.notificacions;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1;
    NotificationManager nm;
    Notification notificacion;
    private final static int NOTIFICACIONALERTAID=9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.boton);
        NotificationCompat.Builder ncBuilder= new NotificationCompat.Builder(this);
        ncBuilder.setSmallIcon(R.mipmap.ic_launcher);
        ncBuilder.setTicker("Alerta");
        ncBuilder.setContentTitle("Notificacion de proba");
        ncBuilder.setContentText("texto proba");
        ncBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.gato));
        Intent i=new Intent(this,MainActivity.class);
        PendingIntent pi=PendingIntent.getActivity(this,0,i,0);
        ncBuilder.setContentIntent(pi);
        nm=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificacion= ncBuilder.build();
        ncBuilder.setAutoCancel(true);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nm.notify(NOTIFICACIONALERTAID,notificacion);
            }
        });
    }
}
