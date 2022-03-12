package com.codixlab.collapsingrecyclerview.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codixlab.collapsingrecyclerview.R;
import com.codixlab.collapsingrecyclerview.adapter.ExpendableRecyclerViewAdapter;
import com.codixlab.collapsingrecyclerview.model.Person;
import com.codixlab.collapsingrecyclerview.util.Data;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpendableRecyclerViewAdapter adapter;
    List<Person> personList;
    private Toolbar toolbar;
    private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        list = findViewById(R.id.list);

        init();


    }

    private void init() {


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Expandable");
        personList = new ArrayList<>();
        personList = Data.getPersonsData(this);
        personList.addAll(Data.getPersonsData(this));
        adapter = new ExpendableRecyclerViewAdapter(this, personList);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setHasFixedSize(true);
        list.setAdapter(adapter);


    }
}
