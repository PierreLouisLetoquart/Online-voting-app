/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package votingapp.model;

import java.time.LocalDate;
/**
 *
 * @author pilou
 */
public class Admin extends User {

    public Admin() {
        super();
    }

    public Admin(int id) {
        super(id);
    }

    public Admin(int id, String gender, String fname, String lname, String location, LocalDate dob) {
        super(id, gender, fname, lname, location, dob);
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getFname() {
        return fname;
    }

    public String getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    public String getLname() {
        return lname;
    }

    public String getLocation() {
        return location;
    }
    
}
