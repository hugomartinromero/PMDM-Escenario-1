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
            opciones.add("Sevilla");
            opciones.add("Huelva");
            opciones.add("Cádiz");
        }

        if (tipo == R.id.rbFrutas) {
            opciones.add("Manzana");
            opciones.add("Naranja");
            opciones.add("Piña");
        }

        if (tipo == R.id.rbCoches) {
            opciones.add("Seat");
            opciones.add("Renault");
            opciones.add("Ford");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opciones);
        spInfo.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}