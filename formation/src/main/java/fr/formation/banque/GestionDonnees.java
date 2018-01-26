package fr.formation.banque;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GestionDonnees {

	public void ajoutPortefeuille(Map<String, Portefeuille> map, Portefeuille portefeuille) {

		if (map.containsKey(portefeuille.getLibelle())) {
			System.out.println("Le portefeuille existe déjà");
		} else {
			map.put(portefeuille.getLibelle(), portefeuille);
		}

	}

	public void lecturePortefeuille(String str, Map<String, Portefeuille> map) {
		System.out.println(map.get(str).getLibelle() + " " + map.get("bob").getNomBanque());

	}

	public void ajoutCompte(Map<String, Compte> map, Compte compte) {

		if (map.containsKey(compte.getNumero())) {
			System.out.println("Le compte existe déjà");
		} else {
			map.put(compte.getNumero(), compte);
		}

	}

	public void lectureCompte(Compte compte) {
		System.out.println(compte.getNumero() + " " + compte.getDateOuverture() + " " + compte.getDateFermeture());
	}

	public void ajoutOperation(List<Operation> list, Operation operation) {

		list.add(operation);

	}

	public Operation creerNouvelleOperation() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Veuillez choisir votre opération: " + "\n" + "1-Enregistrement \n" + "2-Virement \n"
				+ "3-Prelevement \n" + "4-Depot");

		int indexOperation = sc.nextInt();
		boolean saisieCorrecte = false;

		while (saisieCorrecte == false) {
			switch (indexOperation) {
			case 1:
				Enregistrement enregistrement = new Enregistrement();
				saisieCorrecte = enregistrement.creerNouveauEnregistrement();
				return enregistrement;
			case 2:
				Virement virement = new Virement();
				saisieCorrecte = virement.creerNouveauVirement();
				return virement;
			case 3:
				Prelevement prelevement = new Prelevement();
				saisieCorrecte = prelevement.creerNouveauPrelevement();
				return prelevement;
			case 4:
				Depot depot = new Depot();
				saisieCorrecte = depot.creerNouveauDepot();
				return depot;
			}

		}
		return null;
	}

}
