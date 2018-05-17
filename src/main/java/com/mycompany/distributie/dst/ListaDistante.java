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

    private DBConex conex;
    private ResultSet rs;
    private ArrayList<DistantaPD> listDistancePDs;
    private ArrayList<DistantaDC> listDistanceDCs;
    private ArrayList<Distanta> distante;
    private ArrayList<Long> distantePD;
    private ArrayList<Long> distanteDC;

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

        for (int i = 0; i < distantePD.size(); i++) {
            System.out.println(distantePD.get(i));
        }
        System.out.println("");
        for (int i = 0; i < distanteDC.size(); i++) {
            System.out.println(distanteDC.get(i));
        }
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
            for (int i = 0; i < producatori.size(); i++) {
                for (int j = 0; j < distribuitori.size(); j++) {
                    DistantaPD d = new DistantaPD(i, j, distantePD.get(i + j));
                    listDistancePDs.add(d);
                }
            }
        });
        pd.start();
        Thread dc = new Thread(() -> {
            for (int i = 0; i < distribuitori.size(); i++) {
                for (int j = 0; j < clienti.size(); j++) {
                    DistantaDC d = new DistantaDC(i, j, distanteDC.get(i + j));
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
                if(listDistanceDC.idDistribuitor != listDistancePD.idDistribuitor){
                    continue;
                }
                long distance = listDistancePD.distance + listDistanceDC.distance;
                if (distance < minDistance) {
                    minDistance = distance;
                    waypointId = listDistanceDC.getIdDistribuitor();
                }
            }
        }

        Distribuitor fastestDistributor = distribuitori.get(waypointId);
        System.out.println("Fastest Distributor " + fastestDistributor.toString());
        System.out.println(minDistance);
        return waypointId;
    }

}
