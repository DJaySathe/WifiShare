/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.database;

import connect.Connect;
import hospital.model.PrescriptionModel;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author STAR
 */
public class GetPrescription {
public static ArrayList<PrescriptionModel> getPrescription(PrescriptionModel model)
    {

        ArrayList<PrescriptionModel> prescriptionModels=new ArrayList<PrescriptionModel>();

        try {
            Connection connection = Connect.connection();
            PreparedStatement psmt1= connection.prepareStatement("select * from medicine_table where D_ID=1 and Prescription_ID=?");
            psmt1.setInt(1, model.getPreid());
            ResultSet rs=psmt1.executeQuery();
            while (rs.next())
            {
                PrescriptionModel pm =new PrescriptionModel(rs.getInt(2),rs.getString(4),rs.getString(5),rs.getString(6));
                prescriptionModels.add(pm);
//                System.out.println("This->"+pm.getDosage());
            }
            psmt1.close();
            } catch (Exception ex) {
            System.out.println(ex);
        }
        return prescriptionModels;
    }
// public static void main(String[] args) {
//        PrescriptionModel model=new PrescriptionModel();
//        model.setPreid(1);
//        getPrescription(model);
// }
}
