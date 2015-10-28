/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Basket;
import Model.Product;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Jakob
 */
public class BasketInventory extends javax.swing.JPanel {
    private Basket kurv;
    private Product item;
    private String size;
    private int amount;
    private JPanel basketPanelInner;
    private JScrollPane ItemsPanel;
    private JLabel headerBeløb;
    private String totalAmount;

    public BasketInventory(Basket kurv, JPanel basketPanelInner, JScrollPane basketPane, JLabel headerBeløb, String totalAmount) {
        this.kurv = kurv;
        this.basketPanelInner = basketPanelInner;
        this.ItemsPanel = basketPane;
        this.headerBeløb = headerBeløb;
        this.totalAmount = totalAmount;
        initComponents();
    }
    
    public JPanel updateItems(Product item, String size, int amount){
        this.item = item;
        this.size = size;
        this.amount = amount;
        nameLabel.setText(item.getName());
        sizeLabel.setText(size);
        priceLabel.setText(item.getPrice()+" DKK");
        numberOfItem.setText(amount+"");
        kurvItem.setVisible(true);
        return kurvItem;
    }
    
    public void update(){
        totalAmount = kurv.calculateTotalAmount();
        headerBeløb.setText(totalAmount + " DKK");
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
                BasketInventory bi = new BasketInventory(kurv, basketPanelInner, ItemsPanel, headerBeløb, totalAmount);
                JPanel biPanel;
                biPanel = new JPanel();
                biPanel = bi.updateItems((Product) kurvUdenGentagelser.get(i), (String) kurvUdenGentagelserSize.get(i), (Integer) kurvUdenGentagelserAmount.get(i));
                basketPanelInner.add(biPanel);
                ItemsPanel.setViewportView(basketPanelInner);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kurvItem = new javax.swing.JPanel();
        sizeLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        plusButton = new javax.swing.JButton();
        minusButton = new javax.swing.JButton();
        numberOfItem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setMaximumSize(new java.awt.Dimension(672, 80));
        setMinimumSize(new java.awt.Dimension(672, 80));
        setPreferredSize(new java.awt.Dimension(672, 80));

        kurvItem.setMaximumSize(new java.awt.Dimension(620, 80));
        kurvItem.setMinimumSize(new java.awt.Dimension(620, 80));
        kurvItem.setPreferredSize(new java.awt.Dimension(620, 80));

        sizeLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        nameLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        plusButton.setText("+");
        plusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusButtonActionPerformed(evt);
            }
        });

        minusButton.setText("-");
        minusButton.setMaximumSize(new java.awt.Dimension(23, 28));
        minusButton.setMinimumSize(new java.awt.Dimension(23, 28));
        minusButton.setPreferredSize(new java.awt.Dimension(23, 28));
        minusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusButtonActionPerformed(evt);
            }
        });

        numberOfItem.setEditable(false);
        numberOfItem.setText("0");

        jLabel2.setText("Pris per styk:");

        priceLabel.setText("Test");

        jLabel1.setText("Antal");

        javax.swing.GroupLayout kurvItemLayout = new javax.swing.GroupLayout(kurvItem);
        kurvItem.setLayout(kurvItemLayout);
        kurvItemLayout.setHorizontalGroup(
            kurvItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kurvItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kurvItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kurvItemLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(kurvItemLayout.createSequentialGroup()
                        .addGroup(kurvItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(kurvItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(kurvItemLayout.createSequentialGroup()
                                .addComponent(minusButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numberOfItem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(4, 4, 4)
                        .addComponent(plusButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        kurvItemLayout.setVerticalGroup(
            kurvItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kurvItemLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(kurvItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(kurvItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kurvItemLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(sizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kurvItemLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(kurvItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(minusButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberOfItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(plusButton)
                            .addComponent(jLabel2)
                            .addComponent(priceLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kurvItem, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(kurvItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void plusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusButtonActionPerformed
        kurv.addSameItem(item, size);
        update();
    }//GEN-LAST:event_plusButtonActionPerformed

    private void minusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusButtonActionPerformed
        kurv.removeItem(item, size);
        update();
    }//GEN-LAST:event_minusButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel kurvItem;
    private javax.swing.JButton minusButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField numberOfItem;
    private javax.swing.JButton plusButton;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel sizeLabel;
    // End of variables declaration//GEN-END:variables
}
