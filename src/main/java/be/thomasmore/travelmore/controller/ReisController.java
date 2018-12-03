package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Periode;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.domain.Stad;
import be.thomasmore.travelmore.domain.Transportmiddel;
import be.thomasmore.travelmore.service.ReisService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
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
    private double prijs;
    private int periodeID;
    private int aantal_plaatsen;

    @Inject
    private ReisService reisService;

    @Inject
    private TransportmiddelController transportmiddelController;

    @Inject
    private StadController stadController;

    @Inject
    private PeriodeController periodeController;

    public String overzichtReizen() {
        reizen = this.reisService.findAllByVertrekAndBestemming(bestemmingsLandID, vertrekLandID);
        maakVariabeleLeeg(false);
        return "reizenoverzicht";
    }

    public String testAdmin() {
        reizen = this.reisService.findAll();
        transportmiddelController.setTransportmiddelen(transportmiddelController.getTransportmiddelen());
        stadController.setSteden(stadController.getSteden());
        return "admin";
    }

    public void addReis() {
        Stad vertrek = stadController.getStad(vertrekStadID);
        Stad bestemming = stadController.getStad(bestemmingsStadID);
        Transportmiddel transportmiddel = transportmiddelController.getTransportmiddel(transportmiddelID);
        Periode periode = periodeController.getPeriode(periodeID);

        Reis reis = new Reis();
        reis.setBeschrijving(beschrijving);
        reis.setBestemming(bestemming);
        reis.setTransportmiddel(transportmiddel);
        reis.setVertreklocatie(vertrek);
        reis.setPrijs(prijs);
        reis.setPeriode(periode);
        reis.setAantal_plaatsen(aantal_plaatsen);

        this.reisService.addReis(reis);
        reizen = this.reisService.findAll();

        maakVariabeleLeeg(true);
    }

    public void deleteReis(int reisId) {
        Reis reis = reisService.findReisById(reisId);
        reisService.delete(reis);
        reizen = this.reisService.findAll();
    }

    public Reis getById(int reisId){
        Reis reis = reisService.findReisById(reisId);
        return reis;}

    public String filter() {
        String query = String.format("SELECT r from Reis r where r.bestemming.land.id = (SELECT s.land.id from Stad s where s.land.id = %s) AND r.vertreklocatie.land.id = (SELECT s.land.id from Stad s where s.land.id = %s ) and ",bestemmingsLandID, vertrekLandID);

        if (transportmiddelID != 0) {
            query += " r.transportmiddel.id = " + transportmiddelID + " and ";
        }

        if (prijs > 0) {
            query += " r.prijs <=  " + prijs + " and ";
        }

        if(aantal_plaatsen > 0){
            query += " r.aantal_plaatsen >= " + aantal_plaatsen + " and ";
        }

        if(periodeID != 0){
            query += " r.periode.id = " + periodeID +  " and ";
        }

        reizen = reisService.findByFilters(query);
        return "reizenoverzicht";
    }

    private void maakVariabeleLeeg(boolean vertrek_bestemming){
        if(vertrek_bestemming){
            bestemmingsLandID = 0;
            vertrekLandID = 0;
        }

        beschrijving = "";
        transportmiddelID = 0;
        vertrekStadID = 0;
        bestemmingsStadID = 0;
        prijs = 0;
        periodeID = 0;
        aantal_plaatsen = 0;
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

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public int getPeriodeID() {
        return periodeID;
    }

    public void setPeriodeID(int periodeID) {
        this.periodeID = periodeID;
    }

    public int getAantal_plaatsen() {
        return aantal_plaatsen;
    }

    public void setAantal_plaatsen(int aantal_plaatsen) {
        this.aantal_plaatsen = aantal_plaatsen;
    }
}
