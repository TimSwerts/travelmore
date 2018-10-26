package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Stad;
import be.thomasmore.travelmore.repository.StadRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class StadService {
    @Inject
    private StadRepository stadRepository;

    public Stad findStadById(int id){
        return stadRepository.findById(id);
    }

    public List<Stad> findAll() {
        return stadRepository.findAll();
    }

    public void insert(Stad stad){
        stadRepository.insert(stad);
    }
}
