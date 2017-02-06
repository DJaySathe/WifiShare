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
public class DeleteMap {
public static boolean deleteMap(MapModel model)
    {
        boolean success=false;
        try{
            Connection connection=Connect.connection();
            PreparedStatement ps=connection.prepareStatement("delete from IMAGE_TABLE where IMAGE=? and D_ID=1 and TAG='map'");
            ps.setString(1,model.getFloorName());
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
