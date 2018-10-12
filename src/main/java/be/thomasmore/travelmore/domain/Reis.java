package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reis")

public class Reis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "beschrijving")
    private String beschrijving;

    @ManyToOne
    private Stad vertreklocatie;

    @ManyToOne
    private Stad bestemming;

    @ManyToOne
    private Transportmiddel transportmiddel;

    @OneToMany(mappedBy = "id")
    private List<Reis> reizen = new ArrayList<>();

    public Reis() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Stad getVertreklocatie() {
        return vertreklocatie;
    }

    public void setVertreklocatie(Stad vertreklocatie) {
        this.vertreklocatie = vertreklocatie;
    }

    public Stad getBestemming() {
        return bestemming;
    }

    public void setBestemming(Stad bestemming) {
        this.bestemming = bestemming;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public List<Reis> getReizen() {
        return reizen;
    }

    public Transportmiddel getTransportmiddel() {
        return transportmiddel;
    }

    public void setTransportmiddel(Transportmiddel transportmiddel) {
        this.transportmiddel = transportmiddel;
    }

    public void setReizen(List<Reis> reizen) {
        this.reizen = reizen;
    }
}
