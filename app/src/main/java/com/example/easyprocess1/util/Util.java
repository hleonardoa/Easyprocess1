package com.example.easyprocess1.util;

import android.content.Context;

import com.example.easyprocess1.ConexionSQLiteHelper;

import java.util.HashMap;

/***
 * @author HLEONARDOA
 * */
public class Util {
    static String horas;
    private static String minutos;

    public Util() {
    }


    public static HashMap<Object,Object> CalculoTiempo(String tiempo, Context context){
        HashMap<Object,Object> listaCompleta = new HashMap<>();
        int tiempoTotal;
        int tiempoPorPersona;
        final ConexionSQLiteHelper conexion= new ConexionSQLiteHelper(context);

        listaCompleta = conexion.consultarUsuarios();
        //obtenemos las horas
        horas = tiempo.substring(0,2);
        //obtenemos los minutos
        minutos = tiempo.substring(4,6);

        tiempoTotal = (Integer.parseInt(horas) * 60)+ Integer.parseInt(minutos);
        tiempoPorPersona = (int)Math.floor(tiempoTotal/listaCompleta.size());

        for (int i=1;i<=listaCompleta.size();i++){
            listaCompleta.replace(String.valueOf(i),String.valueOf(i)+"");
        }

        return listaCompleta;
    }

    /*Método ocupado para probar la clase*/
    public static void main(String[] args) {
        
    }
}
