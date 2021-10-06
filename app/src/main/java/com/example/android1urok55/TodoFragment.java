package com.example.android1urok55;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class TodoFragment extends Fragment {
    RecyclerView recyclerView;
    EditText editText;
    TodoAdapter adapter;
    String task;
    Button addButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new TodoAdapter();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.edit_text);
        addButton = view.findViewById(R.id.add_button);
        recyclerView = view.findViewById(R.id.todo_recycler);
        recyclerView.setAdapter(adapter);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = editText.getText().toString();
                adapter.addData(task);
            }
        });
    }
}