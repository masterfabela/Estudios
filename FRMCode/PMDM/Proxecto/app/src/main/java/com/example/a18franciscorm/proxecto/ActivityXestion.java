package com.example.a18franciscorm.proxecto;

import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityXestion extends AppCompatActivity {
    Button b1,b2;
    SQLiteDatabase sqldb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xestion);
        b1=(Button)findViewById(R.id.purgar);
        b2=(Button)findViewById(R.id.engadir);
        //Integrar nunha bd 12 elementos da lista e realizar as consultas sobre el.
        //o monitor solo vai na 22, ata que execute o comando máxico.


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClaseDB cdb= new ClaseDB(ActivityXestion.this,"BDAlimentos",null,1);
                sqldb=cdb.getReadableDatabase();
                sqldb.execSQL("DROP TABLE Alimentos;");
                sqldb.execSQL("CREATE TABLE Alimentos (codigo INTEGER PRIMARY KEY, nombre TEXT, tipo TEXT,azucares TEXT, grasas TEXT, sodio TEXT);");
                sqldb.close();
                System.out.println("Purga realizada");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                ClaseDB cdb= new ClaseDB(ActivityXestion.this,"BDAlimentos",null,1);
                sqldb=cdb.getWritableDatabase();
                sqldb.execSQL("insert into Alimentos(codigo,nombre,tipo,azucares,grasas,sodio) values (03,'Arroz_con_leite','Lacteo','17','0.77','38')");
                sqldb.close();
                System.out.println("Insercion realizada");}
                catch(SQLiteConstraintException sqlce){
                    System.out.println("Erro na inserción dos datos: "+sqlce.getMessage());
                }
            }
        });
    }
}
