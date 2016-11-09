package com.example.dm2.ejer17_0;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ejer17_01 extends AppCompatActivity {
    EditText nombre;
    EditText apellido;
    Button btnVolver,btnVerificar;
    TextView tCondiciones;
    String txtCondiciones = "Aceptas condiciones:";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejer17_01);
        nombre = (EditText) findViewById(R.id.eNombre);
        apellido = (EditText) findViewById(R.id.eApellido);
        btnVerificar = (Button) findViewById(R.id.btnVerificar);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        tCondiciones = (TextView) findViewById(R.id.tCondiciones);


        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean entrarN = true;
                boolean entrarA = true;
                if(nombre.getText().toString().equals("")){
                    nombre.setBackgroundColor(Color.RED);
                    nombre.setHighlightColor(Color.BLACK);
                    entrarN = false;
                }else{
                    nombre.setBackgroundColor(Color.WHITE);
                    nombre.setHighlightColor(Color.RED);
                    entrarN = true;
                }
                if (apellido.getText().toString().equals("")){
                    apellido.setBackgroundColor(Color.RED);
                    apellido.setHighlightColor(Color.BLACK);
                    entrarA = false;
                }else{
                    apellido.setBackgroundColor(Color.WHITE);
                    apellido.setHighlightColor(Color.RED);
                    entrarA = true;
                }
                if(entrarN == true && entrarA == true) {
                    Intent intent = new Intent(Ejer17_01.this, Ejer17_01Condiciones.class);
                    intent.putExtra("Nombre", nombre.getText().toString());
                    intent.putExtra("Apellido", apellido.getText().toString());
                    startActivityForResult(intent, 123);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == RESULT_OK){
            tCondiciones.setText(txtCondiciones+"ACEPTADO");
        }else if (requestCode == 123 && resultCode == RESULT_CANCELED){
            tCondiciones.setText(txtCondiciones + "RECHAZADO");
        }
    }
}
