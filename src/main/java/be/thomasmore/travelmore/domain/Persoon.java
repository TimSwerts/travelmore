package be.thomasmore.travelmore.domain;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "PERSOONTYPE", discriminatorType = DiscriminatorType.STRING)
@Entity
@Table(name = "persoon")
@NamedQueries(
        {
                @NamedQuery(
                        name = Persoon.FIND_ALL,
                        query = "SELECT p from Persoon p "
                ),
                @NamedQuery(
                        name = Persoon.FIND_PERSOON_BY_EMAIL,
                        query = "SELECT p.email, p.wachtwoord, p.actief from Persoon p where p.email = :email"
                )
        }
)

public class Persoon {
    public static final String FIND_ALL = "Persoon.findAll";
    public static final String FIND_PERSOON_BY_EMAIL = "Persoon.findPersoonByEmail";

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
