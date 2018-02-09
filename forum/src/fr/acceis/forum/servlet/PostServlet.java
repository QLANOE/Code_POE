package fr.acceis.forum.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PostService;
import dao.UtilisateurService;
import utilisateurs.FilDiscussion;
import utilisateurs.Post;
import utilisateurs.Utilisateur;

public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PostServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/creationPost.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = request.getParameter("messagePost");
		String login = request.getParameter("name");
		Date creation = new Date();

		HttpSession session = request.getSession();

		Post post = new Post();
		post.setDate(creation);
		post.setMessage(message);
		post.setThread((FilDiscussion) session.getAttribute("topic"));

		Utilisateur utilisateur = UtilisateurService.chercherUtilisateur(login);
		if (utilisateur != null) {
			post.setUser(utilisateur);
		} else {
			Utilisateur user = new Utilisateur();
			user.setName("Non Identifié");
		}
		PostService.ajouterPost(post);
		response.sendRedirect("fil");

	}

}
