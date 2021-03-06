package com.educacionit.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.educacionit.entidades.Usuario;

/**
 * Servlet implementation class Login
 */

@WebServlet(name = "login", urlPatterns = "/validacion")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<Usuario> usuarios;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		llenarUsuarios();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String correo = request.getParameter("correo");
		String clave = request.getParameter("clave");
		Usuario usuario = buscar(correo, clave);
		String pagina = "formulario.jsp";
		String mensaje = "Credenciales incorrectas";
		
		
		if(usuario!=null) {
			HttpSession sesion = request.getSession();
			mensaje = "Bienvenido: ";
			pagina = "index.jsp";
			sesion.setAttribute("mensaje", mensaje);
			sesion.setAttribute("usuario", usuario);
			sesion.setAttribute("id", sesion.getId());
		}else {
			request.setAttribute("mensaje", mensaje);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);
		//Podria reemplazarse por: request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	private Usuario buscar(String correo, String clave) {
		for (Usuario usuario : usuarios) {
			if(usuario.getCorreo().equalsIgnoreCase(correo) && usuario.getClave().equals(clave)) {
				return usuario;
			}
		}
		return null; //En caso de que no encuentre el usuario retorna null ya que tiene que retornar obligatoriamente
	}
	
	private void llenarUsuarios() {
		usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("user1@gmail.com","user1.1234"));
		usuarios.add(new Usuario("user2@gmail.com","user2.1234"));
		usuarios.add(new Usuario("user3@gmail.com","user3.1234"));
		usuarios.add(new Usuario("user4@gmail.com","user4.1234"));
	}
}
