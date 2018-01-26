package lundi;

import java.util.Scanner;
import java.lang.Math;

public class Carre {

	public static void main(String[] args) {

		Scanner saisieUtilisateur = new Scanner(System.in);//création de l'objet scanner

		System.out.println("Veuillez saisir un nombre :");
		double nombre = saisieUtilisateur.nextInt();

		System.out.println("votre nombre est " + nombre);

		nombre = Math.pow(nombre, 2);

		System.out.println("Le carré de ce nombre est " + nombre);
		saisieUtilisateur.close();
	}
}
