package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Persoon;
import be.thomasmore.travelmore.repository.PersoonRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PersoonService {
    @Inject
    PersoonRepository  persoonRepository;

    public Persoon controleerEmailWachtwoord(Persoon persoon){
        return persoonRepository.controleerEmailWachtwoord(persoon);

    }
}
