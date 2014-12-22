/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucamezzolla.memory;

import java.awt.Toolkit;
import java.util.Properties;

/**
 *
 * @author Luca
 */
public class DiffForm extends javax.swing.JFrame {
    
    private final Properties prop;
    private DiffInterface listener;
    private int choice = 1;

    /**
     * Creates new form DiffForm
     * @param impProp
     * @param choiceImp
     */
    public DiffForm(Properties impProp, int choiceImp) {
        initComponents();
        prop = impProp;
        choice = choiceImp;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("mind.png")));
        combo.addItem(prop.getProperty("easy"));
        combo.addItem(prop.getProperty("medium"));
        combo.addItem(prop.getProperty("hard"));
        switch(choice) {
            case 1:
                combo.setSelectedItem(prop.getProperty("easy"));
                break;
            case 2:
                combo.setSelectedItem(prop.getProperty("medium"));
                break;
            case 3:
                combo.setSelectedItem(prop.getProperty("hard"));
                break;
                
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

        combo = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        combo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combo, 0, 260, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(listener != null) {
            int n = 1;
            if(combo.getSelectedItem().equals(prop.getProperty("easy"))) n = 1;
            if(combo.getSelectedItem().equals(prop.getProperty("medium"))) n = 2;
            if(combo.getSelectedItem().equals(prop.getProperty("hard"))) n = 3;
            listener.changeDiff(n);
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void setListener(DiffInterface listener) {
        this.listener = listener;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox combo;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}