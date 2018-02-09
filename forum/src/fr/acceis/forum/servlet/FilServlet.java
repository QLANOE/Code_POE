package fr.acceis.forum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FilDiscussionService;
import utilisateurs.FilDiscussion;

public class FilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FilServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FilDiscussion topic1 = new FilDiscussion();
		HttpSession session = request.getSession();
		session.setAttribute("topic", topic1);
		FilDiscussionService.ajouterTopic(topic1);
		request.getRequestDispatcher("/WEB-INF/jsp/thread.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
