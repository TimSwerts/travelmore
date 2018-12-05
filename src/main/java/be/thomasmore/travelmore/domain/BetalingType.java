package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "betalingType")
@NamedQueries(
        @NamedQuery(
                name = BetalingType.FIND_ALL,
                query = "select b from BetalingType b"
        )
)

public class BetalingType {

    public static final String FIND_ALL = "BetalingType.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "naam")
    private String naam;

    @OneToMany(mappedBy = "id")
    private List<Boeking> boekingen = new ArrayList<>();

    public BetalingType() {
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

    public List<Boeking> getBoekingen() {
        return boekingen;
    }

    public void setBoekingen(List<Boeking> boekingen) {
        this.boekingen = boekingen;
    }
}
