/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package college.model;


/**
 *
 * @author STAR
 */
public class ScheduleModel {
    private String services;
    private String opTime;
    private String clsTime;
    private String days;
    public String getClsTime() {
        return clsTime;
    }

    public void setClsTime(String clsTime) {
        this.clsTime = clsTime;
    }

    public String getOpTime() {
        return opTime;
    }

    public void setOpTime(String opTime) {
        this.opTime = opTime;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public ScheduleModel(String services, String opTime, String clsTime,String days) {
        this.services = services;
        this.opTime = opTime;
        this.clsTime = clsTime;
        this.days=days;
    }


}
