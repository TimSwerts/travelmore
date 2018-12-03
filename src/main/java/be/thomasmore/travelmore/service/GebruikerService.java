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

    public Gebruiker insert(Gebruiker gebruiker){
        return gebruikerRepository.insert(gebruiker);
    }

    public boolean controleerEmailGebruikt(Gebruiker gebruiker){
        return gebruikerRepository.controleerEmailGebruikt(gebruiker);

    }

    public void update(Gebruiker gebruiker){
        gebruikerRepository.update(gebruiker);
    }






    public boolean controleerTokenGebruikt(String token){
        return  gebruikerRepository.controleerTokenGebruikt(token);
    }


}
