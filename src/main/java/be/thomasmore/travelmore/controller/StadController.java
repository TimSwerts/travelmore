package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Stad;
import be.thomasmore.travelmore.service.StadService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class StadController implements Serializable {

    private Stad stad = new Stad();

    @Inject
    private StadService stadService;

    public Stad getStad(int id){
        return this.stadService.findStadById(id);
    }

    public List<Stad> getSteden(){
        return this.stadService.findAll();
    }
}
