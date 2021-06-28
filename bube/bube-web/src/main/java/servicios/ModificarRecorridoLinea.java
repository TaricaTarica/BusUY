package servicios;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import controladores.controladorLineaRemote;


@RequestScoped
@Path("/modificar-recorrido-linea")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ModificarRecorridoLinea {
	@EJB
	controladorLineaRemote clr;
	
	@POST
	@Path("/{geomCoordenadas}/{gidLinea}")
	public Response modificarRecorridoLinea(@PathParam("geomCoordenadas") String geomCoordenadas, @PathParam("gidLinea") int gidLinea) {
		try {
			clr.modificarRecorridoLinea(geomCoordenadas, gidLinea);
			return Response
		            .status(Response.Status.OK)
		            .build();
		}
		catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
}
