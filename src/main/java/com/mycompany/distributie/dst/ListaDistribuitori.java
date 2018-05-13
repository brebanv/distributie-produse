package com.mycompany.distributie.dst;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListaDistribuitori {

    private DBConex conex;
    private ResultSet rs;
    private ArrayList<Distribuitor> distribuitori;

    public ListaDistribuitori() {
        conex = new DBConex();
    }

    public ArrayList<Distribuitor> getDistribuitori() {
        return distribuitori;
    }

    public void init() {
        try {
            conex = new DBConex();
            try (Statement smt = conex.con.createStatement()) {
                rs = smt.executeQuery("select * from DISTRIBUITOR");
                distribuitori = new ArrayList<>();

                while (rs.next()) {
                    distribuitori.add(new Distribuitor(rs.getString("NUME"), rs.getString("ADRESA"), rs.getDouble("LATITUDE"), rs.getDouble("LONGITUDE")));
                }
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void creareDB() throws SQLException {
        operatiiDB("create table DISTRIBUITOR"
                    + "(   ID INTEGER not null primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
                + "    NUME VARCHAR(255) not null,"
                + "	ADRESA VARCHAR(255) not null,"
                + "	LATITUDE DOUBLE not null,"
                + "	LONGITUDE DOUBLE not null"
                + ")");
    }
    
    public void modificaDB(Distribuitor distribuitor, Integer id) throws SQLException {
        operatiiDB("update DISTRIBUITOR set NUME = '" + distribuitor.getNume() + "' where id=" + id);
        init();
    }

    public void stergeDB(Integer id) throws SQLException {
        operatiiDB("delete from DISTRIBUITOR where id=" + id);
        init();
    }

    public void adaugaDB(Distribuitor distribuitor) throws SQLException {
        operatiiDB("insert into DISTRIBUITOR(nume, adresa, latitude, longitude) "
                + "values('" + distribuitor.getNume() + "', '" + distribuitor.getAdresa() + "', " + distribuitor.getLatitude() + ", " + distribuitor.getLongitude() + ")");
        init();
    }
    
    public void deleteAllRows() throws SQLException{
        operatiiDB("delete from DISTRIBUITOR where id > 0");
        init();
    }
    
    private void operatiiDB(String comandaSQL) throws SQLException {
        try (Statement smt = conex.con.createStatement()) {
            System.out.println(comandaSQL);
            smt.executeUpdate(comandaSQL);
        }
    }
}
