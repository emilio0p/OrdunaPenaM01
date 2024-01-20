package com.vedruna.ordunapenae01.Interfaces;

import com.vedruna.ordunapenae01.model.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CRUDInterface {

    @GET("api")
    Call<List<Producto>> getAllProducts();
}
