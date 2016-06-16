package com.example.upao.androidretrofit.apiservices.service;

/**
 * Created by UPAO on 15/06/2016.
 */
import com.example.upao.androidretrofit.apiservices.model.Tvshow;

import java.util.List;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface APIService {
    @POST("/api/tvshows")
    Call<Tvshow> createTvshow(@Body Tvshow tvshow);

    @GET("/api/tvshows")
    Call<List<Tvshow>> tvshows();
}