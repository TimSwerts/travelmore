package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Gebruiker;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class GebruikerRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Gebruiker findById(int id) {
        return entityManager.find(Gebruiker.class, id);
    }

    public List<Gebruiker> findAll() {
        return entityManager.createNamedQuery(Gebruiker.FIND_ALL, Gebruiker.class).getResultList();
    }

    public void insert(Gebruiker gebruiker) {
        entityManager.persist(gebruiker);
    }

    public Gebruiker findPersoonByEmail(String email) {
        return entityManager.createNamedQuery(
                Gebruiker.FIND_PERSOON_BY_EMAIL, Gebruiker.class).
                setParameter("email", email).getSingleResult();
    }

    public boolean controleerEmailGebruikt(Gebruiker gebruiker) {
        Long count = entityManager.createNamedQuery(Gebruiker.FIND_COUNT_BY_EMAIL, Long.class).setParameter("email", gebruiker.getEmail()).getSingleResult();
        boolean aanwezig = false;
        if (count > 0) {
            aanwezig = true;
        }
        return aanwezig;
    }
}
