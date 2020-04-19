package com.sitiouno.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.appcompat.widget.Toolbar;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    //Instancio los objetos de las vista que voy a utilizar para setear los valores que voy a mostrar
    TextView tvNombre;
    TextView tvTelefono;
    TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        miActionBar.setTitleTextColor(getResources().getColor(R.color.colorWhite));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Obtengo los extras que se colocar en el MainActivity
        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));

        //Instancio los objetos de las vista que voy a utilizar para setear los valores que voy a mostrar
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);

        //En los objetos instanciados les busco el metodo Set de la variable que voy a modificar y le paso valor que va a mostrar
        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
    }

    public void llamar(View v) {

        String telefono = tvTelefono.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("Tel:" + telefono)));

    }

    public void enviarMail (View v){

     String email = tvEmail.getText().toString();
     Intent emailIntent = new Intent((Intent.ACTION_SEND));

     emailIntent.setData(Uri.parse("mailto:"));
     emailIntent.putExtra(Intent.EXTRA_EMAIL,email);
     emailIntent.setType("message/rfc822");

     startActivity(Intent.createChooser(emailIntent,"Email "));

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

}
