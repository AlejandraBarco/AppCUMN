package com.example.proyect;

import com.example.proyect.Model.Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface JsonPlaceHolderApi {

    @GET("v1/prices/now?zone=PCB")
    Call<Data> getPrecio();
    //Call <List<Data>> getPrecio();

}
