package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.domain.Stad;
import be.thomasmore.travelmore.domain.Transportmiddel;
import be.thomasmore.travelmore.service.ReisService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class ReisController implements Serializable {
    private Reis reis = new Reis();
    private List<Reis> reizen;

    private int bestemmingsLandID;
    private int vertrekLandID;
    private String beschrijving;
    private int transportmiddelID;
    private int vertrekStadID;
    private int bestemmingsStadID;

    @Inject
    private ReisService reisService;

    @Inject
    private TransportmiddelController transportmiddelController;

    @Inject
    private StadController stadController;

    public String overzichtReizen() {
        reizen = this.reisService.findAllByVertrekAndBestemming(bestemmingsLandID, vertrekLandID);
        return "reizenoverzicht";
    }

    public String testAdmin() {
        reizen = this.reisService.findAll();
        transportmiddelController.setTransportmiddelen(transportmiddelController.getTransportmiddelen());
        stadController.setSteden(stadController.getSteden());
        return "admin";
    }

    public void addReis(){
        Stad vertrek = stadController.getStad(vertrekStadID);
        Stad bestemming = stadController.getStad(bestemmingsStadID);
        Transportmiddel transportmiddel = transportmiddelController.getTransportmiddel(transportmiddelID);

        Reis reis = new Reis();
        reis.setBeschrijving(beschrijving);
        reis.setBestemming(bestemming);
        reis.setTransportmiddel(transportmiddel);
        reis.setVertreklocatie(vertrek);

        this.reisService.addReis(reis);
        reizen = this.reisService.findAll();
    }

    public void deleteReis(int reisId){
        Reis reis = reisService.findReisById(reisId);
        reisService.delete(reis);
        reizen = this.reisService.findAll();
    }

    public List<Reis> getReizen() {
        return reizen;
    }

    public void setReizen(List<Reis> reizen) {
        this.reizen = reizen;
    }

    public int getBestemmingsLandID() {
        return bestemmingsLandID;
    }

    public void setBestemmingsLandID(int bestemmingsLandID) {
        this.bestemmingsLandID = bestemmingsLandID;
    }

    public int getVertrekLandID() {
        return vertrekLandID;
    }

    public void setVertrekLandID(int vertrekLandID) {
        this.vertrekLandID = vertrekLandID;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public int getTransportmiddelID() {
        return transportmiddelID;
    }

    public void setTransportmiddelID(int transportmiddelID) {
        this.transportmiddelID = transportmiddelID;
    }

    public int getVertrekStadID() {
        return vertrekStadID;
    }

    public void setVertrekStadID(int vertrekStadID) {
        this.vertrekStadID = vertrekStadID;
    }

    public int getBestemmingsStadID() {
        return bestemmingsStadID;
    }

    public void setBestemmingsStadID(int bestemmingsStadID) {
        this.bestemmingsStadID = bestemmingsStadID;
    }
}
