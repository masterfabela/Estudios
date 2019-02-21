package com.example.a18franciscorm.proxecto;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Integrar nunha bd 12 elementos da lista e realizar as consultas sobre el.
        //o monitor solo vai na 22, ata que execute o comando máxico.
        ClaseDB cdb= new ClaseDB(this,"BDAlimentos",null,1);
        SQLiteDatabase sqldb=cdb.getReadableDatabase();
        sqldb.execSQL("insert into Alimentos(codigo,nombre,tipo,azucares_simples,grasas_saturadas,sodio) values (03,'Arroz_con_leite','Lacteo','17','0.77','38')");
        sqldb.close();
        System.out.println("Insercion realizada");
    }
}
