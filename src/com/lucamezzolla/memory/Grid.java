package com.lucamezzolla.memory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Timer;

import javax.swing.JOptionPane;

public abstract class Grid extends javax.swing.JPanel {

	private static final long serialVersionUID = -7440758912939460645L;

    protected Properties prop;
    protected Properties propTimer;
    protected Timer timer;
    protected GridInterface listener;
    protected int diffChoice = 1;
    protected int timerInt;
    
    protected javax.swing.JButton jButton1;
    protected javax.swing.JButton newBut;
    protected javax.swing.JButton okBut;
    protected javax.swing.JLabel timerLabel;
	
	protected void setup(Properties prop, int diffChoice) {
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
	
    protected void newButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButActionPerformed
        okBut.setEnabled(false);
        timer.cancel();
        timer.purge();
        setFields();
        startTimerWait();
    }//GEN-LAST:event_newButActionPerformed

    protected void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(listener != null) {
            timer.cancel();
            timer.purge();
            listener.stopActivity();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    protected final int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
	
	 protected abstract void initComponents();
	 
	 protected abstract void setFields();
	 
	 protected abstract void startTimerWait();
	
}