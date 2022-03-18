/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package votingapp.model.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import votingapp.model.Citizen;

/**
 *
 * @author pilou
 */
public class CitizenDaoImpl implements usersDao {
    
    private final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/voteit_maindb";
    /*classic_user_voteit : this mysql user have access to the entire db in READ only*/
    private final String DB_USERNAME = "classic_user_voteit";
    private final String DB_PASSWORD = "TheUserPassword";
    
    private Citizen citizen;
    private Connection conn;

    public CitizenDaoImpl(Citizen citizen) {
        this.citizen = citizen;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    

    @Override
    public Boolean log(String hash) {
        try{
                Class.forName(DB_DRIVER);
                conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                if(conn != null){
                    
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE us_id = " + this.citizen.getId() + " AND us_hash_pw = \"" + hash + "\";");
                    
                    if(!rs.next()) {
                        System.out.println("Wrong password or user id.");
                        return false;
                    } else {
                        this.citizen.setFname(rs.getString("us_f_name"));
                        this.citizen.setLname(rs.getString("us_l_name"));
                        String date[] = rs.getString("us_date_of_birth").split("-");
                        this.citizen.setDob(LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])));
                        this.citizen.setGender(rs.getString("us_gender"));
                        this.citizen.setLocation(rs.getString("us_location"));
                        
                        
                        ResultSet rs2 = stmt.executeQuery("SELECT * FROM citizens WHERE us_id = " + this.citizen.getId() + ";");
                        if(rs2.next()){
                            this.citizen.setNbrVotes(rs2.getInt("ci_vote_nbr"));
                            this.citizen.setVoteId(rs2.getInt("ci_vote_id"));
                        } else {
                            System.out.println("Problem with vote id, contact your local administration!");
                            return false;
                        }
                        
                        System.out.println("Successfully connected.");
                        return true;
                    }
                    
                }else{
                    
                   System.out.println("Failed to connect.");
                   return false;
                   
                }
        }catch(ClassNotFoundException | SQLException e){
                System.out.println(e);
                return false;
        }
    }

    @Override
    public Citizen search(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int vote(int ca_id) {
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            
            if(conn != null){
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM votes WHERE ci_vote_id = " + this.citizen.getVoteId());
                if(rs.next()) {
                    return -1;
                } else {
                    stmt.executeUpdate("INSERT INTO votes VALUES (" + this.citizen.getVoteId() + "," + ca_id + ",\"" + LocalDate.now() + "\",\"" + this.citizen.getLocation() + "\");");
                    return 1;
                }
            } else {
                return 0;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
            return 0;
        }
    }

    @Override
    public int create(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int modify(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
