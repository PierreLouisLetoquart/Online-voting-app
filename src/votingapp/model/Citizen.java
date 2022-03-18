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
public class Citizen extends User {
    private int nbrVotes;
    private int voteId;

    public Citizen() {
        super();
        this.nbrVotes = 0;
        this.voteId = 0;
    }
    
    public Citizen(int id) {
        super(id);
        this.nbrVotes = 0;
        this.voteId = 0;
    }

    public Citizen(int id, String gender, String fname, String lname, String location, LocalDate dob, int nbrVotes, int voteId) {
        super(id, gender, fname, lname, location, dob);
        this.nbrVotes = nbrVotes;
        this.voteId = voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
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

    public void setNbrVotes(int nbrVotes) {
        this.nbrVotes = nbrVotes;
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

    public int getNbrVotes() {
        return nbrVotes;
    }

    public int getVoteId() {
        return voteId;
    }

    @Override
    public String toString() {
        return "Citizen{id=" + this.getId() + 
                " , fname=" + this.getFname() + 
                ", lname=" + this.getLname() + 
                ", dob=" + this.getDob() + 
                ", location=" + this.getLocation() + 
                ", voteId=" + this.getVoteId() + "}";
    }

}
