package com.example.easyprocess1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.annotation.Nullable;

import java.util.HashMap;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {
    private static final String USUARIOS = "usuarios.bd";
    private static final int VERSION_BD=1;
    private static final String TABLA_ALTAS = "CREATE TABLE ALTAS(ID  TEXT PRIMARY KEY,NOMNBRE TEXT)";


    public ConexionSQLiteHelper(Context context) {
        super(context,USUARIOS, null, VERSION_BD );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_ALTAS);//recibe la base de datos creada

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versionAntigua, int versionNueva) {//identifica el requerimiento de actulizacion
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ALTAS");
        sqLiteDatabase.execSQL(TABLA_ALTAS);
    }
    public void agregarusuarios(String id,String nombre){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            //consulta e insertamos datos
            bd.execSQL("INSERT INTO ALTAS VALUES('"+id+"','"+nombre+"')");
            bd.close();
        }
    }
    /*    metodo que devuelve las listas de usuario en una coleccion de datos tipo HASHMAP*/
    public HashMap<Object,Object> consultarUsuarios(){
        SQLiteDatabase bd=getWritableDatabase();
        HashMap<Object,Object> hashMap = new HashMap<>();
        if (bd!=null){
            //consulta datos
            Cursor cursor = bd.rawQuery("SELECT * FROM ALTAS",null);

                if(cursor.moveToFirst()){
                    do {
                        hashMap.put(cursor.getString(0),cursor.getString(1));
                    }while(cursor.moveToNext());
                }
            bd.close();
        }
        return hashMap;
    }

    public int consultaCount(){
        SQLiteDatabase bd=getWritableDatabase();
        int count =0;
        if (bd!=null){
            Cursor cursor = bd.rawQuery("SELECT COUNT(*)  FROM ALTAS",null);
            count = Integer.parseInt(cursor.getString(0));
        }
        return count;
    }
}
