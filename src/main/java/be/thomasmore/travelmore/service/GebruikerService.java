package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.repository.GebruikerRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class GebruikerService {
    @Inject
    private GebruikerRepository gebruikerRepository;

    public Gebruiker findGebruikerById(int id){
        return gebruikerRepository.findById(id);
    }

    public void insert(Gebruiker gebruiker){
        gebruikerRepository.insert(gebruiker);
    }
    public boolean controleerEmailGebruikt(Gebruiker gebruiker){
        return gebruikerRepository.controleerEmailGebruikt(gebruiker);

    }




    public boolean controleerTokenGebruikt(String token){
        return  gebruikerRepository.controleerTokenGebruikt(token);
    }


}
