package com.example.application.data.widget.mywidgets;

import com.example.application.data.widget.Widget;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;

public class MeteoWidget extends Widget {

    H2 h11;
    H1 h12;
    Image img;

    public MeteoWidget() {
        super();
        try {
            URL url = new URL(
                    "https://api.openweathermap.org/data/2.5/weather?q=Montpellier&APPID=9ba88132de7df76aabe5cf83054bf3e0");

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
                System.out.println(json.toString());
                in.close();
                // Show the output
                h11 = new H2(json.get("name").toString());
                l.add(h11);
                JSONObject j = (JSONObject) json.get("main");
                double temp = Double.valueOf(j.get("temp").toString()) - 273.15;
                DecimalFormat df = new DecimalFormat("#");
                h12 = new H1(String.valueOf(df.format(temp)) + "c°");
                l.add(h12);
                JSONArray weather = (JSONArray) json.get("weather");
                System.out.println("weather");
                System.out.println(weather);
                
                JSONObject zero = (JSONObject) weather.get(0);
                System.out.println("zero");
                System.out.println(zero);
                JSONObject zeroparse = (JSONObject) parser.parse(zero.toString());
                System.out.println("zeroparse");
                System.out.println(zeroparse.getClass());
                String icon =  (String) zeroparse.get("icon");
                System.out.println("icon");
                System.out.println(icon.toString());
                img = new Image("http://openweathermap.org/img/wn/"+icon.toString()+"@2x.png","icon");
                l.add(img);
            } else {
                System.out.println("Error found !!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
