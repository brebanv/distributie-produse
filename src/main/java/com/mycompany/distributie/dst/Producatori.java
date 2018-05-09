package com.mycompany.distributie.dst;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Producatori {

    DBConex conex;
    private ResultSet rs;
    List<Producator> producatori;

    public Producatori() {
        conex = new DBConex();
    }

    public void init() {
        try {
            conex = new DBConex();
            try (Statement smt = conex.con.createStatement()) {
                rs = smt.executeQuery("select * from PRODUCATOR");
                producatori = new ArrayList<>();

                while (rs.next()) {
                    producatori.add(new Producator(rs.getInt("ID"), rs.getString("NUME"), rs.getString("Adresa"), rs.getDouble("latitude"), rs.getDouble("longitude")));
                    System.out.println(rs.getInt("ID") + rs.getString("NUME") + rs.getString("Adresa") + rs.getDouble("latitude") + rs.getDouble("longitude"));
                }
                rs.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void modifica(Producator producator) throws SQLException {
        operatiiBD("update PRODUCATOR set NUME = '" + producator.getNume() + "' where id=" + producator.getId());
    }

    public void sterge(Producator producator) throws SQLException {
        operatiiBD("delete from PRODUCATOR where id=" + producator.getId());
        init();
    }

    public void adauga(Producator producator) throws SQLException {
        operatiiBD("insert into PRODUCATOR(nume, adresa, latitude, longitude) "
                + "values('" + producator.getNume() + "', '" + producator.getAdresa() + "', " + producator.getLatitude() + ", " + producator.getLongitude() + ")");
        init();
    }

    private void operatiiBD(String comandaSQL) throws SQLException {
        Statement smt = conex.con.createStatement();
        System.out.println(comandaSQL);
        smt.executeUpdate(comandaSQL);
        smt.close();
    }
}
