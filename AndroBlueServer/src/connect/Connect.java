/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package connect;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author STAR
 */
public class Connect {
    public  static Connection connection() throws Exception
    {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root", "admin");
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return conn;
    }

}
