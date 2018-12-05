package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.BetalingType;
import be.thomasmore.travelmore.service.BetalingTypeService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class BetalingTypeController implements Serializable {

    private BetalingType betalingType = new BetalingType();
    private List<BetalingType> betalingTypes;

    @Inject
    private BetalingTypeService betalingTypeService;

    public BetalingType getBetalingType(int id) {
        return this.betalingTypeService.findBetalingTypeById(id);
    }

    public List<BetalingType> getBetalingTypes() {
        betalingTypes = this.betalingTypeService.findAll();
        return betalingTypes;
    }
}
