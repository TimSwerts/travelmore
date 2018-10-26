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


    @Inject
    private GebruikerService gebruikerService;

    public void registreer(String voornaam, String achternaam, String email, String wachtwoord, String rijksregisternummer, String geboortedatum) {
        newGebruiker.setActief(false);
        newGebruiker.setVoornaam(voornaam);
        newGebruiker.setAchternaam(achternaam);
        newGebruiker.setEmail(email);
        newGebruiker.setWachtwoord(wachtwoord);
        newGebruiker.setRijksregisternummer(rijksregisternummer);
        newGebruiker.setGeboortedatum(new Date());
        gebruikerService.insert(newGebruiker);
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
