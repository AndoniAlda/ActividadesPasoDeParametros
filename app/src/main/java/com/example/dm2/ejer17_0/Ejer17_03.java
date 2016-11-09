package com.example.dm2.ejer17_0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ejer17_03 extends AppCompatActivity {
    EditText eOperador1;
    EditText eOperador2;
    EditText eResultado;
    Button btnCalcula;
    TextView tRespuesta;
    int n;
    int n2;
    int resultadoEsperado;
    int nAciertos = 0;
    int nFallos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejer17_03);
        eOperador1 = (EditText) findViewById(R.id.eOperador1);
        eOperador2 = (EditText) findViewById(R.id.eOperador2);
        eResultado = (EditText) findViewById(R.id.eResultado);
        btnCalcula = (Button) findViewById(R.id.btnCalculaSuma);
        tRespuesta = (TextView) findViewById(R.id.tRespuestas);
        n = (int)Math.floor(Math.random()*(0-100)+100);
        n2 = (int)Math.floor(Math.random()*(0-100)+100);
        resultadoEsperado = n + n2;
        eOperador1.setText(n+"");
        eOperador2.setText(n2+"");
        btnCalcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eResultado.getText().toString().equals("")){
                    Intent intent = new Intent(Ejer17_03.this, Ejer17_03ComprobarResultado.class);
                    intent.putExtra("Resultado", eResultado.getText().toString());
                    intent.putExtra("ResultadoEsperado", resultadoEsperado);
                    intent.putExtra("nAciertos",nAciertos);
                    intent.putExtra("nFallos",nFallos);
                    startActivityForResult(intent, 123);
                }else{
                    Intent intent = new Intent(Ejer17_03.this, Ejer17_03ComprobarResultado.class);
                    intent.putExtra("Resultado", eResultado.getText().toString());
                    intent.putExtra("ResultadoEsperado", resultadoEsperado);
                    intent.putExtra("nAciertos",nAciertos);
                    intent.putExtra("nFallos",nFallos);
                    startActivityForResult(intent, 123);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            nAciertos = extras.getInt("nAciertos");
            nFallos = extras.getInt("nFallos");
            tRespuesta.setText("PREGUNTAS CORRECTAS "+ nAciertos+ " INCORRECTAS "+ nFallos);

            n = (int)Math.floor(Math.random()*(0-100)+100);
            n2 = (int)Math.floor(Math.random()*(0-100)+100);
            resultadoEsperado = n + n2;
            eOperador1.setText(n+"");
            eOperador2.setText(n2+"");

        }
    }
}
