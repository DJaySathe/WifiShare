/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.database;

import java.sql.PreparedStatement;
import connect.Connect;
import hospital.model.PatientModel;
import hospital.model.PrescriptionModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;

/**
 *
 * @author STAR
 */
public class AddPrescription {
    public static void addPrescription(PatientModel patientModel)
    {
        try
        {
            Connection connection = Connect.connection();
            PreparedStatement ps=connection.prepareStatement("INSERT INTO prescription_table(D_ID,U_ID,Prescription_Date) values(1,?,?)");
            ps.setInt(1, patientModel.getId());
            ps.setDate(2,new Date(new java.util.Date().getTime()));
            ps.execute();
            ps.close();
//            ps=connection.prepareStatement("select Prescription_ID from prescription_table where D_ID=1 and U_ID=?");
//            ps.setInt(1, patientModel.getId());
//            ResultSet rs = ps.executeQuery();
//            int lastPID = 0;
//            while(rs.next())
//            {
//                lastPID=rs.getInt("Prescription_ID");
//            }
//
//            ps.close();
//            for(int i=1;i<=10;i++)
//            {
//                    ps=connection.prepareStatement("insert into table_2 values(1,?,?,?,?,?)");
//                    ps.setInt(1, lastPID);
//                    ps.setString(2,i+"");
//                    ps.setString(3, "");
//                    ps.setString(4, "");
//                    ps.setString(5, "");
//                    ps.execute();
//                    ps.close();
//            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
