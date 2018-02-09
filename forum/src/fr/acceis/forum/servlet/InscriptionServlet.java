package fr.acceis.forum.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoService;
import utilisateurs.Utilisateur;

public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InscriptionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("msg", "");
		request.getRequestDispatcher("/WEB-INF/jsp/Inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String login = request.getParameter("username");
		String pwd = request.getParameter("password");
		String email = request.getParameter("email");
		Date date = new Date();

		Utilisateur utilisateur = DaoService.chercherUtilisateur(login);
		if (utilisateur == null) {
			Utilisateur user = new Utilisateur();
			user.setDateInscription(date);
			user.setMail(email);
			user.setName(login);
			user.setPassword(pwd);
			DaoService.ajouterUtilisateur(user);
			session.setAttribute("connection", "true");
			session.setAttribute("name", login);
			response.sendRedirect("home");

		} else {
			request.setAttribute("msg", "Ce login existe déjà");
			session.removeAttribute("connection");
			request.getRequestDispatcher("/WEB-INF/jsp/Inscription.jsp").forward(request, response);
		}
	}

}
