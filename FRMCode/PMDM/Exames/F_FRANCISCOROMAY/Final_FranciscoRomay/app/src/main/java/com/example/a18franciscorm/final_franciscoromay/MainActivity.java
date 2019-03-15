package com.example.a18franciscorm.final_franciscoromay;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp ;
    NotificationManager nm;
    Notification notificacion;
    private final int PERMISO_LLAMADA=0,NOTIFICACIONALERTAID=9;
    TextView tv;
    ImageView iv;
    LinearLayout ll1,ll2;
    DB db=new DB(this,"DBXogos",null,1);
    ArrayList<String> nomes=new ArrayList();
    ListView lv;
    private final int CODIGO=1;
    SharedPreferences.Editor e;
    Bundle b=new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        e=sp.edit();
        if(!sp.getBoolean("primeiravez",true)){
            Toast.makeText(this, "Acertos: "+String.valueOf(sp.getInt("acertos",0)), Toast.LENGTH_SHORT).show();
        }else{
            e.putBoolean("primeiravez",false);
            e.commit();
        }

        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textoBenvida);
        iv=(ImageView)findViewById(R.id.imaxePrincipal);
        registerForContextMenu(tv);
        registerForContextMenu(iv);
        ll1=(LinearLayout)findViewById(R.id.layoutBenvida);
        ll2=(LinearLayout)findViewById(R.id.layoutExecucion);
        lv=(ListView)findViewById(R.id.listaCompostos);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seleccion= nomes.get(position);
                Intent i=new Intent(MainActivity.this,Consulta.class);
                b.putString("seleccion",seleccion);
                i.putExtras(b);
                startActivityForResult(i,CODIGO);
            }
        });
    }
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucontextual, menu); }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubenvida, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.item1){
            AlertDialog.Builder ventana = new AlertDialog.Builder(this);
            ventana.setTitle(R.string.AcercaDe);
            ventana.setMessage(R.string.mensaxeAcercade);
            ventana.setIcon(R.drawable.flask);
            ventana.show();
        }if(item.getItemId()==R.id.item2){
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                String[] permisos = {Manifest.permission.CALL_PHONE};
                ActivityCompat.requestPermissions(this,permisos, PERMISO_LLAMADA);
            } else {
                Intent i= new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)986110011"));
                startActivity(i);
            }
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item3:
                ll1.setVisibility(View.GONE);
                ll2.setVisibility(View.VISIBLE);
                SQLiteDatabase operador=db.getReadableDatabase();
                Cursor c=operador.rawQuery("Select * from Compostos;",null);
                if(c.moveToFirst()){
                    do{
                        nomes.add(c.getString(0));
                        System.out.println(c.getString(0));
                    }while(c.moveToNext());
                    AdaptadorPersonalizado adaptador = new AdaptadorPersonalizado(this, nomes);
                    lv.setAdapter(adaptador);
                }else{
                    System.out.println("Base de datos vacia");
                }
                return true;
            case R.id.item4:
                finish();
                return true;
            default:
                return super.onContextItemSelected(item);     } }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==CODIGO){
            Bundle b1=data.getExtras();
            if(resultCode==RESULT_CANCELED){

                e.putInt("acertos",b1.getInt("acertos"));
                e.commit();
                finish();
            }else{

                if(b1.getInt("fallos",0)>2){
                    NotificationCompat.Builder ncBuilder= new NotificationCompat.Builder(this);
                    ncBuilder.setSmallIcon(R.mipmap.ic_launcher);
                    ncBuilder.setTicker("Aviso");
                    ncBuilder.setContentTitle("Multiples erros");
                    ncBuilder.setContentText("Vista a gran cantidade de erros, recomendamoslle que busque axuda especializada.");
                    ncBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.flask));
                    Intent is= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.formulacionquimica.com"));
                    PendingIntent pi=PendingIntent.getActivity(this,0,is,0);
                    ncBuilder.setContentIntent(pi);
                    nm=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                    notificacion= ncBuilder.build();
                    ncBuilder.setAutoCancel(true);
                    nm.notify(NOTIFICACIONALERTAID,notificacion);
                }else{
                    b.putInt("fallos",b1.getInt("fallos"));
                }
                System.out.println(b1.getInt("fallos"));
            }
        }

    }
}
