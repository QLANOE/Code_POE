package mardi;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Voiture voiture = new Voiture();
		voiture.marque = "BOB";
		voiture.afficherMarque();

		Roue roue1 = new Roue();
		roue1.taille = 17;

		voiture.roues = new ArrayList();
		voiture.roues.add(roue1);
		System.out.println(voiture.roues.get(0).taille);

	}

}
