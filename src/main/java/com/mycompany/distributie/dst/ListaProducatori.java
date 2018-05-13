package com.mycompany.distributie.dst;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListaProducatori {

    private DBConex conex;
    private ResultSet rs;
    private ArrayList<Producator> producatori;

    public ListaProducatori() {
        conex = new DBConex();
    }

    public ArrayList<Producator> getProducatori() {
        return producatori;
    }

    public void init() {
        try {
            conex = new DBConex();
            try (Statement smt = conex.con.createStatement()) {
                rs = smt.executeQuery("select * from PRODUCATOR");
                producatori = new ArrayList<>();

                while (rs.next()) {
                    producatori.add(new Producator(rs.getString("NUME"), rs.getString("Adresa"), rs.getDouble("latitude"), rs.getDouble("longitude")));
                }
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void modificaDB(Producator producator, Integer id) throws SQLException {
        operatiiDB("update PRODUCATOR set NUME = '" + producator.getNume() + "' where id=" + id);
    }

    public void stergeDB(Integer id) throws SQLException {
        operatiiDB("delete from PRODUCATOR where id=" + id);
        init();
    }

    public void adaugaDB(Producator producator) throws SQLException {
        operatiiDB("insert into PRODUCATOR(nume, adresa, latitude, longitude) "
                + "values('" + producator.getNume() + "', '" + producator.getAdresa() + "', " + producator.getLatitude() + ", " + producator.getLongitude() + ")");
        init();
    }
    
    public void deleteAllRows() throws SQLException{
        operatiiDB("delete from PRODUCATOR where id > 0");
        init();
    }
    
    private void operatiiDB(String comandaSQL) throws SQLException {
        try (Statement smt = conex.con.createStatement()) {
            System.out.println(comandaSQL);
            smt.executeUpdate(comandaSQL);
        }
    }
}
