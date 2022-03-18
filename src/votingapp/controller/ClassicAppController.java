/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package votingapp.controller;

import votingapp.model.Candidate;
import votingapp.model.Citizen;
import votingapp.model.dao.CandidateDaoImpl;
import votingapp.model.dao.CitizenDaoImpl;

/**
 *
 * @author pilou
 */
public class ClassicAppController {
    
    private final CandidateDaoImpl candidateDaoImpl;
    private final Citizen citizen;

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public ClassicAppController(Citizen citizen) {
        this.citizen = citizen;
        this.candidateDaoImpl = new CandidateDaoImpl(new Candidate()); 
    }

    public Candidate initCandidate(int ca_id) {
        if(ca_id > candidateDaoImpl.getNbrCand()) {
            return candidateDaoImpl.search(1);
        } else if(ca_id < 1) {
            return candidateDaoImpl.search(candidateDaoImpl.getNbrCand());
        } else {
            return candidateDaoImpl.search(ca_id);
        }
    }
    
    public int getNbrCandidate() {
        return candidateDaoImpl.getNbrCand();
    }
    
    public Boolean voted(int ca_id) {
        CitizenDaoImpl citizenDaoImpl = new CitizenDaoImpl(citizen);
        return citizenDaoImpl.vote(ca_id) == 1;
    }
    
}
