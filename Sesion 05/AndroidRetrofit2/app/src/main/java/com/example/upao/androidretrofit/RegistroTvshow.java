package com.example.upao.androidretrofit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.upao.androidretrofit.apiservices.RestClient;
import com.example.upao.androidretrofit.apiservices.model.Tvshow;

public class RegistroTvshow  extends Fragment {

    EditText titulo;
    EditText anno;
    EditText pais;
    EditText temporadas;
    EditText genero;
    EditText resumen;
    Button addTvshow;
    Button retTvshow;
    RestClient restClient = RestClient.getInstance();


    public static RegistroTvshow newInstance() {
        return new RegistroTvshow();
    }

    public RegistroTvshow() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_registro_tvshow, container, false);

        titulo = (EditText) root.findViewById(R.id.etTitulo);
        anno = (EditText) root.findViewById(R.id.etAnno);
        pais = (EditText) root.findViewById(R.id.etPais);
        temporadas = (EditText) root.findViewById(R.id.etTemporadas);
        genero = (EditText) root.findViewById(R.id.etGenero);
        resumen = (EditText) root.findViewById(R.id.etResumen);
        addTvshow = (Button) root.findViewById(R.id.btnRegistrar);



        addTvshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _titulo = titulo.getText().toString();
                int _anno = Integer.parseInt(anno.getText().toString());
                String _pais=pais.getText().toString();
                int _temporadas=Integer.parseInt(temporadas.getText().toString());
                String _genero=genero.getText().toString();
                String _resumen=resumen.getText().toString();

                Tvshow tv = new Tvshow(_titulo,_anno,_pais,_temporadas,_genero,_resumen);
                restClient.createTvshow(getActivity(), tv);
                titulo.setText("");
                anno.setText("");
                pais.setText("");
                temporadas.setText("");
                genero.setText("");
                resumen.setText("");

            }
        });

        return root;
    }


}
