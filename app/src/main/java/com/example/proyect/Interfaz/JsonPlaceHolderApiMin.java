package com.example.proyect.Interfaz;

import com.example.proyect.Model.Data;

import retrofit2.Call;
import retrofit2.http.GET;


public interface JsonPlaceHolderApiMin {

    @GET("v1/prices/min?zone=PCB")
    Call<Data> getPrecio();
    //Call <List<Data>> getPrecio();

}
