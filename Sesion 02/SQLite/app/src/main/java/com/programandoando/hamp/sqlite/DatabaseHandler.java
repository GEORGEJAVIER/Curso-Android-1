package com.programandoando.hamp.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAMP on 20/05/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper{

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null,
                DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE ="CREATE TABLE "
                +TABLE_CONTACTS+"("+
                KEY_ID+" INTEGER PRIMARY KEY,"
                +KEY_NAME+" TEXT,"
                +KEY_PH_NO+" TEXT"+")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Borrar la version anterior de las tablas
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CONTACTS);
        //Crear la nuea tabla
        onCreate(db);
    }

    //CRUD
    void addContact(Contact contact){
        SQLiteDatabase db=this.getWritableDatabase();

        //Almacenar los datos (Contact) ContentValues
        ContentValues values=new ContentValues();
        values.put(KEY_NAME,contact.get_name());
        values.put(KEY_PH_NO,contact.get_phone_number());

        //Insertar Fila SQLite

        db.insert(TABLE_CONTACTS,null,values);
        db.close();//Cierro la conexion
    }

    public List<Contact> getAllContacts(){
        List<Contact> contactList =new ArrayList<>();
        //Select
        String selectQuery="SELECT * FROM "+TABLE_CONTACTS;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                Contact contact=new Contact();
                contact.set_id(Integer.parseInt(cursor.getString(0)));
                contact.set_name(cursor.getString(1));
                contact.set_phone_number(cursor.getString(2));
                //Agregar contacto a lista
                contactList.add(contact);
            }while(cursor.moveToNext());
        }
        return contactList;
    }

    Contact getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                        KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        return contact;
    }

    public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.get_name());
        values.put(KEY_PH_NO, contact.get_phone_number());


        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.get_id()) });
    }


    public void deleteContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.get_id()) });
        db.close();
    }



    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();


        return cursor.getCount();
    }
}
