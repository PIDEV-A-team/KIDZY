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
public class maitre extends personne {
    private int nbreclasses;

  
   
    public maitre( String login, String password, String nom, String prenom, String cin, String tel, String role) {
        super(login, password, nom, prenom, cin, tel, role);
    }

    public maitre(int id, String login, String password, String nom, String prenom, String cin, String tel, String role) {
        super(id,login, password, nom, prenom, cin, tel, role);

    }

   

    public int getNbreclasses() {
        return nbreclasses;
    }

    public void setNbreclasses(int nbreclasses) {
        this.nbreclasses = nbreclasses;
    }

    @Override
    public String toString() {
        return super.toString()+"maitre{" + "nbreclasses=" + nbreclasses + '}';
    }
    
    
}
