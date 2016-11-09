package com.example.dm2.ejer17_0;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ejer17_02Comprobar extends AppCompatActivity {
    String passwd;
    String user;
    TextView text;
    Button volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejer17_02_comprobar);
        Bundle extras = getIntent().getExtras();
        passwd = extras.getString("Passwd");
        user = extras.getString("User");
        text = (TextView) findViewById(R.id.tEjer17_02ComprobarText);
        volver =(Button) findViewById(R.id.btnEjer17_02ComprobarVolver);

        if (user.toUpperCase().equals("ANDONI") && passwd.toUpperCase().equals("1234")){
            text.setText("EL USUARIO Y LA PASSWORD SON CORRECTAS");
            text.setBackgroundColor(Color.BLUE);
            text.setTextColor(Color.WHITE);
        }else{
            text.setText("USUARIO Y/O PASSWORD INCORRECTA");
            text.setBackgroundColor(Color.BLUE);
            text.setTextColor(Color.WHITE);
        }

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
