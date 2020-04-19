package com.sitiouno.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos){
        this.contactos = contactos;
        this.activity  = activity;
    }

    //Inflar el layout y lo pasara a viewholder para el obtenga los views
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);
        return new ContactoViewHolder(v);
    }

    //asocia cada elemento de las lista con cada view
    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int position) {

        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext() ,contacto.getNombre(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(),DetalleContacto.class);
                intent.putExtra("nombre",contacto.getNombre());
                intent.putExtra("telefono",contacto.getTelefono());
                intent.putExtra("email",contacto.getEmail());
                v.getContext().startActivity(intent);
            }
        });

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext() , "Diste like a " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {//Cantidad de elementos que contiene mi lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private ImageButton btnLike;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto       = (ImageView)itemView.findViewById(R.id.imgFoto);
            tvNombreCV    = (TextView) itemView.findViewById(R.id.tvNombre);
            tvTelefonoCV  = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            btnLike       = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
