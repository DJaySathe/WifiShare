/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.database;

import connect.Connect;
import hospital.model.PatientModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author STAR
 */
public class SetPatient {

    public static boolean setPatient(PatientModel model)
    {
        boolean success=false;
        int id=0;
        try{
            Connection connection = Connect.connection();
            PreparedStatement psmt1= connection.prepareStatement("insert into USER_TABLE(D_ID,USER_NAME,GENDER,B_GROUP,ADDRESS,PHONE_NO,DOB,OPTION_1,OPTION_2,OPTION_3)VALUES(?,?,?,?,?,?,?,?,?,?)");
            psmt1.setInt(1,1);
            psmt1.setString(2,model.getName());
            psmt1.setString(3,model.getGender());
            psmt1.setString(4,model.getBloodgroup());
            psmt1.setString(5,model.getAddress());
            psmt1.setString(6,model.getPhone());
            psmt1.setDate(7,new Date(model.getDob().getTime()));
            psmt1.setString(8, model.getCunFee()+"");
            psmt1.setString(9, model.getOpExp()+"");
            psmt1.setString(10, model.getMedExp()+"");
            success=!psmt1.execute();
            psmt1.close();

//            psmt1= connection.prepareStatement("select U_ID from USER_TABLE where USER_NAME=? and PHONE_NO=?");
//            psmt1.setString(1,model.getName());
//            psmt1.setString(2,model.getPhone());
//            ResultSet rs = psmt1.executeQuery();
//            while(rs.next())
//            {
//                id=rs.getInt("U_ID");
//            }
//            psmt1.close();
//            psmt1= connection.prepareStatement("INSERT INTO `table_4` VALUES ('1',?,?,?,?);");
//            psmt1.setInt(1, id);
//            psmt1.setString(2, model.getCunFee()+"");
//            psmt1.setString(3, model.getOpExp()+"");
//            psmt1.setString(4, model.getMedExp()+"");
//            psmt1.execute();
//            psmt1.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return success;
    }

}
