/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package college.database;

import connect.Connect;
import college.model.ScheduleModel;
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
            PreparedStatement psmt1= connection.prepareStatement("delete from schedule_table where D_ID=2");
            psmt1.execute();
            psmt1.close();
            for(Object obj:list)
            {

                ScheduleModel model=(ScheduleModel) obj;
                if(!model.getServices().equals("")&&!model.getOpTime().equals("")&&!model.getClsTime().equals("")&&!model.getDays().equals(""))
                {
                    psmt1= connection.prepareStatement("insert into schedule_table(D_ID,NAME,inTime,OUTTIME,Days) values(2,?,?,?,?)");
                    psmt1.setString(1,model.getServices());
                    psmt1.setString(2,model.getOpTime());
                    psmt1.setString(3,model.getClsTime());
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
