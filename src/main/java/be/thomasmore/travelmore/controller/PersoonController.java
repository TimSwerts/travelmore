package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.service.GebruikerService;
import be.thomasmore.travelmore.service.PersoonService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Date;


@ManagedBean
@ViewScoped
public class PersoonController implements Serializable {


    @Inject
    private GebruikerService gebruikerService;

    public void login(String email, String wachtwoord) {

        /*
        TODO CONTROLEREN OF USER ACTIEF IS
         */


        Gebruiker gebruiker = gebruikerService.findGebruikerByEmail(email);

        System.out.println(email + wachtwoord + gebruiker.getVoornaam());
//        if (persoonService.findPersoonByEmail(email) != null){
//
//
//
//            String wachtwoordDB = persoonService.findPersoonByEmail(email).getWachtwoord();
//            System.out.println(email + wachtwoord + wachtwoordDB);
//            if (wachtwoord == wachtwoordDB) {
//                System.out.println(email + wachtwoord + wachtwoordDB);
//            } else {
//                System.out.println(email + wachtwoord + wachtwoordDB);
//            }
//        }
//        else{
//            System.out.println("Persoon is niet gekend.");
//        }


    }
}
