package com.vedruna.ordunapenae01;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vedruna.ordunapenae01.Interfaces.CRUDInterface;
import com.vedruna.ordunapenae01.model.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFragment extends Fragment {

    List<Producto> listaProductos;
    CRUDInterface crudInterface;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAllProducts();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_api, container, false);
    }

    private void getAllProducts(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.153.1:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        crudInterface = retrofit.create(CRUDInterface.class);

        Call<List<Producto>> call = crudInterface.getAllProducts();
        call.enqueue(new Callback<List<Producto>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if (!response.isSuccessful()){
                    Log.e("Response err: ",response.message());
                    return;
                }
                listaProductos = response.body();
                listaProductos.forEach(p -> Log.i("Prods: ",p.toString()));
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Log.e("Throw err: ",t.getMessage());
            }
        });

    }
}