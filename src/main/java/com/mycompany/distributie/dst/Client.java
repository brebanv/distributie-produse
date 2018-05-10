package com.mycompany.distributie.dst;

import java.io.BufferedReader;
import java.io.IOException;
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

public class Client {

    String nume;
    String adresa;
    double latitude;
    double longitude;

    public Client(String nume, String adresa) {
        this.nume = nume;
        this.adresa = adresa;
    }

    public Client(String nume, String adresa, double latitude, double longitude) {
        this.nume = nume;
        this.adresa = adresa;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public String getNume() {
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    
    @Override
    public String toString() {
        return nume;
    }
    
    public void setCoordinates() throws UnsupportedEncodingException, ParseException {
        String adresa = URLEncoder.encode(this.adresa, "UTF-8");
        InputStream inputStream = null;
        String json = "";
        String basePath = "https://maps.google.com/maps/api/geocode/json?";
        String googleKey = "&key=AIzaSyAmFZVeNDgmAcVNFA1OHwhPBM4lKTHZsSc";
        String region = "&region=ro";

        try {
            HttpClient client = new DefaultHttpClient();
            String adresaURL = URLEncoder.encode(adresa, "UTF-8");
            HttpPost post = new HttpPost(basePath + "address=" + adresaURL + region + googleKey);
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            inputStream = entity.getContent();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"), 8);
            StringBuilder sbuild = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sbuild.append(line);
            }
            inputStream.close();
            json = sbuild.toString();
        } catch (IOException | UnsupportedOperationException e) {
        }

        JSONParser parser = new JSONParser();
        Object obj;
        obj = parser.parse(json);
        JSONObject jb = (JSONObject) obj;
        JSONArray routes = (JSONArray) jb.get("results");
        JSONObject jsonObject2 = (JSONObject) routes.get(0);
        JSONObject legs = (JSONObject) jsonObject2.get("geometry");
        JSONObject coordinate = (JSONObject) legs.get("location");

        this.latitude = (Double) coordinate.get("lat");
        this.longitude = (Double) coordinate.get("lng");
    }
}
