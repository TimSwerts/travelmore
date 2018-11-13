package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Transportmiddel;
import be.thomasmore.travelmore.service.TransportmiddelService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class TransportmiddelController {

    private Transportmiddel transportmiddel = new Transportmiddel();

    @Inject
    private TransportmiddelService transportmiddelService;

    public Transportmiddel getTransportmiddel() {
        return transportmiddel;
    }

    public void setTransportmiddel(Transportmiddel transportmiddel) {
        this.transportmiddel = transportmiddel;
    }

    public List<Transportmiddel> getTransportmiddelen(){
        return this.transportmiddelService.findAll();
    }
}
