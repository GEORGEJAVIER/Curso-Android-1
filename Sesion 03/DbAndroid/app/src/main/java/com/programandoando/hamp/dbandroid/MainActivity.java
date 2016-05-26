package com.programandoando.hamp.dbandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_nombre,et_universidad,
            et_ciudad,et_userid,et_numero;
    Button btn_sig;
    DbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = DbHelper.getInstance(getApplicationContext());
        et_nombre = (EditText) findViewById(R.id.et_nombre);
        et_universidad = (EditText) findViewById(R.id.et_uni);
        et_ciudad = (EditText) findViewById(R.id.et_ciudad);
        et_userid = (EditText) findViewById(R.id.et_userid);
        et_numero = (EditText) findViewById(R.id.et_numero);
        btn_sig = (Button) findViewById(R.id.btn_sig);

        btn_sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserData userData = new UserData();

                userData.setNombre(et_nombre.getText().toString());

                userData.setUniversidad(et_universidad.getText().toString());

                userData.setUser_id(et_userid.getText().toString());

                userData.setNumero(et_numero.getText().toString());

                userData.setCiudad(et_ciudad.getText().toString());


                dbHelper.insertUserDetail(userData);

                Intent intent=new Intent(MainActivity.this,UserDetailList.class);
                startActivity(intent);
            }
        });
    }
}
