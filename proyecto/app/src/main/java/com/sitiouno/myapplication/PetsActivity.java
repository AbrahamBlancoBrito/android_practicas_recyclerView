package com.sitiouno.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class PetsActivity extends AppCompatActivity {

    ArrayList<Contacto> favoritos;
    private RecyclerView listaFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        miActionBar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listaFav= (RecyclerView) findViewById(R.id.rvPets);

        //Lineal
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaFav.setLayoutManager(llm);

        inicializarListaContactos();
        inicializarAdaptador();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(favoritos);
        listaFav.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){
        favoritos = new ArrayList<Contacto>();

        favoritos.add(new Contacto(R.drawable.mike_9,"Mike", "", ""));
        favoritos.add(new Contacto(R.drawable.rocky_9,"Rocky", "", ""));
        favoritos.add(new Contacto(R.drawable.second_dog_9,"Pelusa", "", ""));
        favoritos.add(new Contacto(R.drawable.fifth_dog_9,"Neron", "", ""));
        favoritos.add(new Contacto(R.drawable.fifi_9,"Fifi", "", ""));
        //Toast.makeText(this, getResources().getString(R.string.oncreate), Toast.LENGTH_LONG).show();
    }

}
