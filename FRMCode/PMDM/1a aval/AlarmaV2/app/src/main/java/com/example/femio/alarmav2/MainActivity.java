package com.example.femio.alarmav2;

import android.content.Intent;
import android.os.Build;
import android.provider.AlarmClock;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    TextView texto;
    TimePicker tp;
    DatePicker dp;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto=(TextView)findViewById(R.id.texto);
        tp=(TimePicker)findViewById(R.id.timep);
        dp=(DatePicker)findViewById(R.id.datep);
        b=(Button)findViewById(R.id.boton);
        b.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                texto.setText(String.valueOf(dp.getDayOfMonth())+"/"+String.valueOf(dp.getMonth()+1)+"/"+String.valueOf(dp.getYear()));
                Intent i=new Intent(AlarmClock.ACTION_SET_ALARM);
                i.putExtra(AlarmClock.EXTRA_MESSAGE,"Arriiiiiba");
                i.putExtra(AlarmClock.EXTRA_HOUR,tp.getHour());
                i.putExtra(AlarmClock.EXTRA_MINUTES,tp.getMinute());
                if(i.resolveActivity(getPackageManager())!=null){
                    startActivity(i);
                }
            }
        });
    }
}
