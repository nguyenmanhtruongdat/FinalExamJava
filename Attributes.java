/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Truong Dat
 */
public class Attributes {

    private String id;
    private String name;
    private String gender;
    private Date dob;
    private String country;
    private String position;
    private String department;

    public Attributes(String string, String string0, float aFloat, int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Attributes() {
    }

    public Attributes(String id, String name, String gender, Date dob, String country, String position, String department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.country = country;
        this.position = position;
        this.department = department;
    }

    public Attributes(String id, String name,String position) {
        this.id = id;
        this.name = name;
        this.position=position;
    }

    public Attributes(String name) {
        this.name = name;
    }
    

}
