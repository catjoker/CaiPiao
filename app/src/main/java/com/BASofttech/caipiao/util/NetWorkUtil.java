package com.BASofttech.caipiao.util;

import com.BASofttech.caipiao.APIService;
import com.BASofttech.caipiao.bean.NewLuckBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkUtil {
    private static Retrofit retrofit;
    private static synchronized Retrofit getRetrofit(){
        if (retrofit==null{
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://guoqiang.space")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static APIService getApiService(){
        APIService apiService =  getRetrofit().create(APIService.class);
        return apiService;
    }
    public static <T>T getInfo(Call<T> call){
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
//                return response.body();
                //观察者?
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {

            }
        });
        return null;
    }
}
