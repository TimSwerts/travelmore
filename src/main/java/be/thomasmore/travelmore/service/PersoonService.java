package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Persoon;
import be.thomasmore.travelmore.repository.PersoonRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PersoonService {
    @Inject
    private PersoonRepository persoonRepository;

    public Persoon findPersoonById(int id){
        return persoonRepository.findById(id);
    }

    public void insert(Persoon persoon){
        persoonRepository.insert(persoon);
    }
}
