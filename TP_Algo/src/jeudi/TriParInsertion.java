package jeudi;

import java.util.Arrays;
import java.util.Scanner;

public class TriParInsertion {

	public static void main(String[] args) {

		int[] tab=new int[askUserTabSize()];
		creerTableauAleatoire(tab);
		
		System.out.println(Arrays.toString(tab));
		
		triInsertion(tab);

	}

	private static void triInsertion(int[] tab) {
		for(int i=1;i<tab.length;i++){
			int temp=tab[i];
			int precedent=i-1;
			while (precedent>=0 && tab[precedent]>temp ){
				
				tab[precedent+1]=tab[precedent];
				tab[precedent]=temp;
				precedent--;

			}

			System.out.println(Arrays.toString(tab));
		}
	}

	private static int askUserTabSize() {
		Scanner saisieUser = new Scanner(System.in);// création de l'objet
													// scanner

		System.out.println("Veuillez saisir la taille du tableau :");
		int tailleTab = saisieUser.nextInt();
		saisieUser.close();
		return tailleTab;
	} // scanner
	
	private static void creerTableauAleatoire(int[] tab) {
		for (int j = 0; j < tab.length; j++) {
			tab[j] = (int) (Math.random() * 100 + 1);
		}
	}

}