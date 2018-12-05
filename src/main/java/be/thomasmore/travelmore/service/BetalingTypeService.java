package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.BetalingType;
import be.thomasmore.travelmore.repository.BetalingTypeRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BetalingTypeService {
    @Inject
    private BetalingTypeRepository betalingTypeRepository;

    public BetalingType findBetalingTypeById(int id){
        return betalingTypeRepository.findById(id);
    }

    public List<BetalingType> findAll() {
        return betalingTypeRepository.findAll();
    }

    public void insert(BetalingType betalingType){
        betalingTypeRepository.insert(betalingType);
    }
}
