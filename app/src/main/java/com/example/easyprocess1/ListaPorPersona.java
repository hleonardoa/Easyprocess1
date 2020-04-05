package com.example.easyprocess1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListaPorPersona extends AppCompatActivity {

    private Button atras;
    private TextView tiempoPersona;

    String time;
    public void init(){
        atras = findViewById(R.id.atrasListado);
        tiempoPersona = findViewById(R.id.textTiempoPersona);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_por_persona);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        Intent intent = getIntent();
        time = intent.getStringExtra("time");
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void onStart(){
        super.onStart();
        time = String.valueOf  ( (Integer.parseInt(time.split(":")[0])*60)+
                                    (Integer.parseInt(time.split(":")[1].substring(0,2)))
                );
        tiempoPersona.setText(tiempoPersona.getText()+" "+time);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ventana = new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(ventana,0);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
