package com.example.mvvm_retrofit_recyclerview_callback.pojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("posts")
    public Call<ArrayList<PostsModel>> getPosts();
}
