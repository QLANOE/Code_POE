package jeudi;

import java.util.Arrays;
import java.util.Scanner;

public class DichotomieRécursive {

	public static void main(String[] args) {

		int jet[];

		jet = new int[askUserTabSize()];

		creerTableauAleatoire(jet);

		// Sélection aléatoire d'une cible
		int target = (int) (Math.random() * 10 + 1);

		System.out.println("la valeur target est " + target);

		System.out.println(Arrays.toString(jet));

		triInsertionTableau(jet);

		System.out.println(Arrays.toString(jet));

		/* trouveCible(jet, target); */
		recursif(jet,target);
	}

	private static void trouveCible(int[] jet, int target) {

		// Définition des indices entre lesquels sera effectuée la recherche

		int indiceBas = 0;
		int indiceHaut = jet.length - 1;

		// sert à savoir si la target a été trouvée

		boolean trouve = false;

		// il s'arrête si target est trouvée ou si l'indice haut est plus petit
		// que l'indice bas

		while (trouve == false && indiceHaut >= indiceBas) {

			// recherche le milieu de la sélection en cours

			int mid = rechercheMidIndice(indiceBas, indiceHaut);

			if (jet[mid] < target) {

				indiceBas = mid + 1;

			}

			else {
				if (jet[mid] > target) {
					indiceHaut = mid - 1;
				} else {
					trouve = true;
					// pour la position dans le tableau
					mid++;
					System.out.println("la valeur est en position " + mid);

				}
			}
		}
		if (trouve == false) {
			System.out.println("la valeur n'est pas dans le tableau");
		}

	}

	private static int askUserTabSize() {
		Scanner saisieUser = new Scanner(System.in);// création de l'objet
													// scanner

		System.out.println("Veuillez saisir la taille du tableau :");
		int tailleTab = saisieUser.nextInt();
		saisieUser.close();
		return tailleTab;
	}

	private static int rechercheMidIndice(int ibas, int ihaut) {
		return (ihaut + ibas) / 2;
	}

	private static void triInsertionTableau(int[] jet) {
		for (int i = 0; i < jet.length; i++) {

			int index = 0;
			index = chercheMax(jet, i);
			int tampon = jet[jet.length - i - 1];
			jet[jet.length - i - 1] = jet[index];
			jet[index] = tampon;
		}
	}

	private static int chercheMax(int[] jet, int i) {
		int index = -1;
		int max = 0;
		for (int j = 0; j < jet.length - i; j++) {

			if (jet[j] > max) {
				max = jet[j];
				index = j;
			}

		}
		return index;
	}

	private static void creerTableauAleatoire(int[] jet) {
		for (int j = 0; j < jet.length; j++) {
			jet[j] = (int) (Math.random() * 10 + 1);
		}
	}

	private static int recursif(int[] jet, int target) {

		int mid = rechercheMidIndice(0, jet.length - 1);

		if (jet.length == 1 && jet[mid] != target) {
			System.out.println("pas dans le tableau");
			return -1;
		} else if (jet[mid] == target) {
			System.out.println("la valeur se trouve à la position " + jet[mid]);
			return target;
		} else {

			if (jet[mid] < target) {
				jet = Arrays.copyOfRange(jet,mid,jet.length-1 );
			} else {
				jet = Arrays.copyOfRange(jet, 0 , mid);
			}

			return recursif(jet,target);
		}
	}
}
