package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Boeking;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BoekingRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Boeking findById(int id){
        return entityManager.find(Boeking.class, id);
    }

    public List<Boeking> findAll(){
        return entityManager.createNamedQuery(Boeking.FIND_ALL, Boeking.class).getResultList();
    }

    public void addBoeking(Boeking boeking){
        entityManager.persist(boeking);
        entityManager.flush();
    }
}
