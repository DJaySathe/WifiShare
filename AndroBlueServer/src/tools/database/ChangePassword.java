/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tools.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author STAR
 */
public class ChangePassword {

    public static boolean changePassword(String oldPassword,String newPassword) {
        boolean b=false;
        try {
            Connection connection = connect.Connect.connection();
            PreparedStatement prepareStatement = connection.prepareStatement("select * from admin_table where password=?");
            prepareStatement.setString(1, oldPassword);
            ResultSet rs = prepareStatement.executeQuery();
            if(rs.next())
                b=true;
            prepareStatement.close();
            prepareStatement = connection.prepareStatement("update admin_table set password=? where password=?");
            prepareStatement.setString(1, newPassword);
            prepareStatement.setString(2, oldPassword);
            prepareStatement.execute();
            prepareStatement.close();
        } catch (Exception e) {
        }
        return b;
    }
}
