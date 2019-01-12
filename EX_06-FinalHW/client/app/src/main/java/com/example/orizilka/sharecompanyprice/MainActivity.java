package com.example.orizilka.sharecompanyprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.socket.emitter.Emitter;

import java.net.URISyntaxException;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.json.JSONException;
import org.json.JSONObject;



public class MainActivity extends AppCompatActivity {

    // declaring the string and button that I'll use after.
    String companyShareName;
    Button submitButton;

    EditText shareNameInput;

   // private String mUsername;
    private Socket mSocket;
   // private Boolean isConnected = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * creating and handling the Socket.io
         */
        try {
            mSocket = IO.socket("http://10.0.2.2:3000");
            mSocket.connect();
//            mSocket.on("userSharedACompany", new Emitter.Listener(){
//                @Override
//                public void call(final Object... args) {
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            String data = (String) args[0];
//                            Toast.makeText(MainActivity.this,data,Toast.LENGTH_SHORT).show();
//
//
//                        }
//                    });
//                }
//            });

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        /*
         * creating and handling the UI
         */
        // Taking the data from the text box and the button created in the xml.
        shareNameInput = (EditText) findViewById(R.id.InsertCompName);
        submitButton = (Button) findViewById(R.id.publishButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // changing the text from the text box to a string.
                companyShareName = shareNameInput.getText().toString();
            }
        });

    }
}

