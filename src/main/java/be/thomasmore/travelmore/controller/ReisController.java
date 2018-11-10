package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.ReisService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class ReisController implements Serializable {
    private Reis reis = new Reis();
    private List<Reis> reizen;

    private int bestemmingsLandID;
    private int vertrekLandID;


    @Inject
    private ReisService reisService;

    public String overzichtReizen(){

        reizen = this.reisService.findAllByVertrekAndBestemming(bestemmingsLandID, vertrekLandID);
        return  "reizenoverzicht";
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
}
