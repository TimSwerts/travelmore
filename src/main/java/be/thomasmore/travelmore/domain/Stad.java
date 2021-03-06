package be.thomasmore.travelmore.domain;

import javax.inject.Named;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stad")

@NamedQueries(
        {
                @NamedQuery(
                        name = Stad.FIND_ALL,
                        query = "SELECT s from Stad s "
                ),
                @NamedQuery(
                        name = Stad.FIND_BY_ID,
                        query = "SELECT s FROM Stad s WHERE s.id = :id"
                )
        }
)

public class Stad {
    public static final String FIND_ALL = "Stad.findAll";
    public static final String FIND_BY_ID = "Stad.findById";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "naam")
    private String naam;

    @ManyToOne
    private Land land;

    @OneToMany(mappedBy = "id")
    private List<Reis> bestemmingen = new ArrayList<>();

    @OneToMany(mappedBy = "id")
    private List<Reis> vertreklocaties = new ArrayList<>();

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
