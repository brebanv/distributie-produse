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

public class Distribuitor {

    int id;
    String nume;
    String adresa;
    double latitude;
    double longitude;

    public Distribuitor(String nume, String adresa) {
        this.nume = nume;
        this.adresa = adresa;
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

            HttpPost post = new HttpPost(basePath + "address=" + adresa + region + "&waypoints=Strada+Castanilor,Maramures" + googleKey);

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
        } catch (Exception e) {
        }

        JSONParser parser = new JSONParser();
        Object obj;
        obj = parser.parse(json);
        JSONObject jb = (JSONObject) obj;
        JSONArray routes = (JSONArray) jb.get("results");
        JSONObject jsonObject2 = (JSONObject) routes.get(0);
        JSONObject legs = (JSONObject) jsonObject2.get("geometry");
        JSONObject coordinate = (JSONObject) legs.get("viewport");
        JSONObject jsonObject5 = (JSONObject) coordinate.get("northeast");

        this.latitude = (Double) jsonObject5.get("lat");
        this.longitude = (Double) jsonObject5.get("lng");
    }

}
