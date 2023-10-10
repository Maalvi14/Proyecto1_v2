package com.example.proyecto1_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class OrdenActivity extends AppCompatActivity {

    ImageView imagenCombo;

    TextView verCosto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden);

        imagenCombo = findViewById(R.id.imagenCombo);
        verCosto = findViewById(R.id.verCosto);

        Intent intent = getIntent();

        double precio = intent.getDoubleExtra("COSTO_TOTAL", 0.0);
        int combo = intent.getIntExtra("COMBO", 0);

        int comboResourceId = getResources().getIdentifier("combo" + combo, "drawable", getPackageName());

        precio = Math.round(precio*100.0)/100.0;

        imagenCombo.setImageResource(comboResourceId);
        verCosto.setText("Costo del Pedido: " + precio);

    }
}

