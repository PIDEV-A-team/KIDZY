/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import kids.project.utiles.DataBase;

/**
 *
 * @author ferjani
 */
public class ServiceParticipation {
      private  Connection con;
    private Statement ste;
     
    public ServiceParticipation(){
        con = DataBase.getInstance().getConnection();
    }
    
    public int getEnfantP() {
        String req="SELECT COUNT(id_enfant) as nombre from participation GROUP BY id_event";  
        int p=0;
        try {
            ste=con.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
            p=res.getInt(1);
        }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceParticipation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
}
