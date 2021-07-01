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
@Path("/modificar-parada")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ModificarParada {
	@EJB
	controladorLineaRemote clr;
	
	@POST
	@Path("/{geomCoordenadas}/{gidParada}")
	public Response modificarParada(@PathParam("geomCoordenadas") String geomCoordenadas, @PathParam("gidParada") int gidParada) {
		try {
			clr.modificarParada(geomCoordenadas, gidParada);
			return Response
		            .status(Response.Status.OK)
		            .build();
		}
		catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
}
