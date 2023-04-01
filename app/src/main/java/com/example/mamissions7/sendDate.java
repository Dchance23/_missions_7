package com.example.mamissions7;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class sendDate extends AsyncTask<String, Void, Void> {
    @Override
    protected Void doInBackground(String... strings) {
        try {

            URL url = new URL("http://localhost/ApiFourmiDisp/Disp.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //Ajouter des paramètres à la requête
            String requestBody = "codeEquipe=" + strings[0] + "&Jour=" + strings[2] + "&HeureDebut=" + strings[1] + "&HeureFin=" + strings[3];
            OutputStream outputStream = conn.getOutputStream();
            outputStream.write(requestBody.getBytes());
            outputStream.flush();
            outputStream.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  null ;
    }
}
