package com.example.gor.taskforjob.api;

import com.example.gor.taskforjob.model.ContactList;
import com.nowandroid.retrofitjson.model.ContactList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/lessons/retrofit-json/json_data.json")
    Call<ContactList> getMyJSON();
}