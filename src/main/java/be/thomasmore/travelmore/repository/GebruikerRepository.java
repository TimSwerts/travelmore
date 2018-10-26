package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Gebruiker;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    public void insert(Gebruiker gebruiker){
        entityManager.persist(gebruiker);
    }
}
