/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.distributie.dst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vlad
 */
public class DBConex {
    
    Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public DBConex() {
        try {
            System.out.println("cevaaa");
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/distributie", "root", "root");
            System.out.println("---------------conexiune");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void finalize() {
        try {
            con.close();
            System.out.println("----------------inchidere conexiune");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
