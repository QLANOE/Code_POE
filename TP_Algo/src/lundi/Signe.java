package lundi;

import java.util.Scanner;

public class Signe {

	public static void main(String[] args) {// rend la classe executable

		Scanner saisieUtilisateur = new Scanner(System.in);// création de l'objet scanner

		double nombre1 = askUser("Veuillez saisir le premier nombre",saisieUtilisateur);
		
		double nombre2=askUser("Veuillez saisir le deuxième nombre :", saisieUtilisateur);

		System.out.println("vos nombre sont " + nombre1 +" et "+ nombre2);

		double produit= nombre1*nombre2;
		System.out.println("Le produit des deux nombres est " + produit);
		
		if (produit <0){
			System.out.println("Le produit est négatif");
		}
		else{
			System.out.println("Le produit est positif");
		}
		
		if (produit==0){
			System.out.println("Le produit vaut zéro");
		}
			
		//Autre méthode
		
		 boolean isPositiveProduct;
		 //c'est négatif si
		 if((nombre1<0 && nombre2>0)||(nombre1>0 && nombre2<0)){
			 isPositiveProduct=false;
		 }
		 else{
			 isPositiveProduct=true;
		 }
		//valuetested value ? is true: is false
		 String signWord=isPositiveProduct ? "positif" : "negatif";
		 System.out.println("c'est " + signWord);
		saisieUtilisateur.close();
	}

	private static double askUser(String text, Scanner saisieUtilisateur) {
		System.out.println(text);
		return saisieUtilisateur.nextDouble();
	}

}
