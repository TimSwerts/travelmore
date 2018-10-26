package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "boeking")

public class Boeking {
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
    private Betaling betaling;

    @ManyToOne
    private Reis reis;

    @ManyToOne
    private Gebruiker gebruiker;
}
