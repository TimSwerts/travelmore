package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Persoon;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PersoonRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;


    public Persoon controleerEmailWachtwoord(Persoon persoon ){

         List results  = entityManager.createNamedQuery(Persoon.FIND_BY_EMAIL_AND_PASSWORD, Persoon.class)
                .setParameter("email", persoon.getEmail()).setParameter("wachtwoord", persoon.getWachtwoord()).getResultList();

         Persoon found = null;
         if (!results.isEmpty()){
             found = (Persoon) results.get(0);
         }

         return found;
    }
}
