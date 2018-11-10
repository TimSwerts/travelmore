package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reis")
@NamedQueries(
        {
                @NamedQuery(
                        name = Reis.FIND_ALL,
                        query = "SELECT r from Reis r where r.bestemming.id = (SELECT s.land.id from Stad s where s.land.id = :bestemmingsLandID) AND r.vertreklocatie.id = (SELECT s.land.id from Stad s where s.land.id = :vertrekLandID)"

                )// and r.vertreklocatie_id =(select s.land_id from stad s where s.land_id = 2)

        }
)
public class Reis {
    public static final String FIND_ALL = "Reis.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
