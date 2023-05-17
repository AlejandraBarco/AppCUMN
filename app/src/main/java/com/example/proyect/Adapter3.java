package com.example.proyect;

import android.content.Context;
        import android.content.Intent;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

        import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

        import java.util.List;

public class Adapter3 extends RecyclerView.Adapter<Adapter3.AppsHolder>  {


    List<Aplicacion> apps;


    public Adapter3(List<Aplicacion> apps) {
        this.apps = apps;
    }

    @NonNull
    @Override
    public Adapter3.AppsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler3,parent,false);
        Adapter3.AppsHolder holder = new Adapter3.AppsHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter3.AppsHolder holder, int position) {
        Aplicacion app = apps.get(position);
        holder.nombre.setText(app.getNombre());
        holder.cpu.setText(String.valueOf(app.getCpu())+" vatios");
        Context context = holder.itemView.getContext();
        ImageView imageView = holder.itemView.findViewById(R.id.imageView);

        ProgressBar progressBar = holder.itemView.findViewById(R.id.progress_bar);
        double cpuValue = app.getCpu();

        float progress = (float) (cpuValue / 14.07 * 100);

        progressBar.setProgress((int) progress);

        if (progress < 35.42554708599858) {
            progressBar.setProgressDrawable(ContextCompat.getDrawable(context, R.drawable.progress_bar_green));
            imageView.setImageResource(R.drawable.green);
        } else if (progress < 67.71277354655295) {
            progressBar.setProgressDrawable(ContextCompat.getDrawable(context, R.drawable.progress_bar_orange));
            imageView.setImageResource(R.drawable.orange);
        } else {
            progressBar.setProgressDrawable(ContextCompat.getDrawable(context, R.drawable.progress_bar_red));
            imageView.setImageResource(R.drawable.red);
        }

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
