package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import controladores.controladorLineaParadaRemote;
import datatypes.DTCompania;

/**
 * Servlet implementation class ListarParadaCambio
 */
@WebServlet("/ParadaCambio")
public class ListarParadaCambio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	controladorLineaParadaRemote clp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarParadaCambio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> paradasCambio = clp.buscarParadaCambio();
		
		System.out.print(paradasCambio.isEmpty());
		
		String json = new Gson().toJson(paradasCambio);

	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}
}
