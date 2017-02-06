/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.database;

import connect.Connect;
import hospital.model.ScheduleModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author STAR
 */
public class SaveScheduleTable {
    public static void saveScheduleTable(ArrayList<ScheduleModel> list)
    {
        try{
            Connection connection = Connect.connection();
            PreparedStatement psmt1= connection.prepareStatement("delete from schedule_table where D_ID=1");
            psmt1.execute();
            psmt1.close();
            for(Object obj:list)
            {
                ScheduleModel model=(ScheduleModel) obj;
                if(!model.getDoctorName().equals("")&&!model.getDays().equals("")&&!model.getTimeArr().equals("")&&!model.getTimeDpr().equals(""))
                {
                    psmt1= connection.prepareStatement("insert into schedule_table(D_ID,NAME,inTime,OUTTIME,Days) values(1,?,?,?,?)");
                    psmt1.setString(1,model.getDoctorName());
                    psmt1.setString(2,model.getTimeArr());
                    psmt1.setString(3,model.getTimeDpr());
                    psmt1.setString(4,model.getDays());
                    psmt1.execute();
                    psmt1.close();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
