/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mall.database;

import java.sql.Connection;
import connect.Connect;
import mall.model.TipModel;
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
            PreparedStatement ps=connection.prepareStatement("delete from TIPS_TABLE where TIP=? and D_ID=3");
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
