package com.example.mvvm_retrofit_recyclerview_callback.pojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private final static String baseLink = "https://jsonplaceholder.typicode.com/";
    static PostsClient instant;
    private ApiInterface apiInterface;

    public PostsClient () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseLink)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
    }
    public static PostsClient getInstance(){
        if(instant==null){
            instant = new PostsClient();
        }
        return instant;
    }
    Call<ArrayList<PostsModel>> getPosts(){
        return apiInterface.getPosts();
    }
}
