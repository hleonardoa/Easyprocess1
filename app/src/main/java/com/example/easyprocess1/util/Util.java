package com.example.easyprocess1.util;

import android.content.Context;
import com.example.easyprocess1.util.*;
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
        Util prueba = new Util();
        String obj = prueba.Calculohoras("7:00","3:20");
        System.out.println("valor calculado:"+obj);
    }
    public static String Calculohoras (String Hinicio ,String Hfinal){
        int hi, hf , mi, mf;
        hi = Integer.parseInt(Hinicio.split(":")[0]);
        mi = Integer.parseInt(Hinicio.split(":")[1]);
        hf = Integer.parseInt(Hfinal.split(":")[0]);
        mf = Integer.parseInt(Hfinal.split(":")[1]);
        int Hrango = (12-hi)+hf;
        int mrango = mi+mf;
        if (mrango >59){
            Hrango = Hrango+1;
            mrango = mrango-60;
        }
        if (Hrango >12){
            Hrango = Hrango-12;
        }
     return  ""+Hrango + ":"+ mrango;
    }
}
