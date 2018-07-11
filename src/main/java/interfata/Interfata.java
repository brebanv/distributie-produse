package interfata;

import limba.Limba;
import coordonate.Punct;
import coordonate.Ruta;
import coordonate.Path;
import utilizatori.Producator;
import utilizatori.Client;
import utilizatori.Distribuitor;
import distante.ListaDistante;
import distante.Distanta;
import firme.ListaClienti;
import firme.ListaDistribuitori;
import firme.ListaProducatori;
import harta.RoutePainter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import harta.FancyWaypointRenderer;
import harta.MyWaypoint;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
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
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;
import org.json.simple.parser.ParseException;

import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Prediction;

public final class Interfata extends javax.swing.JFrame {

    private final JXMapViewer mapViewer = new JXMapViewer();
    private ArrayList<Distribuitor> distribuitori = new ArrayList<>();
    private ArrayList<Client> clienti = new ArrayList<>();
    private ArrayList<Producator> producatori = new ArrayList<>();
    private ArrayList<Distanta> distante = new ArrayList<>();
    private ImageIcon imageIcon;
    private String raportStart;
    private String raportMijloc;
    private String raportStop;

    public Interfata() {
        initComponents();
        initInterface();
        initMap();
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

    private void initMap() {
        mapViewer.removeAll();
        mapViewer.setBounds(0, 0, 800, 600);
        mapViewer.setCenterPosition(new GeoPosition(47.656683, 23.579543));
        mapViewer.setZoom(10);
        jPanelMap.add(mapViewer);
        jPanelMap.setSize(600, 800);

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
        jButtonExportRaport = new javax.swing.JButton();
        jButtonCautaInGoogleMaps = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPaneHarta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelMap.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
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
                .addContainerGap(140, Short.MAX_VALUE))
        );

        jTabbedPaneHarta.addTab("Harta", jPanelMap);

        jPanelAdaugaProducator.setPreferredSize(new java.awt.Dimension(636, 200));

        jLabelAdaugaProducatorNume.setText("Nume:");

        jLabelAdaugaProducatorAdresa.setText("Adresa:");

        jTextFieldAdaugaProducatorAdresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAdaugaProducatorAdresaKeyPressed(evt);
            }
        });

        jButtonAdaugaProducator.setText("Adaugă");
        jButtonAdaugaProducator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdaugaProducatorActionPerformed(evt);
            }
        });

        jLabelLoadingAdaugaProducator.setText("Se încarcă..");

        javax.swing.GroupLayout jPanelAdaugaProducatorLayout = new javax.swing.GroupLayout(jPanelAdaugaProducator);
        jPanelAdaugaProducator.setLayout(jPanelAdaugaProducatorLayout);
        jPanelAdaugaProducatorLayout.setHorizontalGroup(
            jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdaugaProducatorLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdaugaProducatorLayout.createSequentialGroup()
                        .addComponent(jLabelAdaugaProducatorNume)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldAdaugaProducatorNume, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAdaugaProducatorLayout.createSequentialGroup()
                        .addComponent(jLabelAdaugaProducatorAdresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAdaugaProducatorAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelAdaugaProducatorLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButtonAdaugaProducator, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabelLoadingAdaugaProducator, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelSugestiiAdresaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelAdaugaProducatorLayout.setVerticalGroup(
            jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdaugaProducatorLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdaugaProducatorNume)
                    .addComponent(jTextFieldAdaugaProducatorNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdaugaProducatorLayout.createSequentialGroup()
                        .addGroup(jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldAdaugaProducatorAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAdaugaProducatorAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelAdaugaProducatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAdaugaProducator)
                            .addComponent(jLabelLoadingAdaugaProducator, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelSugestiiAdresaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(325, Short.MAX_VALUE))
        );

        jTabbedPaneHarta.addTab("Adaugă Producător", jPanelAdaugaProducator);

        jLabelAdaugaDistribuitorNume.setText("Nume:");

        jLabelAdaugaDistribuitorAdresa.setText("Adresa:");

        jTextFieldAdaugaDistAdresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAdaugaDistAdresaKeyPressed(evt);
            }
        });

        jButtonAdaugaDistribuitor.setText("Adaugă");
        jButtonAdaugaDistribuitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdaugaDistribuitorActionPerformed(evt);
            }
        });

        jLabelLoadingAdaugaDistribuitor.setText("Se încarcă..");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAdaugaDistribuitorNume)
                    .addComponent(jLabelAdaugaDistribuitorAdresa))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldAdaugaDistNume, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAdaugaDistAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButtonAdaugaDistribuitor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelLoadingAdaugaDistribuitor, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSugestiiAdresaDist, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAdaugaDistNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAdaugaDistribuitorNume))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldAdaugaDistAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAdaugaDistribuitorAdresa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAdaugaDistribuitor)
                            .addComponent(jLabelLoadingAdaugaDistribuitor)))
                    .addComponent(jLabelSugestiiAdresaDist, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(329, Short.MAX_VALUE))
        );

        jTabbedPaneHarta.addTab("Adaugă Distribuitor", jPanel1);

        jLabelAdaugaClientNume.setText("Nume:");

        jLabelAdaugaClientAdresa.setText("Adresa:");

        jTextFieldAdaugaClientAdresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAdaugaClientAdresaKeyPressed(evt);
            }
        });

        jButtonAdaugaClient.setText("Adaugă");
        jButtonAdaugaClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdaugaClientActionPerformed(evt);
            }
        });

        jLabelLoadingAdaugaClient.setText("Se încarcă..");

        javax.swing.GroupLayout jPanelAdaugaClientLayout = new javax.swing.GroupLayout(jPanelAdaugaClient);
        jPanelAdaugaClient.setLayout(jPanelAdaugaClientLayout);
        jPanelAdaugaClientLayout.setHorizontalGroup(
            jPanelAdaugaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdaugaClientLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanelAdaugaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAdaugaClientNume)
                    .addComponent(jLabelAdaugaClientAdresa))
                .addGap(18, 18, 18)
                .addGroup(jPanelAdaugaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldAdaugaClientAdresa)
                    .addGroup(jPanelAdaugaClientLayout.createSequentialGroup()
                        .addGroup(jPanelAdaugaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAdaugaClientLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButtonAdaugaClient, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelLoadingAdaugaClient, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldAdaugaClientNume, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelSugestiiAdresaClient, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanelAdaugaClientLayout.setVerticalGroup(
            jPanelAdaugaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdaugaClientLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(jPanelAdaugaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAdaugaClientNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAdaugaClientNume))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAdaugaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdaugaClientLayout.createSequentialGroup()
                        .addGroup(jPanelAdaugaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldAdaugaClientAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAdaugaClientAdresa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelAdaugaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAdaugaClient)
                            .addComponent(jLabelLoadingAdaugaClient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelSugestiiAdresaClient, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(308, Short.MAX_VALUE))
        );

        jTabbedPaneHarta.addTab("Adaugă Client", jPanelAdaugaClient);

        jLabelDistanta.setText("  ");

        jButtonTraseu.setText("Traseu Simplu");
        jButtonTraseu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTraseuActionPerformed(evt);
            }
        });

        jLabelProducator.setText("Producători:");

        jLabelDistribuitor.setText("Distribuitori:");

        jLabelClient.setText("Clienți:");

        jLabelDistantaText.setText("Distanța:");

        jLabelDurataText.setText("Durata:");

        jButtonStergeTot.setText("Șterge firme");
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

        jButtonExportRaport.setText("Export PDF");
        jButtonExportRaport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportRaportActionPerformed(evt);
            }
        });

        jButtonCautaInGoogleMaps.setText("Google Maps Web");
        jButtonCautaInGoogleMaps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCautaInGoogleMapsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPaneHarta, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabelDistantaText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDistanta, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDurataText, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelDurata, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelProducator)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxProducatori, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDistribuitor)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabelClient)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxDistribuitori, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxClienti, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonCautaInGoogleMaps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonTraseu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonTraseuOptim, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jButtonStergeTot, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jRadioButtonRomana)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonEngleza))
                            .addComponent(jButtonExportRaport, javax.swing.GroupLayout.Alignment.TRAILING)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxProducatori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonEngleza)
                    .addComponent(jRadioButtonRomana)
                    .addComponent(jLabelProducator))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonTraseu)
                                    .addComponent(jButtonTraseuOptim))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonCautaInGoogleMaps)
                                    .addComponent(jButtonStergeTot))
                                .addGap(0, 15, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelDistribuitor)
                                    .addComponent(jComboBoxDistribuitori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxClienti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelClient))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelDistanta)
                                .addComponent(jLabelDistantaText))
                            .addComponent(jLabelDurataText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelDurata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonExportRaport)))
                .addGap(4, 4, 4)
                .addComponent(jTabbedPaneHarta, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prepareMap() {
        mapViewer.removeAll();
        mapViewer.setBounds(0, 0, 800, 600);
        jPanelMap.add(mapViewer);
        jPanelMap.setSize(600, 800);
    }

    private void deseneazaRuta(Punct start, Punct mijloc, Punct stop) throws MalformedURLException, IOException {
        addLoading();
        Ruta route = new Ruta(start, mijloc, stop);

        ArrayList<String> routeStringPath = new ArrayList<>();
        try {
            routeStringPath = route.getRouteDetails();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Interfata.class.getName()).log(Level.SEVERE, null, ex);
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

        List<Punct> l = new ArrayList<>();
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

    private void deseneazaWayponts(Punct from, Punct to, Punct mijloc, RoutePainter routePainter) throws IOException {
        GeoPosition g1 = new GeoPosition(from.getLatitude(), from.getLongitude());
        GeoPosition g2 = new GeoPosition(to.getLatitude(), to.getLongitude());
        GeoPosition g3 = new GeoPosition(mijloc.getLatitude(), mijloc.getLongitude());

        Set<MyWaypoint> waypoints = new HashSet<MyWaypoint>(Arrays.asList(
                new MyWaypoint("P", Color.GREEN, g1),
                new MyWaypoint("C", Color.RED, g2),
                new MyWaypoint("D", Color.GRAY, g3)));

        WaypointPainter<MyWaypoint> waypointPainter = new WaypointPainter<MyWaypoint>();
        waypointPainter.setWaypoints(waypoints);
        waypointPainter.setRenderer(new FancyWaypointRenderer());

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
        Punct start = new Punct(producatori.get(jComboBoxProducatori.getSelectedIndex()).getLatitude(), producatori.get(jComboBoxProducatori.getSelectedIndex()).getLongitude());
        Punct mijloc = new Punct(distribuitori.get(jComboBoxDistribuitori.getSelectedIndex()).getLatitude(), distribuitori.get(jComboBoxDistribuitori.getSelectedIndex()).getLongitude());
        Punct stop = new Punct(clienti.get(jComboBoxClienti.getSelectedIndex()).getLatitude(), clienti.get(jComboBoxClienti.getSelectedIndex()).getLongitude());

        new Thread(() -> {
            try {
                deseneazaRuta(start, mijloc, stop);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Interfata.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Interfata.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
        raportStart = producatori.get(jComboBoxProducatori.getSelectedIndex()).getNume();
        raportMijloc = distribuitori.get(jComboBoxDistribuitori.getSelectedIndex()).getNume();
        raportStop = clienti.get(jComboBoxClienti.getSelectedIndex()).getNume();
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
                    Logger.getLogger(Interfata.class.getName()).log(Level.SEVERE, null, ex);
                }
                clienti.add(client);
                listaClienti.init();
                refreshComboBox();
                jLabelLoadingAdaugaClient.setVisible(false);
                jTextFieldAdaugaClientNume.setText("");
                jTextFieldAdaugaClientAdresa.setText("");
                jLabelSugestiiAdresaClient.setText("");
            } catch (UnsupportedEncodingException | ParseException ex) {
                Logger.getLogger(Interfata.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(Interfata.class.getName()).log(Level.SEVERE, null, ex);
                }
                distribuitori.add(distribuitor);
                listaDistribuitori.init();
                refreshComboBox();
                jLabelLoadingAdaugaDistribuitor.setVisible(false);
                jTextFieldAdaugaDistNume.setText("");
                jTextFieldAdaugaDistAdresa.setText("");
                jLabelSugestiiAdresaDist.setText("");
            } catch (UnsupportedEncodingException | ParseException ex) {
                Logger.getLogger(Interfata.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Interfata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonStergeTotActionPerformed

    private void jButtonTraseuOptimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraseuOptimActionPerformed
        Punct start = new Punct(producatori.get(jComboBoxProducatori.getSelectedIndex()).getLatitude(), producatori.get(jComboBoxProducatori.getSelectedIndex()).getLongitude());
        Punct mijloc;
        Punct stop = new Punct(clienti.get(jComboBoxClienti.getSelectedIndex()).getLatitude(), clienti.get(jComboBoxClienti.getSelectedIndex()).getLongitude());
        try {
            ListaDistante d = new ListaDistante();
            d.getDistances(producatori, distribuitori, clienti);
            Integer fastestDistribuitor = d.getFastestRoute(producatori, distribuitori, clienti, jComboBoxProducatori.getSelectedIndex(), jComboBoxClienti.getSelectedIndex());
            raportMijloc = distribuitori.get(fastestDistribuitor).getNume();
            mijloc = new Punct(distribuitori.get(fastestDistribuitor).getLatitude(), distribuitori.get(fastestDistribuitor).getLongitude());
            new Thread(() -> {
                try {
                    deseneazaRuta(start, mijloc, stop);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Interfata.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Interfata.class.getName()).log(Level.SEVERE, null, ex);
                }
            }).start();

        } catch (UnsupportedEncodingException | InterruptedException ex) {
            Logger.getLogger(Interfata.class.getName()).log(Level.SEVERE, null, ex);
        }
        raportStart = producatori.get(jComboBoxProducatori.getSelectedIndex()).getNume();

        raportStop = clienti.get(jComboBoxClienti.getSelectedIndex()).getNume();
    }//GEN-LAST:event_jButtonTraseuOptimActionPerformed

    private void jRadioButtonEnglezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEnglezaActionPerformed
        Limba language = new Limba("Engleza");
        setLanguage(language);
    }//GEN-LAST:event_jRadioButtonEnglezaActionPerformed

    private void jRadioButtonRomanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonRomanaActionPerformed
        Limba language = new Limba();
        setLanguage(language);
    }//GEN-LAST:event_jRadioButtonRomanaActionPerformed

    void cautaSugestii(JTextField jTextField, JLabel jLabel) throws Exception {
        jLabel.removeAll();
        GooglePlaces client = new GooglePlaces("AIzaSyAmFZVeNDgmAcVNFA1OHwhPBM4lKTHZsSc");
        List<Prediction> predictions = client.getPlacePredictions(jTextField.getText());
        if (predictions.get(0) != null && predictions.get(1) != null && predictions.get(2) != null) {
            jLabel.setText("<html>" + removeFirstAndLast(predictions.get(0).toString()) + "<br>" + removeFirstAndLast(predictions.get(1).toString()) + "<br>" + removeFirstAndLast(predictions.get(2).toString()) + "</html>");
        }
    }
    private void jTextFieldAdaugaDistAdresaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAdaugaDistAdresaKeyPressed
        if (jTextFieldAdaugaDistAdresa.getText() != "") {
            new Thread(() -> {
                try {
                    cautaSugestii(jTextFieldAdaugaDistAdresa, jLabelSugestiiAdresaDist);
                } catch (Exception ex) {
                }
            }).start();
        }
    }//GEN-LAST:event_jTextFieldAdaugaDistAdresaKeyPressed

    private void jButtonExportRaportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportRaportActionPerformed
        try {
            Document document = new Document(PageSize.A4, 20, 20, 20, 20);
            PdfWriter.getInstance(document, new FileOutputStream("Raport Traseu pentru clientul " + clienti.get(jComboBoxClienti.getSelectedIndex()).getNume() + ".pdf"));
            document.open();
            Font titleFont = FontFactory.getFont(FontFactory.COURIER, 24, BaseColor.BLACK);
            Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
            Chunk titlu = new Chunk("           Raport Traseu", titleFont);
            Chunk continut = new Chunk("        " + raportStart + " -> " + raportMijloc + " -> " + raportStop, font);
            Chunk distanta = new Chunk("        Distanta: " + jLabelDistanta.getText(), font);
            Chunk durata = new Chunk("        Durata: " + jLabelDurata.getText(), font);

            document.add(new Paragraph(titlu));
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph(continut));
            document.add(new Paragraph(distanta));
            document.add(new Paragraph(durata));

            BufferedImage bi = new BufferedImage(jPanelMap.getSize().width, jPanelMap.getSize().height, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            jPanelMap.paint(g);  //this == JComponent
            g.dispose();
            ImageIO.write(bi, "png", new File("test.png"));

            com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance("test.png");
            img.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
            document.add(img);

            document.close();
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(Interfata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonExportRaportActionPerformed

    private void jButtonCautaInGoogleMapsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCautaInGoogleMapsActionPerformed
        String url = "https://www.google.ro/maps";
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException ex) {
            Logger.getLogger(Interfata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCautaInGoogleMapsActionPerformed

    private void jTextFieldAdaugaClientAdresaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAdaugaClientAdresaKeyPressed
        if (jTextFieldAdaugaClientAdresa.getText() != "") {
            new Thread(() -> {
                try {
                    cautaSugestii(jTextFieldAdaugaClientAdresa, jLabelSugestiiAdresaClient);
                } catch (Exception ex) {
                }
            }).start();
        }
    }//GEN-LAST:event_jTextFieldAdaugaClientAdresaKeyPressed

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
                    Logger.getLogger(Interfata.class.getName()).log(Level.SEVERE, null, ex);
                }
                producatori.add(producator);
                listaProducatori.init();
                refreshComboBox();
                jLabelLoadingAdaugaProducator.setVisible(false);
                jTextFieldAdaugaProducatorNume.setText("");
                jTextFieldAdaugaProducatorAdresa.setText("");
                jLabelSugestiiAdresaProd.setText("");
            } catch (UnsupportedEncodingException | ParseException ex) {
                Logger.getLogger(Interfata.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }//GEN-LAST:event_jButtonAdaugaProducatorActionPerformed

    private void jTextFieldAdaugaProducatorAdresaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAdaugaProducatorAdresaKeyPressed
        if (jTextFieldAdaugaProducatorAdresa.getText() != "") {
            new Thread(() -> {
                try {
                    cautaSugestii(jTextFieldAdaugaProducatorAdresa, jLabelSugestiiAdresaProd);
                } catch (Exception ex) {

                }
            }).start();
        }
    }//GEN-LAST:event_jTextFieldAdaugaProducatorAdresaKeyPressed

    private String removeFirstAndLast(String text) {
        return text.substring(1, text.length() - 1);
    }

    private void setLanguage(Limba language) {
        jLabelProducator.setText(language.getjLabelProDucator());
        jLabelDistribuitor.setText(language.getjLabelDistribuitor());
        jLabelClient.setText(language.getjLabelClient());
        jLabelDistantaText.setText(language.getjLabelDistanta());
        jLabelDurataText.setText(language.getjLabelDurata());
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
        jButtonStergeTot.setText(language.getjButtonStergeFirme());
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
            java.util.logging.Logger.getLogger(Interfata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Interfata().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAdaugaClient;
    private javax.swing.JButton jButtonAdaugaDistribuitor;
    private javax.swing.JButton jButtonAdaugaProducator;
    private javax.swing.JButton jButtonCautaInGoogleMaps;
    private javax.swing.JButton jButtonExportRaport;
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
