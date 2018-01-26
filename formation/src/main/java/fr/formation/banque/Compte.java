package fr.formation.banque;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Compte implements Serializable {

	private String numero;
	private Date dateOuverture;
	private Date dateFermeture;
	private ArrayList<Operation> operations = new ArrayList<>();

	public Compte() {

	}

	public Compte(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Date getDateFermeture() {
		return dateFermeture;
	}

	public void setDateFermeture(Date dateFermeture) {
		this.dateFermeture = dateFermeture;
	}

	public Compte creerNouveauCompte() {

		Scanner sc = new Scanner(System.in);

		Compte compte = new Compte();
		System.out.println("Veuillez saisir le numéro de compte");
		compte.setNumero(sc.next());
		System.out.println("Veuillez saisir la date de création du compte sous le format jj/mm/aa");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			compte.setDateOuverture(formatter.parse(sc.next()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		compte.setDateFermeture(null);

		return compte;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(ArrayList<Operation> operations) {
		this.operations = operations;
	}

	@Override
	public String toString() {
		return "Le numéro de compte est " + getNumero() + " ouvert à la date " + getDateOuverture();
	}

	public double getMontant() {
		return operations.stream().mapToDouble(Operation::getMontant).sum();
	}

}
