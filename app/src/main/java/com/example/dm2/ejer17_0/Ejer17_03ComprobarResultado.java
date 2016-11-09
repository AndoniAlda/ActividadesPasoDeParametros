package com.example.dm2.ejer17_0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ejer17_03ComprobarResultado extends AppCompatActivity {
    String resultadoUser;
    int resultadoEsperado;
    TextView tResultado;
    Button btnVolver17_03;
    int nAciertos,nFallos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejer17_03_comprobar_resultado);
        Bundle extras = getIntent().getExtras();
        resultadoUser = extras.getString("Resultado");
        resultadoEsperado = extras.getInt("ResultadoEsperado");
        nAciertos = extras.getInt("nAciertos");
        nFallos = extras.getInt("nFallos");
        tResultado = (TextView) findViewById(R.id.tResultado);
        btnVolver17_03 = (Button) findViewById(R.id.btnVolver17_03);


        int r = Integer.parseInt(resultadoUser);

        if (r == resultadoEsperado){
            tResultado.setText("El resultado de la operacion es CORRECTO");
            nAciertos++;
        }else{
            tResultado.setText("El resultado de la operacion es INCORRECTO");
            nFallos++;
        }

        btnVolver17_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("nAciertos",nAciertos);
                intent.putExtra("nFallos",nFallos);
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }
}
