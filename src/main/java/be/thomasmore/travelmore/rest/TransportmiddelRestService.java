package be.thomasmore.travelmore.rest;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.domain.Transportmiddel;
import be.thomasmore.travelmore.service.GebruikerService;
import be.thomasmore.travelmore.service.TransportmiddelService;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/transportmiddelen")
public class TransportmiddelRestService {

    @Inject
    private TransportmiddelService transportmiddelService;

    @Inject
    private GebruikerService gebruikerService;

    //    localhost:xxxx/travelmore/rest/transportmiddelen/getTransportmiddelen
    @GET
    @Path("/getTransportmiddelen")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Transportmiddel> findAll() {
        return transportmiddelService.findAll();
    }

    //    localhost:xxxx/travelmore/rest/transportmiddelen/addTransportmiddel?naam=xxxx
    @POST
    @Path("/addTransportmiddel")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response addTransportmiddel(@NotNull @QueryParam("naam") String naam) {
        if (!naam.equals("")) {
            Transportmiddel nieuwTransportmiddel = new Transportmiddel();
            nieuwTransportmiddel.setNaam(naam);
            transportmiddelService.insert(nieuwTransportmiddel);
            return Response.status(Response.Status.CREATED).entity(this.findAll()).build();
        }

        return Response
                .status(Response.Status.NOT_MODIFIED)
                .entity("Er trad een fout op tijdens het maken van een nieuw transportmiddel.").build();
    }

    //    localhost:xxxx/travelmore/rest/transportmiddelen/deleteTransportmiddel?id=x&token=6532
    @DELETE
    @Path("/deleteTransportmiddel")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deleteTransportmiddel(@NotNull @QueryParam("id") int id, @NotNull @QueryParam("token") String token) {
        if (transportmiddelService.controleerIdGebruikt(id)) {
            if (!token.equals("")) {
                if (gebruikerService.controleerTokenGebruikt(token)) {
                    Transportmiddel transportmiddel = transportmiddelService.findTransportmiddelById(id);
                    transportmiddelService.delete(transportmiddel);
                    return Response.status(Response.Status.ACCEPTED).entity(this.findAll()).build();
                }
            }
        }

        return Response
                .status(Response.Status.NOT_MODIFIED)
                .entity("Er trad een fout op tijdens het verwijderen van het transportmiddel.").build();
    }
}
