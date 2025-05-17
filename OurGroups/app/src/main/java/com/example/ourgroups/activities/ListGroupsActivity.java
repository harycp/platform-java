package com.example.ourgroups.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ourgroups.R;
import com.example.ourgroups.adapter.GroupAdapter;
import com.example.ourgroups.db.DbHelper;
import com.example.ourgroups.model.Group;

import java.util.ArrayList;

public class ListGroupsActivity extends AppCompatActivity {
    private GroupAdapter adapter;
    private ArrayList<Group> groupsArrayList;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_groups);

        RecyclerView recyclerView = findViewById(R.id.rview);
        adapter = new GroupAdapter(this);

        dbHelper = new DbHelper(this);
        groupsArrayList = dbHelper.getAllUsers();
        adapter.setListGroups(groupsArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListGroupsActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.list_groups), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onResume() {
        super.onResume();
        groupsArrayList = dbHelper.getAllUsers();
        adapter.setListGroups(groupsArrayList);
        adapter.notifyDataSetChanged();
    }
}
