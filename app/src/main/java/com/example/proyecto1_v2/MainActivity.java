package com.example.proyecto1_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    //DECLARAR WIDGETS
    //Spinner
    Spinner sp;

    //RadioGroup
    RadioButton combo1, combo2, combo3;

    //CheckBox
    CheckBox agrandarCombo;

    //Button
    Button ordenar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = findViewById(R.id.sp);
        String[] options = {"No Jubilado", "Jubilado"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        sp.setAdapter(adapter);

        combo1 = findViewById(R.id.combo1);
        combo2 = findViewById(R.id.combo2);
        combo3 = findViewById(R.id.combo3);
        RadioGroup radiogroup = findViewById(R.id.radiogroup);

        agrandarCombo = findViewById(R.id.agrandarCombo);

        ordenar = findViewById(R.id.ordenar);

        ordenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sp.setSelection(0);
                //int selectedRadioButtonId = radiogroup.getCheckedRadioButtonId();

                double costoCombo = 0;
                double costoTotal = 0;
                int combo = 0;

                //Chequear Combo
                if(combo1.isChecked()){
                    costoCombo = 5.99;
                    combo = 1;
                } else if (combo2.isChecked()) {
                    costoCombo = 4.99;
                    combo = 2;
                } else if (combo3.isChecked()) {
                    costoCombo = 6.99;
                    combo = 3;
                }

                //Chequear Agrandado
                if(agrandarCombo.isChecked()){
                    costoTotal = costoTotal + 1;
                }

                costoTotal = costoTotal + costoCombo;

                String selec = sp.getSelectedItem().toString();

                //Chequear Jubilacion
                if (selec.equals("Jubilado")){
                    costoTotal = costoTotal - (costoTotal*0.20);
                }

                //Intent para ver la orden
                Intent intent = new Intent(MainActivity.this, OrdenActivity.class);
                intent.putExtra("COSTO_TOTAL", costoTotal);
                intent.putExtra("COMBO", combo);
                startActivity(intent);
            }
        });
    }
}