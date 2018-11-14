package com.example.orizilka.app_ex1;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class StarkFamily extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stark_family);

        RecyclerView recyclerView = findViewById(R.id.StarkFamilyList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ListAdapter(new String[]{"Eddard \"Ned\" Stark", "Catelyn Stark", "Sansa Stark" , "Arya Stark" ,
                                                            "Robb Stark" , "Bran Stark" , "Rickon Stark"},
                                                            new Drawable[] {ContextCompat.getDrawable(this,R.drawable.ned_stark),
                                                                            ContextCompat.getDrawable(this,R.drawable.catelyn_stark),
                                                                            ContextCompat.getDrawable(this,R.drawable.sansa_stark),
                                                                            ContextCompat.getDrawable(this,R.drawable.arya_stark),
                                                                            ContextCompat.getDrawable(this,R.drawable.robb_stark),
                                                                            ContextCompat.getDrawable(this,R.drawable.bran_stark),
                                                                            ContextCompat.getDrawable(this,R.drawable.rickon_stark)}));
    }
}
