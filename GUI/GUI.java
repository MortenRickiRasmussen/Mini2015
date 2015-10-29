/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Basket;
import Model.DBHandler;
import Model.Pants;
import Model.PdfHandler;
import Model.Product;
import Model.Shirt;
import Model.TShirt;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.apache.pdfbox.exceptions.COSVisitorException;

/**
 * @author Jakob Ferdinandsen
 * @author Morten Ricki Rasmussen
 */
public class GUI extends javax.swing.JFrame {

    private String totalAmount;
    private ArrayList<TShirt> tShirts;
    private ArrayList<Pants> pants;
    private ArrayList<Shirt> shirts;
    private ArrayList<Shirt> tShirtPanels;
    private Basket kurv;

    /**
     * Creates new form GUI
     */
    //--------------------------------------------------------------------------
    // Metode til at beregne totalprisen 
    //--------------------------------------------------------------------------
    public void calculateAmount() {
        totalAmount = kurv.calculateTotalAmount() + " DKK";
        headerPrice.setText(totalAmount);
    }

    public GUI() {
        initComponents();
        //--------------------------------------------------------------------------
        //Sætter titlen på programmet
        //--------------------------------------------------------------------------
        super.setTitle("Næstveds Tøjmagasin");

        basketPanel.setVisible(false);
        checkoutPanel.setVisible(false);

        //--------------------------------------------------------------------------
        //Laver et basket Objekt og b
        //--------------------------------------------------------------------------
        kurv = new Basket();

        totalAmount = kurv.calculateTotalAmount();
        headerPrice.setText(totalAmount + " DKK");

        //--------------------------------------------------------------------------
        // Initialisere produkt ArrayLists
        //--------------------------------------------------------------------------
        tShirts = new ArrayList<>();
        pants = new ArrayList<>();
        shirts = new ArrayList<>();

        //--------------------------------------------------------------------------
        // Loader de tre arraylists med produkter fra datasen
        //--------------------------------------------------------------------------
        try {
            DBHandler.loadArrayLists(tShirts, pants, shirts);
        } catch (ClassNotFoundException ex) {
            popUpFrame.pack();
            popUpFrame.setVisible(true);
            popUpLabel1.setText("Kan ikke finde JDBC driver");
            popUpLabel2.setText("Kontakt administrator");
            popUpLabel4.setText("Fejl: "+ex.getMessage());
            popUpLabel3.setText("");
        } catch (SQLException ex) {
            popUpFrame.pack();
            popUpFrame.setVisible(true);
            popUpLabel1.setText("Kan ikke få forbindelse til database server");
            popUpLabel2.setText("Er du på internettet?, hvis ja, kontakt administrator");
            popUpLabel4.setText("Database serveren er muligvis nede");
            popUpLabel3.setText("Fejl: "+ex.getMessage());
        } catch (Exception ex) {
            popUpFrame.pack();
            popUpFrame.setVisible(true);
            popUpLabel1.setText("Ukendt Fejl");
            popUpLabel2.setText("Fejl: "+ex.getMessage());
            popUpLabel4.setText("");
            popUpLabel3.setText("");
        }

        //--------------------------------------------------------------------------
        // Fylder de tre produkt panels op med produkter dynamisk
        //--------------------------------------------------------------------------
        for (int i = 0; i < tShirts.size(); i++) {
            JPanel jp = new ProductShow(tShirts.get(i).getName(), tShirts.get(i).getColor(), tShirts.get(i).getSizes(), Float.toString(tShirts.get(i).getPrice()), tShirts, kurv, headerPrice, totalAmount);
            jp.setVisible(true);
            tShirtPanel.add(jp);
        }
        for (int i = 0; i < shirts.size(); i++) {
            JPanel jp = new ProductShow(shirts.get(i).getName(), shirts.get(i).getColor(), shirts.get(i).getSizes(), Float.toString(shirts.get(i).getPrice()), shirts, kurv, headerPrice, totalAmount);
            jp.setVisible(true);
            shirtPanel.add(jp);
        }
        for (int i = 0; i < pants.size(); i++) {
            JPanel jp = new ProductShow(pants.get(i).getName(), pants.get(i).getColor(), pants.get(i).getSizes(), Float.toString(pants.get(i).getPrice()), pants, kurv, headerPrice, totalAmount);
            jp.setVisible(true);
            pantsPanel.add(jp);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popUpFrame = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        popUpLabel3 = new javax.swing.JLabel();
        popUpLabel1 = new javax.swing.JLabel();
        popUpLabel2 = new javax.swing.JLabel();
        popUpLabel4 = new javax.swing.JLabel();
        topPanel = new javax.swing.JPanel();
        headerPrice = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        mainMenuButton = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        mainPane = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tShirtPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        shirtPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pantsPanel = new javax.swing.JPanel();
        basketPanel = new javax.swing.JPanel();
        basketCheckoutButton = new javax.swing.JButton();
        basketBackButton = new javax.swing.JButton();
        ItemsPanel = new javax.swing.JScrollPane();
        basketPanelInner = new javax.swing.JPanel();
        checkoutPanel = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        payButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        eMailField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        telephoneField = new javax.swing.JTextField();
        streetField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        zipCodeField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cardTypeCombo = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        monthCombo = new javax.swing.JComboBox();
        yearCombo = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        ccvField = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        cardNumberField = new javax.swing.JTextField();
        streetNumField = new javax.swing.JTextField();

        jPanel4.setPreferredSize(new java.awt.Dimension(700, 106));

        popUpLabel3.setText("Label1");
        popUpLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        popUpLabel1.setText("Label2");
        popUpLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        popUpLabel2.setText("Label3");
        popUpLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        popUpLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        popUpLabel4.setText("Label3");
        popUpLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        popUpLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(popUpLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                    .addComponent(popUpLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(popUpLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(popUpLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(popUpLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(popUpLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(popUpLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(popUpLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout popUpFrameLayout = new javax.swing.GroupLayout(popUpFrame.getContentPane());
        popUpFrame.getContentPane().setLayout(popUpFrameLayout);
        popUpFrameLayout.setHorizontalGroup(
            popUpFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(popUpFrameLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        popUpFrameLayout.setVerticalGroup(
            popUpFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, popUpFrameLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.getAccessibleContext().setAccessibleName("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 625));

        topPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        headerPrice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        headerPrice.setText("0 DKK");
        headerPrice.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel2.setText("Kurv:");

        jLabel3.setText("Velkommen");

        jButton1.setText("Gå til kurv");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        mainMenuButton.setText("Gå til hovedmenu");
        mainMenuButton.setMaximumSize(new java.awt.Dimension(79, 28));
        mainMenuButton.setMinimumSize(new java.awt.Dimension(79, 28));
        mainMenuButton.setPreferredSize(new java.awt.Dimension(79, 28));
        mainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(headerPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                        .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(headerPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tShirtPanel.setLayout(new javax.swing.BoxLayout(tShirtPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(tShirtPanel);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
        );

        jScrollPane1.getVerticalScrollBar().setUnitIncrement(10);

        mainPane.addTab("T-Shirts", jPanel5);

        shirtPanel.setLayout(new javax.swing.BoxLayout(shirtPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(shirtPanel);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
        );

        jScrollPane2.getVerticalScrollBar().setUnitIncrement(10);

        mainPane.addTab("Skjorter", jPanel7);

        pantsPanel.setLayout(new javax.swing.BoxLayout(pantsPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane3.setViewportView(pantsPanel);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
        );

        jScrollPane3.getVerticalScrollBar().setUnitIncrement(10);

        mainPane.addTab("Bukser", jPanel6);

        basketPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        basketCheckoutButton.setText("Bestil");
        basketCheckoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basketCheckoutButtonActionPerformed(evt);
            }
        });

        basketBackButton.setText("Tilbage til kataloget");
        basketBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basketBackButtonActionPerformed(evt);
            }
        });

        ItemsPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ItemsPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        basketPanelInner.setLayout(new javax.swing.BoxLayout(basketPanelInner, javax.swing.BoxLayout.Y_AXIS));
        ItemsPanel.setViewportView(basketPanelInner);

        javax.swing.GroupLayout basketPanelLayout = new javax.swing.GroupLayout(basketPanel);
        basketPanel.setLayout(basketPanelLayout);
        basketPanelLayout.setHorizontalGroup(
            basketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basketPanelLayout.createSequentialGroup()
                .addContainerGap(544, Short.MAX_VALUE)
                .addGroup(basketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(basketCheckoutButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(basketBackButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(basketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(basketPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ItemsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        basketPanelLayout.setVerticalGroup(
            basketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basketPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(basketBackButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 479, Short.MAX_VALUE)
                .addComponent(basketCheckoutButton)
                .addContainerGap())
            .addGroup(basketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basketPanelLayout.createSequentialGroup()
                    .addContainerGap(37, Short.MAX_VALUE)
                    .addComponent(ItemsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(41, Short.MAX_VALUE)))
        );

        jScrollPane1.getVerticalScrollBar().setUnitIncrement(10);

        checkoutPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel25.setText("Vejnr");

        payButton.setText("Betal");
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Bestilling");

        jLabel13.setText("Fakturareingsoplysninger");

        jLabel14.setText("Fulde navn");

        jLabel15.setText("E-Mail");

        jLabel16.setText("Telefon nr.");

        jLabel17.setText("Vej");

        jLabel18.setText("By");

        jLabel19.setText("Postnummer");

        cardTypeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Visa", "MasterCard" }));

        jLabel20.setText("Korttype");

        monthCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        yearCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015", "2016", "2017", "2018", "2019", "2020" }));

        jLabel21.setText("Måned");

        jLabel22.setText("År");

        jLabel23.setText("SikkerhedsCifre");

        jLabel24.setText("Kortnummer");

        javax.swing.GroupLayout checkoutPanelLayout = new javax.swing.GroupLayout(checkoutPanel);
        checkoutPanel.setLayout(checkoutPanelLayout);
        checkoutPanelLayout.setHorizontalGroup(
            checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkoutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(cardTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cardNumberField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, checkoutPanelLayout.createSequentialGroup()
                            .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21))
                            .addGap(18, 18, 18)
                            .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel22)
                                .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(55, 55, 55)
                            .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ccvField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(payButton, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(checkoutPanelLayout.createSequentialGroup()
                                .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(checkoutPanelLayout.createSequentialGroup()
                                        .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(streetField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(streetNumField)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(checkoutPanelLayout.createSequentialGroup()
                                        .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(eMailField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15))
                                        .addGap(18, 18, 18)
                                        .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16)
                                            .addComponent(telephoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(checkoutPanelLayout.createSequentialGroup()
                                        .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18)
                                            .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addComponent(zipCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addComponent(jLabel20))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        checkoutPanelLayout.setVerticalGroup(
            checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkoutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(checkoutPanelLayout.createSequentialGroup()
                        .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(5, 5, 5)
                        .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eMailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telephoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(checkoutPanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(streetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(streetNumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkoutPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(zipCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(checkoutPanelLayout.createSequentialGroup()
                        .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(cardTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cardNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ccvField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(payButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPane)
                .addContainerGap())
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(basketPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(checkoutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPane)
                .addContainerGap())
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(basketPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(checkoutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jLayeredPane1.setLayer(mainPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(basketPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(checkoutPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void basketBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basketBackButtonActionPerformed
        basketPanel.setVisible(false);
        checkoutPanel.setVisible(false);
        mainPane.setVisible(true);
    }//GEN-LAST:event_basketBackButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mainPane.setVisible(false);
        checkoutPanel.setVisible(false);
        basketPanel.setVisible(true);
        basketPanelInner.removeAll();
        basketPanelInner.revalidate();
        basketPanelInner.repaint();
        ItemsPanel.setViewportView(basketPanelInner);
        ArrayList<Product> kurvUdenGentagelser = new ArrayList<>();
        ArrayList<String> kurvUdenGentagelserSize = new ArrayList<>();
        ArrayList kurvUdenGentagelserAmount = new ArrayList<>();
        for (int i = 0; i < kurv.returnBasket().size(); i++) {
            int amount = 0;
            for (int j = 0; j < kurv.returnBasket().size(); j++) {
                if (kurv.returnBasket().get(j).equals(kurv.returnBasket().get(i)) && kurv.returnSelectedSize().get(j).equals(kurv.returnSelectedSize().get(i))){
                    amount++;
                }
            }
            if (kurvUdenGentagelser.isEmpty()){
                kurvUdenGentagelser.add((Product) kurv.returnBasket().get(i));
                kurvUdenGentagelserSize.add((String) kurv.returnSelectedSize().get(i));
                kurvUdenGentagelserAmount.add(amount);
            }
            int count = 0;
            for (int j = 0; j < kurvUdenGentagelser.size(); j++) {
                if (kurvUdenGentagelser.get(j).equals((Product) kurv.returnBasket().get(i)) && kurvUdenGentagelserSize.get(j).equals((String) kurv.returnSelectedSize().get(i))){
                    count++;
                }
            }
            if (count == 0){
                kurvUdenGentagelser.add((Product) kurv.returnBasket().get(i));
                kurvUdenGentagelserSize.add((String) kurv.returnSelectedSize().get(i));
                kurvUdenGentagelserAmount.add(amount);
            }
        }
        for (int i = 0; i < kurvUdenGentagelser.size(); i++) {
            if (!kurvUdenGentagelser.isEmpty()){
                BasketInventory bi = new BasketInventory(kurv, basketPanelInner, ItemsPanel, headerPrice, totalAmount);
                JPanel biPanel;
                biPanel = new JPanel();
                biPanel = bi.updateItems((Product) kurvUdenGentagelser.get(i), (String) kurvUdenGentagelserSize.get(i), (Integer) kurvUdenGentagelserAmount.get(i));
                basketPanelInner.add(biPanel);
                ItemsPanel.setViewportView(basketPanelInner);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void basketCheckoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basketCheckoutButtonActionPerformed
        basketPanel.setVisible(false);
        checkoutPanel.setVisible(true);
    }//GEN-LAST:event_basketCheckoutButtonActionPerformed

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payButtonActionPerformed
        
        //--------------------------------------------------------------------------
        // Laver variable som henter info fra bestillingssiden.
        //--------------------------------------------------------------------------
        String name = nameField.getText();
        String eMail = eMailField.getText();
        String telephone = telephoneField.getText();
        String street = streetField.getText();
        String streetNum = streetNumField.getText();
        String city = cityField.getText();
        String zipCode = zipCodeField.getText();

        String cardNumber = cardNumberField.getText();
        String cardType = (String) cardTypeCombo.getSelectedItem();
        String month = (String) monthCombo.getSelectedItem();
        String year = (String) yearCombo.getSelectedItem();
        String ccv = ccvField.getText();
        

        //--------------------------------------------------------------------------
        // Prøver at oprette en PDF med de forskellige information
        //--------------------------------------------------------------------------
        try {
            if (PdfHandler.gemPdf(name, street, streetNum, city, zipCode, eMail, telephone, cardNumber, cardType, month, year, ccv, kurv.returnBasket(), kurv.returnSelectedSize(), kurv.calculateTotalAmount())){
                popUpFrame.pack();
                popUpFrame.setVisible(true);
                popUpLabel1.setText("");
                popUpLabel2.setText("Ordre modtaget");
                popUpLabel3.setText("");
                popUpLabel4.setText("");
            }else{
                popUpFrame.pack();
                popUpFrame.setVisible(true);
                popUpLabel1.setText("De har ikke indtastet korrekte oplysninger");
                popUpLabel2.setText("Har de husket deres fulde navn, en korrekt email, Vejnavn, Vejnummer, by, ");
                popUpLabel4.setText("otte cifre i deres telefonnummer samt et postnummer som eksistere? Tjek evt. deres betalingsoplysninger");
                popUpLabel3.setText("");
            }
            //PdfHandler.gemPdf("morten ", "sdahsjdj", "54", "hasdj", "4578", "jasdkl@jsd.dk", "45781547", "4578547854785478", "Visa", "05", "1997", "548", kurv.returnBasket(), kurv.returnSelectedSize(), kurv.calculateTotalAmount());
        } catch (IOException | COSVisitorException ex) {
            popUpFrame.pack();
            popUpFrame.setVisible(true);
            popUpLabel1.setText("Der mangler muligvis en fil i programroden");
            popUpLabel2.setText("Kontakt administratoren og giv ham følgende oplysninger:");
            popUpLabel4.setText("Fejlkode: " + ex.getMessage());
            popUpLabel3.setText("");
        } catch (NumberFormatException ex) {
            popUpFrame.pack();
            popUpFrame.setVisible(true);
            popUpLabel1.setText("De har ikke indtastet korrekte oplysninger");
            popUpLabel2.setText("Har de husket deres fulde navn, en korrekt email, Vejnavn, Vejnummer, by, ");
            popUpLabel4.setText("otte cifre i deres telefonnummer samt et postnummer som eksistere? Tjek evt. deres betalingsoplysninger");
            popUpLabel3.setText("Fejlkode: " + ex.getMessage());
        } catch (ArrayIndexOutOfBoundsException ex) {
            popUpFrame.pack();
            popUpFrame.setVisible(true);
            popUpLabel1.setText("Du har for mange dele i din kurv.");
            popUpLabel2.setText("lav venligst 2 ordre istedet");
            popUpLabel4.setText("Fejlkode: " + ex.getMessage());
            popUpLabel3.setText("");
        } catch (Exception ex) {
            popUpFrame.pack();
            popUpFrame.setVisible(true);
            popUpLabel1.setText("Uventet fejl");
            popUpLabel2.setText("");
            popUpLabel4.setText("Fejlkode: " + ex.getMessage());
            popUpLabel3.setText("");
        }
    }//GEN-LAST:event_payButtonActionPerformed

    private void mainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuButtonActionPerformed
        checkoutPanel.setVisible(false);
        basketPanel.setVisible(false);
        mainPane.setVisible(true);
    }//GEN-LAST:event_mainMenuButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ItemsPanel;
    private javax.swing.JButton basketBackButton;
    private javax.swing.JButton basketCheckoutButton;
    private javax.swing.JPanel basketPanel;
    private javax.swing.JPanel basketPanelInner;
    private javax.swing.JTextField cardNumberField;
    private javax.swing.JComboBox cardTypeCombo;
    private javax.swing.JTextField ccvField;
    private javax.swing.JPanel checkoutPanel;
    private javax.swing.JTextField cityField;
    private javax.swing.JTextField eMailField;
    private javax.swing.JLabel headerPrice;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton mainMenuButton;
    private javax.swing.JTabbedPane mainPane;
    private javax.swing.JComboBox monthCombo;
    private javax.swing.JTextField nameField;
    private javax.swing.JPanel pantsPanel;
    private javax.swing.JButton payButton;
    private javax.swing.JFrame popUpFrame;
    private javax.swing.JLabel popUpLabel1;
    private javax.swing.JLabel popUpLabel2;
    private javax.swing.JLabel popUpLabel3;
    private javax.swing.JLabel popUpLabel4;
    private javax.swing.JPanel shirtPanel;
    private javax.swing.JTextField streetField;
    private javax.swing.JTextField streetNumField;
    private javax.swing.JPanel tShirtPanel;
    private javax.swing.JTextField telephoneField;
    private javax.swing.JPanel topPanel;
    private javax.swing.JComboBox yearCombo;
    private javax.swing.JTextField zipCodeField;
    // End of variables declaration//GEN-END:variables
}
