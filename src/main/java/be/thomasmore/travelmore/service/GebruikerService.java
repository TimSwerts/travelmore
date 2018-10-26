package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.repository.GebruikerRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GebruikerService {
    @Inject
    private GebruikerRepository gebruikerRepository;

    public Gebruiker findGebruikerById(int id){
        return gebruikerRepository.findById(id);
    }
    public Gebruiker findGebruikerByEmail(String email){
        return gebruikerRepository.findByEmail(email);
    }

    public void insert(Gebruiker gebruiker){
        gebruikerRepository.insert(gebruiker);
    }
}
