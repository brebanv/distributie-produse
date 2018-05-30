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
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.KeyStroke;
import javax.swing.ListModel;
import javax.swing.event.MouseInputListener;
import org.json.simple.parser.ParseException;

import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Prediction;

public final class Interface extends javax.swing.JFrame {

    private final JXMapViewer mapViewer = new JXMapViewer();
    private ArrayList<Distribuitor> distribuitori = new ArrayList<>();
    private ArrayList<Client> clienti = new ArrayList<>();
    private ArrayList<Producator> producatori = new ArrayList<>();
    private ArrayList<Distanta> distante = new ArrayList<>();
    private ImageIcon imageIcon;

    public Interface() {
        initComponents();
        initInterface();
    }

    private void initInterface() {
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Your Distribution");
        initComboBox();
        jRadioButtonRomana.setSelected(true);

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("loading.png"));
        } catch (IOException e) {
        }

        jLabelLoadingAdaugaProducator.setVisible(false);
        jLabelLoadingAdaugaClient.setVisible(false);
        jLabelLoadingAdaugaDistribuitor.setVisible(false);
        jLabelDistanta.setVisible(false);
        jLabelDurata.setVisible(false);
        jLabelDistantaText.setVisible(false);
        jLabelDurataText.setVisible(false);

        Image dimg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(dimg);
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        mapViewer.setTileFactory(tileFactory);
        addMouseInteractions();
    }

    private void initComboBox() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPaneHarta = new javax.swing.JTabbedPane();
        jPanelMap = new javax.swing.JPanel();
        jLabelLoading = new javax.swing.JLabel();
        jPanelAdaugaProducator = new javax.swing.JPanel();
        jLabelAdaugaProducatorNume = new javax.swing.JLabel();
        jLabelAdaugaProducatorAdresa = new javax.swing.JLabel();
        jTextFieldAdaugaProducatorNume = new javax.swing.JTextField();
        jTextFieldAdaugaProducatorAdresa = new javax.swing.JTextField();
        jButtonAdaugaProducator = new javax.swing.JButton();
        jLabelLoadingAdaugaProducator = new javax.swing.JLabel();
        jLabelSugestiiAdresaProd = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelAdaugaDistribuitorNume = new javax.swing.JLabel();
        jLabelAdaugaDistribuitorAdresa = new javax.swing.JLabel();
        jTextFieldAdaugaDistNume = new javax.swing.JTextField();
        jTextFieldAdaugaDistAdresa = new javax.swing.JTextField();
        jButtonAdaugaDistribuitor = new javax.swing.JButton();
        jLabelLoadingAdaugaDistribuitor = new javax.swing.JLabel();
        jLabelSugestiiAdresaDist = new javax.swing.JLabel();
        jPanelAdaugaClient = new javax.swing.JPanel();
        jLabelAdaugaClientNume = new javax.swing.JLabel();
        jLabelAdaugaClientAdresa = new javax.swing.JLabel();
        jTextFieldAdaugaClientNume = new javax.swing.JTextField();
        jTextFieldAdaugaClientAdresa = new javax.swing.JTextField();
        jButtonAdaugaClient = new javax.swing.JButton();
        jLabelLoadingAdaugaClient = new javax.swing.JLabel();
        jLabelSugestiiAdresaClient = new javax.swing.JLabel();
        jLabelDistanta = new javax.swing.JLabel();
        jButtonTraseu = new javax.swing.JButton();
        jLabelTraseuOptim = new javax.swing.JLabel();
        jLabelProducator = new javax.swing.JLabel();
        jComboBoxProducatori = new javax.swing.JComboBox<>();
        jLabelDistribuitor = new javax.swing.JLabel();
        jComboBoxDistribuitori = new javax.swing.JComboBox<>();
        jLabelClient = new javax.swing.JLabel();
        jComboBoxClienti = new javax.swing.JComboBox<>();
        jLabelDistantaText = new javax.swing.JLabel();
        jLabelDurataText = new javax.swing.JLabel();
        jLabelDurata = new javax.swing.JLabel();
        jButtonStergeTot = new javax.swing.JButton();
        jButtonTraseuOptim = new javax.swing.JButton();
        jRadioButtonEngleza = new javax.swing.JRadioButton();
        jRadioButtonRomana = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPaneHarta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jTabbedPaneHarta.addTab("Map", jPanelMap);

        jLabelAdaugaProducatorNume.setText("Nume");

        jLabelAdaugaProducatorAdresa.setText("Adresa");

        jTextFieldAdaugaProducatorAdresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAdaugaProducatorAdresaKeyPressed(evt);
            }
        });

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
                                .addComponent(jLabelAdaugaProducatorNume)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldAdaugaProducatorNume, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelAdaugaProducatorLayout.createSequentialGroup()
                                .addComponent(jLabelAdaugaProducatorAdresa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldAdaugaProducatorAdresa))))
                    .addGroup(jPanelAdaugaProducatorLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jButtonAdaugaProducator, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelLoadingAdaugaProducator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jLabelSugestiiAdresaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanelAdaugaProducatorLayout.setVerticalGroup(
            jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdaugaProducatorLayout.createSequentialGroup()
                .addGroup(jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdaugaProducatorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAdaugaProducatorNume)
                            .addComponent(jTextFieldAdaugaProducatorNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAdaugaProducatorAdresa)
                            .addComponent(jTextFieldAdaugaProducatorAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLoadingAdaugaProducator, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAdaugaProducator)))
                    .addGroup(jPanelAdaugaProducatorLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabelSugestiiAdresaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(437, Short.MAX_VALUE))
        );

        jTabbedPaneHarta.addTab("Adauga Producator", jPanelAdaugaProducator);

        jLabelAdaugaDistribuitorNume.setText("Nume");

        jLabelAdaugaDistribuitorAdresa.setText("Adresa");

        jTextFieldAdaugaDistAdresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAdaugaDistAdresaKeyPressed(evt);
            }
        });

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
                                .addComponent(jLabelAdaugaDistribuitorNume)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldAdaugaDistNume, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelAdaugaDistribuitorAdresa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldAdaugaDistAdresa))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jButtonAdaugaDistribuitor, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelLoadingAdaugaDistribuitor)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelSugestiiAdresaDist, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdaugaDistribuitorNume)
                    .addComponent(jTextFieldAdaugaDistNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAdaugaDistribuitorAdresa)
                            .addComponent(jTextFieldAdaugaDistAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAdaugaDistribuitor)
                            .addComponent(jLabelLoadingAdaugaDistribuitor)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabelSugestiiAdresaDist, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(426, Short.MAX_VALUE))
        );

        jTabbedPaneHarta.addTab("Adauga Distribuitor", jPanel1);

        jLabelAdaugaClientNume.setText("Nume");

        jLabelAdaugaClientAdresa.setText("Adresa");

        jButtonAdaugaClient.setText("Adauga");
        jButtonAdaugaClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdaugaClientActionPerformed(evt);
            }
        });

        jLabelLoadingAdaugaClient.setText("Loading...");

        javax.swing.GroupLayout jPanelAdaugaClientLayout = new javax.swing.GroupLayout(jPanelAdaugaClient);
        jPanelAdaugaClient.setLayout(jPanelAdaugaClientLayout);
        jPanelAdaugaClientLayout.setHorizontalGroup(
            jPanelAdaugaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdaugaClientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAdaugaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdaugaClientLayout.createSequentialGroup()
                        .addComponent(jLabelAdaugaClientAdresa)
                        .addGroup(jPanelAdaugaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAdaugaClientLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jButtonAdaugaClient, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelLoadingAdaugaClient, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelAdaugaClientLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldAdaugaClientAdresa))))
                    .addGroup(jPanelAdaugaClientLayout.createSequentialGroup()
                        .addComponent(jLabelAdaugaClientNume)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldAdaugaClientNume, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelSugestiiAdresaClient, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelAdaugaClientLayout.setVerticalGroup(
            jPanelAdaugaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdaugaClientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAdaugaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdaugaClientNume)
                    .addComponent(jTextFieldAdaugaClientNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAdaugaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdaugaClientLayout.createSequentialGroup()
                        .addGroup(jPanelAdaugaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAdaugaClientAdresa)
                            .addComponent(jTextFieldAdaugaClientAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanelAdaugaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAdaugaClient)
                            .addComponent(jLabelLoadingAdaugaClient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelSugestiiAdresaClient, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(415, Short.MAX_VALUE))
        );

        jTabbedPaneHarta.addTab("Adauga Client", jPanelAdaugaClient);

        jLabelDistanta.setText("  ");

        jButtonTraseu.setText("Traseu");
        jButtonTraseu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTraseuActionPerformed(evt);
            }
        });

        jLabelTraseuOptim.setText("  ");

        jLabelProducator.setText("Producator");

        jLabelDistribuitor.setText("Distribuitor");

        jLabelClient.setText("Client");

        jLabelDistantaText.setText("Distanta:");

        jLabelDurataText.setText("Durata:");

        jButtonStergeTot.setText("Sterge Tot");
        jButtonStergeTot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStergeTotActionPerformed(evt);
            }
        });

        jButtonTraseuOptim.setText("Traseu Optim");
        jButtonTraseuOptim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTraseuOptimActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonEngleza);
        jRadioButtonEngleza.setText("En");
        jRadioButtonEngleza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEnglezaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonRomana);
        jRadioButtonRomana.setText("Ro");
        jRadioButtonRomana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonRomanaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabelDistantaText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelDistanta, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDurataText)
                                .addGap(10, 10, 10)
                                .addComponent(jLabelDurata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabelProducator)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxClienti, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxProducatori, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButtonRomana)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonEngleza)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDistribuitor)
                                    .addComponent(jLabelClient))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBoxDistribuitori, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabelTraseuOptim, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addComponent(jButtonTraseu)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonTraseuOptim, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonStergeTot))
                            .addComponent(jTabbedPaneHarta, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxProducatori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButtonEngleza)
                        .addComponent(jRadioButtonRomana))
                    .addComponent(jLabelProducator, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDistribuitori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDistribuitor)
                    .addComponent(jButtonTraseu)
                    .addComponent(jButtonStergeTot)
                    .addComponent(jButtonTraseuOptim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTraseuOptim)
                    .addComponent(jComboBoxClienti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelClient))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDurata, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelDistanta)
                        .addComponent(jLabelDistantaText)
                        .addComponent(jLabelDurataText)))
                .addGap(4, 4, 4)
                .addComponent(jTabbedPaneHarta, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
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

    private void deseneazaRuta(Point start, Point mijloc, Point stop) throws MalformedURLException {
        addLoading();
        Route route = new Route(start, mijloc, stop);

        ArrayList<String> routeStringPath = new ArrayList<>();
        try {
            routeStringPath = route.getRouteDetails();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        afisareJLabelsPentruInformatii();
        jLabelDistanta.setText(Long.toString((long) (route.getDistanta() * 0.001)) + " km");

        Long zile = route.getDurata() / 86400;
        Long ore = (route.getDurata() % 86400) / 3600;
        Long minute = ((route.getDurata() % 86400) % 3600) / 60;

        if (zile > 0 && ore > 0 & minute > 0) {
            jLabelDurata.setText(zile + " zile  " + ore + " ore " + minute + " minute");
        } else {
            if (ore > 0 && minute > 0) {
                jLabelDurata.setText(ore + " ore " + minute + " minute");
            } else {
                jLabelDurata.setText(minute + " minute");
            }
        }

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
        deseneazaWayponts(start, stop, mijloc, routePainter);
        removeLoading();
    }

    private void deseneazaWayponts(Point from, Point to, Point mijloc, RoutePainter routePainter) {
        Set<Waypoint> waypoints = new HashSet<>();
        GeoPosition g1 = new GeoPosition(from.getLatitude(), from.getLongitude());
        GeoPosition g2 = new GeoPosition(to.getLatitude(), to.getLongitude());
        GeoPosition g3 = new GeoPosition(mijloc.getLatitude(), mijloc.getLongitude());
        waypoints.add(new DefaultWaypoint(g1));
        waypoints.add(new DefaultWaypoint(g2));
        waypoints.add(new DefaultWaypoint(g3));

        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
        waypointPainter.setWaypoints(waypoints);

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

    private void jButtonTraseuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraseuActionPerformed
        Point start = new Point(producatori.get(jComboBoxProducatori.getSelectedIndex()).getLatitude(), producatori.get(jComboBoxProducatori.getSelectedIndex()).getLongitude());
        Point mijloc = new Point(distribuitori.get(jComboBoxDistribuitori.getSelectedIndex()).getLatitude(), distribuitori.get(jComboBoxDistribuitori.getSelectedIndex()).getLongitude());
        Point stop = new Point(clienti.get(jComboBoxClienti.getSelectedIndex()).getLatitude(), clienti.get(jComboBoxClienti.getSelectedIndex()).getLongitude());

        new Thread(() -> {
            try {
                deseneazaRuta(start, mijloc, stop);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();

    }//GEN-LAST:event_jButtonTraseuActionPerformed

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
        new Thread(() -> {
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
        }).start();
    }//GEN-LAST:event_jButtonAdaugaDistribuitorActionPerformed

    private void jButtonStergeTotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStergeTotActionPerformed
        try {
            ListaProducatori stergeProducatori = new ListaProducatori();
            stergeProducatori.deleteAllRows();
            ListaDistribuitori stergeDistribuitori = new ListaDistribuitori();
            stergeDistribuitori.deleteAllRows();
            ListaClienti stergeClienti = new ListaClienti();
            stergeClienti.deleteAllRows();

            initComboBox();
            refreshComboBox();
        } catch (SQLException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonStergeTotActionPerformed

    private void jButtonTraseuOptimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraseuOptimActionPerformed
        Point start = new Point(producatori.get(jComboBoxProducatori.getSelectedIndex()).getLatitude(), producatori.get(jComboBoxProducatori.getSelectedIndex()).getLongitude());
        Point mijloc;
        Point stop = new Point(clienti.get(jComboBoxClienti.getSelectedIndex()).getLatitude(), clienti.get(jComboBoxClienti.getSelectedIndex()).getLongitude());
        try {
            ListaDistante d = new ListaDistante();
            d.getDistances(producatori, distribuitori, clienti);
            System.out.println(jComboBoxProducatori.getSelectedIndex() + ", " + jComboBoxClienti.getSelectedIndex());
            Integer fastestDistribuitor = d.getFastestRoute(producatori, distribuitori, clienti, jComboBoxProducatori.getSelectedIndex(), jComboBoxClienti.getSelectedIndex());

            mijloc = new Point(distribuitori.get(fastestDistribuitor).getLatitude(), distribuitori.get(fastestDistribuitor).getLongitude());
            new Thread(() -> {
                try {
                    deseneazaRuta(start, mijloc, stop);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }).start();

        } catch (UnsupportedEncodingException | InterruptedException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonTraseuOptimActionPerformed

    private void jRadioButtonEnglezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEnglezaActionPerformed
        Language language = new Language("Engleza");
        setLanguage(language);
    }//GEN-LAST:event_jRadioButtonEnglezaActionPerformed

    private void jRadioButtonRomanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonRomanaActionPerformed
        Language language = new Language();
        setLanguage(language);
    }//GEN-LAST:event_jRadioButtonRomanaActionPerformed

    private void jButtonAdaugaProducatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdaugaProducatorActionPerformed
        jLabelLoadingAdaugaProducator.setVisible(true);
        new Thread(() -> {
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
        }).start();
    }//GEN-LAST:event_jButtonAdaugaProducatorActionPerformed

    private void jTextFieldAdaugaProducatorAdresaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAdaugaProducatorAdresaKeyPressed
        if (jTextFieldAdaugaProducatorAdresa.getText() != "") {
            new Thread(() -> {
                jLabelSugestiiAdresaProd.removeAll();
                GooglePlaces client = new GooglePlaces("AIzaSyAmFZVeNDgmAcVNFA1OHwhPBM4lKTHZsSc");
                List<Prediction> predictions = client.getPlacePredictions(jTextFieldAdaugaProducatorAdresa.getText());
                if (predictions.get(0) != null && predictions.get(1) != null && predictions.get(2) != null) {
                    jLabelSugestiiAdresaProd.setText("<html>" + removeFirstAndLast(predictions.get(0).toString()) + "<br>" + removeFirstAndLast(predictions.get(1).toString()) + "<br>" + removeFirstAndLast(predictions.get(2).toString()) + "</html>");
                }

            }).start();
        }
    }//GEN-LAST:event_jTextFieldAdaugaProducatorAdresaKeyPressed

    private void jTextFieldAdaugaDistAdresaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAdaugaDistAdresaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAdaugaDistAdresaKeyPressed

    private String removeFirstAndLast(String text) {
        return text.substring(1, text.length() - 1);
    }

    private void setLanguage(Language language) {
        jLabelProducator.setText(language.getjLabelProDucator());
        jLabelDistribuitor.setText(language.getjLabelDistribuitor());
        jLabelClient.setText(language.getjLabelClient());
        jLabelDistanta.setText(language.getjLabelDistanta());
        jLabelDurata.setText(language.getjLabelDurata());
        jTabbedPaneHarta.setTitleAt(0, language.getjTabbedPaneHarta());
        jTabbedPaneHarta.setTitleAt(1, language.getjTabbedPaneAdaugaProducator());
        jTabbedPaneHarta.setTitleAt(2, language.getjTabbedPaneAdaugaDistribuitor());
        jTabbedPaneHarta.setTitleAt(3, language.getjTabbedPaneAdaugaClient());
        jLabelLoadingAdaugaClient.setText(language.getjLabelLoading());
        jLabelLoadingAdaugaDistribuitor.setText(language.getjLabelLoading());
        jLabelLoadingAdaugaProducator.setText(language.getjLabelLoading());
        jButtonAdaugaClient.setText(language.getjButtonAdauga());
        jButtonAdaugaDistribuitor.setText(language.getjButtonAdauga());
        jButtonAdaugaProducator.setText(language.getjButtonAdauga());
        jButtonTraseu.setText(language.getjButtonTraseu());
        jButtonTraseuOptim.setText(language.getjButtonTraseuOptim());
        jLabelAdaugaClientNume.setText(language.getjLabelAdaugaNume());
        jLabelAdaugaClientAdresa.setText(language.getjLabelAdaugaAdresa());
        jLabelAdaugaDistribuitorNume.setText(language.getjLabelAdaugaNume());
        jLabelAdaugaDistribuitorAdresa.setText(language.getjLabelAdaugaAdresa());
        jLabelAdaugaProducatorNume.setText(language.getjLabelAdaugaNume());
        jLabelAdaugaProducatorAdresa.setText(language.getjLabelAdaugaAdresa());

    }

    private void removeLoading() {
        jLabelLoading.setVisible(false);
    }

    private void addLoading() {
        jLabelLoading.setVisible(true);
        jLabelLoading.setIcon(imageIcon);
    }

    void refreshComboBox() {
        jComboBoxClienti.removeAllItems();
        for (int i = 0; i < clienti.size(); i++) {
            jComboBoxClienti.addItem(clienti.get(i));
        }
        jComboBoxProducatori.removeAllItems();
        for (int i = 0; i < producatori.size(); i++) {
            jComboBoxProducatori.addItem(producatori.get(i));
        }
        jComboBoxDistribuitori.removeAllItems();
        for (int i = 0; i < distribuitori.size(); i++) {
            jComboBoxDistribuitori.addItem(distribuitori.get(i));
        }
    }

    private void afisareJLabelsPentruInformatii() {
        jLabelDistanta.setVisible(true);
        jLabelDurata.setVisible(true);
        jLabelDistantaText.setVisible(true);
        jLabelDurataText.setVisible(true);
    }

    private void getDistances() {
        if (clienti.size() > 0 && producatori.size() > 0 && distribuitori.size() > 0) {
            return;
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAdaugaClient;
    private javax.swing.JButton jButtonAdaugaDistribuitor;
    private javax.swing.JButton jButtonAdaugaProducator;
    private javax.swing.JButton jButtonStergeTot;
    private javax.swing.JButton jButtonTraseu;
    private javax.swing.JButton jButtonTraseuOptim;
    private javax.swing.JComboBox<Client> jComboBoxClienti;
    private javax.swing.JComboBox<Distribuitor> jComboBoxDistribuitori;
    private javax.swing.JComboBox<Producator> jComboBoxProducatori;
    private javax.swing.JLabel jLabelAdaugaClientAdresa;
    private javax.swing.JLabel jLabelAdaugaClientNume;
    private javax.swing.JLabel jLabelAdaugaDistribuitorAdresa;
    private javax.swing.JLabel jLabelAdaugaDistribuitorNume;
    private javax.swing.JLabel jLabelAdaugaProducatorAdresa;
    private javax.swing.JLabel jLabelAdaugaProducatorNume;
    private javax.swing.JLabel jLabelClient;
    private javax.swing.JLabel jLabelDistanta;
    private javax.swing.JLabel jLabelDistantaText;
    private javax.swing.JLabel jLabelDistribuitor;
    private javax.swing.JLabel jLabelDurata;
    private javax.swing.JLabel jLabelDurataText;
    private javax.swing.JLabel jLabelLoading;
    private javax.swing.JLabel jLabelLoadingAdaugaClient;
    private javax.swing.JLabel jLabelLoadingAdaugaDistribuitor;
    private javax.swing.JLabel jLabelLoadingAdaugaProducator;
    private javax.swing.JLabel jLabelProducator;
    private javax.swing.JLabel jLabelSugestiiAdresaClient;
    private javax.swing.JLabel jLabelSugestiiAdresaDist;
    private javax.swing.JLabel jLabelSugestiiAdresaProd;
    private javax.swing.JLabel jLabelTraseuOptim;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAdaugaClient;
    private javax.swing.JPanel jPanelAdaugaProducator;
    private javax.swing.JPanel jPanelMap;
    private javax.swing.JRadioButton jRadioButtonEngleza;
    private javax.swing.JRadioButton jRadioButtonRomana;
    private javax.swing.JTabbedPane jTabbedPaneHarta;
    private javax.swing.JTextField jTextFieldAdaugaClientAdresa;
    private javax.swing.JTextField jTextFieldAdaugaClientNume;
    private javax.swing.JTextField jTextFieldAdaugaDistAdresa;
    private javax.swing.JTextField jTextFieldAdaugaDistNume;
    private javax.swing.JTextField jTextFieldAdaugaProducatorAdresa;
    private javax.swing.JTextField jTextFieldAdaugaProducatorNume;
    // End of variables declaration//GEN-END:variables

}
