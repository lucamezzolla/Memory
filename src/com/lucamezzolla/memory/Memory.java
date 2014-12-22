package com.lucamezzolla.memory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Luca
 */
public class Memory {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        new Memory().TimerProp();
    	MainFrame mf = new MainFrame();
        mf.setResizable(false);
        mf.setLocationRelativeTo(null);
        mf.setVisible(true);
    }
    
    public void TimerProp() throws FileNotFoundException, IOException {
    	Properties propTimer = new Properties();
		propTimer.setProperty("easyWait", "5");
        propTimer.setProperty("mediumWait", "10");
        propTimer.setProperty("hardWait", "60");
        propTimer.setProperty("easyTimer", "10");
        propTimer.setProperty("mediumTimer", "30");
        propTimer.setProperty("hardTimer", "60");
        FileOutputStream fos = new FileOutputStream("timer.properties");
        propTimer.store(fos, null);
        fos.flush();
        fos.close();
    }
    
}