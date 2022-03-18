/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package votingapp.model.dao;

import java.sql.*;
import java.time.LocalDate;
import votingapp.model.Candidate;

/**
 *
 * @author pilou
 */
public class CandidateDaoImpl implements usersDao {
    
    private final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/voteit_maindb";
    /*classic_user_voteit : this mysql user have access to the entire db in READ only*/
    private final String DB_USERNAME = "classic_user_voteit";
    private final String DB_PASSWORD = "TheUserPassword";
    
    private Candidate candidate;
    private Connection conn;

    public CandidateDaoImpl(Candidate candidate) {
        this.candidate = candidate;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
    
    
    

    @Override
    public Boolean log(String hash) {
        try{
                Class.forName(DB_DRIVER);
                conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                if(conn != null){
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE us_id = " + this.candidate.getId() + " AND us_hash_pw = \"" + hash + "\";");
                    if(!rs.next()) {
                        System.out.println("Wrong password or user id.");
                        return false;
                    } else {
                        this.candidate.setFname(rs.getString("us_f_name"));
                        this.candidate.setLname(rs.getString("us_l_name"));
                        String date[] = rs.getString("us_date_of_birth").split("-");
                        this.candidate.setDob(LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])));
                        this.candidate.setGender(rs.getString("us_gender"));
                        this.candidate.setLocation(rs.getString("us_location"));
                        ResultSet rs2 = stmt.executeQuery("SELECT * FROM candidates WHERE us_id = " + this.candidate.getId() + ";");
                        if(rs2.next()){
                            this.candidate.setDescription(rs2.getString("ca_description"));
                            this.candidate.setCaId(Integer.parseInt(rs2.getString("ca_id")));
                            this.candidate.setPoliticParty(rs2.getString("ca_politic_party"));
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
    public Candidate search(int id) {
        try{
                Class.forName(DB_DRIVER);
                conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                if(conn != null){
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE us_id = (SELECT us_id FROM candidates WHERE ca_id =" + id + " );");
                    if(rs.next()){
                        this.candidate.setId(Integer.parseInt(rs.getString("us_id")));
                        this.candidate.setFname(rs.getString("us_f_name"));
                        this.candidate.setLname(rs.getString("us_l_name"));
                        String date[] = rs.getString("us_date_of_birth").split("-");
                        this.candidate.setDob(LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])));
                        this.candidate.setGender(rs.getString("us_gender"));
                        this.candidate.setLocation(rs.getString("us_location"));
                        this.candidate.setCaId(id);
                        ResultSet rs2 = stmt.executeQuery("SELECT * FROM candidates WHERE ca_id = " + this.candidate.getCaId()+ "");
                        if(rs2.next()) {
                            this.candidate.setDescription(rs2.getString("ca_description"));
                            this.candidate.setPoliticParty(rs2.getString("ca_politic_party"));
                            return this.candidate;
                        } else {
                            return null;
                        }
                    } else {
                        return null;
                    }
                }else{
                   System.out.println("Failed to connect.");
                   return null;
                }
        }catch(ClassNotFoundException | SQLException e){
                System.out.println(e);
                return null;
        }
    
    }

    @Override
    public int vote(int ca_id) {
        throw new UnsupportedOperationException("Not supported for candidate.");
    }

    @Override
    public int create(Object obj) {
        throw new UnsupportedOperationException("Not supported for candidate.");
    }

    @Override
    public int delete(Object obj) {
        throw new UnsupportedOperationException("Not supported for candidate.");
    }

    @Override
    public int modify(Object obj) {
        throw new UnsupportedOperationException("Not supported for candidate.");
    }
    
    public int getNbrCand() {
        try{
                Class.forName(DB_DRIVER);
                conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                if(conn != null){
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as nbr FROM candidates");
                    if(rs.next()){
                        return rs.getInt("nbr");
                    } else {
                        return -1;
                    }
                }else{
                   System.out.println("Failed to connect.");
                   return 1;
                }
        }catch(ClassNotFoundException | SQLException e){
                System.out.println(e);
                return -1;
        }
    }
    
}
