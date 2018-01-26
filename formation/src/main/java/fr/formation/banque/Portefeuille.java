package fr.formation.banque;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Portefeuille implements Serializable {

	private String libelle;
	private String nomBanque;
	private Map<String, Compte> comptes = new HashMap<>();

	public Portefeuille() {

	}

	public Portefeuille(String libelle, String banque) {
		this.libelle = libelle;
		this.nomBanque = banque;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getNomBanque() {
		return nomBanque;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}

	public Map<String, Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Map<String, Compte> comptes) {
		this.comptes = comptes;
	}

	public Portefeuille creerNouveauPortefeuille() {

		Scanner sc = new Scanner(System.in);

		Portefeuille portefeuille = new Portefeuille();

		System.out.println("Veuillez saisir le nom du Portefeuille");
		portefeuille.setLibelle(sc.next());
		System.out.println("Veuillez saisir le nom de votre banque");
		portefeuille.setNomBanque(sc.next());

		return portefeuille;
	}

	public String toString() {
		return "Le nom du portefeuille est " + getLibelle() + " à la banque " + getNomBanque();
	}

}
