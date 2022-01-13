package com.demo.starter.api;

import com.demo.result.Result;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Map;

/**
 * @author Will Liu
 * @date 2022/1/11
 */
public interface DemoApi {

    @GET("/demo/demoApi")
    Result demoAPi(@Query("message") String message);
}
