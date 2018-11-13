package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "land")
@NamedQueries(
        {
                @NamedQuery(
                        name = Land.FIND_ALL,
                        query = "SELECT l from Land l order by l.naam"
                )
        }
)
public class Land {
    public static final String FIND_ALL = "Land.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "naam")
    private String naam;

    @OneToMany(mappedBy = "id")
    private List<Land> landen = new ArrayList<>();

    public Land() {
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

    public List<Land> getLanden() {
        return landen;
    }

    public void setLanden(List<Land> landen) {
        this.landen = landen;
    }
}
