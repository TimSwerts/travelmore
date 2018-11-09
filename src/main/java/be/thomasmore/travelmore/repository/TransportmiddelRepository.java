package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Transportmiddel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TransportmiddelRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public List<Transportmiddel> findAll() {
        return entityManager.createNamedQuery(Transportmiddel.FIND_ALL, Transportmiddel.class).getResultList();
    }

    public Transportmiddel findById(int id) {
        return entityManager.find(Transportmiddel.class, id);
    }

    public void insert(Transportmiddel transportmiddel) {
        entityManager.persist(transportmiddel);
        entityManager.flush();
    }

}
