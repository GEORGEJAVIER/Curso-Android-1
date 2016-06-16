package com.example.upao.androidretrofit.apiservices;

/**
 * Created by UPAO on 15/06/2016.
 */
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.upao.androidretrofit.apiservices.model.Tvshow;
import com.example.upao.androidretrofit.apiservices.service.APIService;

import java.util.List;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class RestClient {

    private static RestClient instance = null;

    private ResultReadyCallback callback;

    private static final String BASE_URL = "http://172.16.30.75:3000";
    private APIService service;
    List<Tvshow> tvshows = null;
    boolean success = false;

    public RestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        service = retrofit.create(APIService.class);
    }

    public List<Tvshow> getTvshows() {
        Call<List<Tvshow>> tvshowlist = service.tvshows();
        tvshowlist.enqueue(new Callback<List<Tvshow>>() {
            @Override
            public void onResponse(Response<List<Tvshow>> response) {
                if (response.isSuccess()) {
                    tvshows = response.body();
                    callback.resultReady(tvshows);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("REST", t.getMessage());
            }
        });
        return tvshows;
    }


    public void setCallback(ResultReadyCallback callback) {
        this.callback = callback;
    }

    public boolean createTvshow(final Context ctx, Tvshow tvshow) {
        Call<Tvshow> tv = service.createTvshow(tvshow);
        tv.enqueue(new Callback<Tvshow>() {
            @Override
            public void onResponse(Response<Tvshow> response) {
                success = response.isSuccess();
                if(success) {
                    Toast.makeText(ctx, "Tvshow Creado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ctx, "Error al crear TvShow", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("REST", t.getMessage());
                Toast.makeText(ctx, "Error TvShow", Toast.LENGTH_SHORT).show();

            }
        });
        return success;
    }

    public static RestClient getInstance() {
        if(instance == null) {
            instance = new RestClient();
        }
        return instance;
    }

    public interface ResultReadyCallback {
        public void resultReady(List<Tvshow> tvshows);
    }

}

