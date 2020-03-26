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

import java.util.Calendar;

import static java.util.Calendar.*;

public class MainActivity extends AppCompatActivity {

    private Button altas, consulta;
    private EditText horas;
    private EditText minutos;
    private TextView tiempoMostrado;
    String timeshow = "";

    private void init (){
    altas = (Button)findViewById(R.id.altaspr);
    consulta = (Button)findViewById(R.id.consulta);
    horas =  (EditText)findViewById(R.id.editextTiempoHrs);
    minutos = (EditText)findViewById(R.id.editextTiempoMin);
    tiempoMostrado = findViewById(R.id.textMpstrado);
    timeshow =tiempoMostrado.getText().toString();
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

        horas.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                String a =horas.getText().toString();

                return false;
            }
        });

        horas.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String timeHrs =horas.getText().toString();
                tiempoMostrado.setText((timeHrs.length()==1?"0"+timeHrs:timeHrs)+":00 Horas");

            }
        });

        minutos.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                timeshow = tiempoMostrado.getText().toString().substring(0,3);
                timeshow = timeshow+minutos.getText().toString()+" Horas";
                tiempoMostrado.setText(timeshow);
            }
        });

        //Evento Click
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
                            }
                        }, hour, minute, true);
                timePickerDialog.show();
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
