package be.thomasmore.travelmore.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@DiscriminatorValue("Gebruiker")
@Entity
@NamedQueries(
        {
                @NamedQuery(
                        name = Gebruiker.FIND_ALL,
                        query = "SELECT p from Persoon p "
                )
        }
)

public class Gebruiker extends Persoon {
    public static final String FIND_ALL = "Gebruiker.findAll";

    @Column(name = "rijksregisternummer")
    private String rijksregisternummer;

    @Column(name = "actief")
    private Boolean actief;

    @Column(name = "geboortedatum")
    private Date geboortedatum;

    @OneToMany(mappedBy = "id")
    private List<Boeking> boekingen = new ArrayList<>();

    public Gebruiker() {
        super();
    }

    public String getRijksregisternummer() {
        return rijksregisternummer;
    }

    public void setRijksregisternummer(String rijksregisternummer) {
        this.rijksregisternummer = rijksregisternummer;
    }

    public Boolean getActief() {
        return actief;
    }

    public void setActief(Boolean actief) {
        this.actief = actief;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }
}
