package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Betaling {
    @Id
    private int id;
    @Column(name = "bedrag")
    private double bedrag;
    @Column(name = "datum")
    private Date datum;
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
}
