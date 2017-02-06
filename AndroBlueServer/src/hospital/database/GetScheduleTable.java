/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.database;

import connect.Connect;
import hospital.model.ScheduleModel;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author STAR
 */
public class GetScheduleTable {
public static ArrayList<ScheduleModel> getScheduleTableList()
    {
        ArrayList<ScheduleModel> scheduleModels=new ArrayList<ScheduleModel>();

        try {
            Connection connection = Connect.connection();
            PreparedStatement psmt1= connection.prepareStatement("select * from schedule_table where D_ID=1");
            ResultSet rs=psmt1.executeQuery();
            while (rs.next())
            {
                ScheduleModel scheduleModel =new ScheduleModel(rs.getString(2),rs.getString(5),rs.getString(3),rs.getString(4));
                scheduleModels.add(scheduleModel);
            }
            psmt1.close();
            } catch (Exception ex) {
            System.out.println(ex);
        }
        return scheduleModels;
    }
}
