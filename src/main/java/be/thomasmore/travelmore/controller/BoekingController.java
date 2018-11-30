package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.service.BoekingService;

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
public class BoekingController implements Serializable {

    private Boeking boeking = new Boeking();
    public Boeking newBoeking = new Boeking();
    private List<Boeking> boekingen;

    @Inject
    private BoekingService boekingService;

    public Boeking getBoeking(int id){
        return this.boekingService.findBoekingById(id);
    }

    public String addBoeking(Boeking nieuw){
        this.boekingService.addBoeking(nieuw);
        return "Geslaagd";
    }

    public List<Boeking> getBoekingen(){
        boekingen = this.boekingService.findAll();
        return boekingen;
    }

    public Boeking getNewBoeking() {
        return newBoeking;
    }

    public void setNewBoeking(Boeking newBoeking) {
        this.newBoeking = newBoeking;
    }
}