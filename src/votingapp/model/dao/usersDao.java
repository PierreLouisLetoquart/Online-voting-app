/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package votingapp.model.dao;
/**
 *
 * @author pilou
 */
public interface usersDao {
    Boolean log(String hash);
    Object search(int id);
    int vote(int ca_id);
    int create(Object obj);
    int delete(Object obj);
    int modify(Object obj);
}
