package com.example.proyect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AppsHolder> {

    List<Aplicacion> apps;

    public Adapter(List<Aplicacion> apps) {
        this.apps = apps;
    }

    @NonNull
    @Override
    public AppsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler,parent,false);
        AppsHolder holder = new AppsHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AppsHolder holder, int position) {
        Aplicacion app = apps.get(position);
        holder.nombre.setText(app.getNombre());
        holder.elemento.setText(app.getElemento());
        holder.herramienta.setText(app.getHerramienta());
        holder.medida.setText(app.getMedida());
        holder.tamaño.setText(app.getTamaño());
        holder.codelines.setText(String.valueOf(app.getCodelines()));
        holder.funciones.setText(String.valueOf(app.getCodelines()));
        holder.metodos.setText(String.valueOf(app.getCodelines()));
        holder.clases.setText(String.valueOf(app.getCodelines()));
        holder.codesmells.setText(String.valueOf(app.getCodelines()));
        holder.concretas.setText(String.valueOf(app.getCodelines()));
        holder.abstractas.setText(String.valueOf(app.getCodelines()));
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

    public static class AppsHolder extends RecyclerView.ViewHolder{

        TextView nombre,elemento,herramienta,medida,tamaño,codelines,funciones,
                metodos,clases,codesmells,concretas,abstractas;


        public AppsHolder(View itemView){
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.textview_nombre);
            elemento = (TextView) itemView.findViewById(R.id.textview_elemento);
            herramienta = (TextView) itemView.findViewById(R.id.textview_herramienta);
            medida = (TextView) itemView.findViewById(R.id.textview_medida);
            tamaño = (TextView) itemView.findViewById(R.id.textview_tamaño);
            codelines = (TextView) itemView.findViewById(R.id.textview_codelines);
            funciones = (TextView) itemView.findViewById(R.id.textview_funciones);
            metodos = (TextView) itemView.findViewById(R.id.metodos);
            clases = (TextView) itemView.findViewById(R.id.textview_clases);
            codesmells = (TextView) itemView.findViewById(R.id.textview_codesmells);
            concretas = (TextView) itemView.findViewById(R.id.textview_concretas);
            abstractas = (TextView) itemView.findViewById(R.id.textview_abstractas);

        }
    }
}
