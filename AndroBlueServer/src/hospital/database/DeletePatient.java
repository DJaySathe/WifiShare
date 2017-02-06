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
public class DeletePatient {
 public static boolean deletePatient(PatientModel patient)
    {
        boolean success=false;
        try{
            Connection connection=Connect.connection();
            PreparedStatement ps=connection.prepareStatement("delete from USER_TABLE where U_ID=? and D_ID=1");
            ps.setInt(1,patient.getId());
            ps.execute();
            ps.close();
            ps=connection.prepareStatement("delete from TABLE_4 where U_ID=? and D_ID=1");
            ps.setInt(1,patient.getId());
            ps.execute();
            ps.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return success;
    }
}
