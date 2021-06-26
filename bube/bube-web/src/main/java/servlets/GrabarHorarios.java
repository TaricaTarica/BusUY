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
import datatypes.DTLineaSimple;

/**
 * Servlet implementation class GetLineaForParada
 */
@WebServlet("/GrabarHorarios")
public class GrabarHorarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	controladorLineaParadaRemote clpr;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GrabarHorarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<DTLineaSimple> lineas = clpr.getLineasForParada(Integer.valueOf(request.getParameter("gid")));
		String json = new Gson().toJson(lineas);
		System.out.println(json);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idparada = Integer.parseInt(request.getParameter("idparada"));
		int idlinea= Integer.parseInt(request.getParameter("idlinea"));
		int hora = Integer.parseInt(request.getParameter("hora"));
		int minuto = Integer.parseInt(request.getParameter("minuto"));
		System.out.println("**********************************************************************");
		System.out.println("**********************************************************************");
		System.out.println("Datos:  parada " +idparada+" linea "+idlinea+" hora "+hora+" minuto " + minuto);
		System.out.println("**********************************************************************");
		System.out.println("**********************************************************************");

		boolean res=clpr.agregarHorario(idparada, idlinea, hora, minuto);

		String json = new Gson().toJson(res);
		System.out.println(json);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
		
		//doGet(request, response);
	}

}
