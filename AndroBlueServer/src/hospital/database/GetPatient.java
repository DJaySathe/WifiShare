/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.database;

import connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import hospital.model.PatientModel;

/**
 *
 * @author STAR
 */
public class GetPatient {

    public static ArrayList<PatientModel> getPatientList()
    {
        ArrayList<PatientModel> patients=new ArrayList<PatientModel>();
        try {
            Connection connection = Connect.connection();
            PreparedStatement psmt1= connection.prepareStatement("select * from USER_TABLE where D_ID=1");
            ResultSet rs=psmt1.executeQuery();
            while (rs.next())
            {
                PatientModel p=new PatientModel(rs.getInt(2),rs.getString(3), rs.getString(7),rs.getString(6),rs.getString(4), rs.getString(5), rs.getDate(8),rs.getInt(9),rs.getInt(10),rs.getInt(11));
                patients.add(p);
                //System.out.println("Name="+p.getName());
            }
            psmt1.close();
            } catch (Exception ex) {
            System.out.println(ex);
        }
        return patients;
    }
//    public static void main(String[] args) {
//        getPatientList();
//    }
}
