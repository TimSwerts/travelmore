package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Land;
import be.thomasmore.travelmore.repository.LandRepository;

import javax.inject.Inject;
import java.util.List;

public class LandService {
    @Inject
    private LandRepository landRepository;

    public List<Land> findAll(){
        return landRepository.findAll();
    }
}






