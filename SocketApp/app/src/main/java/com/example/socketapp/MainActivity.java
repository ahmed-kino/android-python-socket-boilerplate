package com.example.socketapp;



import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class MainActivity extends Activity {

    private Socket client;
    private PrintWriter printwriter;
    private EditText textField;
    private Button button;
    private String msg;

    public void setUpNetworking(View view) {
        // getting the message from the text field
        msg = textField.getText().toString(); //get the text message on the text field
        textField.setText("");
        // connect to the local server
        new ConnectSimpleServerTask(client, msg).execute();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textField = (EditText) findViewById(R.id.etMessage); //reference to the text field
        button = (Button) findViewById(R.id.btnSend);   //reference to the send button


    }

}