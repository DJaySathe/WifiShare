/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.database;

import connect.Connect;
import hospital.model.MapModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author STAR
 */
public class GetMap {
public static ArrayList<MapModel> getMapList()
    {
        ArrayList<MapModel> maps=new ArrayList<MapModel>();

        try {
            Connection connection = Connect.connection();
            PreparedStatement psmt1= connection.prepareStatement("select * from IMAGE_TABLE where D_ID=1 and TAG='map'");
            ResultSet rs=psmt1.executeQuery();
            while (rs.next())
            {
                MapModel mm =new MapModel(rs.getString(3));
                maps.add(mm);
            }
            psmt1.close();
            } catch (Exception ex) {
            System.out.println(ex);
        }
        return maps;
    }
}
