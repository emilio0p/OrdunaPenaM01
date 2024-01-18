package com.vedruna.ordunapenae01;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CounterFragment extends Fragment {

    private int contadorValue = 0;

    private TextView numeroContador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counter, container, false);

        numeroContador = view.findViewById(R.id.numeroContador);
        Button buttonSumar = view.findViewById(R.id.button2);
        Button buttonReset = view.findViewById(R.id.button7);
        Button buttonRestar = view.findViewById(R.id.button8);


        buttonSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumar();
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        buttonRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restar();
            }
        });

        return view;
    }

    private void sumar() {
        contadorValue++;
        actualizarNumero();
    }

    private void restar() {

            contadorValue--;
            actualizarNumero();

    }

    private void reset() {
        contadorValue = 0;
        actualizarNumero();
    }
    private void actualizarNumero() {
        numeroContador.setText(String.valueOf(contadorValue));
    }
}