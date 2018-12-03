package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Betaling;
import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.service.BetalingService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

@ManagedBean
@ViewScoped
public class BetalingController implements Serializable {

    private Betaling betaling = new Betaling();
    public Betaling newBetaling = new Betaling();
    private List<Betaling> betalingen;
    private Date datum = new Date();

    @Inject
    private BetalingService betalingService;

    @Inject
    private GebruikerController gebruikerController;

    public Betaling getBetaling(int id){
        return this.betalingService.findBetalingById(id);
    }

    public String addBetaling(Betaling nieuw){



        this.betalingService.addBetaling(nieuw);

        return "Geslaagd";
    }

    public Date getDatum(){
        newBetaling.setDatum(datum);
        return datum;
    }

    public List<Betaling> getBetalingen(){
        betalingen = this.betalingService.findAll();
        return betalingen;
    }

    public Betaling getNewBetaling() {
        return newBetaling;
    }

    public void setNewBetaling(Betaling newBetaling) {
        this.newBetaling = newBetaling;
    }
}