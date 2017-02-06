/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package college.database;

import college.model.StudentModel;
import connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author STAR
 */
public class DeleteStudent {

    public static boolean delete(StudentModel selectedStudent) {
        boolean status=false;
        try {
            Connection connection=Connect.connection();
            PreparedStatement ps=connection.prepareStatement("delete from USER_TABLE where U_ID=? and D_ID=2");
            ps.setInt(1,selectedStudent.getId());
            status = !ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

}
