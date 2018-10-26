package be.thomasmore.travelmore.controller;
import be.thomasmore.travelmore.domain.Land;
import be.thomasmore.travelmore.service.LandService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class LandController implements Serializable {
    private Land land = new Land();

    @Inject
    private LandService landService;

    public List<Land> getLanden(){
        return this.landService.findAll();
    }
}