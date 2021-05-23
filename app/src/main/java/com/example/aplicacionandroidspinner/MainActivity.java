package com.example.aplicacionandroidspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText cajaInput, cajaOutput;
    Spinner spinnerInput, spinnerOutput;
    int posicion1 = 1;
    int posicion2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cajaInput = findViewById(R.id.caja_input);
        cajaOutput = findViewById(R.id.caja_output);

        ArrayAdapter adaptador = ArrayAdapter.createFromResource(this, R.array.spinner_conversion,
                android.R.layout.simple_spinner_item);

        spinnerInput = findViewById(R.id.spinner_input);
        spinnerInput.setAdapter(adaptador);
        spinnerInput.setOnItemSelectedListener(this);

        spinnerOutput = findViewById(R.id.spinner_output);
        spinnerOutput.setAdapter(adaptador);
        spinnerOutput.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        String texto = cajaInput.getText().toString();
        if (texto.equals(""))
            texto="0";
        double numeroInput = Double.parseDouble(texto);
        double numeroOutput=numeroInput;

        if (parent.getId() == R.id.spinner_input)
            posicion1=position;
        if (parent.getId() == R.id.spinner_output)
            posicion2=position;

        switch (spinnerInput.getItemAtPosition(posicion1).toString()){
            case "Centigrados":
                switch (spinnerOutput.getItemAtPosition(posicion2).toString()){
                    case "Fahrenheit":  numeroOutput=(numeroInput*1.8)+32;  break;
                    case "Rankine":     numeroOutput=(numeroInput*1.8)+32+ 459.67;  break;
                    case "Kelvin":      numeroOutput=numeroInput+ 273.15;   break;
                    default:break;
                }
                break;
            case "Fahrenheit":
                switch (spinnerOutput.getItemAtPosition(posicion2).toString()){
                    case "Centigrados": numeroOutput=(numeroInput-32)/1.8;break;
                    case "Rankine":     numeroOutput=numeroInput+459.67;  break;
                    case "Kelvin":      numeroOutput=(numeroInput+459.67)/1.8;   break;
                    default:break;
                }
                break;
            case "Rankine":
                switch (spinnerOutput.getItemAtPosition(posicion2).toString()){
                    case "Centigrados": numeroOutput=(numeroInput-491.67) / 1.8;break;
                    case "Fahrenheit":  numeroOutput=numeroInput-459.67;  break;
                    case "Kelvin":      numeroOutput=numeroInput/1.8;   break;
                    default:break;
                }
                break;
            case "Kelvin":
                switch (spinnerOutput.getItemAtPosition(posicion2).toString()){
                    case "Centigrados": numeroOutput=numeroInput- 273.15;  break;
                    case "Fahrenheit":  numeroOutput=(numeroInput* 1.8) - 459.67;  break;
                    case "Rankine":     numeroOutput=numeroInput*1.8;  break;
                    default:break;
                }
                break;
            default:break;
        }
        cajaOutput.setText(""+numeroOutput);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}