package com.sodabazapplication.Services;

import com.sodabazapplication.Login_ModelClass;
import com.sodabazapplication.Login_Payload;
import com.sodabazapplication.Modelclasses.DashboardModel_Class;
import com.sodabazapplication.Modelclasses.Dashboard_Market_ModelClass;
import com.sodabazapplication.Modelclasses.FetchUsername_Model_Class;
import com.sodabazapplication.Modelclasses.ForgetPassword_ModelClass;
import com.sodabazapplication.Modelclasses.Market_Model_Class;
import com.sodabazapplication.Signup_Payload;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Endpoints {

    @POST("login")
    Call<Login_ModelClass> getLoginData(@Body Login_Payload login_payload);

    @POST("signup")
    Call<Login_ModelClass> getSignupData(@Body Signup_Payload signup_payload);


    @POST("forgetpassword")
    Call<Login_ModelClass> forgetPassword(@Body ForgetPassword_ModelClass forgetPassword_modelClass);

    @GET("dashboard")
    Call<List<DashboardModel_Class>> getDashboardData();

    @GET("dashboardmarket")
    Call<List<Dashboard_Market_ModelClass>> getDashboardMarketData();


    @GET("market")
    Call<List<Market_Model_Class>> getMarketData();

    @POST("fetchusername")
    Call<Login_ModelClass> fetchUsername(@Body FetchUsername_Model_Class fetchUsername_model_class);
}
