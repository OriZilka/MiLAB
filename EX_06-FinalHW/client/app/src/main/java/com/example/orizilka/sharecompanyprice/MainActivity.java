package com.example.orizilka.sharecompanyprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String companyShareName;
    Button submitButton;

    EditText shareNameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shareNameInput = (EditText) findViewById(R.id.InsertCompName);
        submitButton = (Button) findViewById(R.id.publishButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                companyShareName = shareNameInput.getText().toString();
            }
        });
    }
}
