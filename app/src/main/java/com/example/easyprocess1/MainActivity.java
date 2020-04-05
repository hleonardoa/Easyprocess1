package com.example.easyprocess1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.easyprocess1.util.Util;

import java.util.Calendar;
import java.util.HashMap;

import static java.util.Calendar.*;

public class MainActivity extends AppCompatActivity {

    private Button altas, consulta, calculo;
    private EditText horas;
    private EditText minutos;
    private TextView tiempoMostrado;
    String timeshow = "";

    private void init (){
    altas =         findViewById(R.id.altaspr);
    consulta =      findViewById(R.id.consulta);
    horas =         findViewById(R.id.editextTiempoHrs);
    minutos =       findViewById(R.id.editextTiempoMin);
    tiempoMostrado =findViewById(R.id.textMpstrado);
    calculo =       findViewById(R.id.calculo);
    timeshow =      tiempoMostrado.getText().toString();

}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bajamos los datos de los componentes
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();


        /********************************************EVENTOS ONCLICK*****************************************************************************************/
        /*************************************************************************************************************************************/
        //Evento Click ALTA
        altas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ventana = new Intent(v.getContext(),ALTAS.class);
                startActivityForResult(ventana,0);
            }

        });

        consulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ventana = new Intent(view.getContext(),Consulta.class);
                startActivityForResult(ventana, 0);
            }
        });

        calculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ventna = new Intent(view.getContext(),ListaPorPersona.class);
                ventna.putExtra("time",tiempoMostrado.getText().toString().replace("HORAS",""));
                startActivityForResult(ventna,0);
            }
        });
/********************************************EVENTOS ONFOCUS*****************************************************************************************/
/*************************************************************************************************************************************/
        minutos.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

 /*************************************************************************************************************************************/
 /************************PINTANMOS EL DATAPICKER (RELOJ)*************************************************************************************************************/
        horas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = getInstance();
                int hour = c.get(HOUR_OF_DAY);
                int minute = c.get(MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                horas.setText(hourOfDay + ":" + minute);
                            }
                        }, hour, minute, true);
                timePickerDialog.show();
            }
        });


        minutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = getInstance();
                int hour = c.get(HOUR_OF_DAY);
                int minute = c.get(MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                minutos.setText(hourOfDay + ":" + minute);
                                MuestraTiempo();
                            }
                        }, hour, minute, true);
                timePickerDialog.show();
            }
        });
/*************************************************************************************************************************************/
/*************************************************************************************************************************************/


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

    public void MuestraTiempo(){
        String time="";
        if(!horas.getText().toString().equals("") && !minutos.getText().toString().equals("")){
            time = Util.Calculohoras(horas.getText().toString(),minutos.getText().toString());
            if(Integer.parseInt(time.split(":")[0])<10)
                time = "0"+time;
            if(Integer.parseInt(time.split(":")[1])<10)
                time = time+time.replace(":",":0"+Integer.parseInt(time.split(":")[1]));
            tiempoMostrado.setText(time+" Horas");
        }
    }
}
