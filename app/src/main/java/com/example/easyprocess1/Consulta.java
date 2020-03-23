package com.example.easyprocess1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class Consulta extends AppCompatActivity {

    private TextView campos;

    private void init (){
        campos = findViewById(R.id.lista);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        HashMap<Object,Object> registros = new HashMap<>();
        final ConexionSQLiteHelper conexion= new ConexionSQLiteHelper(getApplicationContext());
        registros = conexion.consultarUsuarios();
        if(registros.size()>0)
            campos.setText(registros.toString());
    }
}
