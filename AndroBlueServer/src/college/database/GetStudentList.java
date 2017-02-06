/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package college.database;

import college.model.StudentModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author STAR
 */
public class GetStudentList {

    public static ArrayList<StudentModel> getList() {
        ArrayList<StudentModel> list=new ArrayList<StudentModel>();
        try{
            Connection connection = connect.Connect.connection();
            PreparedStatement ps1 = connection.prepareStatement("select * from USER_TABLE where D_ID=2");
            ResultSet rs = ps1.executeQuery();
            while (rs.next())
            {
                StudentModel model=new StudentModel(rs.getInt(2),rs.getString(3), rs.getString(7),rs.getString(6),rs.getString(4), rs.getString(5), rs.getDate(8),rs.getString(9),rs.getInt(10),rs.getInt(11));
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
