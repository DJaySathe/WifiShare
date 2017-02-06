/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package college.database;

import college.model.NoticeModel;
import connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author STAR
 */
public class DeleteNotice {

    public static void deleteNotice(NoticeModel selectedNotice) {
        try{
            Connection connection=Connect.connection();
            PreparedStatement ps=connection.prepareStatement("delete from IMAGE_TABLE where IMAGE=? and D_ID=2 and TAG='notice'");
            ps.setString(1,selectedNotice.getSubject());
            ps.execute();
            ps.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
