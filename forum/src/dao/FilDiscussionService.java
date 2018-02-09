package dao;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import utilisateurs.FilDiscussion;

public class FilDiscussionService {

	public static FilDiscussion chercherTopic(long postId) {

		Session session = HibernateUtil.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<FilDiscussion> query = criteriaBuilder.createQuery(FilDiscussion.class);
		Root<FilDiscussion> root = query.from(FilDiscussion.class);
		query.select(root);
		query.where(criteriaBuilder.equal(root.get("id"), postId));
		FilDiscussion fil;
		try {
			fil = session.createQuery(query).getSingleResult();
		} catch (NoResultException e) {
			fil = null;
		}

		return fil;
	}

	public static void ajouterTopic(FilDiscussion topic) {

		Session session = HibernateUtil.getSession();
		EntityTransaction tx = session.getTransaction();
		tx.begin();

		session.persist(topic);

		tx.commit();

	}

}
