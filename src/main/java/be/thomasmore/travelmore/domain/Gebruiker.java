package be.thomasmore.travelmore.domain;


import javax.jms.Session;
import javax.persistence.*;
import javax.xml.stream.Location;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

@DiscriminatorValue("Gebruiker")
@Entity
@NamedQueries(
        {
                @NamedQuery(
                        name = Gebruiker.FIND_ALL,
                        query = "SELECT p from Persoon p "
                ),
                @NamedQuery(
                        name= Gebruiker.FIND_BY_EMAIL,
                        query = "select count(p) from Persoon p where p.email = :email"
                )
        }
)

public class Gebruiker extends Persoon {
    public static final String FIND_ALL = "Gebruiker.findAll";
    public static final String FIND_BY_EMAIL = "Gebruiker.findByEmail";

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

    public void stuurBevestigingsMail(){
        //setup
        final String host = "smtp.gmail.com";
        final String from = "phpteam26@gmail.com";
        final String pass = "phpprojectteam26";
        String to  = this.getEmail();

        //get session obj
        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");








    }
}
