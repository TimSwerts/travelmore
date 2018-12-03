package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.domain.Persoon;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


public class GebruikerRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Gebruiker findById(int id){
        return entityManager.find(Gebruiker.class, id);
    }

    public List<Gebruiker> findAll(){
        return entityManager.createNamedQuery(Gebruiker.FIND_ALL, Gebruiker.class).getResultList();
    }

    public Gebruiker insert(Gebruiker gebruiker){
         entityManager.persist(gebruiker);
         return gebruiker;
    }

    public boolean controleerEmailGebruikt(Gebruiker gebruiker){
        Long count =  entityManager.createNamedQuery(Gebruiker.FIND_BY_EMAIL, Long.class).setParameter("email", gebruiker.getEmail()).getSingleResult();
        boolean aanwezig = false;
        if (count > 0){
            aanwezig = true;
        }
        return aanwezig;
    }


    public boolean controleerTokenGebruikt(String token){
        Long count =  entityManager.createNamedQuery(Gebruiker.FIND_BY_TOKEN, Long.class).setParameter("token", token).getSingleResult();
        return (count > 0);
    }

    public void update(Gebruiker gebruiker){
        entityManager.merge(gebruiker);
    }




}
