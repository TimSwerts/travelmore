package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Transportmiddel;
import be.thomasmore.travelmore.repository.TransportmiddelRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class TransportmiddelService {
    @Inject
    private TransportmiddelRepository transportmiddelRepository;

    public List<Transportmiddel> findAll() {
        return transportmiddelRepository.findAll();
    }

    public Transportmiddel findTransportmiddelById(int id) {
        return transportmiddelRepository.findById(id);
    }

    public void insert(Transportmiddel transportmiddel) {
        transportmiddelRepository.insert(transportmiddel);
    }

    public void delete(Transportmiddel transportmiddel){
        transportmiddelRepository.delete(transportmiddel);
    }

    public boolean controleerIdGebruikt(int id){
        return transportmiddelRepository.controleerIdGebruikt(id);
    }
}
