/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.database;

import connect.Connect;
import hospital.model.PatientModel;
import hospital.model.PrescriptionModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author STAR
 */
public class GetPrescriptionList {
public static ArrayList<PrescriptionModel> getPrescriptionList(PatientModel model)
    {
        ArrayList<PrescriptionModel> preList=new ArrayList<PrescriptionModel>();
        try {
            Connection connection = Connect.connection();
            PreparedStatement psmt1= connection.prepareStatement("select Prescription_ID from prescription_table where D_ID=1 and U_ID=?");
            psmt1.setInt(1, model.getId());
            ResultSet rs=psmt1.executeQuery();
            while (rs.next())
            {
                PrescriptionModel p=new PrescriptionModel();
                p.setPreid(rs.getInt("Prescription_ID"));
                preList.add(p);
                //System.out.println("ID="+p.getPreid());
            }
            psmt1.close();

            } catch (Exception ex) {
            ex.printStackTrace();
        }
        return preList;
    }
//    public static void main(String[] args) {
//        PatientModel model=new PatientModel();
//        model.setId(1);
//        getPrescriptionList(model);
//    }

}
