/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package college.database;

import connect.Connect;
import college.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author STAR
 */
public class AddTip {
    public static boolean addTip(TipModel model)
    {
        boolean success=false;
        int id=0;
        try{
            Connection connection = Connect.connection();
            PreparedStatement psmt1= connection.prepareStatement("insert into TIPS_TABLE values(2,?)");
            psmt1.setString(1, model.getTip());
            psmt1.execute();
            psmt1.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return success;
    }
}
