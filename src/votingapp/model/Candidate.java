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
public class Candidate extends User {
    private String politicParty;
    private String description;
    private int caId;

    public Candidate() {
        super();
        this.politicParty = "";
        this.description = "";
    }

    public Candidate(int id) {
        super(id);
        this.politicParty = "";
        this.description = "";
        this.caId = 0;
    }

    public Candidate(String politicParty, String description, int id, String gender, String fname, String lname, String location, LocalDate dob, int caId) {
        super(id, gender, fname, lname, location, dob);
        this.politicParty = politicParty;
        this.description = description;
        this.caId = caId;
    }

    public void setCaId(int caId) {
        this.caId = caId;
    }
    
    public void setDescription(String description) {
        this.description = description;
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

    public void setPoliticParty(String politicParty) {
        this.politicParty = politicParty;
    }

    public String getDescription() {
        return description;
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

    public String getPoliticParty() {
        return politicParty;
    }

    public int getCaId() {
        return caId;
    }
    
    @Override
    public String toString() {
        return "Citizen{id=" + this.getId() + 
                " , fname=" + this.getFname() + 
                ", lname=" + this.getLname() + 
                ", dob=" + this.getDob() + 
                ", location=" + this.getLocation() + 
                ", party=" + this.getPoliticParty()+ "}";
    }


}
