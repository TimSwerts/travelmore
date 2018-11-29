package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Betaling;
import be.thomasmore.travelmore.service.BetalingService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class BetalingController implements Serializable {

    private Betaling betaling = new Betaling();
    private List<Betaling> betalingen;

    @Inject
    private BetalingService betalingService;

    public Betaling getBetaling(int id){
        return this.betalingService.findBetalingById(id);
    }

    public List<Betaling> getBetalingen(){
        betalingen = this.betalingService.findAll();
        return betalingen;
    }
}