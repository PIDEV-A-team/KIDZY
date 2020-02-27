/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.entities;

/**
 *
 * @author ala
 */
public class parent extends personne {
    
  

    public parent( String login, String password, String nom, String prenom, String cin, String tel, String role) {
        super(login, password, nom, prenom, cin, tel, role);
    }

    public parent(int id, String login, String password, String nom, String prenom, String cin, String tel, String role) {
        super(id,login, password, nom, prenom, cin, tel, role);

    }

   


}
