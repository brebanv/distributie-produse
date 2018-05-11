
package com.mycompany.distributie.dst;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListaClienti {
    DBConex conex;
    private ResultSet rs;
    ArrayList<Client> clienti;

    public ListaClienti() {
        conex = new DBConex();
    }

    public ArrayList<Client> getClienti() {
        return clienti;
    }

    public void init() {
        try {
            conex = new DBConex();
            try (Statement smt = conex.con.createStatement()) {
                rs = smt.executeQuery("select * from CLIENT");
                clienti = new ArrayList<>();

                while (rs.next()) {
                    clienti.add(new Client(rs.getString("NUME"), rs.getString("ADRESA"), rs.getDouble("LATITUDE"), rs.getDouble("LONGITUDE")));
                }
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateSizeDB() throws SQLException {
        operatiiDB("ALTER TABLE CLIENT ALTER COLUMN nume varchar(255)");
    }
    
    public void modificaDB(Client client, Integer id) throws SQLException {
        operatiiDB("update CLIENT set NUME = '" + client.getNume() + "' where id=" + id);
        init();
    }

    public void stergeDB(Integer id) throws SQLException {
        operatiiDB("delete from CLIENT where id=" + id);
        init();
    }

    public void adaugaDB(Client client) throws SQLException {
        operatiiDB("insert into CLIENT(nume, adresa, latitude, longitude) "
                + "values('" + client.getNume() + "', '" + client.getAdresa() + "', " + client.getLatitude() + ", " + client.getLongitude() + ")");
        init();
    }

    private void operatiiDB(String comandaSQL) throws SQLException {
        try (Statement smt = conex.con.createStatement()) {
            System.out.println(comandaSQL);
            smt.executeUpdate(comandaSQL);
        }
    }
}
