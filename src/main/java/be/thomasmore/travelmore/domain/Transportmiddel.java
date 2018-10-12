package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "Transportmiddel")
//@NamedQueries(
//        {@NamedQuery(
//                name = Transportmiddel.FIND_BY_CODE,
//                query = "SELECT t FROM Transportmiddel t WHERE t.code = :code"
//        ),
//                @NamedQuery(
//                        name = Transportmiddel.FIND_ALL,
//                        query = "SELECT t FROM Transportmiddel t"
//                )}
//)

public class Transportmiddel {
    @Id
    private int id;

    @Column(name = "naam")
    private String naam;

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
