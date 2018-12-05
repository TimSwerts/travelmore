package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.repository.BoekingRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BoekingService {
    @Inject
    private BoekingRepository boekingRepository;

    public Boeking findBoekingById(int id){
        return boekingRepository.findById(id);
    }

    public List<Boeking> findAll() {
        return boekingRepository.findAll();
    }

    public void addBoeking(Boeking boeking){
        boekingRepository.addBoeking(boeking);
    }
}
