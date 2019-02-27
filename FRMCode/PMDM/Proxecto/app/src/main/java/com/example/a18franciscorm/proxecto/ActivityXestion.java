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
                sqldb.execSQL("insert into Alimentos(codigo,nombre,tipo,azucares,grasas,sodio) values (1,'Arroz_con_leite','Lacteo','17','0.77','38')");
                sqldb.execSQL("insert into Alimentos(codigo,nombre,tipo,azucares,grasas,sodio) values (2,'Ovo_de_galiña','Ovo','0','3.1','140')");
                sqldb.execSQL("insert into Alimentos(codigo,nombre,tipo,azucares,grasas,sodio) values (3,'Tofu','Sementes_F.Secos','0.3','0.8','7')");
                sqldb.execSQL("insert into Alimentos(codigo,nombre,tipo,azucares,grasas,sodio) values (4,'Café_soluble','Bebida','6.5','0','41')");
                sqldb.execSQL("insert into Alimentos(codigo,nombre,tipo,azucares,grasas,sodio) values (5,'Fresas','Froita','4.8','0.03','2')");
                sqldb.execSQL("insert into Alimentos(codigo,nombre,tipo,azucares,grasas,sodio) values (6,'Grelo','Verduras','0.1','0.05','10')");
                sqldb.execSQL("insert into Alimentos(codigo,nombre,tipo,azucares,grasas,sodio) values (7,'Churros','Cereais_e_derivados','29','2.62','2')");
                sqldb.execSQL("insert into Alimentos(codigo,nombre,tipo,azucares,grasas,sodio) values (8,'Améndoas_cruas','Sementes_F.Secos','4.35','4.32','6')");
                sqldb.execSQL("insert into Alimentos(codigo,nombre,tipo,azucares,grasas,sodio) values (9,'Piñón','Sementes_F.Secos','3.6','9.88','1')");
                sqldb.execSQL("insert into Alimentos(codigo,nombre,tipo,azucares,grasas,sodio) values (10,'Kiwi','Froita','8.6','0.1','4')");
                sqldb.execSQL("insert into Alimentos(codigo,nombre,tipo,azucares,grasas,sodio) values (11,'Champiñons','Verduras','0.54','0.07','7.9')");
                sqldb.execSQL("insert into Alimentos(codigo,nombre,tipo,azucares,grasas,sodio) values (12,'Kefir','Lacteo','4.8','2.3','46')");
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



                sqldb.close();
                System.out.println("Insercion realizada");}
                catch(SQLiteConstraintException sqlce){
                    System.out.println("Erro na inserción dos datos: "+sqlce.getMessage());
                }
            }
        });
    }
}
