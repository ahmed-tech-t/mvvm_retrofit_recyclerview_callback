package com.example.mvvm_retrofit_recyclerview_callback;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm_retrofit_recyclerview_callback.pojo.PostsAdapter;
import com.example.mvvm_retrofit_recyclerview_callback.pojo.PostsModel;
import com.example.mvvm_retrofit_recyclerview_callback.pojo.PostsViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
    PostsViewModel postsViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postsViewModel = ViewModelProviders.of(this).get(PostsViewModel.class);
        PostsViewModel.getPosts();

        recyclerView = findViewById(R.id.recyclerView);
        PostsAdapter adapter = new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        PostsViewModel.mutableLiveData.observe(this, new Observer<ArrayList<PostsModel>>() {
            @Override
            public void onChanged(ArrayList<PostsModel> postsModels) {
                adapter.setList(postsModels);
            }
        });
    }
}