package fr.formation.banque;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Enregistrement extends Operation {

	private String modePaiement;
	private TypeOperation2 libelle;

	public Enregistrement(Float montant, String typeoperation) throws Exception {
		super(montant);
		this.libelle = TypeOperation2.getValue(typeoperation);
	}

	public Enregistrement() {
		super();
	}

	public String getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	public double getMontant() {
		return ((getCredit() - getDebit()) / 100);
	}

	public TypeOperation2 getTypeOperation() {
		return this.libelle;
	}

	public void setMontant(double montant) {
		if (montant > 0) {
			setCredit(montant);
			setDebit(0);
		} else {
			setDebit(-montant);
			setCredit(0);
		}

	}

	public boolean creerNouveauEnregistrement() {
		Scanner sc = new Scanner(System.in);
		TypeOperation2.afficherListeOperation();
		try {
			this.libelle = TypeOperation2.getValue(sc.nextLine());
		} catch (NullPointerException | ExceptionValeurIndefinie e) {
			e.printStackTrace();
		}
		System.out.println("Veuillez saisir le titre de l'enregistrement");
		setLibelle(sc.next());
		System.out.println("Veuillez saisir le montant de l'enregistrement");
		setMontant(sc.nextDouble());
		System.out.println("Veuillez saisir la date de création de l'enregistrement sous le format jj/mm/aa");
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
