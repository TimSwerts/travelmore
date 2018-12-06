package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reis")
@NamedQueries(
        {
                @NamedQuery(
                        name = Reis.FIND_ALL_BY_VERTREK_BESTEMMING,
                        query = "SELECT r from Reis r where r.bestemming.land.id in (SELECT s.land.id from Stad s where s.land.id = :bestemmingsLandID) AND r.vertreklocatie.land.id in (SELECT s.land.id from Stad s where s.land.id = :vertrekLandID)"
                ),
                @NamedQuery(
                        name = Reis.FIND_ALL,
                        query = "select r from Reis r"
                ),
                @NamedQuery(
                        name = Reis.FIND_BY_ID,
                        query = "select r from Reis r where r.id = :id"
                )
        }
)
public class Reis {
    public static final String FIND_ALL_BY_VERTREK_BESTEMMING = "Reis.findAll_by_vertrek_bestemming";
    public static final String FIND_ALL = "Reis.findAll";
    public static final String FIND_BY_ID = "Reis.findById";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "beschrijving")
    private String beschrijving;

    @Column(name = "prijs")
    private double prijs;

    @ManyToOne
    private Stad vertreklocatie;

    @ManyToOne
    private Stad bestemming;

    @ManyToOne
    private Transportmiddel transportmiddel;

    @Column
    private int aantal_plaatsen;

    @ManyToOne
    private Periode periode;

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

    public Transportmiddel getTransportmiddel() {
        return transportmiddel;
    }

    public void setTransportmiddel(Transportmiddel transportmiddel) {
        this.transportmiddel = transportmiddel;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public int getAantal_plaatsen() {
        return aantal_plaatsen;
    }

    public void setAantal_plaatsen(int aantal_plaatsen) {
        this.aantal_plaatsen = aantal_plaatsen;
    }
}
