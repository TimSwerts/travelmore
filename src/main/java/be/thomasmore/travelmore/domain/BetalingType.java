package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class BetalingType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "naam")
    private String naam;
    @OneToMany(mappedBy = "betalingType")
    private List<Betaling> betalingen = new ArrayList<Betaling>();

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
