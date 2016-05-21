package com.programandoando.hamp.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db=new DatabaseHandler(this);

        //Insertar Contactos
        Log.d("Insertar:","Insertando");
        db.addContact(new Contact("Henry","12344556"));
        db.addContact(new Contact("Juan","25344556"));
        db.addContact(new Contact("Patricia","32344556"));
        db.addContact(new Contact("Jorge","132344556"));
        db.addContact(new Contact("Maria","132344553"));

        //Listado de Contactos
        Log.d("Listar:","Listando");
        List<Contact> contacts=db.getAllContacts();

        for (Contact cn:contacts){
            String log="Id:"+cn.get_id()
                    +", Nombre:"+cn.get_name()
                    +", Telefono:"+cn.get_phone_number();
            Log.d("Contacto:",log);
        }
    }
}
