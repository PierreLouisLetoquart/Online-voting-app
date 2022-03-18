package votingapp.model;

import java.time.LocalDate;

/**
 *
 * @author pilou
 */
public abstract class User {
    
    protected int id;
    protected String gender;
    protected String fname;
    protected String lname;
    protected String location;
    protected LocalDate dob;

    public User() {
        this(0, "", "", "", "", LocalDate.now());
    }
    
    public User(int id) {
        this(id, "", "", "", "", LocalDate.now());
    }

    public User(int id, String gender, String fname, String lname, String location, LocalDate dob) {
        this.id = id;
        this.gender = gender;
        this.fname = fname;
        this.lname = lname;
        this.location = location;
        this.dob = dob;
    }
    
}
