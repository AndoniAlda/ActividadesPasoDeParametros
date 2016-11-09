package com.example.dm2.ejer17_0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ejer17_01Condiciones extends AppCompatActivity implements View.OnClickListener {
    TextView texto;
    Button aceptar;
    Button rechazar;
    String nombre;
    String apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejer17_01_condiciones);
        Bundle extras = getIntent().getExtras();
        nombre = extras.getString("Nombre");
        apellido = extras.getString("Apellido");
        texto = (TextView) findViewById(R.id.tCondicionesText);
        texto.setText("Hola " + nombre + " " + apellido + " ¿ Aceptas las condiciones?");

        aceptar = (Button) findViewById(R.id.btnCondicionesAceptar);
        rechazar = (Button) findViewById(R.id.btnCondicionesRechazar);

        aceptar.setOnClickListener(this);
        rechazar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == aceptar) {
            Intent intent = new Intent();

            setResult(RESULT_OK, intent);
            finish();
        } else {
            Intent intent = new Intent();

            setResult(RESULT_CANCELED, intent);
            finish();
        }
    }
}