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
public class GebruikerController implements Serializable  {
    public Gebruiker newGebruiker = new Gebruiker();

    public Gebruiker getNewGebruiker() {
        return newGebruiker;
    }

    public void setNewGebruiker(Gebruiker newGebruiker) {
        this.newGebruiker = newGebruiker;
    }

    @Inject
    private GebruikerService gebruikerService;

    public void registreer(String controleWachtwoord){
        newGebruiker.setActief(false);

        if (newGebruiker.getWachtwoord().equals(controleWachtwoord) && !gebruikerService.controleerEmailGebruikt(newGebruiker)){
            gebruikerService.insert(newGebruiker);
            newGebruiker.stuurBevestigingsMail();
        }

    }







}
