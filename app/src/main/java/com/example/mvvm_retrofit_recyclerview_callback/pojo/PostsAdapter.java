package com.example.mvvm_retrofit_recyclerview_callback.pojo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mvvm_retrofit_recyclerview_callback.R;
import java.util.ArrayList;


public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {
    private ArrayList<PostsModel> list = new ArrayList();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.body.setText(list.get(position).body);
        holder.title.setText(list.get(position).title);
        holder.id.setText(list.get(position).id);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(ArrayList list){
        this.list = list;
        notifyDataSetChanged();
    }
    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView id;
        TextView body;
        public PostViewHolder(@NonNull View v) {
            super(v);
            title = v.findViewById(R.id.title);
            id = v.findViewById(R.id.id);
            body = v.findViewById(R.id.body);
        }
    }
}
