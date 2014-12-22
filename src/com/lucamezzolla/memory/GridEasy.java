package com.lucamezzolla.memory;

import java.io.IOException;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

/**
 *
 * @author Luca
 */
public final class GridEasy extends Grid {

	int f1, f2, f3, f4;    
    
    /**
     * Creates new form GridEasy
     * @param prop
     * @param diffChoice
     * @throws java.io.IOException
     */
    public GridEasy(Properties prop, int diffChoice) throws IOException {
        setup(prop, diffChoice);
    }

    protected void setFields() {
        f1 = randInt(1, 9);
        f2 = randInt(1, 9);
        f3 = randInt(1, 9);
        f4 = randInt(1, 9);        
        field1.setText(String.valueOf(f1));
        field2.setText(String.valueOf(f2));
        field3.setText(String.valueOf(f3));
        field4.setText(String.valueOf(f4));
    }

    public void setListener(GridInterface listener) {
        this.listener = listener;
    }
    
    protected void startTimerWait() {
        timerInt = 1;
        switch(diffChoice) {
            case 1: { timerInt = Integer.valueOf(propTimer.getProperty("easyWait")); break; }
            case 2: { timerInt = Integer.valueOf(propTimer.getProperty("mediumWait")); break; }
            case 3: { timerInt = Integer.valueOf(propTimer.getProperty("hardWait")); break; }
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = timerInt;
            @Override
            public void run() {
                timerLabel.setText(i-- + " sec.");
                if(i < 0) {
                    timer.cancel();
                    timer.purge();
                    field1.setText("");
                    field2.setText("");
                    field3.setText("");
                    field4.setText("");
                    okBut.setEnabled(true);
                    startTimer();
                }
            }
        }, 0, 1000);
    }
    
    void startTimer() {
        timerInt = 1;
        switch(diffChoice) {
            case 1: { timerInt = Integer.valueOf(propTimer.getProperty("easyTimer")); break; }
            case 2: { timerInt = Integer.valueOf(propTimer.getProperty("mediumTimer")); break; }
            case 3: { timerInt = Integer.valueOf(propTimer.getProperty("hardTimer")); break; }
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = timerInt;
            @Override
            public void run() {
                timerLabel.setText(i-- + " sec.");
                if(i < 0) {
                    timer.cancel();
                    timer.purge();
                    okButActionPerformed(null);
                }
            }
        }, 0, 1000);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    protected void initComponents() {

        field2 = new javax.swing.JTextField();
        field3 = new javax.swing.JTextField();
        field1 = new javax.swing.JTextField();
        field4 = new javax.swing.JTextField();
        timerLabel = new javax.swing.JLabel();
        okBut = new javax.swing.JButton();
        newBut = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        field2.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field3.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field1.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field4.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        timerLabel.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        timerLabel.setText("-");

        okBut.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        okBut.setText("OK");
        okBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButActionPerformed(evt);
            }
        });

        newBut.setText("Restart");
        newBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButActionPerformed(evt);
            }
        });

        jButton1.setText("STOP");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newBut, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(field1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(field3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(field4, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(field2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(field1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(field2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(field3, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(field4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okBut)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(newBut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void okButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButActionPerformed
        timer.cancel();
        timer.purge();
        if(field1.getText().equals(String.valueOf(f1)) &&
            field2.getText().equals(String.valueOf(f2)) &&
                field3.getText().equals(String.valueOf(f3)) &&
                field4.getText().equals(String.valueOf(f4))) {
            JOptionPane.showMessageDialog(this, "Complimenti!");
            newButActionPerformed(null);
        } else {
            JOptionPane.showMessageDialog(this, "Hai perso!");
            jButton1ActionPerformed(null);
        }
    }//GEN-LAST:event_okButActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField field1;
    private javax.swing.JTextField field2;
    private javax.swing.JTextField field3;
    private javax.swing.JTextField field4;
    // End of variables declaration//GEN-END:variables
}