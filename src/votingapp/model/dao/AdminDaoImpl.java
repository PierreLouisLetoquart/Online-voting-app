/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package votingapp.model.dao;

import votingapp.model.Admin;
import java.sql.*;
import java.time.LocalDate;
import votingapp.model.Candidate;
import votingapp.model.Citizen;

/**
 *
 * @author pilou
 */
public class AdminDaoImpl implements usersDao {
    
    private final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/voteit_maindb";
    /*classic_user_voteit : this mysql user have access to the entire db in READ only*/
    private final String DB_USERNAME = "classic_user_voteit";
    private final String DB_PASSWORD = "TheUserPassword";
    
    private Admin admin;
    private Connection conn;

    public AdminDaoImpl(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    
    

    @Override
    public Boolean log(String hash) {
        try{
                Class.forName(DB_DRIVER);
                conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                if(conn != null){
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE us_id = " + this.admin.getId() + " AND us_hash_pw = \"" + hash + "\";");
                    
                    if(!rs.next()) {
                        System.out.println("Wrong password or user id.");
                        return false;
                    } else {
                        this.admin.setFname(rs.getString("us_f_name"));
                        this.admin.setLname(rs.getString("us_l_name"));
                        String date[] = rs.getString("us_date_of_birth").split("-");
                        this.admin.setDob(LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])));
                        this.admin.setGender(rs.getString("us_gender"));
                        this.admin.setLocation(rs.getString("us_location"));
                        
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
    public Object search(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int vote(int ca_id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int create(Citizen cit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public int create(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int create(Candidate can) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public int create(Admin adm) {
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
