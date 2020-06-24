package com.app.apitest.Retrofit;

import com.app.apitest.Pojo.PanDetails;
import com.google.gson.JsonObject;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("getPanDetails")
    Observable<PanDetails> getDetails(@Body JsonObject jsonObject);
}
