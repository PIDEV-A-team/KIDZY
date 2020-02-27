/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.entities;

import java.util.Objects;
import javafx.event.Event;

/**
 *
 * @author ASUS
 */
public class participation {

    private Event event;
    private int id_event;
    private int id_enf;
    private String description;
    private enfant enfant;

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getId_enf() {
        return id_enf;
    }

    public void setId_enf(int id_enf) {
        this.id_enf = id_enf;
    }
    private String date_partici;

    

    public participation() {
    }

    public participation(int id_event, int id_enf, String date_partici, String description) {
        this.id_event = id_event;
        this.id_enf = id_enf;
        this.date_partici = date_partici;
        this.description = description;
    }

    public participation(int id_enf, int id_event, String date_partici) {
        this.id_event = id_event;
        this.id_enf = id_enf;
        this.date_partici = date_partici;
    }

    public participation(enfant enfant, Event event, String date_partici) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Event getEvent() {
        return event;
    }

    public void setDate_partici(String date_partici) {
        this.date_partici = date_partici;
    }

    public String getDate_partici() {
        return date_partici;
    }

    public participation(String date_partici) {
        this.date_partici = date_partici;
    }

    public String getDescription() {
        return description;
    }

    public enfant getEnfant() {
        return enfant;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEnfant(enfant enfant) {
        this.enfant = enfant;
    }

    @Override
    public String toString() {
        return "participation{" + "event=" + event + ", description=" + description + ", enfant=" + enfant + ", date_partici=" + date_partici + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.event);
        hash = 23 * hash + Objects.hashCode(this.enfant);
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
        final participation other = (participation) obj;
        if (!Objects.equals(this.event, other.event)) {
            return false;
        }
        if (!Objects.equals(this.enfant, other.enfant)) {
            return false;
        }
        return true;
    }

}
