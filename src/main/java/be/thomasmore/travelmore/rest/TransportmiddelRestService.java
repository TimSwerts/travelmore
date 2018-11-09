package be.thomasmore.travelmore.rest;

import be.thomasmore.travelmore.domain.Transportmiddel;
import be.thomasmore.travelmore.service.TransportmiddelService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/transportmiddelen")
public class TransportmiddelRestService {

    @Inject
    private TransportmiddelService transportmiddelService;

    @GET
    @Path("/getTransportmiddelen")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Transportmiddel> findAll() {
        return transportmiddelService.findAll();
    }

    @POST
    @Path("/addTransportmiddel")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response addTransportmiddel(@QueryParam("naam") String naam) {
        if (!naam.equals("")) {
            Transportmiddel nieuwTransportmiddel = new Transportmiddel();
            nieuwTransportmiddel.setNaam(naam);
            transportmiddelService.insert(nieuwTransportmiddel);
            return Response.status(Response.Status.CREATED).entity(nieuwTransportmiddel).build();
        }

        return Response
                .status(Response.Status.NOT_MODIFIED)
                .entity("Er trad een fout op tijdens het maken van een nieuw transportmiddel.").build();
    }
}
