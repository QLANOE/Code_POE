package questionnaire;

import java.util.Scanner;

public class Affichage {

	public void afficherScore(int score, int nbreponse) {
		System.out.println("Votre score est de " + score + "/" + nbreponse);

	}

	public void afficherQuestion(Question question) {

		System.out.println(question.intitulé);

		for (int i = 0; i < question.bonnereponse.size(); i++) {
			System.out.println((1 + i) + ") " + question.reponse.get(i));
		}

	}

	public boolean demanderSiAjouterQuestion() {
		System.out.println("Voulez ajouter une question au questionnaire?\n True ou False");
		Scanner sc = new Scanner(System.in);
		return sc.nextBoolean();
	}

}
