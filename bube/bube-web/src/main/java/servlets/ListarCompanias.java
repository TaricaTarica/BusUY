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

import controladores.controladorCompaniaRemote;
import datatypes.DTCompania;

/**
 * Servlet implementation class ListarCompanias
 */
@WebServlet("/ListarCompanias")
public class ListarCompanias extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	controladorCompaniaRemote ccr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarCompanias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DTCompania> companias = ccr.listarCompanias();
		
		System.out.print(companias.isEmpty());
		
		String json = new Gson().toJson(companias);

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
