package com.sitiouno.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //******* Setea Toolbar ****************************//
        Toolbar miActionBar = findViewById(R.id.miActionBar);
        miActionBar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        setSupportActionBar(miActionBar);
        //**************************************************//

        //******* Setea los Perros del Activity Main ********//
        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        //Lineal
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);

        inicializarListaContactos();
        inicializarAdaptador();
        //***************************************************//

        //************* Boton de Toolbar *******************//
        ImageButton imgPrefers = (ImageButton)findViewById(R.id.btnToPrefers);

        imgPrefers.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {
                Toast.makeText(MainActivity.this, "Action clicked", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this,PetsActivity.class);
                startActivity(intent);
            }
        });
        //**************************************************//
    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.fifth_dog_9,"Neron", "", ""));
        contactos.add(new Contacto(R.drawable.second_dog_9,"Pelusa", "", ""));
        contactos.add(new Contacto(R.drawable.fifi_9,"Fifi", "", ""));
        contactos.add(new Contacto(R.drawable.rocky_9,"Rocky", "", ""));
        contactos.add(new Contacto(R.drawable.mike_9,"Mike", "", ""));
        //Toast.makeText(this, getResources().getString(R.string.oncreate), Toast.LENGTH_LONG).show();
    }



    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(this, getResources().getString(R.string.onstart), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(this, getResources().getString(R.string.onresume), Toast.LENGTH_LONG).show();
    }
    
    //Corriendo

    @Override
    protected void onRestart() {
        super.onRestart();
        //Toast.makeText(this, getResources().getString(R.string.onrestart), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(this, getResources().getString(R.string.onpause), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(this, getResources().getString(R.string.onstop), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this, getResources().getString(R.string.ondestroy), Toast.LENGTH_LONG).show();
    }

}
