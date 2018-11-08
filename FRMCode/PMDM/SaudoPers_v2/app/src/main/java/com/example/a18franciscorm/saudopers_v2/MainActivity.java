package com.example.a18franciscorm.saudopers_v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1=(Button)findViewById(R.id.btn1);
        EditText etIdade=(EditText)findViewById(R.id.etIdade);
        EditText etNome=(EditText)findViewById(R.id.etNome);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent (MainActivity.this,Main2Activity.class);
            }
        });
    }
}
