package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controladores.controladorAdministradorRemote;
import datatypes.DTAdministrador;

/**
 * Servlet implementation class Sesion
 */
@WebServlet("/Sesion")
public class Sesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private controladorAdministradorRemote car;
	HttpSession sesion;
	RequestDispatcher rd;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sesion() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		if(!nickname.isEmpty() && !password.isEmpty()) {
			DTAdministrador administrador = new DTAdministrador(nickname, password);
			try {
				
				if(car.iniciarSesion(administrador)) {
					sesion = request.getSession();
					sesion.setAttribute("administrador", true);
					rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
				else {
					request.setAttribute("error", "Usuario y/o contraseña inválido");
					rd = request.getRequestDispatcher("/bu-admin.jsp");
					rd.forward(request, response);
				}
			}
			catch(Exception e) {
				request.setAttribute("error", "Error iniciando sesión");
				rd = request.getRequestDispatcher("/bu-admin.jsp");
				rd.forward(request, response);
			}
		}
		else {
			request.setAttribute("error", "¡Campos vacíos!");
			rd = request.getRequestDispatcher("/bu-admin.jsp");
			rd.forward(request, response);
		}
		
	}

}
