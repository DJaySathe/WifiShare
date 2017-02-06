/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mall.database;
import mall.model.CustomerModel;
import connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author STAR
 */
public class DeleteCustomer {
    public static boolean delete(CustomerModel selectedCustomer) {
        boolean status=false;
        try {
            Connection connection=Connect.connection();
            PreparedStatement ps=connection.prepareStatement("delete from USER_TABLE where U_ID=? and D_ID=3");
            ps.setInt(1,selectedCustomer.getId());
            status=!ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
