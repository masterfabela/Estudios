package com.example.a18franciscorm.tresactividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button b1=(Button)findViewById(R.id.buta3);
        TextView t1=(TextView)findViewById(R.id.texa3);
        t1.setText(getIntent().getExtras().getString("Mensaxe").toString());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent();
                Bundle b1=new Bundle();
                b1.putDouble("Volta",1.5);
                in.putExtras(b1);
                setResult(RESULT_OK,in);
                finish();
            }
        });
    }
}
