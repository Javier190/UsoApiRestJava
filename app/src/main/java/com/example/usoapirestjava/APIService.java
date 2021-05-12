package com.example.usoapirestjava;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
//API
public interface APIService {
    @GET
    public Call<EmployeeResponse> getEmployees(@Url String url);
}
