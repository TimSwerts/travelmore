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
//                        query = "SELECT r from Reis r where r.bestemming.id = (SELECT s.land.id from Stad s where s.land.id = :bestemmingsLandID) AND r.vertreklocatie.id = (SELECT s.land.id from Stad s where s.land.id = :vertrekLandID)"
                        query = "SELECT r from Reis r where r.bestemming.land.id = (SELECT s.land.id from Stad s where s.land.id = :bestemmingsLandID) AND r.vertreklocatie.land.id = (SELECT s.land.id from Stad s where s.land.id = :vertrekLandID)"

                ),// and r.vertreklocatie_id =(select s.land_id from stad s where s.land_id = 2)
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
    private int prijs;

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

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }
}
