package lundi;

import java.time.Year;
import java.util.Scanner;


public class AnneeNaissance {
	public static void main(String[] args) {

		Scanner saisieUtilisateur = new Scanner(System.in);//cr�ation de l'objet scanner

		System.out.println("Veuillez saisir votre age :");
		int age = saisieUtilisateur.nextInt();

		System.out.println("votre age est " + age);

		// on va chercher l'ann�e avec Year.now() puis sa valeur en i=entier avec getValue()
		int date= Year.now().getValue();
		int annee= date-age;
		
		System.out.println("vous �tes n� en " + annee);
		
		System.out.println("Veuillez saisir votre ann�e de naissance :");
		annee=saisieUtilisateur.nextInt();
		
		age=date-annee;
		
		System.out.println("vous avez " + age+ " ans");
		
		saisieUtilisateur.close();
	}
}
