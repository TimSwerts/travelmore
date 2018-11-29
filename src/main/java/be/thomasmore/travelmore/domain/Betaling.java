package be.thomasmore.travelmore.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "betaling")
@NamedQueries(
        @NamedQuery(
                name = Betaling.FIND_ALL,
                query = "select b from Betaling b"
        )
//        ,
//        @NamedQuery(
//                name = Reis.FIND_BY_ID,
//                query = "select b from Betaling b where b.id = :id"
//        )
)

public class Betaling {
    public static final String FIND_ALL = "Betaling.findAll";
//    public static final String FIND_BY_ID = "Reis.findById";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bedrag")
    private double bedrag;

    @Column(name = "datum")
    private Date datum;

    @OneToOne(cascade = {CascadeType.PERSIST})
    private Boeking boeking;

    @ManyToOne
    private BetalingType betalingType;

    public Betaling() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBedrag() {
        return bedrag;
    }

    public void setBedrag(double bedrag) {
        this.bedrag = bedrag;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public BetalingType getBetalingType() {
        return betalingType;
    }

    public void setBetalingType(BetalingType betalingType) {
        this.betalingType = betalingType;
    }

    public Boeking getBoeking() {
        return boeking;
    }

    public void setBoeking(Boeking boeking) {
        this.boeking = boeking;
    }
}
