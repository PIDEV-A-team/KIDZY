package kids.project.entities;

import java.sql.Date;
import java.util.Comparator;

public class personne implements Comparator<personne> {

    private int id;
    private String username;
    private String username_canonical;
    private String email;
    private String email_canonical;
    private short enabled;
    private String salt;
    private Date lastLogin;
    private Date passwordRequestedAt;
    private String password;
    private String confirmation_token;
    private String nom;
    private String prenom;
    private String cin;
    private String tel;
    private String role;
    private int code;
    private String tentative;

    public personne(String username, String password, String nom, String prenom, String cin, String tel, String role, int code, String tentative) {
        this.username = username;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.tel = tel;
        this.role = role;
        this.code = code;
        this.tentative = tentative;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTentative() {
        return tentative;
    }

    public void setTentative(String tentative) {
        this.tentative = tentative;
    }

    public personne() {
    }

    public personne(int id, String username, String password, String nom, String prenom, String cin, String tel, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;

        this.cin = cin;
        this.tel = tel;
        this.role = role;
    }

    public personne( String username, String password, String nom, String prenom,String cin, String tel, String role) {

        this.username = username;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.tel = tel;
        this.role = role;
    }
    public personne( String username,String password,String nom,String prenom , String cin, String tel, String role,int code) {

        this.username = username;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.tel = tel;
        this.role = role;
        this.code=code;
    }

    public personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public personne(String username) {
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public void setEnabled(short enabled) {
        this.enabled = enabled;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setPasswordRequestedAt(Date passwordRequestedAt) {
        this.passwordRequestedAt = passwordRequestedAt;
    }

    public void setConfirmation_token(String confirmation_token) {
        this.confirmation_token = confirmation_token;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPassword() {
        return password;
    }

    public String getCin() {
        return cin;
    }

    public String getTel() {
        return tel;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public short getEnabled() {
        return enabled;
    }

    public String getSalt() {
        return salt;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public Date getPasswordRequestedAt() {
        return passwordRequestedAt;
    }

    public String getConfirmation_token() {
        return confirmation_token;
    }

    @Override
    public String toString() {
        return "personne{" + "id=" + id + ", username=" + username + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", tel=" + tel + ", role=" + role + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final personne other = (personne) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public int compare(personne o1, personne o2) {
        return (o1.getNom().compareTo(o2.getNom()));
    }

}
