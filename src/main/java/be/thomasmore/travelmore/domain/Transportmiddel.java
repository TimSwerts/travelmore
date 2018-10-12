package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "transportmiddel")

public class Transportmiddel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "naam")
    private String naam;

    public Transportmiddel() {
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
}
