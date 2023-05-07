package com.example.proyect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.AppsHolder> {

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
        holder.cpu.setText(String.valueOf(app.getCpu()));
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

    public static class AppsHolder extends RecyclerView.ViewHolder{

        TextView nombre, cpu;


        public AppsHolder(View itemView){
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.textview_nombre);
            cpu = (TextView) itemView.findViewById(R.id.textview_cpu);

        }
    }
}
