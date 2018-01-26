package fr.formation.banque;

import java.util.Date;

public interface IOperation {

	Date getDateOperation();

	Date getDateValeur();

	String getLibelle();

	double getMontant();

	void setDateOperation(Date date);

	void setDateValeur(Date date);

	void setLibelle(String libelle);

	double getDebit();

	void setDebit(double debit);

	double getCredit();

	void setCredit(double credit);

	void setMontant(double montant);

	public default double calculMontantTTC(double taux) {
		return (getCredit() - getDebit()) * (1 + taux);
	}

	public TypeOperation2 getTypeOperation();

	void setLigne(String libelle, double montant, double taux);

	double calculeTaux(double taux, ICalculTaux calculTaux);

}