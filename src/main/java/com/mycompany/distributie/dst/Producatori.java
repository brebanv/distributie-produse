package com.mycompany.distributie.dst;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Producatori {

    DBConex conex;
    private ResultSet rs;
    ArrayList <Producator> producatori;

    public Producatori() {
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
                    System.out.println(rs.getInt("ID") + rs.getString("NUME") + rs.getString("Adresa") + rs.getDouble("latitude") + rs.getDouble("longitude"));
                }
                rs.close();
            }
        } catch (SQLException ex) {
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

    private void operatiiDB(String comandaSQL) throws SQLException {
        try (Statement smt = conex.con.createStatement()) {
            System.out.println(comandaSQL);
            smt.executeUpdate(comandaSQL);
        }
    }
}
