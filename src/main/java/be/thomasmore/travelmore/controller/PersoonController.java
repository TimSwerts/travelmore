package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Persoon;
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
    private PersoonService persoonService;

    public void login(String email, String wachtwoord) {

        /*
        TODO CONTROLEREN OF USER ACTIEF IS
         */

        Persoon Persoon = persoonService.findPersoonByEmail(email);

        String wachtwoordDB = Persoon.getWachtwoord();
        System.out.println(email + wachtwoord + wachtwoordDB);
        if (wachtwoord == wachtwoordDB) {
            System.out.println(email + wachtwoord + wachtwoordDB);
        } else {
            System.out.println(email + wachtwoord + wachtwoordDB);
        }
    }
}
