package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@DiscriminatorValue("Admin")
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Admin extends Persoon {
    public Admin() {
        super();
    }


}
