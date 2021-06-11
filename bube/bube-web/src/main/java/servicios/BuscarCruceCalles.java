package servicios;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import controladores.controladorCalleRemote;

@RequestScoped
@Path("/buscar-cruce-calles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class BuscarCruceCalles {

	@EJB
	controladorCalleRemote ccr;
	
	@GET
	@Path("/{calleA}/{calleB}")
	public Response buscarCruceCalles(@PathParam("calleA") String calleA, @PathParam("calleB") String calleB) {
		return Response
	            .status(Response.Status.OK)
	            .entity(ccr.buscarCruceCalles(calleA, calleB))
	            .build();
	}
	
	
}
