package com.BASofttech.caipiao;

import com.BASofttech.caipiao.bean.NewLuckBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("/dgq/getNewLuck")
    Call<NewLuckBean> getNewLuck();
    @GET("/dgq/getMyLuck")
    Call<List<NewLuckBean>> getMyLuck();
    @GET("/dgq/getAllLuck")
    Call<List<NewLuckBean>> getAllLuck(@Query("everynper")String everynper);//get请求有参数的用法
}
