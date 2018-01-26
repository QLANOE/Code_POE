package fr.formation.banque;

import java.io.Serializable;
import java.util.Date;

public abstract class Operation implements IOperation, Serializable {

	class Ligne implements Serializable {

		public int montant;
		public String libelle;

		public String toString() {
			return "<" + this.libelle + ">" + " d'un montant de " + this.montant;
		}
	}

	private Date dateOperation = new Date();
	private Date dateValeur = null;
	private String libelle = "test";
	private int debit = 0;
	private int credit = 0;
	private Ligne ligneHT = new Ligne();
	private Ligne ligneTVA = new Ligne();

	Operation() {
		dateOperation = new Date();
		dateValeur = null;
	}

	Operation(double montant) {
		this();
		setMontant(montant);
	}

	Operation(String libelle, double montant) {
		this.libelle = libelle;
		setMontant(montant);
	}

	Operation(String libelle) {
		this();
		this.libelle = libelle;
	}

	Operation(double montant, String libelle) {

		this(libelle);
		setMontant(montant);
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public Date getDateValeur() {
		return dateValeur;
	}

	public String getLibelle() {
		return libelle;
	}

	public abstract double getMontant();

	public void setDateOperation(Date date) {
		this.dateOperation = date;
	}

	public void setDateValeur(Date date) {
		this.dateValeur = date;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getDebit() {
		// return convertSomme(this.debit);
		return (double) this.debit / 100;
	}

	public void setDebit(double debit) {
		this.debit = convertSomme(debit);
	}

	public double getCredit() {
		// return convertSomme(this.debit);
		return (double) this.credit / 100;
	}

	public void setCredit(double credit) {
		this.credit = convertSomme(credit);
	}

	public abstract void setMontant(double montant);

	double calculeMontantTTC(double taux) {
		return getMontant() * (1 + taux);
	}

	public Ligne getLigneHT() {
		return ligneHT;
	}

	public Ligne getLigneTVA() {
		return ligneTVA;
	}

	protected void finalize() {
		System.out.println("finalize");
	}

	protected void setLigneHT(String libelle, double montant) {
		ligneHT.libelle = libelle;
		ligneHT.montant = convertSomme(montant);
	}

	protected void setLigneTVA(String libelle, double montant) {
		ligneTVA.libelle = libelle;
		ligneTVA.montant = convertSomme(montant);
	}

	public void setLigne(String libelle, double montant, double taux) {
		setLibelle(libelle);
		setMontant(montant * (1. + taux));
		setLigneHT(libelle, montant);
		setLigneTVA(libelle, montant * taux);

	}

	public abstract TypeOperation2 getTypeOperation();

	public static int convertSomme(double value) {
		return (int) Math.floor(value * 100);
	}

	public static double convertSomme(int value) {
		return (double) value / 100;
	}

	public String toString() {
		return "Operation : " + getTypeOperation().toString() + "\n" + "Libelle :" + getLibelle() + "\n" + "Montant : "
				+ getMontant() + "\n" + "D�bit : " + getDebit() + "\n" + "Cr�dit : " + getCredit() + "\n" + "HT :"
				+ ligneHT.toString() + "\n" + "TVA :" + ligneTVA.toString();
	}

	@Override
	public double calculeTaux(double taux, ICalculTaux calculTaux) {
		return calculTaux.calcule(this, taux);
	}

}
