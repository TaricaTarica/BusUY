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
@WebServlet("/RecorridoCambio")
public class ListarRecorridoCambio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	controladorLineaParadaRemote clp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarRecorridoCambio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Integer> recorridosCambio = clp.buscarRecorridoCambio();
		
		System.out.print(recorridosCambio.isEmpty());
		
		String json = new Gson().toJson(recorridosCambio);

	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}
}
