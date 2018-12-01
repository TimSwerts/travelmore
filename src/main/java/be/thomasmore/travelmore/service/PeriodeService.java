package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Periode;
import be.thomasmore.travelmore.repository.PeriodeRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PeriodeService {
    @Inject
    private PeriodeRepository periodeRepository;

    public List<Periode> findAll() {
        return periodeRepository.findAll();
    }

    public Periode findById(int id) {
        return periodeRepository.findById(id);
    }
}
