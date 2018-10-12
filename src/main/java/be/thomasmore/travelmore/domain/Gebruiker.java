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
}
