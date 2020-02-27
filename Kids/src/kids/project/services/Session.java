/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.services;

import kids.project.entities.personne;



public class Session {
     private static personne userloggedin;
        // pour initialiser la session avec le user connecté lors de l'authentification
        public static void SetSession(personne user){
		userloggedin= user;
	}
        // Pour obtenir le User connecté
         public static personne GetSession(){
		 return userloggedin;
	}
         // Pour vérifier s'il y a un user connecté
         public static boolean SessionOn(){
             if(userloggedin != null)
                 return true;
             return false;
         }
         //Pour libérer la session avant le logout
         public static void DestroySession(){
             userloggedin =null;
         }
    
}
