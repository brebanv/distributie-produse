package com.mycompany.distributie.dst;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.event.MouseInputListener;
import org.json.simple.parser.ParseException;

import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;

public final class Interface extends javax.swing.JFrame {

    JXMapViewer mapViewer = new JXMapViewer();
    ArrayList<Distribuitor> distribuitori = new ArrayList<>();
    ArrayList<Client> clienti = new ArrayList<>();
    ArrayList<Producator> producatori = new ArrayList<>();
    String distantaRuta = "";
    Boolean prodDist = true;
    ImageIcon imageIcon;

    public Interface() {
        initComponents();
        initInterface();
    }

    void initInterface() {
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Your Distribution");
        initComboBox();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("loading.png"));
        } catch (IOException e) {
        }

        jLabelLoadingAdaugaProducator.setVisible(false);
        jLabelLoadingAdaugaClient.setVisible(false);
        jLabelLoadingAdaugaDistribuitor.setVisible(false);
        Image dimg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(dimg);

        // Create a TileFactoryInfo for OpenStreetMap
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        mapViewer.setTileFactory(tileFactory);

        // Add interactions
        addMouseInteractions();
    }

    void initComboBox() {
        ListaProducatori listaProducatori = new ListaProducatori();
        listaProducatori.init();

        producatori = listaProducatori.getProducatori();

        ListaDistribuitori listaDistribuitori = new ListaDistribuitori();
        listaDistribuitori.init();

        distribuitori = listaDistribuitori.getDistribuitori();

        ListaClienti listaClienti = new ListaClienti();
        listaClienti.init();

        clienti = listaClienti.getClienti();

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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelMap = new javax.swing.JPanel();
        jLabelLoading = new javax.swing.JLabel();
        jPanelAdaugaProducator = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldAdaugaProducatorNume = new javax.swing.JTextField();
        jTextFieldAdaugaProducatorAdresa = new javax.swing.JTextField();
        jButtonAdaugaProducator = new javax.swing.JButton();
        jLabelLoadingAdaugaProducator = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldAdaugaDistNume = new javax.swing.JTextField();
        jTextFieldAdaugaDistAdresa = new javax.swing.JTextField();
        jButtonAdaugaDistribuitor = new javax.swing.JButton();
        jLabelLoadingAdaugaDistribuitor = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldAdaugaClientNume = new javax.swing.JTextField();
        jTextFieldAdaugaClientAdresa = new javax.swing.JTextField();
        jButtonAdaugaClient = new javax.swing.JButton();
        jLabelLoadingAdaugaClient = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabelDistanta = new javax.swing.JLabel();
        jButtonTraseuTotal = new javax.swing.JButton();
        jLabelTraseuOptim = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxProducatori = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxDistribuitori = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxClienti = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelMap.setPreferredSize(new java.awt.Dimension(800, 800));

        jLabelLoading.setText(" ");

        javax.swing.GroupLayout jPanelMapLayout = new javax.swing.GroupLayout(jPanelMap);
        jPanelMap.setLayout(jPanelMapLayout);
        jPanelMapLayout.setHorizontalGroup(
            jPanelMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMapLayout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLabelLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
        );
        jPanelMapLayout.setVerticalGroup(
            jPanelMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMapLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabelLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Map", jPanelMap);

        jLabel7.setText("Nume");

        jLabel8.setText("Adresa");

        jButtonAdaugaProducator.setText("Adauga");
        jButtonAdaugaProducator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdaugaProducatorActionPerformed(evt);
            }
        });

        jLabelLoadingAdaugaProducator.setText("Loading ...");

        javax.swing.GroupLayout jPanelAdaugaProducatorLayout = new javax.swing.GroupLayout(jPanelAdaugaProducator);
        jPanelAdaugaProducator.setLayout(jPanelAdaugaProducatorLayout);
        jPanelAdaugaProducatorLayout.setHorizontalGroup(
            jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdaugaProducatorLayout.createSequentialGroup()
                .addGroup(jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelAdaugaProducatorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelAdaugaProducatorLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldAdaugaProducatorNume, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelAdaugaProducatorLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldAdaugaProducatorAdresa))))
                    .addGroup(jPanelAdaugaProducatorLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jButtonAdaugaProducator, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelLoadingAdaugaProducator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(484, Short.MAX_VALUE))
        );
        jPanelAdaugaProducatorLayout.setVerticalGroup(
            jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdaugaProducatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldAdaugaProducatorNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldAdaugaProducatorAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelLoadingAdaugaProducator, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdaugaProducator))
                .addContainerGap(459, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Adauga Producator", jPanelAdaugaProducator);

        jLabel3.setText("Nume");

        jLabel4.setText("Adresa");

        jButtonAdaugaDistribuitor.setText("Adauga");
        jButtonAdaugaDistribuitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdaugaDistribuitorActionPerformed(evt);
            }
        });

        jLabelLoadingAdaugaDistribuitor.setText("Loading...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldAdaugaDistNume, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldAdaugaDistAdresa))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jButtonAdaugaDistribuitor, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelLoadingAdaugaDistribuitor)))
                .addContainerGap(486, Short.MAX_VALUE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdaugaDistribuitor)
                    .addComponent(jLabelLoadingAdaugaDistribuitor))
                .addContainerGap(459, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Adauga Distribuitor", jPanel1);

        jLabel5.setText("Nume");

        jLabel6.setText("Adresa");

        jButtonAdaugaClient.setText("Adauga");
        jButtonAdaugaClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdaugaClientActionPerformed(evt);
            }
        });

        jLabelLoadingAdaugaClient.setText("Loading...");

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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jButtonAdaugaClient, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelLoadingAdaugaClient, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 8, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldAdaugaClientAdresa)))))
                .addContainerGap(482, Short.MAX_VALUE))
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
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdaugaClient)
                    .addComponent(jLabelLoadingAdaugaClient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(456, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Adauga Client", jPanel2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(781, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addContainerGap(538, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Afisare", jPanel4);

        jLabelDistanta.setText("  ");

        jButtonTraseuTotal.setText("Traseu");
        jButtonTraseuTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTraseuTotalActionPerformed(evt);
            }
        });

        jLabelTraseuOptim.setText("  ");

        jLabel12.setText("Producator");

        jLabel10.setText("Distribuitor");

        jLabel11.setText("Client");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTraseuOptim, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxDistribuitori, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(jButtonTraseuTotal))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxClienti, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxProducatori, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDistanta, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxProducatori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDistribuitori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jButtonTraseuTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTraseuOptim)
                    .addComponent(jComboBoxClienti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(9, 9, 9)
                .addComponent(jLabelDistanta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prepareMap() {
        mapViewer.removeAll();
        mapViewer.setBounds(0, 0, 800, 600);
        jPanelMap.add(mapViewer);
        jPanelMap.setSize(600, 800);
    }

    void deseneazaRuta(String p1, String p2) throws MalformedURLException {
        addLoading();
        Point from = new Point();
        Point to = new Point();
        try {
            from.getCoordinates(p1);
            to.getCoordinates(p2);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Create a track from the geo-positions
        Route route = new Route(p1, p2);

        Object distribuitor = jComboBoxDistribuitori.getSelectedItem();
        String wayPoint = "";
        try {
            ((Distribuitor) distribuitor).setCoordinates();
            wayPoint = ((Distribuitor) distribuitor).getAdresa();
            route.setWaypoint(((Distribuitor) distribuitor).getAdresa());
            wayPoint = route.getWaypoint();
        } catch (UnsupportedEncodingException | ParseException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<String> routeStringPath = new ArrayList<>();
        try {
            routeStringPath = route.getRouteDetailsWithWayPoints();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }

        jLabelDistanta.setText(Long.toString((long) (route.getDistanta() * 0.001)) + " km");

        List<Point> l = new ArrayList<>();
        for (int i = 0; i < routeStringPath.size(); i++) {
            Path d = new Path(routeStringPath.get(i));
            for (int j = 0; j < d.decode().size(); j++) {
                l.add(d.decode().get(j));
            }
        }

        List<GeoPosition> track = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            GeoPosition g = new GeoPosition(l.get(i).latitude, l.get(i).longitude);
            track.add(g);
        }

        RoutePainter routePainter = new RoutePainter(track);
        prepareMap();
        mapViewer.zoomToBestFit(new HashSet<>(track), 0.7);
        deseneazaWayponts(from, to, (Distribuitor) distribuitor, routePainter);
        removeLoading();
    }

    void deseneazaRutaCuPuncte(Point start, Point mijloc, Point stop) throws MalformedURLException {
        addLoading();

        //Create a track from the geo-positions
        Route route = new Route(start, mijloc, stop);

        ArrayList<String> routeStringPath = new ArrayList<>();
        try {
            routeStringPath = route.getRouteDetails();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }

        jLabelDistanta.setText(Long.toString((long) (route.getDistanta() * 0.001)) + " km");

        List<Point> l = new ArrayList<>();
        for (int i = 0; i < routeStringPath.size(); i++) {
            Path d = new Path(routeStringPath.get(i));
            for (int j = 0; j < d.decode().size(); j++) {
                l.add(d.decode().get(j));
            }
        }

        List<GeoPosition> track = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            GeoPosition g = new GeoPosition(l.get(i).latitude, l.get(i).longitude);
            track.add(g);
        }

//        RoutePainter routePainter = new RoutePainter(track);
//        prepareMap();
//        mapViewer.zoomToBestFit(new HashSet<>(track), 0.7);
//        deseneazaWayponts(from, to, (Distribuitor) distribuitor, routePainter);
//        removeLoading();
    }

    private void deseneazaWayponts(Point from, Point to, Distribuitor distribuitor, RoutePainter routePainter) {
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

        // Create a compound painter that uses both the route-painter and the waypoint-painter
        List<Painter<JXMapViewer>> painters = new ArrayList<>();
        painters.add(routePainter);
        painters.add(waypointPainter);

        CompoundPainter<JXMapViewer> painter = new CompoundPainter<>(painters);
        mapViewer.setOverlayPainter(painter);
    }

    private void addMouseInteractions() {
        MouseInputListener mia = new PanMouseInputListener(mapViewer);
        mapViewer.addMouseListener(mia);
        mapViewer.addMouseMotionListener(mia);
        mapViewer.addMouseListener(new CenterMapListener(mapViewer));
        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));
        mapViewer.addKeyListener(new PanKeyListener(mapViewer));
    }

    private void jButtonTraseuTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraseuTotalActionPerformed
        System.out.println(jComboBoxProducatori.getSelectedIndex() + " " + jComboBoxDistribuitori.getSelectedIndex() + " " + jComboBoxClienti.getSelectedIndex());
        Point start = new Point(producatori.get(jComboBoxProducatori.getSelectedIndex()).getLatitude(), producatori.get(jComboBoxProducatori.getSelectedIndex()).getLongitude());
        Point mijloc = new Point(distribuitori.get(jComboBoxDistribuitori.getSelectedIndex()).getLatitude(), distribuitori.get(jComboBoxDistribuitori.getSelectedIndex()).getLongitude());
        Point stop = new Point(clienti.get(jComboBoxClienti.getSelectedIndex()).getLatitude(), clienti.get(jComboBoxClienti.getSelectedIndex()).getLongitude());
        try {
            deseneazaRutaCuPuncte(start, mijloc, stop);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
//        Object producator = jComboBoxProducatori.getSelectedItem();
//        String valProducator = ((Producator) producator).getAdresa();
//
//        Object client = jComboBoxClienti.getSelectedItem();
//        String valClient = ((Client) client).getAdresa();
//        new Thread(() -> {
//            try {
//                deseneazaRuta(valProducator, valClient);
//            } catch (MalformedURLException ex) {
//                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }).start();

    }//GEN-LAST:event_jButtonTraseuTotalActionPerformed

    private void jButtonAdaugaClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdaugaClientActionPerformed
        jLabelLoadingAdaugaClient.setVisible(true);
        new Thread(() -> {
            try {
                Client c = new Client(jTextFieldAdaugaClientNume.getText(), jTextFieldAdaugaClientAdresa.getText());
                c.setCoordinates();
                Client client = new Client(c.getNume(), c.getAdresa(), c.getLatitude(), c.getLongitude());
                ListaClienti listaClienti = new ListaClienti();
                try {
                    listaClienti.adaugaDB(client);
                } catch (SQLException ex) {
                    Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
                clienti.add(client);
                listaClienti.init();
                refreshComboBox();
                jLabelLoadingAdaugaClient.setVisible(false);
            } catch (UnsupportedEncodingException | ParseException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }//GEN-LAST:event_jButtonAdaugaClientActionPerformed

    private void jButtonAdaugaDistribuitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdaugaDistribuitorActionPerformed
        jLabelLoadingAdaugaDistribuitor.setVisible(true);
        try {
            Distribuitor d = new Distribuitor(jTextFieldAdaugaDistNume.getText(), jTextFieldAdaugaDistAdresa.getText());
            d.setCoordinates();
            Distribuitor distribuitor = new Distribuitor(d.getNume(), d.getAdresa(), d.getLatitude(), d.getLongitude());
            ListaDistribuitori listaDistribuitori = new ListaDistribuitori();
            try {
                listaDistribuitori.adaugaDB(distribuitor);
            } catch (SQLException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
            distribuitori.add(distribuitor);
            listaDistribuitori.init();
            refreshComboBox();
            jLabelLoadingAdaugaDistribuitor.setVisible(false);
        } catch (UnsupportedEncodingException | ParseException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAdaugaDistribuitorActionPerformed

    private void jButtonAdaugaProducatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdaugaProducatorActionPerformed
        jLabelLoadingAdaugaProducator.setVisible(true);
        try {
            Producator p = new Producator(jTextFieldAdaugaProducatorNume.getText(), jTextFieldAdaugaProducatorAdresa.getText());
            p.setCoordinates();
            Producator producator = new Producator(p.getNume(), p.getAdresa(), p.getLatitude(), p.getLongitude());
            ListaProducatori listaProducatori = new ListaProducatori();
            try {
                listaProducatori.adaugaDB(producator);
            } catch (SQLException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
            producatori.add(producator);
            listaProducatori.init();
            refreshComboBox();
            jLabelLoadingAdaugaProducator.setVisible(false);
        } catch (UnsupportedEncodingException | ParseException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAdaugaProducatorActionPerformed

    private void removeLoading() {
        jLabelLoading.setVisible(false);

    }

    private void addLoading() {
        jLabelLoading.setVisible(true);
        jLabelLoading.setIcon(imageIcon);
    }

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
        java.awt.EventQueue.invokeLater(() -> {
            new Interface().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdaugaClient;
    private javax.swing.JButton jButtonAdaugaDistribuitor;
    private javax.swing.JButton jButtonAdaugaProducator;
    private javax.swing.JButton jButtonTraseuTotal;
    private javax.swing.JComboBox<Client> jComboBoxClienti;
    private javax.swing.JComboBox<Distribuitor> jComboBoxDistribuitori;
    private javax.swing.JComboBox<Producator> jComboBoxProducatori;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDistanta;
    private javax.swing.JLabel jLabelLoading;
    private javax.swing.JLabel jLabelLoadingAdaugaClient;
    private javax.swing.JLabel jLabelLoadingAdaugaDistribuitor;
    private javax.swing.JLabel jLabelLoadingAdaugaProducator;
    private javax.swing.JLabel jLabelTraseuOptim;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelAdaugaProducator;
    private javax.swing.JPanel jPanelMap;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldAdaugaClientAdresa;
    private javax.swing.JTextField jTextFieldAdaugaClientNume;
    private javax.swing.JTextField jTextFieldAdaugaDistAdresa;
    private javax.swing.JTextField jTextFieldAdaugaDistNume;
    private javax.swing.JTextField jTextFieldAdaugaProducatorAdresa;
    private javax.swing.JTextField jTextFieldAdaugaProducatorNume;
    // End of variables declaration//GEN-END:variables
}
