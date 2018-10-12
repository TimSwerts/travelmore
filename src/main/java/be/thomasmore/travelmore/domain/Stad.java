package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Stad")

public class Stad {
    @Id
    private int id;

    @Column(name = "naam")
    private String naam;

    @ManyToOne
    private Land land;

    @OneToMany
    private List<Reis> bestemmingen;

    @OneToMany
    private List<Reis> vertreklocaties;

    public Stad() {
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

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    public List<Reis> getBestemmingen() {
        return bestemmingen;
    }

    public void setBestemmingen(List<Reis> bestemmingen) {
        this.bestemmingen = bestemmingen;
    }

    public List<Reis> getVertreklocaties() {
        return vertreklocaties;
    }

    public void setVertreklocaties(List<Reis> vertreklocaties) {
        this.vertreklocaties = vertreklocaties;
    }
}
