/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.database;

import hospital.model.PatientModel;
import java.sql.Connection;
import connect.Connect;
import hospital.model.TipModel;
import java.sql.Date;
import java.sql.PreparedStatement;
/**
 *
 * @author STAR
 */
public class DeleteTip {
    public static boolean deleteTip(TipModel model)
    {
        boolean success=false;
        try{
            Connection connection=Connect.connection();
            PreparedStatement ps=connection.prepareStatement("delete from TIPS_TABLE where TIP=? and D_ID=1");
            ps.setString(1,model.getTip());
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
