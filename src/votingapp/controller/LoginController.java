/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package votingapp.controller;

import votingapp.model.Admin;
import votingapp.model.Candidate;
import votingapp.model.Citizen;
import votingapp.model.dao.AdminDaoImpl;
import votingapp.model.dao.CandidateDaoImpl;
import votingapp.model.dao.CitizenDaoImpl;
import votingapp.view.ClassicAppView;
import votingapp.view.LoginView;

/**
 *
 * @author pilou
 */
public class LoginController {

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public LoginController(int user_type, int id, String hash) {
        switch (user_type) {
            case 1 -> {
                    CitizenDaoImpl dao = new CitizenDaoImpl(new Citizen(id));
                    if(dao.log(hash)){
                        Citizen c = dao.getCitizen();
                        new ClassicAppView(c).setVisible(true);
                    } else {
                        new LoginView(user_type, false).setVisible(true);
                    }
                }
            case 2 -> {
                    CandidateDaoImpl dao = new CandidateDaoImpl(new Candidate(id));
                    if(dao.log(hash)){
                        Candidate c = dao.getCandidate();
                    } else {
                        new LoginView(user_type, false).setVisible(true);
                    }
                }
            case 3 -> {
                    AdminDaoImpl dao = new AdminDaoImpl(new Admin(id));
                    if(dao.log(hash)) {
                        Admin a = dao.getAdmin();
                    } else {
                        new LoginView(user_type, false).setVisible(true);
                    }       
                }
            default -> System.out.println("error");
        }
    }
    
}
