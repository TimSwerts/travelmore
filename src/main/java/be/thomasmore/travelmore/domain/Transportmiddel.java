package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "transportmiddel")
@NamedQueries(
        {
                @NamedQuery(
                        name = Transportmiddel.FIND_ALL,
                        query = "SELECT t FROM Transportmiddel t"
                ),
                @NamedQuery(
                        name = Transportmiddel.FIND_BY_ID,
                        query = "SELECT t FROM Transportmiddel t WHERE t.id = :id"
                ),
                @NamedQuery(
                        name= Transportmiddel.COUNT_BY_ID,
                        query = "select count(t) from Transportmiddel t where t.id = :id"
                )
        }
)

@XmlRootElement(name = "transportmiddel")
public class Transportmiddel {
    public static final String FIND_ALL = "Transportmiddel.findAll";
    public static final String FIND_BY_ID = "Transportmiddel.findById";
    public static final String COUNT_BY_ID = "Transportmiddel.countById";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
