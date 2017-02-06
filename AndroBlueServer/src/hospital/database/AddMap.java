/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.database;

import connect.Connect;
import hospital.model.MapModel;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author STAR
 */
public class AddMap {
public static boolean addMap(MapModel model)
    {
        boolean success=false;
        int id=0;
        try{
            Connection connection = Connect.connection();
            PreparedStatement psmt1= connection.prepareStatement("insert into IMAGE_TABLE values(1,'map',?)");
            psmt1.setString(1, model.getFloorName());
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
