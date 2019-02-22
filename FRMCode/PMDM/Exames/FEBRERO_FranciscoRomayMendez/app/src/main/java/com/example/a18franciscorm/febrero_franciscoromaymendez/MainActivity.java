package com.example.a18franciscorm.febrero_franciscoromaymendez;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.opengl.Visibility;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final static int MENSAXE_DIALOG=1;
    int eliminador,eliminado=0;
    Spinner s1,s2;
    Button b1,b2;
    ListView saida;
    EditText entrada;
    TextView textoCiclos;
    ArrayList<Alumno> alumnos;
    AdaptadorPersonalizado adaptadorLista;
    NotificationManager nm;
    Notification notificacion;
    private final static int NOTIFICACIONALERTAID=9;
        @Override
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder venta=new AlertDialog.Builder(MainActivity.this);
        venta.setTitle("Importante");
        venta.setIcon(android.R.drawable.ic_dialog_alert);
        venta.setPositiveButton("Eliminar",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                eliminar();
            }
        });
            venta.setNegativeButton("Cancelar",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
        return venta.create();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.eliminar:
                Dialog venta=onCreateDialog(MENSAXE_DIALOG);
                venta.show();

                break;
            case R.id.visualizar:
                Toast.makeText(MainActivity.this,"Funcionalidade por implementar",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflador=getMenuInflater();
        inflador.inflate(R.menu.menu,menu);
        menu.setHeaderTitle(alumnos.get(eliminador).getNome());
    }

    @Override
    protected void onDestroy() {
        NotificationCompat.Builder ncBuilder= new NotificationCompat.Builder(this);
        ncBuilder.setSmallIcon(R.mipmap.ic_launcher);
        ncBuilder.setTicker("Aviso");
        ncBuilder.setContentTitle("Notificacion de eliminacions");
        ncBuilder.setContentText("Eliminaronse "+eliminado+" elementos");
        ncBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        Intent i=new Intent();
        PendingIntent pi=PendingIntent.getActivity(this,0,i,0);
        ncBuilder.setContentIntent(pi);
        nm=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificacion= ncBuilder.build();
        ncBuilder.setAutoCancel(true);
        nm.notify(NOTIFICACIONALERTAID,notificacion);
        
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoCiclos=(TextView)findViewById(R.id.textoCiclos);
        textoCiclos.setVisibility(View.INVISIBLE);
        alumnos=new ArrayList();
        s1=(Spinner)findViewById(R.id.entradaCurso);
        s2=(Spinner)findViewById(R.id.entradaCiclo);
        s2.setEnabled(false);
        b1=(Button)findViewById(R.id.gardado);
        b2=(Button)findViewById(R.id.listado);
        b2.setEnabled(false);
        saida=(ListView)findViewById(R.id.listaItems);
        entrada=(EditText)findViewById(R.id.entradaNome);
        ArrayAdapter<CharSequence> adaptador=ArrayAdapter.createFromResource(this,R.array.Cursos,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adaptador2=ArrayAdapter.createFromResource(this,R.array.Ciclos,android.R.layout.simple_spinner_item);
        s1.setAdapter(adaptador);
        s2.setAdapter(adaptador2);
        s2.setVisibility(View.INVISIBLE);
        registerForContextMenu(saida);

        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getSelectedItem().toString().equals("Ciclos")){
                    s2.setVisibility(View.VISIBLE);
                    s2.setEnabled(true);
                    textoCiclos.setVisibility(View.VISIBLE);
                }else{
                    textoCiclos.setVisibility(View.INVISIBLE);
                    s2.setVisibility(View.INVISIBLE);
                    s2.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (s2.isEnabled()){
                    alumnos.add(new Alumno(entrada.getText().toString(),s1.getSelectedItem().toString(),s2.getSelectedItem().toString()));
                }else{
                    alumnos.add(new Alumno(entrada.getText().toString(),s1.getSelectedItem().toString(),""));
                }
                if(!alumnos.isEmpty()){
                    b2.setEnabled(true);}
                entrada.setText("");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adaptadorLista=new AdaptadorPersonalizado(MainActivity.this,alumnos);
                saida.setAdapter(adaptadorLista);
                entrada.setText("");
                b1.setEnabled(false);
                b2.setEnabled(false);
            }
        });
        saida.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                eliminador=position;
                if (alumnos.get(position).getCurso().toString().equals("Ciclos")){
                    Toast.makeText(MainActivity.this,"Alumno:"+alumnos.get(position).getNome()+"\nCurso:"+alumnos.get(position).getCurso()+"\nCiclo:"+alumnos.get(position).getCiclo(),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Alumno:"+alumnos.get(position).getNome()+"\nCurso:"+alumnos.get(position).getCurso(),Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    public void eliminar(){
        String auxiliarNome=alumnos.get(eliminador).getNome();
        alumnos.remove(eliminador);
        eliminado++;
        adaptadorLista=new AdaptadorPersonalizado(MainActivity.this,alumnos);
        saida.setAdapter(adaptadorLista);
        Toast.makeText(MainActivity.this,auxiliarNome+" eliminouse.",Toast.LENGTH_SHORT).show();
    }
}
