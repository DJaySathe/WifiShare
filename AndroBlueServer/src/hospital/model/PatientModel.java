/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.model;

import java.util.Date;

/**
 *
 * @author STAR
 */
public class PatientModel {

        private int id;
        private String name;
        private String phone;
        private String address;
        private String gender;
        private String bloodgroup;
        private Date dob;
        private int cunFee;
        private int medExp;
        private int opExp;

    public int getCunFee() {
        return cunFee;
    }

    public void setCunFee(int cunFee) {
        this.cunFee = cunFee;
    }

    public int getMedExp() {
        return medExp;
    }

    public void setMedExp(int medExp) {
        this.medExp = medExp;
    }

    public int getOpExp() {
        return opExp;
    }

    public void setOpExp(int opExp) {
        this.opExp = opExp;
    }

    public PatientModel(int id, String name, String phone, String address, String gender, String bloodgroup, Date dob, int cunFee, int medExp, int opExp) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.bloodgroup = bloodgroup;
        this.dob = dob;
        this.cunFee = cunFee;
        this.medExp = medExp;
        this.opExp = opExp;
    }

   

    public PatientModel() {
    }
       

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return getId()+" "+getName();
    }



}
