package questionnaire;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionQuestion {

	public Question creerQuestion() {
		int Nbreponse;

		System.out.println("Combien voulez vous de réponse ?");

		Scanner sc = new Scanner(System.in);
		Nbreponse = sc.nextInt();

		Question question = new Question();
		question.reponse = new ArrayList<>();
		question.bonnereponse = new ArrayList<>();

		System.out.println("Quel est l'intitulé de la question?");
		question.intitulé = sc.next();

		for (int i = 0; i < Nbreponse; i++) {
			System.out.println("Donner la réponse " + (i + 1));
			question.reponse.add(sc.next());
			System.out.println("Est-elle true ou false?");
			question.bonnereponse.add(sc.nextBoolean());
		}
		return question;
	}

	public int calculerScore(int[] index, Question question) {

		boolean testVéracité = true;

		// variable qui permet de pointer dans index
		int j = 0;
		// parcours l'ensemble des bonnes réponses
		for (int i = 0; i < question.bonnereponse.size(); i++) {
			// si j ne dépasse pas la taille de index et que i vaut la valeur de
			// l'index de j
			if (j < index.length && i == (index[j] - 1)) {
				// on teste si la réponse est bonne
				testVéracité = question.bonnereponse.get(index[j] - 1) && testVéracité;
				j++;
			} else {
				// on teste si la réponse est fausse
				testVéracité = !(false || question.bonnereponse.get(i)) && testVéracité;
			}
		}

		int score;
		if (testVéracité == true) {
			score = 1;
		} else {
			score = 0;
		}
		return score;
	}

	public int saisirNbQuestion() {

		System.out.println("Combien voulez vous de questions ?");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();

	}

	public int[] répondreQuestion() {
		String reponse;
		String[] reponses;

		Scanner sc = new Scanner(System.in);
		reponse = sc.next();

		reponses = reponse.split(",");

		int[] index = new int[reponses.length];

		for (int i = 0; i < reponses.length; i++) {
			index[i] = Integer.parseInt(reponses[i]);
		}
		return index;
	}

	public void envoyerScore() {

	}

}
