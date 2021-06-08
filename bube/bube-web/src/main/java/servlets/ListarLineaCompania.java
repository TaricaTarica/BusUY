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

import controladores.controladorLineaRemote;
import datatypes.DTLinea;

/**
 * Servlet implementation class ListarLineaCompania
 */
@WebServlet("/ListarLineaCompania")
public class ListarLineaCompania extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	controladorLineaRemote clr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarLineaCompania() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DTLinea> lineas = clr.listarLineaCompania(Integer.valueOf(request.getParameter("id")));
		String json = new Gson().toJson(lineas);
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
