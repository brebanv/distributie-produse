/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.distributie.dst;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Vlad
 */
public class Route {
    
    String fromLocation;
    String toLocation;
    String basePath = "https://maps.googleapis.com/maps/api/directions/json?";
    String googleKey = "&key=AIzaSyAmFZVeNDgmAcVNFA1OHwhPBM4lKTHZsSc";
    String region = "&region=ro";
    String optimize = "&waypoints=optimize:true";
    String waypoint = "";
    Long distanta;
    double latWaypoint;
    double lngWaypoint;

    public Route(String fromLocation, String toLocation) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public Long getDistanta() {
        return distanta;
    }    

    public void setWaypoint(String waypoint) throws UnsupportedEncodingException {
        this.waypoint = "&waypoints=" + URLEncoder.encode(waypoint, "UTF-8");;
    }

    public String getWaypoint() {
        return waypoint;
    }

    
    public ArrayList<String> getRouteDetailsWithWayPoints() throws UnsupportedEncodingException{
        
        ArrayList<String> resultPath = new ArrayList<>();
        InputStream inputStream = null;
        String json = "";

        fromLocation = URLEncoder.encode(fromLocation, "UTF-8");
        toLocation = URLEncoder.encode(toLocation, "UTF-8");
        try {
            HttpClient client = new DefaultHttpClient();

            HttpPost post = new HttpPost(basePath + "origin=" + fromLocation + "&destination="+ toLocation + region + waypoint +  googleKey);
            System.out.println(basePath + "origin=" + fromLocation + "&destination="+ toLocation + region + waypoint +  googleKey);
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
            JSONArray routes = (JSONArray) jb.get("routes");
            JSONObject jsonObject2 = (JSONObject) routes.get(0);
            JSONArray legs = (JSONArray) jsonObject2.get("legs");
            
            JSONObject jsonObject4 = (JSONObject) legs.get(0);
            JSONObject jsonObject10 = (JSONObject) legs.get(1);
            
            JSONObject distanta1 = (JSONObject) jsonObject4.get("distance");
            JSONObject distanta2 = (JSONObject) jsonObject10.get("distance");
            
            JSONArray jsonObject5 = (JSONArray) jsonObject4.get("steps");  
            JSONArray jsonObject11 = (JSONArray) jsonObject10.get("steps"); 
            
            System.out.println((Long) distanta1.get("value"));
            System.out.println((Long) distanta2.get("value"));
            
            Long distantaTotala = ((Long) distanta1.get("value") + (Long) distanta2.get("value"));
            
            this.distanta = distantaTotala;
                        
            for (int i = 0; i < jsonObject5.size(); i++) {
                JSONObject jsonObject6 = (JSONObject) jsonObject5.get(i);
                JSONObject jsonObject7 = (JSONObject) jsonObject6.get("polyline");
                resultPath.add((String) jsonObject7.get("points"));
            }
            for (int i = 0; i < jsonObject11.size(); i++) {
                JSONObject jsonObject6 = (JSONObject) jsonObject11.get(i);
                JSONObject jsonObject7 = (JSONObject) jsonObject6.get("polyline");
                resultPath.add((String) jsonObject7.get("points"));
            }
            return resultPath;
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
