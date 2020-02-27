/*--------------------
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.entities;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Youssef Mimouni
 */
public class Facture {
	private int id_fact ;
	private double total ;
	private Date date_facture ;
        private Boolean paye ;
    

    public Facture(double total, Boolean paye) {
        this.total = total;
        this.date_facture = java.sql.Date.valueOf(LocalDate.now());
        this.paye = paye;
    }

    public Boolean getpaye() {
        return paye;
    }

    public void setpaye(Boolean paye) {
        this.paye = paye;
    }


    public int getId_fact() {
        return id_fact;
    }

    public void setId_fact(int id_fact) {
        this.id_fact = id_fact;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate_facture() {
        return java.sql.Date.valueOf(LocalDate.now());
    }

    public void setDate_facture(Date date_facture) {
        this.date_facture = java.sql.Date.valueOf(LocalDate.now());
    }

    @Override
    public String toString() {
        return "Facture{" + "id_fact=" + id_fact + ", total=" + total + ", date_facture=" + date_facture + ", paye=" + paye + '}';
    }



    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.id_fact;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Facture other = (Facture) obj;
        if (this.id_fact != other.id_fact) {
            return false;
        }
        return true;
    }

	
	
}
