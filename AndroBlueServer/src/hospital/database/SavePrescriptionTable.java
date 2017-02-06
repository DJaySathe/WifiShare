/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.database;

import connect.Connect;
import hospital.model.PrescriptionModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author STAR
 */
public class SavePrescriptionTable {
 public static void saveScheduleTable(ArrayList<PrescriptionModel> list,PrescriptionModel selectedPrescriptionModel)
    {
        Connection connection=null;
        PreparedStatement psmt1=null;
        try{
            connection = Connect.connection();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
//        try{
//            psmt1= connection.prepareStatement("delete from TABLE_2 where D_ID=1 and T1_ID=?");
//            psmt1.setInt(1,list.get(1).getPreid());
//            psmt1.execute();
//            psmt1.close();
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
        try{
            int i=1;
            for(Object obj:list)
            {

                PrescriptionModel model=(PrescriptionModel) obj;
                if(!model.getDosage().equals("")&&!model.getFreq().equals("")&&!model.getMedecine().equals(""))
                {
                    psmt1= connection.prepareStatement("insert into medicine_table (D_ID,Prescription_ID,Medicine_ID,Medicine_Name,Dosage,Frequency) values(1,?,?,?,?,?)");
                    psmt1.setInt(1, selectedPrescriptionModel.getPreid());
                    psmt1.setString(2,""+i);
                    psmt1.setString(3,model.getMedecine());
                    psmt1.setString(4,model.getDosage());
                    psmt1.setString(5,model.getFreq());
                    psmt1.execute();
                    psmt1.close();
                    i++;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
