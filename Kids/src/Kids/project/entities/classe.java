/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.entities;

/**
 *
 * @author ferjani
 */
public class classe {

    private int id_classe;
    private String libelle_cla;
    private String description;

    public classe() {
    }

    public classe(int id_classe, String libelle_cla, String description) {
        this.id_classe = id_classe;
        this.libelle_cla = libelle_cla;
        this.description = description;
    }

    public classe(String libelle_cla, String description) {
        this.libelle_cla = libelle_cla;
        this.description = description;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public String getLibelle_cla() {
        return libelle_cla;
    }

    public void setLibelle_cla(String libelle_cla) {
        this.libelle_cla = libelle_cla;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
