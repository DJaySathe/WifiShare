/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.model;

/**
 *
 * @author STAR
 */
public class ScheduleModel {
    private String doctorName;
    private String days;
    private String timeArr;
    private String timeDpr;

    public ScheduleModel(String doctorName, String days, String timeArr, String timeDpr) {
        this.doctorName = doctorName;
        this.days = days;
        this.timeArr = timeArr;
        this.timeDpr = timeDpr;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getTimeArr() {
        return timeArr;
    }

    public void setTimeArr(String timeArr) {
        this.timeArr = timeArr;
    }

    public String getTimeDpr() {
        return timeDpr;
    }

    public void setTimeDpr(String timeDpr) {
        this.timeDpr = timeDpr;
    }

    

}
