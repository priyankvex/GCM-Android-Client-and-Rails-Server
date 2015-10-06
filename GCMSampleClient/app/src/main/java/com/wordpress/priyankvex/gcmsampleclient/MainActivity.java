package com.wordpress.priyankvex.gcmsampleclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wordpress.priyankvex.gcmsampleclient.services.RegistrationAsyncTask;


public class MainActivity extends AppCompatActivity {

    // Widgets
    Button buttonRegister;
    EditText editTextSenderId;
    EditText editTextDeviceToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // finding views
        findViewsById();

        buttonRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Start the service to get the token and send it to app server.
                String senderId = editTextSenderId.getText().toString();
                new RegistrationAsyncTask(MainActivity.this).execute(senderId);
            }
        });
    }

    private void findViewsById(){
        buttonRegister = (Button) findViewById(R.id.button);
        editTextDeviceToken = (EditText) findViewById(R.id.editTextDeviceToken);
        editTextSenderId = (EditText) findViewById(R.id.editTextSenderId);
    }

    public void updateMessage(String deviceToken){
        editTextDeviceToken.setText(deviceToken);
    }
}
