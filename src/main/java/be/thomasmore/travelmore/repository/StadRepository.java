package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Stad;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class StadRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Stad findById(int id){
        return entityManager.find(Stad.class, id);
    }

    public List<Stad> findAll(){
        return entityManager.createNamedQuery(Stad.FIND_ALL, Stad.class).getResultList();
    }

    public void insert(Stad stad){
        entityManager.persist(stad);
    }
}
