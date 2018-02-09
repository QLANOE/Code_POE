package dao;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import utilisateurs.Utilisateur;

public class UtilisateurService {

	public static Utilisateur chercherUtilisateur(String name, String password) {

		Session session = HibernateUtil.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<Utilisateur> query = criteriaBuilder.createQuery(Utilisateur.class);
		Root<Utilisateur> root = query.from(Utilisateur.class);
		query.select(root);
		query.where(criteriaBuilder.and(criteriaBuilder.equal(root.get("login"), name),
				criteriaBuilder.equal(root.get("password"), password)));
		Utilisateur user;
		try {
			user = session.createQuery(query).getSingleResult();
		} catch (NoResultException e) {
			user = null;
		}

		return user;
	}

	public static Utilisateur chercherUtilisateur(String name) {

		Session session = HibernateUtil.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<Utilisateur> query = criteriaBuilder.createQuery(Utilisateur.class);
		Root<Utilisateur> root = query.from(Utilisateur.class);
		query.select(root);
		query.where(criteriaBuilder.equal(root.get("login"), name));
		Utilisateur user;
		try {
			user = session.createQuery(query).getSingleResult();
		} catch (NoResultException e) {
			user = null;
		}

		return user;
	}

	public static void ajouterUtilisateur(Utilisateur user) {

		Session session = HibernateUtil.getSession();
		EntityTransaction tx = session.getTransaction();
		tx.begin();

		session.persist(user);

		tx.commit();

	}

}
