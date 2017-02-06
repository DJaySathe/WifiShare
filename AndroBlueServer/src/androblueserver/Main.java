/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package androblueserver;

import master.view.MasterUI;

/**
 *
 * @author STAR
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterUI().setVisible(true);
            }
        });
    }

}
