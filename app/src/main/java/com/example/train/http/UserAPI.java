package com.example.train.http;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserAPI {
    @POST("/auth/register")
    Call<String> registerUser(UserRegister userReg);

    @POST("/auth/login")
    Call<String> loginUser(UserLogin userLog);
}
