package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Periode;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PeriodeRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public List<Periode> findAll(){
        return entityManager.createNamedQuery(Periode.FIND_ALL, Periode.class).getResultList();
    }

    public Periode findById(int id){
        return entityManager.createNamedQuery(Periode.FIND_BY_ID, Periode.class).setParameter("id", id).getSingleResult();
    }
}
