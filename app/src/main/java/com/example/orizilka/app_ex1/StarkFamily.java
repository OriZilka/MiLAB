package com.example.orizilka.app_ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class StarkFamily extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stark_family);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.StarkFamilyList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ListAdapter(new String[]{"Eddard \"Ned\" Stark", "Catelyn Stark", "Sansa Stark" , "Arya Stark" , "Robb Stark" , "Bran Stark" , "Rickon Stark"}));
    }
}
