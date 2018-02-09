package utilisateurs;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private long id;
	private String contenu;
	@OneToOne
	private Utilisateur user;
	private Date date = new Date();
	@ManyToOne
	private FilDiscussion thread;

	public String getMessage() {
		return contenu;
	}

	public void setMessage(String message) {
		this.contenu = message;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public FilDiscussion getThread() {
		return thread;
	}

	public void setThread(FilDiscussion thread) {
		this.thread = thread;
	}

}
