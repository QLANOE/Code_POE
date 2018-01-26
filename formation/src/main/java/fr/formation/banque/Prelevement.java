package fr.formation.banque;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Prelevement extends Operation {

	private String destinataire;

	public Prelevement(float montant) {
		super(montant);
	}

	public Prelevement() {
		super();
	}

	public String getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}

	public double getMontant() {
		return getDebit();
	}

	public void setMontant(double montant) {
		setDebit(montant);
		setCredit(0);

	}

	public TypeOperation2 getTypeOperation() {
		return TypeOperation2.PRELEVEMENT;
	}

	public boolean creerNouveauPrelevement() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir le titre de prélévement");
		setLibelle(sc.next());
		System.out.println("Veuillez saisir le montant de prélévement");
		setMontant(sc.nextDouble());
		System.out.println("Veuillez saisir la date de création de prélévement sous le format jj/mm/aa");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			setDateOperation(formatter.parse(sc.next()));
		} catch (ParseException e) {
			System.out.println("Respecte les consignes débile");
			e.printStackTrace();
		}
		setDateValeur(null);

		return true;

	}

	@Override
	public String toString() {
		return super.toString() + "\n Type d'opération: " + getTypeOperation();
	}

}
