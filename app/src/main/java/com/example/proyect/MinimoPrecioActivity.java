package com.example.proyect;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.example.proyect.Model.Data;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class MinimoPrecioActivity extends AppCompatActivity {

    private TextView mJsonTxtView,txt1,txt2,txt3,txt4,txt5,txt6;
    private TextView min;
    private ImageButton icon;
    private Button Ver;
    private FloatingActionButton plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minimo_precio);
        icon = findViewById(R.id.icon);
        plus = findViewById(R.id.plus);
        Ver = findViewById(R.id.button);
        mJsonTxtView = findViewById(R.id.jsonText);
        txt1 = findViewById(R.id.jsonText1);
        txt2 = findViewById(R.id.jsonText2);
        txt3 = findViewById(R.id.jsonText4);
        txt4 = findViewById(R.id.jsonText5);
        txt5 = findViewById(R.id.jsonText6);
        txt6 = findViewById(R.id.jsonText8);
        min = findViewById(R.id.textView2);
        this.getPrecio();

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MinimoPrecioActivity.this,UserActivity.class));
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MinimoPrecioActivity.this, agregarMedicion.class));
            }
        });
        Ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MinimoPrecioActivity.this, PruebaPrecios.class));
            }
        });

    }

    private void getPrecio(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.preciodelaluz.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApiMin jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApiMin.class);

        Call <Data> call = jsonPlaceHolderApi.getPrecio();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if(!response.isSuccessful()){
                    mJsonTxtView.setText("Codigo: "+response.code());
                    return;
                }

                Data data = response.body();

                String content = "";
                content += "A día de hoy " + data.getDate() + "\n";
                mJsonTxtView.append(content);

                String content1 = "";
                content1 += "En el rango de hora " + data.getHour() + "\n";
                txt1.append(content1);

                String content2 = "";
                if(data.isCheap())
                    content2 += "Está barato " + "\n";
                else
                    content2 += "Está caro " + "\n";
                txt2.append(content2);


                String content3 = "";
                if(!data.isUnderAvg())
                    content3 += "Está por encima de la media" + "\n";
                else
                    content3 += "Está por debajo de la media" + "\n";
                txt3.append(content3);

                String content4 = "";
                content4 += "Del mercado " + data.getMarket() + "\n";
                txt4.append(content4);

                String content5 = "";
                content5 += "Precio " + data.getPrice() + "\n";
                txt5.append(content5);

                String content6 = "";
                content6 += "Unidad " + data.getUnits() + "\n\n";
                txt6.append(content6);

                String contentMin ="";
                contentMin += String.valueOf(data.getPrice()) + " €" ;
                min.append(contentMin);


            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}