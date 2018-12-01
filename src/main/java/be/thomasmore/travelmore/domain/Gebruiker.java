package be.thomasmore.travelmore.domain;


import be.thomasmore.travelmore.util.EmailUtil;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.persistence.*;
import java.util.*;

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
                ),
                @NamedQuery(
                        name= Gebruiker.FIND_BY_TOKEN,
                        query = "select count(p) from Persoon p where p.confirmationToken = :token"
                ),
                @NamedQuery(
                name= Gebruiker.FIND_BY_GEBRUIKER_BY_EMAIL,
                query = "select p from Persoon p where p.email = :email AND PERSOONTYPE(p) ='Gebruiker'"
                ),
        }
)

public class Gebruiker extends Persoon {
    public static final String FIND_ALL = "Gebruiker.findAll";
    public static final String FIND_BY_EMAIL = "Gebruiker.findByEmail";
    public static final String FIND_BY_TOKEN = "Gebruiker.findByToken";
    public static final String FIND_BY_GEBRUIKER_BY_EMAIL = "Gebruiker.findPersoonByEmail";


    @Column(name = "rijksregisternummer")
    private String rijksregisternummer;



    @Column(name = "geboortedatum")
    private Date geboortedatum;

    @Column(name = "confirmationToken")
    private String confirmationToken;

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

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public void stuurBevestigingsMail(){

        //setup
        String to = this.getEmail();
        String msg = "volg volgende link om uw registratie te bevestigen: localhost:8081/travelmore/bevestigreg?code=" + getConfirmationToken() + "&id=" + this .getId();
        EmailUtil emailUtil = new EmailUtil();
        emailUtil.sendEmail(to, msg);
    }

    public void generateToken(){
        int token;

        Random random = new Random();

        token = random.nextInt(400 - 100) + 100;

        this.setConfirmationToken(token + "");
    }




}

