/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package college.model;

/**
 *
 * @author STAR
 */
public class NoticeModel {

    private String subject;

    public NoticeModel(String subject) {
        this.subject = subject;
    }

  

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return getSubject();
    }


}
