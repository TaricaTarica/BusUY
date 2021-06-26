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
@WebServlet("/LineasNoAsociadasParada")
public class LineasNoAsociadasParada extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	controladorLineaParadaRemote clpr;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LineasNoAsociadasParada() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<DTLineaSimple> lineas = clpr.getLineasNoAsociadasParada(Integer.valueOf(request.getParameter("gid")));
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
		doGet(request, response);
	}

}
