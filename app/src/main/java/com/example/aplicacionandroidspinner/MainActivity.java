package com.example.aplicacionandroidspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText cajaInput, cajaOutput;
    Spinner spinnerInput, spinnerOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cajaInput = findViewById(R.id.caja_input);
        cajaOutput = findViewById(R.id.caja_output);
        spinnerInput = findViewById(R.id.spinner_input);
        spinnerOutput = findViewById(R.id.spinner_output);

        spinnerInput.setOnItemSelectedListener(this);
        spinnerOutput.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        /*if(parent.getId() == R.id.spinner_operaciones )
            Log.i("MSJ --> ", "SPINNER 1");

        Log.i("MSJ --> ", parent.toString());
        Log.i("MSJ --> ", parent.getItemAtPosition(position).toString());

        switch (parent.getItemAtPosition(position).toString()){
            case "+": Toast.makeText(getBaseContext(), "A sumar se ha dicho", Toast.LENGTH_LONG).show();
                cajaResultado.setText("resultado");
                break;

        }*/
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}