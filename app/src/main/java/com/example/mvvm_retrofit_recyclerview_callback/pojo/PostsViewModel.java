package com.example.mvvm_retrofit_recyclerview_callback.pojo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsViewModel extends ViewModel {

   public static MutableLiveData<ArrayList<PostsModel>> mutableLiveData = new MutableLiveData();

    public static void getPosts(){
        PostsClient.getInstance().getPosts().enqueue(new Callback<ArrayList<PostsModel>>() {
            @Override
            public void onResponse(Call<ArrayList<PostsModel>> call, Response<ArrayList<PostsModel>> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<PostsModel>> call, Throwable t) {
                t.getMessage();
            }
        });
    }

}
