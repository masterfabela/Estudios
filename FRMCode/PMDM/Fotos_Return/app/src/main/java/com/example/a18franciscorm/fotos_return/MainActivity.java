package com.example.a18franciscorm.fotos_return;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
//Abrir unha activity implicita e que retorne a foto a un imageview,
    Button boton;
    ImageView visor;
    int CODIGO_IMAXE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton=(Button)findViewById(R.id.but);
        visor=(ImageView)findViewById(R.id.visor);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,CODIGO_IMAXE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK){
            Bundle paquete=data.getExtras();
            Bitmap imaxe=(Bitmap)paquete.get("data");
            visor.setImageBitmap(imaxe);
        }
    }
}
