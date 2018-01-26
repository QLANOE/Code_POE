package fr.formation.banque;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Virement extends Operation {

	private String compteVirement;

	public Virement(double montant) {
		super(montant);
	}

	public Virement() {
		super();
	}

	public String getCompteVirement() {
		return compteVirement;
	}

	public void setCompteVirement(String compteVirement) {
		this.compteVirement = compteVirement;
	}

	public double getMontant() {
		return getDebit();
	}

	public void setMontant(double montant) {
		setDebit(-montant);
		setCredit(0);

	}

	public TypeOperation2 getTypeOperation() {
		return TypeOperation2.VIREMENT;
	}

	public boolean creerNouveauVirement() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir le titre du virement");
		setLibelle(sc.next());
		System.out.println("Veuillez saisir le montant du virement");
		setMontant(sc.nextDouble());
		System.out.println("Veuillez saisir la date de création du virement sous le format jj/mm/aa");
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
