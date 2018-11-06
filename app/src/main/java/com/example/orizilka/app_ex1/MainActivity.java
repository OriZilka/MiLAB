package com.example.orizilka.app_ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Stark = findViewById(R.id.button_stark);
        Stark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewStark) {
                Intent StarkButton = new Intent(viewStark.getContext(), StarkFamily.class);
                startActivity(StarkButton);
            }
        });

        Button Lannister = findViewById(R.id.button_lannister);
        Lannister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewLannister) {
                Intent LannisterButton = new Intent(viewLannister.getContext(), LannisterFamily.class);
                startActivity(LannisterButton);
            }
        });
    }
}
