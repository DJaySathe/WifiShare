/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.database;

import hospital.model.PatientModel;
import java.sql.Connection;
import connect.Connect;
import java.sql.Date;
import java.sql.PreparedStatement;
/**
 *
 * @author STAR
 */
public class UpdatePatient {

    public static boolean updatePatient(PatientModel oldP,PatientModel newP)
    {
        boolean success=false;
        try{
            Connection connection=Connect.connection();
            PreparedStatement ps=connection.prepareStatement("update USER_TABLE set USER_NAME=?,GENDER=?,B_GROUP=?,ADDRESS=?,PHONE_NO=?,DOB=?,OPTION_1=?,OPTION_2=?,OPTION_3=? where U_ID=? and D_ID=1");
            ps.setString(1,newP.getName());
            ps.setString(2,newP.getGender());
            ps.setString(3,newP.getBloodgroup());
            ps.setString(4,newP.getAddress());
            ps.setString(5,newP.getPhone());
            ps.setDate(6,new Date(newP.getDob().getTime()));
            ps.setString(7, newP.getCunFee()+"");
            ps.setString(8, newP.getOpExp()+"");
            ps.setString(9, newP.getMedExp()+"");
            ps.setInt(10,oldP.getId());
            ps.execute();
            ps.close();
//            ps=connection.prepareStatement("update TABLE_4 set F_1=?,F_2=?,F_3=? where U_ID=? and D_ID=1");
//            ps.setString(1, newP.getCunFee()+"");
//            ps.setString(2, newP.getOpExp()+"");
//            ps.setString(3, newP.getMedExp()+"");
//            ps.setInt(4,oldP.getId());
//            ps.execute();
//            ps.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return success;
    }

}
