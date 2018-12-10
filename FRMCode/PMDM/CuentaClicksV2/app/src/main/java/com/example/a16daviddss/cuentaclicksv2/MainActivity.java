package com.example.a16daviddss.cuentaclicksv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private int clicks = 0;
    private String mensaxe=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
    }

    public void onClickS(View v) {
        tv.setText("");
        clicks++;
    }

    public void onClickF(View v) {
        if (clicks == 1) {
            mensaxe="Pulsaches " + clicks + " vez.";
            tv.setText(mensaxe);
        } else {
            mensaxe="Pulsaches " + clicks + " veces.";
            tv.setText(mensaxe);
        }
        clicks = 0;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Clicks",clicks);
        outState.putString("Mensaxe",mensaxe);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        clicks=savedInstanceState.getInt("Clicks");
        mensaxe=savedInstanceState.getString("Mensaxe");
        tv.setText(mensaxe);
    }
}
