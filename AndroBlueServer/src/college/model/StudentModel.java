/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package college.model;

import java.util.Date;

/**
 *
 * @author STAR
 */
public class StudentModel {
        private int id;
        private String name;
        private String phone;
        private String address;
        private String gender;
        private String bloodgroup;
        private Date dob;
        private String semester;
        private double percentage;
        private double aggregate;


    public StudentModel()
    {

    }
    public StudentModel(int id, String name, String phone, String address, String gender, String bloodgroup, Date dob, String semester, double percentage, double aggregate) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.bloodgroup = bloodgroup;
        this.dob = dob;
        this.semester = semester;
        this.percentage = percentage;
        this.aggregate = aggregate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAggregate() {
        return aggregate;
    }

    public void setAggregate(double aggregate) {
        this.aggregate = aggregate;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return getId()+" "+getName();
    }


}
