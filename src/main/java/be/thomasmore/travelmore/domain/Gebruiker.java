package be.thomasmore.travelmore.domain;


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
                        name = Gebruiker.FIND_PERSOON_BY_EMAIL,
                        query = "SELECT p from Persoon p where p.email = :email"
                ),
                @NamedQuery(
                        name = Gebruiker.FIND_COUNT_BY_EMAIL,
                        query = "select count(p) from Persoon p where p.email = :email"
                )
        }
)

public class Gebruiker extends Persoon {
    public static final String FIND_ALL = "Gebruiker.findAll";
    public static final String FIND_PERSOON_BY_EMAIL = "Gebruiker.findPersoonByEmail";
    public static final String FIND_COUNT_BY_EMAIL = "Gebruiker.findCountByEmail";

    @Column(name = "rijksregisternummer")
    private String rijksregisternummer;

    @Column(name = "actief")
    private Boolean actief;

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

    public List<Boeking> getBoekingen() {
        return boekingen;
    }

    public void setBoekingen(List<Boeking> boekingen) {
        this.boekingen = boekingen;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public void stuurBevestigingsMail() {
        //setup
        this.setConfirmationToken(generateToken());
        final String host = "smtp.gmail.com";
        final String from = "javaproject024@gmail.com\n";
        final String password = "TMK2018!";
        final String port = "587 ";
        String to = this.getEmail();

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.ssl.trust", host);

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Bevestig uw registratie");


            String msg = "Gebruik volgende code bij uw eerste aanmelding:" + this.getConfirmationToken();

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("joepie");
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    private String generateToken() {
        int token;

        Random random = new Random();

        token = random.nextInt(400 - 100) + 100;


        return token + "";
    }
}

