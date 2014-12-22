package memory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author Luca
 */
public final class GridHard extends javax.swing.JPanel {
    
    private final Properties prop;
    private final Properties propTimer;
    int f1, f2, f3, f4, f5, f6, f7, f8, f9, f10,
            f11, f12, f13, f14, f15, f16, f17, f18, f19, f20,
            f21, f22, f23, f24, f25;
    private Timer timer;
    private GridInterface listener;
    private int timerInt;
    private final int diffChoice;

    /**
     * Creates new form GridEasy
     * @param prop
     * @param diffChoice
     * @throws java.io.IOException
     */
    public GridHard(Properties prop, int diffChoice) throws IOException {
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
    }
    
    void setFields() {
        f1 = randInt(1, 9); f2 = randInt(1, 9);
        f3 = randInt(1, 9); f4 = randInt(1, 9);
        f5 = randInt(1, 9); f6 = randInt(1, 9);
        f7 = randInt(1, 9); f8 = randInt(1, 9);
        f9 = randInt(1, 9); f10 = randInt(1, 9);
        f11 = randInt(1, 9); f12 = randInt(1, 9);
        f13 = randInt(1, 9); f14 = randInt(1, 9);
        f15 = randInt(1, 9); f16 = randInt(1, 9);
        f17 = randInt(1, 9); f18 = randInt(1, 9);
        f19 = randInt(1, 9); f20 = randInt(1, 9);
        f21 = randInt(1, 9); f22 = randInt(1, 9);
        f23 = randInt(1, 9); f24 = randInt(1, 9);
        f25 = randInt(1, 9);
        field1.setText(String.valueOf(f1));
        field2.setText(String.valueOf(f2));
        field3.setText(String.valueOf(f3));
        field4.setText(String.valueOf(f4));
        field5.setText(String.valueOf(f5));
        field6.setText(String.valueOf(f6));
        field7.setText(String.valueOf(f7));
        field8.setText(String.valueOf(f8));
        field9.setText(String.valueOf(f9));
        field10.setText(String.valueOf(f10));
        field11.setText(String.valueOf(f11));
        field12.setText(String.valueOf(f12));
        field13.setText(String.valueOf(f13));
        field14.setText(String.valueOf(f14));
        field15.setText(String.valueOf(f15));
        field16.setText(String.valueOf(f16));
        field17.setText(String.valueOf(f17));
        field18.setText(String.valueOf(f18));
        field19.setText(String.valueOf(f19));
        field20.setText(String.valueOf(f20));
        field21.setText(String.valueOf(f21));
        field22.setText(String.valueOf(f22));
        field23.setText(String.valueOf(f23));
        field24.setText(String.valueOf(f24));
        field25.setText(String.valueOf(f25));
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
                    field1.setText(""); field10.setText("");
                    field2.setText(""); field11.setText("");
                    field3.setText(""); field12.setText("");
                    field4.setText(""); field13.setText("");
                    field5.setText(""); field14.setText("");
                    field6.setText(""); field15.setText("");
                    field7.setText(""); field16.setText("");
                    field8.setText(""); field17.setText("");
                    field9.setText(""); field18.setText("");
                    field22.setText(""); field19.setText("");
                    field23.setText(""); field20.setText("");
                    field24.setText(""); field21.setText("");
                    field25.setText("");
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
        field10 = new javax.swing.JTextField();
        field11 = new javax.swing.JTextField();
        field12 = new javax.swing.JTextField();
        field13 = new javax.swing.JTextField();
        field14 = new javax.swing.JTextField();
        field15 = new javax.swing.JTextField();
        field16 = new javax.swing.JTextField();
        field17 = new javax.swing.JTextField();
        field18 = new javax.swing.JTextField();
        field19 = new javax.swing.JTextField();
        field20 = new javax.swing.JTextField();
        field21 = new javax.swing.JTextField();
        field22 = new javax.swing.JTextField();
        field23 = new javax.swing.JTextField();
        field24 = new javax.swing.JTextField();
        field25 = new javax.swing.JTextField();

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

        field10.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field10.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field11.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field11.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field12.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field12.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field13.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field13.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field14.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field14.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field15.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field15.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field16.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field16.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field17.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field17.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field18.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field18.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field19.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field19.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field20.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field20.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field21.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field21.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field22.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field22.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field23.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field23.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field24.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field24.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        field25.setFont(new java.awt.Font("Verdana", 1, 60)); // NOI18N
        field25.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(okBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newBut, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(field4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(field5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(field6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(field13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(field15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(field12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(field14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(field1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(field2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(field16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(field17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(field18, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(timerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(field21, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(field22, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(field23, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field24, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field25, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(field4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(field5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(field6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(field12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(field14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field18, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field22, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field21, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field23, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field24, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field25, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(okBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(newBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            field9.getText().equals(String.valueOf(f9)) &&
            field10.getText().equals(String.valueOf(f10)) &&
            field11.getText().equals(String.valueOf(f11)) &&
            field12.getText().equals(String.valueOf(f12)) &&
            field13.getText().equals(String.valueOf(f13)) &&
            field14.getText().equals(String.valueOf(f14)) &&
            field15.getText().equals(String.valueOf(f15)) &&
            field16.getText().equals(String.valueOf(f16)) &&
            field17.getText().equals(String.valueOf(f17)) &&
            field18.getText().equals(String.valueOf(f18)) &&
            field19.getText().equals(String.valueOf(f19)) &&
            field20.getText().equals(String.valueOf(f20)) &&
            field21.getText().equals(String.valueOf(f21)) &&
            field22.getText().equals(String.valueOf(f22)) &&
            field23.getText().equals(String.valueOf(f23)) &&
            field24.getText().equals(String.valueOf(f24)) &&
            field25.getText().equals(String.valueOf(f25))) {
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
    private javax.swing.JTextField field10;
    private javax.swing.JTextField field11;
    private javax.swing.JTextField field12;
    private javax.swing.JTextField field13;
    private javax.swing.JTextField field14;
    private javax.swing.JTextField field15;
    private javax.swing.JTextField field16;
    private javax.swing.JTextField field17;
    private javax.swing.JTextField field18;
    private javax.swing.JTextField field19;
    private javax.swing.JTextField field2;
    private javax.swing.JTextField field20;
    private javax.swing.JTextField field21;
    private javax.swing.JTextField field22;
    private javax.swing.JTextField field23;
    private javax.swing.JTextField field24;
    private javax.swing.JTextField field25;
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