package com.example.socketapp;


import android.os.AsyncTask;
import android.util.Log;


import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectSimpleServerTask extends AsyncTask<Void, Void, Void> {
    private Socket client;
    private PrintWriter printwriter;
    private String msg;

    ConnectSimpleServerTask(Socket client, String msg) {
        this.client = client;
        this.msg = msg;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            // TODO: change this to point to your mac machine :)
            client = new Socket("192.168.1.118", 8080);
            InputStreamReader streamReader = new InputStreamReader(client.getInputStream());

            printwriter = new PrintWriter(client.getOutputStream(),true);
            printwriter.write(msg);  // write the message to output stream

            printwriter.flush();
            printwriter.close();
            client.close();   // closing the connection

        }catch (Exception ex){
            ex.printStackTrace();
            Log.d("clientSocket", "Connection Failed.");
        }
        return null;
    }
}