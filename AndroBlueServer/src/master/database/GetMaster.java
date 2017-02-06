/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package master.database;


import connect.*;
import java.util.ArrayList;
import master.model.MasterModel;
import java.sql.*;
/**
 *
 * @author STAR
 */
public class GetMaster {
    public static ArrayList<MasterModel> getMaster()
    {
        ArrayList<MasterModel> list=new ArrayList<MasterModel>();
        try{
            Connection connection = Connect.connection();
            PreparedStatement statement=connection.prepareStatement("select * from MASTER_TABLE");
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next())
            {
                MasterModel masterModel=new MasterModel(resultSet.getInt(1),resultSet.getString(2));
                list.add(masterModel);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    
}
