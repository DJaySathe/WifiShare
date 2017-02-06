/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mall.model;

import java.util.Date;

/**
 *
 * @author STAR
 */
public class CustomerModel {
        private int id;
        private String name;
        private String phone;
        private String address;
        private String gender;
        private String bloodgroup;
        private Date dob;
        private int bonusPoints;


    public CustomerModel()
    {

    }
    public CustomerModel(int id, String name, String phone, String address, String gender, String bloodgroup, Date dob, int  bonusPoints) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.bloodgroup = bloodgroup;
        this.dob = dob;
        this.bonusPoints = bonusPoints;
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

    public int getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

   

    @Override
    public String toString() {
        return getId()+" "+getName();
    }


}
