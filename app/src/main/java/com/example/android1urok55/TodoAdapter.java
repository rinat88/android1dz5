package com.example.android1urok55;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    ArrayList<String> list = new ArrayList<>();

    public TodoAdapter() {
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
    }
    @SuppressLint("NotifyDataSetChanged")
    public void addData(String s){
        list.add(s);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo,parent,
        false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        holder.onFill(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView itemTask;
        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTask = itemView.findViewById(R.id.item_task);
        }
        public void onFill(String s){
            itemTask.setText(s);
        }
    }
}
