package com.example.orizilka.app_ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class LannisterFamily extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lannister_family);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.LannisterFamilyList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ListAdapter(new String[]{"Jaime Lannister", "Cersei Lannister", "Tyrion Lannister", "Tywin Lannister", "Lancel Lannister", "Kevan Lannister"}));
    }
}
