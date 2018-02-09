package utilisateurs;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue
	private long id;
	private String email;
	private Date inscription;
	private String login;
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMail() {
		return email;
	}

	public void setMail(String mail) {
		this.email = mail;
	}

	public Date getDateInscription() {
		return inscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.inscription = dateInscription;
	}

	public String getName() {
		return login;
	}

	public void setName(String name) {
		this.login = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Utilisateur() {
	}

	public Utilisateur(long id, String mail, Date dateInscription, String name, String password) {
		this.id = id;
		this.email = mail;
		this.inscription = dateInscription;
		this.login = name;
		this.password = password;
	}

}
