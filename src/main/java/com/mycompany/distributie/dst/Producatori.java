/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.distributie.dst;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vlad
 */
public class Producatori {

    DBConex conex;
    private ResultSet rs;
    private List<Producator> producatori;

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
                    producatori.add(new Producator(rs.getInt("ID"), rs.getString("NUME"), rs.getString("Adresa"), rs.getDouble("latitudine"), rs.getDouble("longitudine")));
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
        operatiiBD("insert into PRODUCATOR(nume, adresa, latitudine, longitudine) "
                + "values(" + producator.getNume() + ", " + producator.getAdresa()+ ", " + producator.getLatitude()+ ", '" + producator.getLongitude()+ "')");
        //producator.setNume("");
        init();
    }

    private void operatiiBD(String comandaSQL) throws SQLException {
        Statement smt = conex.con.createStatement();
        System.out.println(comandaSQL);
        smt.executeUpdate(comandaSQL);
        smt.close();
    }
}
