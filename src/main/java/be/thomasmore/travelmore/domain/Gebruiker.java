package be.thomasmore.travelmore.domain;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@DiscriminatorValue("Gebruiker")
@Entity
public class Gebruiker extends Persoon {
    @Column(name = "rijksregisternummer")
    private String rijksregisternummer;
    @Column(name = "actief")
    private Boolean actief;
    @Column(name = "geboortedatum")
    private Date geboortedatum;

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
