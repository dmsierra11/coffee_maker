package com.dmsierraf.coffeeapp.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by VCHI on 10/5/16.
 */
public class RestClientPublic {

    private static RestClientPublic restClientPublic;
    private final String BASE_URL = "https://api.thingspeak.com/talkbacks/";
    private final APIService apiService;

    private RestClientPublic(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(this.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(APIService.class);
    }

    public APIService getApiService() {
        return apiService;
    }

    public static RestClientPublic getClient(){
        if (restClientPublic == null)
            restClientPublic = new RestClientPublic();
        return restClientPublic;
    }
}
