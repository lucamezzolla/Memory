package memory;

import java.io.IOException;

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
        MainFrame mf = new MainFrame();
        mf.setResizable(false);
        mf.setLocationRelativeTo(null);
        mf.setVisible(true);
    }
    
}