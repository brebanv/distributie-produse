package com.mycompany.distributie.dst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public class ListaDistante {

    private DBConex conex;
    private ResultSet rs;
    private ArrayList<Distanta> distante;

    public ListaDistante() {
        conex = new DBConex();
    }

    public ArrayList<Distanta> getDistante() {
        return distante;
    }

    public void init() {
        try {
            conex = new DBConex();
            try (Statement smt = conex.con.createStatement()) {
                rs = smt.executeQuery("select * from DISTANTE");
                distante = new ArrayList<>();

                while (rs.next()) {
                    distante.add(new Distanta(rs.getInt("IDPRODUCATOR"), rs.getInt("IDDISTRIBUITOR"), rs.getInt("IDCLIENT"), rs.getInt("DISTANTAPD"), rs.getInt("distantaDC")));
                }
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void creareDB() throws SQLException {
        operatiiDB("create table DISTANTE"
                + "(   ID INTEGER not null primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
                + "    IDPRODUCATOR INTEGER not null,"
                + "	IDDISTRIBUITOR INTEGER not null,"
                + "	IDCLIENT INTEGER not null,"
                + "	DISTANTAPD INTEGER not null,"
                + "	DISTANTADC INTEGER not null"
                + ")");
    }

//    public void modificaDB(Distanta distanta, Integer id) throws SQLException {
//        operatiiDB("update DISTRIBUITOR set NUME = '" + distanta.getNume() + "' where id=" + id);
//        init();
//    }
    public void stergeDB(Integer id) throws SQLException {
        operatiiDB("delete from DISTANTE where id=" + id);
        init();
    }

    public void adaugaDB(Distanta distanta) throws SQLException {
        operatiiDB("insert into DISTANTE(IDPRODUCATOR, IDDISTRIBUITOR, IDCLIENT, DISTANTAPD, DISTANTADC) "
                + "values(" + distanta.getIdProducator() + ", " + distanta.getIdDistribuitor() + ", " + distanta.getIdClient() + ", " + distanta.getDitantaPD() + ", " + distanta.getDitantaDC() + ")");
        init();
    }

    public void deleteAllRows() throws SQLException {
        operatiiDB("delete from DISTANTE where id > 0");
        init();
    }

    private void operatiiDB(String comandaSQL) throws SQLException {
        try (Statement smt = conex.con.createStatement()) {
            System.out.println(comandaSQL);
            smt.executeUpdate(comandaSQL);
        }
    }

    public ArrayList<Distanta> getDistances(ArrayList<Producator> producatori, ArrayList<Distribuitor> distribuitori, ArrayList<Client> clienti) throws UnsupportedEncodingException {
        String origins = "";
        String destinations = "";
        InputStream inputStream;
        String json = "";
        String basePath = "https://maps.googleapis.com/maps/api/distancematrix/json?";
        String googleKey = "&key=AIzaSyAmFZVeNDgmAcVNFA1OHwhPBM4lKTHZsSc";
        String region = "&region=ro";

        for (int i = 0; i < producatori.size(); i++) {
            origins += producatori.get(i).getLatitude() + "," + producatori.get(i).getLongitude() + "|";
        }
        for (int i = 0; i < distribuitori.size(); i++) {
            destinations += distribuitori.get(i).getLatitude() + "," + distribuitori.get(i).getLongitude() + "|";
        }
        
        origins = origins.substring(0, origins.length() - 1);
        destinations = destinations.substring(0, destinations.length() - 1);
        String url = basePath + "origins=" + URLEncoder.encode(origins, "UTF-8") + "&destinations=" + URLEncoder.encode(destinations, "UTF-8") + region + googleKey;

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
            JSONArray routes = (JSONArray) jb.get("rows");
            
            
            JSONObject jsonObject2 = (JSONObject) routes.get(0);
            JSONArray legs = (JSONArray) jsonObject2.get("elements");

            for (int i = 0; i < legs.size(); i++) {
                JSONObject elements = (JSONObject) legs.get(i);
                JSONObject distance = (JSONObject) elements.get("distance");
                Long distantaPD = (Long) distance.get("value");
                System.out.println(distantaPD);
            }

            
            JSONObject rows = (JSONObject) routes.get(1);
            JSONArray rows2 = (JSONArray) rows.get("elements");

            for (int i = 0; i < rows2.size(); i++) {
                JSONObject elements = (JSONObject) rows2.get(i);
                JSONObject distance = (JSONObject) elements.get("distance");
                Long distantaPD = (Long) distance.get("value");
                System.out.println(distantaPD);
            }

        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
