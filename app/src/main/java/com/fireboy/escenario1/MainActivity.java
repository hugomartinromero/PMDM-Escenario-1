package com.fireboy.escenario1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgOpciones;
    Spinner spInfo;
    ArrayList<String> opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgOpciones = findViewById(R.id.rgOpciones);
        spInfo = findViewById(R.id.spInfo);

        actualizarInfo(rgOpciones.getCheckedRadioButtonId());

        rgOpciones.setOnCheckedChangeListener((radioGroup, i) -> actualizarInfo(i));
    }

    private void actualizarInfo(int tipo) {
        opciones = new ArrayList<>();

        if (tipo == R.id.rbCiudades) {
            opciones.add(getString(R.string.sevilla));
            opciones.add(getString(R.string.huelva));
            opciones.add(getString(R.string.cadiz));
        }

        if (tipo == R.id.rbFrutas) {
            opciones.add(getString(R.string.manzana));
            opciones.add(getString(R.string.naranja));
            opciones.add(getString(R.string.pinia));
        }

        if (tipo == R.id.rbCoches) {
            opciones.add(getString(R.string.seat));
            opciones.add(getString(R.string.renault));
            opciones.add(getString(R.string.ford));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opciones);
        spInfo.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}