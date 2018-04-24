/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.distributie.dst;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.painter.CompoundPainter;
import org.jxmapviewer.painter.Painter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.event.MouseInputListener;
import org.json.simple.parser.ParseException;

import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;

public class Interface extends javax.swing.JFrame {

    JXMapViewer mapViewer = new JXMapViewer();
    ArrayList<Distribuitor> distribuitori = new ArrayList<>();
    ArrayList<Client> clienti = new ArrayList<>();
    ArrayList<Producator> producatori = new ArrayList<>();
    
    String distProdDist = "";
    String distDistClient = "";
    Boolean prodDist = false;    

    public Interface() {
        initComponents();
        initInterface();
    }

    void initInterface() {
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        initComboBox();
    }

    void initComboBox() {
        Distribuitor d1 = new Distribuitor("Distribuitor 1", "Adresa Dist 1");
        Distribuitor d2 = new Distribuitor("Distribuitor 2", "Adresa Dist 2");
        Distribuitor d3 = new Distribuitor("Axa", "Str. Sperantei, 3, Baia Mare, Maramures");

        Client c1 = new Client("Client 1", "Adresa Client 1");
        Client c2 = new Client("Client 2", "Adresa Client 2");
        Client c3 = new Client("Max", "Strada Turbinei 39, Baia Mare");

        Producator p1 = new Producator(1, "Producator 1", "Adresa Producator 1");
        Producator p2 = new Producator(2, "Producator 2", "Adresa Producator 2");
        Producator p3 = new Producator(2, "Producator Local", "Chiuzbaia Nr 244 Maramures");

        distribuitori.add(d1);
        distribuitori.add(d2);
        distribuitori.add(d3);

        clienti.add(c1);
        clienti.add(c2);
        clienti.add(c3);

        producatori.add(p1);
        producatori.add(p2);
        producatori.add(p3);

        refreshComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldFrom = new javax.swing.JTextField();
        jTextFieldTo = new javax.swing.JTextField();
        jButtonTraseu = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelMap = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldAdaugaProducatorNume = new javax.swing.JTextField();
        jTextFieldAdaugaProducatorAdresa = new javax.swing.JTextField();
        jButtonAdaugaProducator = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldAdaugaDistNume = new javax.swing.JTextField();
        jTextFieldAdaugaDistAdresa = new javax.swing.JTextField();
        jButtonAdaugaDistribuitor = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldAdaugaClientNume = new javax.swing.JTextField();
        jTextFieldAdaugaClientAdresa = new javax.swing.JTextField();
        jButtonAdaugaClient = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxDistribuitori = new javax.swing.JComboBox<>();
        jComboBoxClienti = new javax.swing.JComboBox<>();
        jComboBoxProducatori = new javax.swing.JComboBox<>();
        jButtonDistribuitorClient = new javax.swing.JButton();
        jButtonProducatorDistribuitor = new javax.swing.JButton();
        jLabelDistantaProducatorDistribuitor = new javax.swing.JLabel();
        jLabeDistantalDistribuitorClient = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("De la:");

        jLabel2.setText("Pana la:");

        jTextFieldFrom.setText("Baia Mare");

        jTextFieldTo.setText("Baia Sprie");

        jButtonTraseu.setText("Traseu");
        jButtonTraseu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTraseuActionPerformed(evt);
            }
        });

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelMap.setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout jPanelMapLayout = new javax.swing.GroupLayout(jPanelMap);
        jPanelMap.setLayout(jPanelMapLayout);
        jPanelMapLayout.setHorizontalGroup(
            jPanelMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 594, Short.MAX_VALUE)
        );
        jPanelMapLayout.setVerticalGroup(
            jPanelMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Map", jPanelMap);

        jLabel7.setText("Nume");

        jLabel8.setText("Adresa");

        jTextFieldAdaugaProducatorNume.setText("Producator Local");

        jTextFieldAdaugaProducatorAdresa.setText("Chiuzbaia Nr 244 Maramures");

        jButtonAdaugaProducator.setText("Adauga");
        jButtonAdaugaProducator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdaugaProducatorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldAdaugaProducatorNume, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldAdaugaProducatorAdresa))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jButtonAdaugaProducator)))
                .addContainerGap(365, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldAdaugaProducatorNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldAdaugaProducatorAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonAdaugaProducator)
                .addContainerGap(329, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Adauga Producator", jPanel3);

        jLabel3.setText("Nume");

        jLabel4.setText("Adresa");

        jTextFieldAdaugaDistNume.setText("Axa");

        jTextFieldAdaugaDistAdresa.setText("Str. Sperantei, 3, Baia Mare, Maramures");

        jButtonAdaugaDistribuitor.setText("Adauga");
        jButtonAdaugaDistribuitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdaugaDistribuitorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldAdaugaDistNume, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonAdaugaDistribuitor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(471, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldAdaugaDistAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldAdaugaDistNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldAdaugaDistAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonAdaugaDistribuitor)
                .addContainerGap(329, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Adauga Distribuitor", jPanel1);

        jLabel5.setText("Nume");

        jLabel6.setText("Adresa");

        jTextFieldAdaugaClientNume.setText("Max");

        jTextFieldAdaugaClientAdresa.setText("Strada Turbinei 39, Baia Mare");

        jButtonAdaugaClient.setText("Adauga");
        jButtonAdaugaClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdaugaClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldAdaugaClientNume))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAdaugaClient, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAdaugaClientAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(361, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldAdaugaClientNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldAdaugaClientAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonAdaugaClient)
                .addContainerGap(329, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Adauga Client", jPanel2);

        jLabel10.setText("Distribuitor");

        jLabel11.setText("Client");

        jLabel12.setText("Producator");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(59, 59, 59))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxDistribuitori, 0, 173, Short.MAX_VALUE)
                            .addComponent(jComboBoxClienti, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxProducatori, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(352, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBoxProducatori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDistribuitori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBoxClienti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(300, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Afisare", jPanel4);

        jButtonDistribuitorClient.setText("Distribuitor Client");
        jButtonDistribuitorClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDistribuitorClientActionPerformed(evt);
            }
        });

        jButtonProducatorDistribuitor.setText("Producator Distribuitor");
        jButtonProducatorDistribuitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProducatorDistribuitorActionPerformed(evt);
            }
        });

        jLabelDistantaProducatorDistribuitor.setText("  ");

        jLabeDistantalDistribuitorClient.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonTraseu)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldFrom)
                                    .addComponent(jTextFieldTo, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(jButtonProducatorDistribuitor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonDistribuitorClient))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(89, 89, 89)
                                        .addComponent(jLabelDistantaProducatorDistribuitor, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(85, 85, 85)
                                        .addComponent(jLabeDistantalDistribuitorClient, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonProducatorDistribuitor)
                    .addComponent(jButtonDistribuitorClient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDistantaProducatorDistribuitor)
                    .addComponent(jLabeDistantalDistribuitorClient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonTraseu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    void deseneazaRuta(String p1, String p2) {
        mapViewer = new JXMapViewer();
        mapViewer.setBounds(0, 0, 600, 600);
        jPanelMap.add(mapViewer);
        jPanelMap.setSize(600, 800);

        // Create a TileFactoryInfo for OpenStreetMap
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        mapViewer.setTileFactory(tileFactory);

        Point from = new Point();
        Point to = new Point();

        try {
            from.getCoordinates(p1);
            to.getCoordinates(p2);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }

//      GeoPosition firstLocation = new GeoPosition(from.getLatitude(), from.getLongitude());
//      GeoPosition secondLocation = new GeoPosition(to.getLatitude(), to.getLongitude());
        // Create a track from the geo-positions
        Route route = new Route(p1, p2);
        ArrayList<String> routePath = new ArrayList<>();
        try {
            routePath = route.getRouteDetails();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(prodDist){
            distProdDist = route.getDistanta();
        } else {
            distDistClient = route.getDistanta();
        }
        
        List<LatLng> l = new ArrayList<>();

        for (int i = 0; i < routePath.size(); i++) {
            Path d = new Path(routePath.get(i));
            for (int j = 0; j < d.decode().size(); j++) {
                l.add(d.decode().get(j));
            }
        }

        List<GeoPosition> track = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            GeoPosition g = new GeoPosition(l.get(i).lat, l.get(i).lng);
            track.add(g);
        }

        RoutePainter routePainter = new RoutePainter(track);

        // Set the focus
        mapViewer.zoomToBestFit(new HashSet<>(track), 0.7);
        
        
        Object distribuitor = jComboBoxDistribuitori.getSelectedItem();
        try {
            ((Distribuitor) distribuitor).setCoordinates();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Create waypoints from the geo-positions
        Set<Waypoint> waypoints = new HashSet<>();
        GeoPosition g1 = new GeoPosition(from.getLatitude(), from.getLongitude());
        GeoPosition g2 = new GeoPosition(to.getLatitude(), to.getLongitude());
        
        GeoPosition g3 = new GeoPosition(((Distribuitor) distribuitor).latitude, ((Distribuitor) distribuitor).longitude); 
        
        waypoints.add(new DefaultWaypoint(g1));
        waypoints.add(new DefaultWaypoint(g2));
        waypoints.add(new DefaultWaypoint(g3));
        
        // Create a waypoint painter that takes all the waypoints
        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
        waypointPainter.setWaypoints(waypoints);

        // Add interactions
        addMouseInteractions();

        // Create a compound painter that uses both the route-painter and the waypoint-painter
        List<Painter<JXMapViewer>> painters = new ArrayList<Painter<JXMapViewer>>();
        painters.add(routePainter);
        painters.add(waypointPainter);

        CompoundPainter<JXMapViewer> painter = new CompoundPainter<JXMapViewer>(painters);
        mapViewer.setOverlayPainter(painter);
    }

    private void jButtonTraseuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraseuActionPerformed
        deseneazaRuta(jTextFieldFrom.getText(), jTextFieldTo.getText());
    }//GEN-LAST:event_jButtonTraseuActionPerformed

    private void addMouseInteractions() {
        MouseInputListener mia = new PanMouseInputListener(mapViewer);
        mapViewer.addMouseListener(mia);
        mapViewer.addMouseMotionListener(mia);
        mapViewer.addMouseListener(new CenterMapListener(mapViewer));
        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));
        mapViewer.addKeyListener(new PanKeyListener(mapViewer));
    }

    private void jButtonAdaugaDistribuitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdaugaDistribuitorActionPerformed
        Distribuitor distribuitor = new Distribuitor(jTextFieldAdaugaDistNume.getText(), jTextFieldAdaugaDistAdresa.getText());
        distribuitori.add(distribuitor);
        refreshComboBox();
    }//GEN-LAST:event_jButtonAdaugaDistribuitorActionPerformed

    private void jButtonAdaugaClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdaugaClientActionPerformed
        Client client = new Client(jTextFieldAdaugaClientNume.getText(), jTextFieldAdaugaClientAdresa.getText());
        clienti.add(client);
        refreshComboBox();
    }//GEN-LAST:event_jButtonAdaugaClientActionPerformed

    private void jButtonAdaugaProducatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdaugaProducatorActionPerformed
        Producator producator = new Producator(1, jTextFieldAdaugaProducatorNume.getText(), jTextFieldAdaugaProducatorAdresa.getText());
        producatori.add(producator);
        refreshComboBox();
    }//GEN-LAST:event_jButtonAdaugaProducatorActionPerformed

    private void jButtonDistribuitorClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDistribuitorClientActionPerformed
        prodDist = false;
        
        Object client = jComboBoxClienti.getSelectedItem();
        String valClient = ((Client) client).getAdresa();

        Object distribuitor = jComboBoxDistribuitori.getSelectedItem();
        String valDistribuitor = ((Distribuitor) distribuitor).getAdresa();

        System.out.println("De la " + valDistribuitor + " pana la " + valClient);
        deseneazaRuta(valDistribuitor, valClient);
        
        jLabeDistantalDistribuitorClient.setText(distDistClient);
    }//GEN-LAST:event_jButtonDistribuitorClientActionPerformed

    private void jButtonProducatorDistribuitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProducatorDistribuitorActionPerformed
        prodDist = true;
        
        Object producator = jComboBoxProducatori.getSelectedItem();
        String valProducator = ((Producator) producator).getAdresa();

        Object distribuitor = jComboBoxDistribuitori.getSelectedItem();
        String valDistribuitor = ((Distribuitor) distribuitor).getAdresa();
        
        
        deseneazaRuta(valProducator, valDistribuitor);
        
        jLabelDistantaProducatorDistribuitor.setText(distProdDist);
    }//GEN-LAST:event_jButtonProducatorDistribuitorActionPerformed

    void refreshComboBox() {
        jComboBoxClienti.removeAllItems();
        for (int i = clienti.size() - 1; i >= 0; i--) {
            jComboBoxClienti.addItem(clienti.get(i));
        }
        jComboBoxProducatori.removeAllItems();
        for (int i = producatori.size() - 1; i >= 0; i--) {
            jComboBoxProducatori.addItem(producatori.get(i));
        }
        jComboBoxDistribuitori.removeAllItems();
        for (int i = distribuitori.size() - 1; i >= 0; i--) {
            jComboBoxDistribuitori.addItem(distribuitori.get(i));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdaugaClient;
    private javax.swing.JButton jButtonAdaugaDistribuitor;
    private javax.swing.JButton jButtonAdaugaProducator;
    private javax.swing.JButton jButtonDistribuitorClient;
    private javax.swing.JButton jButtonProducatorDistribuitor;
    private javax.swing.JButton jButtonTraseu;
    private javax.swing.JComboBox<Client> jComboBoxClienti;
    private javax.swing.JComboBox<Distribuitor> jComboBoxDistribuitori;
    private javax.swing.JComboBox<Producator> jComboBoxProducatori;
    private javax.swing.JLabel jLabeDistantalDistribuitorClient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDistantaProducatorDistribuitor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelMap;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldAdaugaClientAdresa;
    private javax.swing.JTextField jTextFieldAdaugaClientNume;
    private javax.swing.JTextField jTextFieldAdaugaDistAdresa;
    private javax.swing.JTextField jTextFieldAdaugaDistNume;
    private javax.swing.JTextField jTextFieldAdaugaProducatorAdresa;
    private javax.swing.JTextField jTextFieldAdaugaProducatorNume;
    private javax.swing.JTextField jTextFieldFrom;
    private javax.swing.JTextField jTextFieldTo;
    // End of variables declaration//GEN-END:variables
}
