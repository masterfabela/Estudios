package com.example.a18franciscorm.tresactividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button b1=(Button)findViewById(R.id.buta1);
        TextView t1=(TextView)findViewById(R.id.texa1);
        t1.setText(getIntent().getExtras().getString("Mensaxe").toString());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent();
                Bundle b1=new Bundle();
                b1.putInt("Volta",1024);
                in.putExtras(b1);
                setResult(RESULT_OK,in);
                finish();
            }
        });
    }
}
