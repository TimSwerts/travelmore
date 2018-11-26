package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Reis;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ReisRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public List<Reis> findAllByVertrekAndBestemming(int bestemmingsLandID, int vertrekLandID) {
        return entityManager.createNamedQuery(Reis.FIND_ALL_BY_VERTREK_BESTEMMING, Reis.class).setParameter("bestemmingsLandID", bestemmingsLandID).setParameter("vertrekLandID", vertrekLandID).getResultList();
    }

    public List<Reis> findAll() {
        return entityManager.createNamedQuery(Reis.FIND_ALL, Reis.class).getResultList();
    }

    public void addReis(Reis reis) {
        entityManager.persist(reis);
        entityManager.flush();
    }
}
