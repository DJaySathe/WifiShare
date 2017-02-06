/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mall.database;

import connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mall.model.*;
/**
 *
 * @author STAR
 */
public class GetTip {
    public static ArrayList<TipModel> getPatientList()
    {
        ArrayList<TipModel> tips=new ArrayList<TipModel>();

        try {
            Connection connection = Connect.connection();
            PreparedStatement psmt1= connection.prepareStatement("select * from TIPS_TABLE where D_ID=3");
            ResultSet rs=psmt1.executeQuery();
            while (rs.next())
            {
                TipModel tm =new TipModel(rs.getString(2));
                tips.add(tm);
            }
            psmt1.close();
            } catch (Exception ex) {
            System.out.println(ex);
        }
        return tips;
    }
}
