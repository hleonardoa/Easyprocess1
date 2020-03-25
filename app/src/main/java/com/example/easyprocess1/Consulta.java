package com.example.easyprocess1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Consulta extends AppCompatActivity {

    private ListView lista;


    private void init (){
        lista = findViewById(R.id.listView);
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
        ArrayList<String> names = new ArrayList<>();
        final ConexionSQLiteHelper conexion= new ConexionSQLiteHelper(getApplicationContext());
        registros = conexion.consultarUsuarios();
        if(registros.size()>0) {

            for (int i=1;i<=registros.size();i++){
                try {
                    names.add(registros.get(String.valueOf(i)).toString());
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
        MyAdapter adapter = new MyAdapter(this,R.layout.list_item,names);
        lista.setAdapter(adapter);
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
