package com.example.a18franciscorm.componentesbasicos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton tb1;
    private TextView tv1;
    private ImageButton ib1;
    private CheckBox chb1;
    private CheckBox chb2;
    private RadioGroup rg1;
    private RadioButton rbSi;
    private RadioButton rbno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1= (TextView) findViewById(R.id.tv1);
        tb1= (ToggleButton)findViewById(R.id.tb1);
        chb1=(CheckBox)findViewById(R.id.cboxPat);
        chb2=(CheckBox)findViewById(R.id.cboxKat);
        rg1=(RadioGroup)findViewById(R.id.rbGroup);
        rbSi=(RadioButton)findViewById(R.id.rbSi);
        rbno=(RadioButton)findViewById(R.id.rbNon);

        tb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tb1.isChecked()){
                    tv1.setText("Estado ON");
                }else
                    tv1.setText("Estado Off");
            }

        });
        /*
        //Se utilizamos un listener  en clase privada, non se necesita definir o onClick
        chb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });*/

    }
    public void onCclick(View v) {
        if(chb1.isChecked()&&chb2.isChecked()){
            tv1.setText("Ambos condimentos seleccionados");
        }else if(chb1.isChecked()){
            tv1.setText("Patatas select");
        }else if(chb2.isChecked()){
            tv1.setText("Katsup select");
        }else{
            tv1.setText("Sen condimentos");
        }
    }
    /*public void onClickRg(View v){
        if(rbSi.isChecked()){
            tv1.setText("Seleccionado SI");
        }else
            tv1.setText("Seleccionado No");
    }*/
    //ou tamén:
    public void onClickRg(View v){
        if(rg1.getCheckedRadioButtonId()==R.id.rbSi){
            tv1.setText("Seleccionado SI");
        }else if(rg1.getCheckedRadioButtonId()==R.id.rbNon)
            tv1.setText("Seleccionado Non");

    }
}
