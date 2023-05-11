package com.example.proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import com.example.proyect.Model.Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PruebaPrecios extends Activity {

    private TextView mJsonTxtView,txt1,txt2,txt3,txt4,txt5,txt6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_precios);
        mJsonTxtView = findViewById(R.id.jsonText);
        txt1 = findViewById(R.id.jsonText1);
        txt2 = findViewById(R.id.jsonText2);
        txt3 = findViewById(R.id.jsonText4);
        txt4 = findViewById(R.id.jsonText5);
        txt5 = findViewById(R.id.jsonText6);
        txt6 = findViewById(R.id.jsonText8);
        this.getPrecio();
    }

    private void getPrecio(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.preciodelaluz.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call <Data> call = jsonPlaceHolderApi.getPrecio();
        //Call<Data> call = json.getPrecioLuz();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if(!response.isSuccessful()){
                    mJsonTxtView.setText("Codigo: "+response.code());
                    return;
                }

                Data data = response.body();



                    String content = "";
                    content += "date: " + data.getDate() + "\n";
                    content += "hour: " + data.getHour() + "\n";
                    content += "isCheap: " + data.isCheap() + "\n";
                    content += "isUnderAvg: " + data.isUnderAvg() + "\n";
                    content += "market: " + data.getMarket() + "\n";
                    content += "price: " + data.getPrice() + "\n";
                    content += "units: " + data.getUnits() + "\n\n";
                    mJsonTxtView.append(content);

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}