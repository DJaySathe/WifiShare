/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package college.database;

import college.model.NoticeModel;
import connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author STAR
 */
public class GetNotice {

    public static ArrayList<NoticeModel> getNoticeList() {
        ArrayList<NoticeModel> notices=new ArrayList<NoticeModel>();

        try {
            Connection connection = Connect.connection();
            PreparedStatement psmt1= connection.prepareStatement("select * from IMAGE_TABLE where D_ID=2 and TAG='notice'");
            ResultSet rs=psmt1.executeQuery();
            while (rs.next())
            {
                NoticeModel mm =new NoticeModel(rs.getString(3));
                notices.add(mm);
            }
            psmt1.close();
            } catch (Exception ex) {
            System.out.println(ex);
        }
        return notices;
    }

}
