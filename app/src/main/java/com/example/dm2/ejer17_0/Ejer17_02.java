package com.example.dm2.ejer17_0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ejer17_02 extends AppCompatActivity {
    Button inSesion;
    EditText user;
    EditText passwd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejer17_02);

        inSesion = (Button) findViewById(R.id.btnEjer17_02IniSesion);
        user = (EditText) findViewById(R.id.eEjer17_02Usuario);
        passwd  = (EditText) findViewById(R.id.eEjer17_02Contraseña);

        inSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ejer17_02.this, Ejer17_02Comprobar.class);
                intent.putExtra("User", user.getText().toString());
                intent.putExtra("Passwd", passwd.getText().toString());
                startActivity(intent);
            }
        });

    }
}
