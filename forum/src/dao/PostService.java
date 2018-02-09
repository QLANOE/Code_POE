package dao;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import utilisateurs.Post;

public class PostService {

	public static Post chercherPost(long postId) {

		Session session = HibernateUtil.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<Post> query = criteriaBuilder.createQuery(Post.class);
		Root<Post> root = query.from(Post.class);
		query.select(root);
		query.where(criteriaBuilder.equal(root.get("id"), postId));
		Post post;
		try {
			post = session.createQuery(query).getSingleResult();
		} catch (NoResultException e) {
			post = null;
		}

		return post;
	}

	public static void ajouterPost(Post post) {

		Session session = HibernateUtil.getSession();
		EntityTransaction tx = session.getTransaction();
		tx.begin();

		session.persist(post);

		tx.commit();

	}

}
