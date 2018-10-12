package be.thomasmore.travelmore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;

@Entity
public class BetalingType {
    @Id
    private int id;
    @Column(name = "naam")
    private String naam;
    @OneToMany
    private ArrayList<Betaling> betalingen;

    public BetalingType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public ArrayList<Betaling> getBetalingen() {
        return betalingen;
    }

    public void setBetalingen(ArrayList<Betaling> betalingen) {
        this.betalingen = betalingen;
    }
}
