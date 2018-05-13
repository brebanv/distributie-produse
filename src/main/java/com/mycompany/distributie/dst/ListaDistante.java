
package com.mycompany.distributie.dst;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListaDistante {
    
    private DBConex conex;
    private ResultSet rs;
    private ArrayList<Distanta> distantaPD;
    private ArrayList<Distanta> distantaDC;

    public ListaDistante() {
        conex = new DBConex();
    }

    public ArrayList<Distanta> getDistantaPD() {
        return distantaPD;
    }

    public ArrayList<Distanta> getDistantaDC() {
        return distantaDC;
    }

    

    public void init() {
        try {
            conex = new DBConex();
            try (Statement smt = conex.con.createStatement()) {
                rs = smt.executeQuery("select * from DISTANTE");
                distantaPD = new ArrayList<>();
                distantaDC = new ArrayList<>();

                while (rs.next()) {
                    distantaPD.add(new Distanta(rs.getInt("IDPRODUCATOR"), rs.getInt("IDDISTRIBUITOR"), rs.getInt("IDCLIENT"), rs.getInt("DISTANTAPD")));
                    distantaDC.add(new Distanta(rs.getInt("IDPRODUCATOR"), rs.getInt("IDDISTRIBUITOR"), rs.getInt("IDCLIENT"), rs.getInt("DISTANTADC")));
                }
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void creareDB() throws SQLException {
        operatiiDB("create table DISTANTE"
                + "    IDPRODUCATOR INTEGER not null,"
                + "	IDDISTRIBUITOR INTEGER not null,"
                + "	IDCLIENT INTEGER not null,"
                + "	DISTANTAPD INTEGER not null,"
                + "	DISTANTADC INTEGER not null"
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
        operatiiDB("insert into DISTANTE(nume, adresa, latitude, longitude) "
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
