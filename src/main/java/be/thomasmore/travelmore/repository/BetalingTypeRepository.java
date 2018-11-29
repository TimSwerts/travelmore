package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.BetalingType;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BetalingTypeRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public BetalingType findById(int id){
        return entityManager.find(BetalingType.class, id);
    }

    public List<BetalingType> findAll(){
        return entityManager.createNamedQuery(BetalingType.FIND_ALL, BetalingType.class).getResultList();
    }

    public void insert(BetalingType betalingType){
        entityManager.persist(betalingType);
    }
}
