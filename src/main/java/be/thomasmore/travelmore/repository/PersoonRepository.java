package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Persoon;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class PersoonRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Persoon findById(int id){
        return entityManager.find(Persoon.class, id);
    }

    public List<Persoon> findAll(){
        return entityManager.createNamedQuery(Persoon.FIND_ALL, Persoon.class).getResultList();
    }

    public void insert(Persoon persoon){
        entityManager.persist(persoon);
    }

    public Persoon findByEmail(String email) {
        return entityManager.createQuery(
                "SELECT DISTINCT p from Persoon p WHERE p.email = :email", Persoon.class).
                setParameter("email", email).getSingleResult();
    }
}
