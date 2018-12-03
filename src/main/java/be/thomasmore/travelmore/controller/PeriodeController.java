package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Periode;
import be.thomasmore.travelmore.service.PeriodeService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class PeriodeController {
    private Periode periode = new Periode();
    private List<Periode> periodes;

    @Inject
    private PeriodeService periodeService;

    public List<Periode> getPeriodes() {
        return this.periodeService.findAll();
    }

    public void setPeriodes(List<Periode> periodes) {
        this.periodes = periodes;
    }

    public Periode getPeriode(int id) {
        return this.periodeService.findById(id);
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }
}
