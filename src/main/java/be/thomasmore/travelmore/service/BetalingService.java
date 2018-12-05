package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Betaling;
import be.thomasmore.travelmore.repository.BetalingRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BetalingService {
    @Inject
    private BetalingRepository betalingRepository;

    public Betaling findBetalingById(int id){
        return betalingRepository.findById(id);
    }

    public List<Betaling> findAll() {
        return betalingRepository.findAll();
    }

    public void addBetaling(Betaling betaling){
        betalingRepository.addBetaling(betaling);
    }
}
