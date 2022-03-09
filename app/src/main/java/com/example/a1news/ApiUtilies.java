package com.example.a1news;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilies {

    private static Retrofit retrofit=null;

    public static ApiInterface getApiInterface()
    {

        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(ApiInterface.Base_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(ApiInterface.class);
    }

}
