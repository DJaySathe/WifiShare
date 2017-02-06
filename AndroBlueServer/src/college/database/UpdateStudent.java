/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package college.database;

import college.model.StudentModel;

import connect.Connect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author STAR
 */
public class UpdateStudent {

    public static boolean saveStudent(StudentModel oldS, StudentModel newS) {
        boolean b=false;
        try {
            Connection connection=Connect.connection();
            PreparedStatement ps=connection.prepareStatement("update USER_TABLE set USER_NAME=?,GENDER=?,B_GROUP=?,ADDRESS=?,PHONE_NO=?,DOB=?,OPTION_1=?,OPTION_2=?,OPTION_3=? where U_ID=? and D_ID=2");
            ps.setString(1,newS.getName());
            ps.setString(2,newS.getGender());
            ps.setString(3,newS.getBloodgroup());
            ps.setString(4,newS.getAddress());
            ps.setString(5,newS.getPhone());
            ps.setDate(6,new Date(newS.getDob().getTime()));
            ps.setString(7, newS.getSemester()+"");
            ps.setString(8, newS.getPercentage()+"");
            ps.setString(9, newS.getAggregate()+"");
            ps.setInt(10,oldS.getId());
            b=!ps.execute();
            ps.close();

//            ps=connection.prepareStatement("update TABLE_4 set F_1=?,F_2=?,F_3=? where U_ID=? and D_ID=2");
//            ps.setString(1, newS.getSemester()+"");
//            ps.setString(2, newS.getPercentage()+"");
//            ps.setString(3, newS.getAggregate()+"");
//            ps.setInt(4,oldS.getId());
//            b=!ps.execute();
//            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

}
