/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mall.database;

import connect.Connect;
import mall.model.MapModel;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author STAR
 */
public class UpdateMap {
public static boolean updateMap(MapModel oldModel,MapModel newModel)
    {
        boolean success=false;
        try{
            Connection connection=Connect.connection();
            PreparedStatement ps=connection.prepareStatement("update IMAGE_TABLE set IMAGE=? where IMAGE=? and D_ID=3 and TAG='map'");
            ps.setString(1,newModel.getFloorName());
            ps.setString(2,oldModel.getFloorName());
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
