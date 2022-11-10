package com.example.application.data.widget.mywidgets;

import com.example.application.data.widget.Widget;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JokeWidget extends Widget {
    private boolean refresh = false;
H2 h21;
H2 h22;
    public JokeWidget() {
        super();

        // Show the output
        JSONObject json = getBlague();
        h21 = new H2(json.get("setup").toString());
        l.add(h21);
        h22 = new H2(json.get("punchline").toString());
        l.add(h22);
        l.add(new Button("new joke", event -> this.refresh = true));
    }

    private JSONObject getBlague(){
        try {
            URL url = new URL("https://official-joke-api.appspot.com/random_joke");

            // Creating an HTTP connection
            HttpURLConnection MyConn = (HttpURLConnection) url.openConnection();

            // Set the request method to "GET"
            MyConn.setRequestMethod("GET");

            // Collect the response code
            int responseCode = MyConn.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == MyConn.HTTP_OK) {
                // Create a reader with the input stream reader.
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        MyConn.getInputStream()));
                // Create a string buffer
                StringBuilder sb = new StringBuilder();
                String readLine;
                while ((readLine = in.readLine()) != null) {
                    sb.append(readLine);
                }
                // Write each of the input line
                JSONParser parser = new JSONParser(); 
                JSONObject json = (JSONObject) parser.parse(sb.toString());
                in.close();
                return json;
                
    }else
    {
        System.out.println("Error found !!!");
        return null;
    }}catch(Exception e)
    {
            System.out.println(e);
        }
        return null;}

    @Override
    public void refresh() {
        if (refresh) {
            JSONObject json = getBlague();
            h21.setText(json.get("setup").toString());
            h22.setText(json.get("punchline").toString());
            refresh = false;
        }
    }
}
