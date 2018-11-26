package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.repository.ReisRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
@Stateless
public class ReisService {
    @Inject
    private ReisRepository reisRepository;

    public List<Reis> findAllByVertrekAndBestemming(int bestemmingsLandID, int vertrekLandID) {
        return reisRepository.findAllByVertrekAndBestemming(bestemmingsLandID, vertrekLandID);
    }

    public List<Reis> findAll() {
        return reisRepository.findAll();
    }

    public void addReis(Reis reis) {
        reisRepository.addReis(reis);
    }
}
