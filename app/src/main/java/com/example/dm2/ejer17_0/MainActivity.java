package com.example.dm2.ejer17_0;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn01;
    Button btn02;
    Button btn03;
    Button btn04;
    Button btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn01 = (Button) findViewById(R.id.btn01);
        btn02 = (Button) findViewById(R.id.btn02);
        btn03 = (Button) findViewById(R.id.btn03);
        btn04 = (Button) findViewById(R.id.btn04);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(this);
        btn04.setOnClickListener(this);
        btnSalir.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
     if (v==btnSalir){
         System.exit(0);

     }else if (v == btn01){
         Intent intent = new Intent(MainActivity.this, Ejer17_01.class);
         startActivity(intent);
     }else if (v == btn02){
         Intent intent = new Intent(MainActivity.this, Ejer17_02.class);
         startActivity(intent);
     }else if (v == btn03){
         Intent intent = new Intent(MainActivity.this, Ejer17_03.class);
         startActivity(intent);
     }
    }
}
