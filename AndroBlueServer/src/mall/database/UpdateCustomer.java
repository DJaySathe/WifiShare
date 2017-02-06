/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mall.database;

import mall.model.CustomerModel;
import connect.Connect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
/**
 *
 * @author STAR
 */
public class UpdateCustomer {
    public static boolean saveCustomer(CustomerModel oldS, CustomerModel newS) {
        boolean b=false;
        try {
            Connection connection=Connect.connection();
            PreparedStatement ps=connection.prepareStatement("update USER_TABLE set USER_NAME=?,GENDER=?,B_GROUP=?,ADDRESS=?,PHONE_NO=?,DOB=?,OPTION_1=? where U_ID=? and D_ID=3");
            ps.setString(1,newS.getName());
            ps.setString(2,newS.getGender());
            ps.setString(3,newS.getBloodgroup());
            ps.setString(4,newS.getAddress());
            ps.setString(5,newS.getPhone());
            ps.setDate(6,new Date(newS.getDob().getTime()));
            ps.setString(7, newS.getBonusPoints()+"");
            ps.setInt(8,oldS.getId());
            b=!ps.execute();
            ps.close();

//            ps=connection.prepareStatement("update TABLE_4 set F_1=?,F_2=?,F_3=? where U_ID=? and D_ID=3");
//            ps.setString(1, newS.getBonusPoints()+"");
//            ps.setInt(4,oldS.getId());
//            b=!ps.execute();
//            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
}
