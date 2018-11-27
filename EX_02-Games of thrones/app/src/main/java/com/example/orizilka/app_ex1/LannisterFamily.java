package com.example.orizilka.app_ex1;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class LannisterFamily extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lannister_family);

        RecyclerView recyclerView = findViewById(R.id.LannisterFamilyList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ListAdapter(new String[]{"Jaime Lannister", "Cersei Lannister", "Tyrion Lannister", "Tywin Lannister",
                                                             "Lancel Lannister", "Kevan Lannister"},
                                                new Drawable[] {ContextCompat.getDrawable(this,R.drawable.jaime_lannister),
                                                                 ContextCompat.getDrawable(this,R.drawable.cersei_lannister),
                                                                ContextCompat.getDrawable(this,R.drawable.tyrion_lannister),
                                                                ContextCompat.getDrawable(this,R.drawable.tywin_lannister),
                                                                ContextCompat.getDrawable(this,R.drawable.lancel_lannister),
                                                                ContextCompat.getDrawable(this,R.drawable.kevan_lannister)}));
    }
}
