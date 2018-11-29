package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Betaling;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BetalingRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Betaling findById(int id){
        return entityManager.find(Betaling.class, id);
    }

    public List<Betaling> findAll(){
        return entityManager.createNamedQuery(Betaling.FIND_ALL, Betaling.class).getResultList();
    }

    public void addBetaling(Betaling betaling){
        entityManager.persist(betaling);
        entityManager.flush();
    }
}
