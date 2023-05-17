package com.example.proyect;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.AppsHolder>  {


    List<Aplicacion> apps;


    public Adapter2(List<Aplicacion> apps) {
        this.apps = apps;
    }

    @NonNull
    @Override
    public Adapter2.AppsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler2,parent,false);
        Adapter2.AppsHolder holder = new Adapter2.AppsHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter2.AppsHolder holder, int position) {
        Aplicacion app = apps.get(position);
        holder.nombre.setText(app.getNombre());
        holder.cpu.setText(String.valueOf(app.getCpu())+" vatios");
        holder.setOnClickListener(app.getKey());
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

    public static class AppsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        TextView nombre, cpu;
        Button button;


        public AppsHolder(View itemView){
            super(itemView);
            context = itemView.getContext();
            nombre = (TextView) itemView.findViewById(R.id.textview_nombre);
            cpu = (TextView) itemView.findViewById(R.id.textview_cpu);
            button = (Button) itemView.findViewById(R.id.button);

        }
        void setOnClickListener(final String appKey){

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, MeasuresActivitySingular.class);
                    intent.putExtra("AppKey", appKey);
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public void onClick(View view) {

        }
    }
}
