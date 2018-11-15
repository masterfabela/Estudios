package com.example.a18franciscorm.saudopers_v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private CheckBox cb1;
    private RadioGroup rg1;
    private LinearLayout LL1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        cb1=(CheckBox)findViewById(R.id.cb1);
        rg1=(RadioGroup)findViewById(R.id.rg1);
        final RadioButton rb1=(RadioButton)findViewById(R.id.rb1);
        final RadioButton rb2=(RadioButton)findViewById(R.id.rb2);
        LL1=(LinearLayout)findViewById(R.id.LL1);
        TextView textosaida =(TextView)findViewById(R.id.textosaida);
        final Bundle b1=getIntent().getExtras();
        Button botvol=(Button)findViewById(R.id.butvolv);
        if (b1.getInt("idade")>=18)
            textosaida.setText("Hola, "+b1.getString("nome")+",és maior de idade.");
        else
            textosaida.setText("Hola, "+b1.getString("nome")+",és menor de idade.");
        botvol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb1.isChecked()){
                    b1.putString("Saudo","Ata a vista");
                }
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
