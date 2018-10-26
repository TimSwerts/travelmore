package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Land;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LandRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public List<Land> findAll(){
        return entityManager.createNamedQuery(Land.FIND_ALL, Land.class).getResultList();
    }
}
