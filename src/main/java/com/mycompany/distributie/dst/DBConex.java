package com.mycompany.distributie.dst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConex {
    
    Connection con;
    private static String dbURL = "jdbc:derby:distributie";

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public DBConex() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            con = DriverManager.getConnection(dbURL); 
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void finalize() {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
