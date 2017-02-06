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
public class AddNotice {

    public static void addNotice(NoticeModel noticeModel) {
        try{
            Connection connection = Connect.connection();
            PreparedStatement psmt1= connection.prepareStatement("insert into IMAGE_TABLE values(2,'notice',?)");
            psmt1.setString(1,noticeModel.getSubject());
            psmt1.execute();
            psmt1.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
