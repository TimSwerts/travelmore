package be.thomasmore.travelmore.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("Admin")
@Entity

public class Admin extends Persoon {
    public Admin() {
        super();
    }
}
