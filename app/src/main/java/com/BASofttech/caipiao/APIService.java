package com.BASofttech.caipiao;

import com.BASofttech.caipiao.bean.NewLuckBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("/dgq/getNewLuck")
    Call<NewLuckBean> getNewLuck();
}
