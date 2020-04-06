package com.pioneer.base.service;

import com.pioneer.base.model.HomeModel;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface RxHomeService {
    @GET("{path}")
    Observable<HomeModel> executeTask(@Path("path") String path,@HeaderMap Map<String,String> commonHeader,@QueryMap Map<String,String> commonFields);
}
