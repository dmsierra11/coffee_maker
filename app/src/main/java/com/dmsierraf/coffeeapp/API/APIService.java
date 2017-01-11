package com.dmsierraf.coffeeapp.API;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by VCHI on 10/5/16.
 */
public interface APIService {

    @POST("12216/commands")
    Call<String> sendSignal(@Query("api_key") String api, @Query("command_string") String command);
}
