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

    public void delete(Transportmiddel transportmiddelParam){
        Transportmiddel transportmiddel = entityManager.find(Transportmiddel.class, transportmiddelParam.getId());
        entityManager.remove(transportmiddel);
        entityManager.flush();
    }

    public boolean controleerIdGebruikt(int id){
        long count =  entityManager.createNamedQuery(Transportmiddel.COUNT_BY_ID, Long.class).setParameter("id", id).getSingleResult();
        return (count > 0);
    }

}
