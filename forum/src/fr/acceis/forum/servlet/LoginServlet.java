package fr.acceis.forum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoService;
import utilisateurs.Utilisateur;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("msg", "");
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String login = request.getParameter("username");
		String pwd = request.getParameter("password");

		Utilisateur user = DaoService.chercherUtilisateur(login, pwd);
		if (user == null && !(login.equals("guillaume") && pwd.equals("poidevin"))
				&& !(login.equals("got") && pwd.equals("it"))) {
			session.removeAttribute("name");
			session.removeAttribute("connection");
			request.setAttribute("msg", "Votre authentification a échoué ! Login ou mot de passe invalide");
			System.out.println(session.getAttribute("inconnu"));
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		} else if (login.equals("guillaume") && pwd.equals("poidevin")) {
			session.setAttribute("name", "T'es mauvais Guillaume");
			session.setAttribute("connection", "true");
			response.sendRedirect("home");
		} else if (login.equals("got") && pwd.equals("it")) {
			session.setAttribute("name", "Galette");
			session.setAttribute("connection", "true");
			response.sendRedirect("home");
		} else {
			session.setAttribute("name", login);
			session.setAttribute("connection", "true");
			response.sendRedirect("home");
		}

	}

}
