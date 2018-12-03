package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "periode")
@NamedQueries(
        {
                @NamedQuery(
                        name = Periode.FIND_ALL,
                        query = "select p from Periode p"
                ),
                @NamedQuery(
                        name = Periode.FIND_BY_ID,
                        query = "select p from Periode p where p.id = :id"
                )
        }
)
public class Periode {
    public static final String FIND_ALL = "Periode.findAll";
    public static final String FIND_BY_ID = "Periode.findById";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "naam")
    private String naam;

    public Periode() {
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
