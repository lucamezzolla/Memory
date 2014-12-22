package memory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author Luca
 */
public final class GridMedium extends javax.swing.JPanel {
    
    private final Properties prop;
    private final Properties propTimer;
    int f1, f2, f3, f4, f5, f6, f7, f8, f9;
    private Timer timer;
    private GridInterface listener;
    private int timerInt;
    private int diffChoice;

    /**
     * Creates new form GridEasy
     * @param prop
     * @param diffChoice
     * @throws java.io.IOException
     */
    public GridMedium(Properties prop, int diffChoice) throws IOException {
        initComponents();
        this.prop = prop;
        this.diffChoice = diffChoice;
        propTimer = new Properties();
        try {
            propTimer.load(new FileInputStream("timer.properties"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        okBut.setEnabled(false);
        okBut.setText(prop.getProperty("check"));
        newBut.setText(prop.getProperty("restart"));
        jButton1.setText(prop.getProperty("back"));
        setFields();
        startTimerWait();
        this.diffChoice = diffChoice;
    }
    
    void setFields() {
        f1 = randInt(1, 9);
        f2 = randInt(1, 9);
        f3 = randInt(1, 9);
        f4 = randInt(1, 9);
        f5 = randInt(1, 9);
        f6 = randInt(1, 9);
        f7 = randInt(1, 9);
        f8 = randInt(1, 9);
        f9 = randInt(1, 9);
        field1.setText(String.valueOf(f1));
        field2.setText(String.valueOf(f2));
        field3.setText(String.valueOf(f3));
        field4.setText(String.valueOf(f4));
        field5.setText(String.valueOf(f5));
        field6.setText(String.valueOf(f6));
        field7.setText(String.valueOf(f7));
        field8.setText(String.valueOf(f8));
        field9.setText(String.valueOf(f9));
    }

    public void setListener(GridInterface listener) {
        this.listener = listener;
    }
    
    void startTimerWait() {
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
                    field5.setText("");
                    field6.setText("");
                    field7.setText("");
                    field8.setText("");
                    field9.setText("");
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
    
    final int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        field2 = new javax.swing.JTextField();
        field3 = new javax.swing.JTextField();
        field1 = new javax.swing.JTextField();
        field4 = new javax.swing.JTextField();
        timerLabel = new javax.swing.JLabel();
        okBut = new javax.swing.JButton();
        newBut = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        field5 = new javax.swing.JTextField();
        field6 = new javax.swing.JTextField();
        field7 = new javax.swing.JTextField();
        field8 = new javax.swing.JTextField();
        field9 = new javax.swing.JTextField();

        field2.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        field2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field2ActionPerformed(evt);
            }
        });

        field3.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field1.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field4.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        timerLabel.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
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

        field5.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field5.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field6.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field6.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field7.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field7.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field8.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field8.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field9.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field9.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(okBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(newBut, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(field4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(field1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(field8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(field2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(field5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(field7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(field3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(field9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(field6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(field3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(okBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void okButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButActionPerformed
        timer.cancel();
        timer.purge();
        if(field1.getText().equals(String.valueOf(f1)) &&
            field2.getText().equals(String.valueOf(f2)) &&
                field3.getText().equals(String.valueOf(f3)) &&
                field4.getText().equals(String.valueOf(f4)) &&
                field5.getText().equals(String.valueOf(f5)) &&
                field6.getText().equals(String.valueOf(f6)) &&
                field7.getText().equals(String.valueOf(f7)) &&
                field8.getText().equals(String.valueOf(f8)) &&
                field9.getText().equals(String.valueOf(f9))               
                ) {
            JOptionPane.showMessageDialog(this, "Complimenti!");
            newButActionPerformed(null);
        } else {
            JOptionPane.showMessageDialog(this, "Hai perso!");
            jButton1ActionPerformed(null);
        }
    }//GEN-LAST:event_okButActionPerformed

    private void newButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButActionPerformed
        okBut.setEnabled(false);
        timer.cancel();
        timer.purge();
        setFields();
        startTimerWait();
    }//GEN-LAST:event_newButActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(listener != null) {
            timer.cancel();
            timer.purge();
            listener.stopActivity();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void field2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField field1;
    private javax.swing.JTextField field2;
    private javax.swing.JTextField field3;
    private javax.swing.JTextField field4;
    private javax.swing.JTextField field5;
    private javax.swing.JTextField field6;
    private javax.swing.JTextField field7;
    private javax.swing.JTextField field8;
    private javax.swing.JTextField field9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton newBut;
    private javax.swing.JButton okBut;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
}