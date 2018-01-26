package jeudi;

import java.util.Arrays;
import java.util.Scanner;

public class Morpion {

	public static void main(String[] args) {

		//création du plateau de jeu
		int[][] plateau = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				plateau[i][j] = 9;
			}
		}
		affichePlateau(plateau);
		//tableau de booléens visualisant les conditions de victoire ou d'égalité
		boolean[] victoire = new boolean[2];
		//victoire[0]-->victoire; victoire[1]-->égalité
		victoire[0] = victoire[1] = false;
		
		//permet se savoir quel joueur joue
		int count = 0;

		while (victoire[0] == false && victoire[1] == false) {

			String User;
			//coordonnées du coup du joueur
			int[] coup = new int[2];
			
			//test du joueur
			if (count % 2 == 0) {
				User = "Joueur 1";
			} else {
				User = "Joueur 2";
			}
			//si la case a déjà été joué
			boolean dejaJouee = true;
			while (dejaJouee == true) {
				coup = demandeUtilPosition(User);
				dejaJouee = estDejaJouee(coup, plateau);
			}
			plateau = insertionJeton(coup, plateau, User);
			victoire = etatPartie(plateau, victoire);
			//si pas de victoire, on incrémente le compteur
			if (victoire[0] == false) {
				count++;
			}
			affichePlateau(plateau);
		}
		//test quel joueur a gagné
		if (victoire[0] == true && count % 2 == 0) {
			System.out.println("Le joueur 1 gagne!");
		} else if (victoire[0] == true && count % 2 == 1) {
			System.out.println("Le joueur 2 gagne!");
		}
	}

	private static void affichePlateau(int[][] plateau) {

		System.out.println(Arrays.toString(plateau[0]));
		System.out.println(Arrays.toString(plateau[1]));
		System.out.println(Arrays.toString(plateau[2]));
	}
	//les coordonnées sont comprise entre 1 et 3
	private static int[] demandeUtilPosition(String User) {
		Scanner saisieUser = new Scanner(System.in);
		int[] placement = new int[2];
		System.out.println(User + " ,veuillez saisir le numéro de ligne de votre prochain coup :");
		placement[0] = saisieUser.nextInt() - 1;
		System.out.println(User + " ,veuillez saisir le numéro de colonne de votre prochain coup :");
		placement[1] = saisieUser.nextInt() - 1;

		return placement;
	}

	private static int[][] insertionJeton(int[] coup, int[][] tab, String User) {
		// place le jeton de chaque joueur
		if (User == "Joueur 1") {
			tab[coup[0]][coup[1]] = -1;
		} else {
			tab[coup[0]][coup[1]] = 1;
		}
		return tab;
	}

	private static boolean estDejaJouee(int[] coup, int[][] tab) {
		boolean jouee;
		if (tab[coup[0]][coup[1]] != 9) {
			jouee = true;
			System.out.println("La case a déjà été jouée, recommencez :");
		} else {
			jouee = false;
		}
		return jouee;
	}

	private static boolean[] etatPartie(int[][] tab, boolean[] victoire) {
		//test la victoire sur les lignes et les colonnes
		for (int i = 0; i < 3; i++) {
			if (Math.abs(sommeLigne(tab, i)) == 3 || Math.abs(sommeColonne(tab, i)) == 3) {
				victoire[0] = true;
			}
		}
		//test la victoire sur les diagonales
		if (Math.abs(tab[0][0] + tab[1][1] + tab[2][2]) == 3 || Math.abs(tab[2][0] + tab[1][1] + tab[0][2]) == 3) {
			victoire[0] = true;
		}
		//initialise l'égalité à vrai
		victoire[1] = true;
		//test chaque case. sort de la boucle et met l'égalité à faux si il trouve une case non jouée
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tab[i][j] == 9 && victoire[0] == false) {
					victoire[1] = false;
					i = 3;
					j = 3;
				}
			}
		}
		//test si la victoire a été trouvé au dernier coup
		if (victoire[1] == true && victoire[0] == false) {
			System.out.println("La partie est une égalié");
		}
		return victoire;

	}

	private static int sommeLigne(int[][] tab, int indiceLigne) {
		return tab[indiceLigne][0] + tab[indiceLigne][1] + tab[indiceLigne][2];
	}

	private static int sommeColonne(int[][] tab, int indiceColonne) {
		return tab[0][indiceColonne] + tab[1][indiceColonne] + tab[2][indiceColonne];
	}
}
