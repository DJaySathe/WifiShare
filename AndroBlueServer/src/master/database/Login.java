/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package master.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author STAR
 */
public class Login {

    public static boolean checkUidPass(String username, String password) {
        boolean b=false;
        try {
            Connection connection = connect.Connect.connection();
            PreparedStatement prepareStatement = connection.prepareStatement("select * from admin_table where username=? and password=?");
            prepareStatement.setString(1, username);
            prepareStatement.setString(2, password);
            ResultSet rs = prepareStatement.executeQuery();
            if(rs.next())
                b=true;
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

}
