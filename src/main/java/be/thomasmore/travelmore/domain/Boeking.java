package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "boeking")
@NamedQueries(
        @NamedQuery(

                name = Boeking.FIND_ALL,
                query = "select b from Boeking b"
        ))

public class Boeking {

    public static final String FIND_ALL = "Boeking.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "boekingsnummer")
    private String boekingsnummer;

    @Column(name = "datum")
    private Date datum;

    @Column(name = "aantalKinderen")
    private int aantalKinderen;

    @Column(name = "aantalVolwassenen")
    private int aantalVolwassenen;

    @Column(name = "prijs")
    private Double prijs;

    @Column(name = "isBetaald")
    private Boolean isBetaald;

    @Column(name = "stuksBagage")
    private int stuksBagage;

    @Column(name = "verzekering")
    private Boolean verzekering;

    @Column(name = "beginDatum")
    private Date beginDatum;

    @Column(name = "eindDatum")
    private Date eindDatum;

    @OneToOne(cascade = {CascadeType.PERSIST})
    private BetalingType betalingType;

    @ManyToOne
    private Reis reis;

    @ManyToOne
    private Gebruiker gebruiker;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBoekingsnummer() {
        return boekingsnummer;
    }

    public void setBoekingsnummer(String boekingsnummer) {
        this.boekingsnummer = boekingsnummer;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getAantalKinderen() {
        return aantalKinderen;
    }

    public void setAantalKinderen(int aantalKinderen) {
        this.aantalKinderen = aantalKinderen;
    }

    public int getAantalVolwassenen() {
        return aantalVolwassenen;
    }

    public void setAantalVolwassenen(int aantalVolwassenen) {
        this.aantalVolwassenen = aantalVolwassenen;
    }

    public Double getPrijs() {
        return prijs;
    }

    public void setPrijs(Double prijs) {
        this.prijs = prijs;
    }

    public Boolean getBetaald() {
        return isBetaald;
    }

    public void setBetaald(Boolean betaald) {
        isBetaald = betaald;
    }

    public int getStuksBagage() {
        return stuksBagage;
    }

    public void setStuksBagage(int stuksBagage) {
        this.stuksBagage = stuksBagage;
    }

    public Boolean getVerzekering() {
        return verzekering;
    }

    public void setVerzekering(Boolean verzekering) {
        this.verzekering = verzekering;
    }

    public Date getBeginDatum() {
        return beginDatum;
    }

    public void setBeginDatum(Date beginDatum) {
        this.beginDatum = beginDatum;
    }

    public Date getEindDatum() {
        return eindDatum;
    }

    public void setEindDatum(Date eindDatum) {
        this.eindDatum = eindDatum;
    }

    public BetalingType getBetalingType() {
        return betalingType;
    }

    public void setBetalingType(BetalingType betalingType) {
        this.betalingType = betalingType;
    }

    public Reis getReis() {
        return reis;
    }

    public void setReis(Reis reis) {
        this.reis = reis;
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }
}
