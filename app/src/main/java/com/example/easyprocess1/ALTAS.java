package com.example.easyprocess1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ALTAS extends AppCompatActivity {
    private EditText etid,etnombre,etap,etam,etedad,etsexo,etphone,etcorreo,etdirecion;
    private Button agregar,inicio;
    private RadioGroup genero;
    private RadioButton btfemenino ,btmasculino;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altas);


        etid = (EditText)findViewById(R.id.ID);
        etnombre =(EditText)findViewById(R.id.Nombre);
        etap =(EditText)findViewById(R.id.Apaterno);
        etam =(EditText)findViewById(R.id.Amaterno);
        agregar=(Button)findViewById(R.id.Agregar);
        inicio = (Button)findViewById(R.id.Inicio);

        final ConexionSQLiteHelper conexion= new ConexionSQLiteHelper(getApplicationContext());
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //conexion.agregarusuarios(etid.getText().toString(),etnombre.getText().toString(),etap.getText().toString(),etam.getText().toString(),btmasculino.getText().toString(),btfemenino.getText().toString(),etphone.getText().toString(),etcorreo.getText().toString(),etdirecion.getText().toString());
                conexion.agregarusuarios(etid.getText().toString(),etnombre.getText().toString());
                Toast.makeText(getApplicationContext(),"SE AGREGO CORRECTAMENTE",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
