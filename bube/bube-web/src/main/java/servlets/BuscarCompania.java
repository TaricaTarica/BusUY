package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import controladores.controladorCompaniaRemote;
import datatypes.DTCompania;

/**
 * Servlet implementation class BuscarCompania
 */
@WebServlet("/BuscarCompania/{id}")
public class BuscarCompania extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	controladorCompaniaRemote ccr;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarCompania() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DTCompania compania = ccr.buscarCompania(Integer.valueOf(request.getParameter("id")));
		String json = new Gson().toJson(compania);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
