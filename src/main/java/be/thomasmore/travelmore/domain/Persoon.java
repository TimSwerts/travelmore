package be.thomasmore.travelmore.domain;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "PERSOONTYPE", discriminatorType = DiscriminatorType.STRING)
@Entity
@NamedQueries(
        {
                @NamedQuery(
                        name = Persoon.FIND_ALL,
                        query = "SELECT p from Persoon p "
                ),
                @NamedQuery(
                        name= Persoon.FIND_BY_EMAIL_AND_PASSWORD,
                        query = "select p from Persoon p where p.email = :email AND p.wachtwoord = :wachtwoord"
                )
        }
)
@Table(name = "persoon")

public class Persoon {
    public static final String FIND_ALL = "Persoon.findAll";
    public static final String FIND_BY_EMAIL_AND_PASSWORD = "Persoon.findByEmailAndPassword";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "voornaam")
    private String voornaam;

    @Column(name = "achternaam")
    private String achternaam;

    @Column(name = "email")
    private String email;

    @Column(name = "wachtwoord")
    @Size(max = 255)
    private String wachtwoord;

    public Persoon() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

}
