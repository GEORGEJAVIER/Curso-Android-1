package com.programandoando.hamp.dbandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class UserDetailList
        extends AppCompatActivity
        implements Listener{

    RecyclerView recyclerView;
    DbHelper dbHelper;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_detail_list);

        dbHelper = DbHelper.getInstance(getApplicationContext());

        recyclerView=(RecyclerView)
                findViewById(R.id.rv_contactoList);
        adapter=new ListAdapter(this,dbHelper.getAllUser());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void nameToChange(String name) {
        dbHelper.deleteRow(name);

        adapter=new ListAdapter(this,dbHelper.getAllUser());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));
    }
}
