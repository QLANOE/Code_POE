package fr.formation.banque;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Depot extends Operation {

	private String type;
	private TypeOperation2 typeOperation;

	public Depot(float montant, String typeOperation) throws Exception {
		super(montant);
		this.typeOperation = TypeOperation2.getValue(typeOperation);
	}

	public Depot() {
		super();
	}

	public TypeOperation2 getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(TypeOperation2 typeOperation) {
		this.typeOperation = typeOperation;
	}

	public String type() {
		return type;
	}

	public void setDestinataire(String type) {
		this.type = type;
	}

	public double getMontant() {
		return getCredit();
	}

	public void setMontant(double montant) {
		setCredit(montant);
		setDebit(0);

	}

	public boolean creerNouveauDepot() {
		Scanner sc = new Scanner(System.in);
		TypeOperation2.afficherListeOperation();
		try {
			this.typeOperation = TypeOperation2.getValue(sc.nextLine());
		} catch (NullPointerException | ExceptionValeurIndefinie e) {
			e.printStackTrace();
		}
		System.out.println("Veuillez saisir le titre du dépot");
		setLibelle(sc.next());
		System.out.println("Veuillez saisir le montant du dépot");
		setMontant(sc.nextDouble());
		System.out.println("Veuillez saisir la date de création du dépot sous le format jj/mm/aa");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			setDateOperation(formatter.parse(sc.next()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
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
