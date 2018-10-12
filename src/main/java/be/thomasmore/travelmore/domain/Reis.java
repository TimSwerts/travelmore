package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "Reis")

public class Reis {
    @Id
    private int id;

    @Column(name = "beschrijving")
    private String beschrijving;

    @ManyToOne
    private Stad vertreklocatie;

    @ManyToOne
    private Stad bestemming;

    @ManyToOne
    private Transportmiddel transportmiddel;

    public Reis() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Transportmiddel getTransportmiddel() {
        return transportmiddel;
    }

    public void setTransportmiddel(Transportmiddel transportmiddel) {
        this.transportmiddel = transportmiddel;
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
}
