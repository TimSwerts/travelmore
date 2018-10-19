package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.service.GebruikerService;

import javax.inject.Inject;

public class GebruikerController {
    private Gebruiker gebruiker = new Gebruiker();

    @Inject
    private GebruikerService gebruikerService;

}
