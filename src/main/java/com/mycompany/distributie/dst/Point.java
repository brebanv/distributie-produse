package com.mycompany.distributie.dst;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Point {

    public double latitude;
    public double longitude;

    public Point() {
    }

    public Point(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    String basePath = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    String googleKey = "&key=AIzaSyAmFZVeNDgmAcVNFA1OHwhPBM4lKTHZsSc";

    public void getCoordinates(String loc) throws UnsupportedEncodingException {
        InputStream inputStream = null;
        String json = "";

        loc = URLEncoder.encode(loc, "UTF-8");
        try {
            HttpClient client = new DefaultHttpClient();

            HttpPost post = new HttpPost(basePath + loc + googleKey);

            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            inputStream = entity.getContent();
        } catch (Exception e) {
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"), 8);
            StringBuilder sbuild = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sbuild.append(line);
            }
            inputStream.close();
            json = sbuild.toString();
        } catch (Exception e) {
        }

        //now parse
        JSONParser parser = new JSONParser();
        Object obj;
        try {
            //now read
            obj = parser.parse(json);
            JSONObject jb = (JSONObject) obj;
            JSONArray jsonObject1 = (JSONArray) jb.get("results");
            JSONObject jsonObject2 = (JSONObject) jsonObject1.get(0);
            JSONObject jsonObject3 = (JSONObject) jsonObject2.get("geometry");
            JSONObject location = (JSONObject) jsonObject3.get("location");

            setLatitude((double) location.get("lat"));
            setLongitude((double) location.get("lng"));
        } catch (ParseException ex) {
            System.out.println(ex);
        }
    }

}
