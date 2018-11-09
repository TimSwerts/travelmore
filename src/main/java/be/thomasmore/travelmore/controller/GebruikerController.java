package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.service.GebruikerService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Date;


@ManagedBean
@ViewScoped
public class GebruikerController implements Serializable {
    private Gebruiker newGebruiker = new Gebruiker();

    public Gebruiker getNewGebruiker() {
        return newGebruiker;
    }

    public void setNewGebruiker(Gebruiker newGebruiker) {
        this.newGebruiker = newGebruiker;
    }

    @Inject
    private GebruikerService gebruikerService;

    public String registreer(String controleWachtwoord){
        newGebruiker.setActief(false);

        if (newGebruiker.getWachtwoord().equals(controleWachtwoord) && !gebruikerService.controleerEmailGebruikt(newGebruiker)){
            newGebruiker.stuurBevestigingsMail();
            gebruikerService.insert(newGebruiker);


            return "login";
        }

        return "registreer";


    }

    public void login(String email, String wachtwoord) {
        Gebruiker Gebruiker = gebruikerService.findGebruikerByEmail(email);

        String wachtwoordDB = Gebruiker.getWachtwoord();

        if (wachtwoord == wachtwoordDB) {
            System.out.println(email + wachtwoord + wachtwoordDB);
        } else {
            System.out.println(email + wachtwoord + wachtwoordDB);
        }
    }
}
