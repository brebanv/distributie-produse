package com.mycompany.distributie.dst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ListaDistante {

    private ArrayList<DistantaPD> listDistancePDs;
    private ArrayList<DistantaDC> listDistanceDCs;
    private ArrayList<Long> distantePD;
    private ArrayList<Long> distanteDC;

    public ListaDistante() {
    }

    public ArrayList<Distanta> getDistances(ArrayList<Producator> producatori, ArrayList<Distribuitor> distribuitori, ArrayList<Client> clienti) throws UnsupportedEncodingException, InterruptedException {
        String puncteProd = "";
        String puncteDist = "";
        String puncteClient = "";
        for (int i = 0; i < producatori.size(); i++) {
            puncteProd += producatori.get(i).getLatitude() + "," + producatori.get(i).getLongitude() + "|";
        }
        for (int i = 0; i < distribuitori.size(); i++) {
            puncteDist += distribuitori.get(i).getLatitude() + "," + distribuitori.get(i).getLongitude() + "|";
        }
        for (int i = 0; i < clienti.size(); i++) {
            puncteClient += clienti.get(i).getLatitude() + "," + clienti.get(i).getLongitude() + "|";
        }
        puncteProd = puncteProd.substring(0, puncteProd.length() - 1);
        puncteDist = puncteDist.substring(0, puncteDist.length() - 1);
        puncteClient = puncteClient.substring(0, puncteClient.length() - 1);
        String p = puncteProd;
        String d = puncteDist;
        String c = puncteClient;

        Thread getProdDist = new Thread(() -> {
            try {
                distantePD = doDistanceMatrixRequest(p, d);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ListaDistante.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        getProdDist.start();

        Thread getDistClient = new Thread(() -> {
            try {
                distanteDC = doDistanceMatrixRequest(d, c);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ListaDistante.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        getDistClient.start();
        getProdDist.join();
        getDistClient.join();
        return null;
    }

    private ArrayList<Long> doDistanceMatrixRequest(String origins, String destinations) throws UnsupportedEncodingException {
        ArrayList<Long> distances = new ArrayList<>();
        String basePath = "https://maps.googleapis.com/maps/api/distancematrix/json?";
        String googleKey = "&key=AIzaSyAmFZVeNDgmAcVNFA1OHwhPBM4lKTHZsSc";
        String region = "&region=ro";
        InputStream inputStream;
        String json = "";
        String url = basePath + "origins=" + URLEncoder.encode(origins, "UTF-8") + "&destinations=" + URLEncoder.encode(destinations, "UTF-8") + region + googleKey;
        System.out.println(url);
        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(url);
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
        try {
            obj = parser.parse(json);
            JSONObject jb = (JSONObject) obj;
            JSONArray rowsRoot = (JSONArray) jb.get("rows");
            for (int i = 0; i < rowsRoot.size(); i++) {
                JSONObject rowsIndex = (JSONObject) rowsRoot.get(i);
                JSONArray elements = (JSONArray) rowsIndex.get("elements");
                for (int j = 0; j < elements.size(); j++) {
                    JSONObject element = (JSONObject) elements.get(j);
                    JSONObject distance = (JSONObject) element.get("distance");
                    Long distantaPD = (Long) distance.get("value");
                    distances.add(distantaPD);
                }
            }
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return distances;
    }

    public Integer getFastestRoute(ArrayList<Producator> producatori, ArrayList<Distribuitor> distribuitori, ArrayList<Client> clienti, Integer idProducator, Integer idClient) throws InterruptedException {
        listDistancePDs = new ArrayList<>();
        listDistanceDCs = new ArrayList<>();
        Integer waypointId = -1;
        Thread pd = new Thread(() -> {
            int k = 0;
            for (int i = 0; i < producatori.size(); i++) {
                for (int j = 0; j < distribuitori.size(); j++) {
                    DistantaPD d = new DistantaPD(i, j, distantePD.get(k++));
                    listDistancePDs.add(d);
                }
            }
        });
        pd.start();
        Thread dc = new Thread(() -> {
            int k = 0;
            for (int i = 0; i < distribuitori.size(); i++) {
                for (int j = 0; j < clienti.size(); j++) {
                    DistantaDC d = new DistantaDC(i, j, distanteDC.get(k++));
                    listDistanceDCs.add(d);
                }
            }
        });
        dc.start();
        pd.join();
        dc.join();

        Long minDistance = Long.MAX_VALUE;
        for (DistantaPD listDistancePD : listDistancePDs) {
            if (listDistancePD.idProducator != idProducator) {
                continue;
            }
            for (DistantaDC listDistanceDC : listDistanceDCs) {
                if (listDistanceDC.idClient != idClient) {
                    continue;
                }
                if (listDistancePD.idDistribuitor != listDistanceDC.idDistribuitor) {
                    continue;
                }
                long distance = listDistancePD.distance + listDistanceDC.distance;
                if (distance < minDistance) {
                    minDistance = distance;
                    waypointId = listDistanceDC.getIdDistribuitor();
                }
            }
        }
        return waypointId;
    }

}
