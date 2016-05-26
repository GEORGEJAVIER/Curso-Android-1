package com.programandoando.hamp.dbandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAMP on 25/05/2016.
 */
public class DbHelper extends SQLiteOpenHelper {

    //TAG
    public static final String TAG="DbHelper";

    //Base Datos y version
    public static final String DATABASE_NAME="UserDb";
    public static final int DATABASE_VERSION=1;

    //Nombre Tabla
    public static final String TABLE_USERDET="userdetail";

    //Columnas Tablas
    public static final String _ID="_id";
    public static final String NOMBRE="nombre";
    public static final String UNIVERSIDAD="univesidad";
    public static final String CIUDAD="ciudad";
    public static final String USER_ID="userid";
    public static final String NUMERO="numero";

    private static DbHelper mDbHelper;
    public static synchronized DbHelper getInstance(Context context) {
        if (mDbHelper == null) {
            mDbHelper = new DbHelper(context.getApplicationContext());
        }
        return mDbHelper;
    }
    private DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERDETAIL_TABLE = "CREATE TABLE " + TABLE_USERDET +
                "(" +
                _ID + " INTEGER PRIMARY KEY ," +
                USER_ID + " TEXT," +
                NOMBRE + " TEXT," +
                UNIVERSIDAD + " TEXT," +
                CIUDAD+ " TEXT," +
                NUMERO + " TEXT" +
                ")";
        db.execSQL(CREATE_USERDETAIL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERDET);

            onCreate(db);
        }
    }

    public List<UserData> getAllUser() {

        List<UserData> usersdetail = new ArrayList<>();
        String USER_DETAIL_SELECT_QUERY = "SELECT * FROM " + TABLE_USERDET;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(USER_DETAIL_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    UserData userData = new UserData();
                    userData.setNombre(cursor.getString(cursor.getColumnIndex(NOMBRE)));
                    userData.setUniversidad( cursor.getString(cursor.getColumnIndex(UNIVERSIDAD)));
                    userData.setCiudad(cursor.getString(cursor.getColumnIndex(CIUDAD)));
                    userData.setUser_id( cursor.getString(cursor.getColumnIndex(USER_ID)));
                    userData.setNumero(cursor.getString(cursor.getColumnIndex(NUMERO)));
                    usersdetail.add(userData);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error listar BD");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return usersdetail;
    }

    public void insertUserDetail(UserData userData){
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values=new ContentValues();
            values.put(NOMBRE,userData.getNombre());
            values.put(UNIVERSIDAD,userData.getUniversidad());
            values.put(CIUDAD,userData.getCiudad());
            values.put(USER_ID,userData.getUser_id());
            values.put(NUMERO,userData.getNumero());
            db.insertOrThrow(TABLE_USERDET,null,values);
            db.setTransactionSuccessful();

        }catch (SQLException e){
            e.printStackTrace();
            Log.d(TAG,"Error al insertar");
        }finally {
            db.endTransaction();
        }
    }

    void deleteRow(String name) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.beginTransaction();
            db.execSQL("delete from " + TABLE_USERDET + " where nombre ='" + name + "'");
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            Log.d(TAG, "Error delete Database");
        } finally {
            db.endTransaction();
        }
    }

}
