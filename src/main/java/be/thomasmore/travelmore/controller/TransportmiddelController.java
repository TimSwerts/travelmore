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
    private List<Transportmiddel> transportmiddelen;

    @Inject
    private TransportmiddelService transportmiddelService;

    public Transportmiddel getTransportmiddel() {
        return transportmiddel;
    }

    public Transportmiddel getTransportmiddel(int id){
       return transportmiddelService.findTransportmiddelById(id);
    }

    public void setTransportmiddel(Transportmiddel transportmiddel) {
        this.transportmiddel = transportmiddel;
    }

    public List<Transportmiddel> getTransportmiddelen(){
        return this.transportmiddelService.findAll();
    }

    public void setTransportmiddelen(List<Transportmiddel> transportmiddelen) {
        this.transportmiddelen = transportmiddelen;
    }
}
