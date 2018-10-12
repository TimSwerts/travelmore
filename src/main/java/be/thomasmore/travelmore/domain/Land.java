package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Land")
public class Land {
    @Id
    private int id;

    @Column(name = "naam")
    private String naam;

    @OneToMany
    private List<Land> landen;

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
