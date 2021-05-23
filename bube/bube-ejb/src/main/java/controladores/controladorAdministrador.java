package controladores;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTAdministrador;
import datos.DatosAdministradorLocal;
import entities.Administrador;


@Stateless
@LocalBean
public class controladorAdministrador implements controladorAdministradorRemote {
	@EJB
	DatosAdministradorLocal dal;
    public controladorAdministrador() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void altaAdministrador(DTAdministrador administrador) {
    	Administrador newAdminsitrador = new Administrador(administrador);
    	dal.altaAdminsitrador(newAdminsitrador);
    }
    @Override
    public void modificarAdministrador(DTAdministrador administrador) {
    	Administrador editAdminsitrador = new Administrador(administrador);
    	dal.modificarAdministrador(editAdminsitrador);
    }
    @Override
    public void eliminarAdministrador(DTAdministrador administrador) {
    	Administrador editAdministrador = new Administrador(administrador);
    	dal.eliminarAdministrador(editAdministrador);
    }
    @Override
    public DTAdministrador buscarAdministrador(String usuario) {
    	Administrador administrador = dal.buscarAdministrador(usuario);
    	if(administrador != null) {
    		DTAdministrador dtAdministrador = new DTAdministrador(administrador);
    		return dtAdministrador;
    	}
    	else {
    		return null;
    	}
    	
    }
    
    @Override
    public boolean iniciarSesion(DTAdministrador dtAdministrador) {
    	boolean retorno = false;
    	try {
    		DTAdministrador administrador = this.buscarAdministrador(dtAdministrador.getNombreUsuario());
    		if(administrador != null && administrador.getContrasenia().equals(dtAdministrador.getContrasenia())) {
    			retorno = true;
    		}
    	}
    	catch(Exception e) {
    		throw e;
    	}
    	return retorno;
    }

}
