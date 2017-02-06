/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mall.database;
import mall.model.CustomerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author STAR
 */
public class GetCustomerList {
    public static ArrayList<CustomerModel> getList() {
        ArrayList<CustomerModel> list=new ArrayList<CustomerModel>();
        try{
            Connection connection = connect.Connect.connection();
            PreparedStatement ps1 = connection.prepareStatement("select * from USER_TABLE where D_ID=3");
            ResultSet rs = ps1.executeQuery();
            while (rs.next())
            {
                CustomerModel model=new CustomerModel(rs.getInt(2),rs.getString(3), rs.getString(7),rs.getString(6),rs.getString(4), rs.getString(5), rs.getDate(8),Integer.parseInt(rs.getString(9)));
                list.add(model);
            }
            ps1.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
}
