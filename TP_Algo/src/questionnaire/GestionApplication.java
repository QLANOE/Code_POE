package questionnaire;

import java.util.Scanner;

public class GestionApplication {

	public void identifierFormateur(boolean identification, String motDePasse) {
		while (identification == false) {
			String identifiant;
			System.out.println("Veuillez saisir le mot de passe");
			Scanner sc = new Scanner(System.in);
			identifiant = sc.next();
			if (!identifiant.equals(motDePasse)) {
				System.out.println("Mot de passe faux");
			} else {
				System.out.println("Identifié");
				identification = true;
			}

		}

	}

	public void demanderSiAjouterQuestion(Questionnaire questionnaire) {

		boolean nouvelleQuestion;
		Affichage affiche = new Affichage();
		GestionQuestion essai = new GestionQuestion();

		nouvelleQuestion = affiche.demanderSiAjouterQuestion();

		while (nouvelleQuestion == true) {
			Question question = new Question();
			question = essai.creerQuestion();
			questionnaire.question.add(question);
			nouvelleQuestion = affiche.demanderSiAjouterQuestion();
		}
	}

	public int demanderNbQuestion(Questionnaire questionnaire1) {
		int nbRéponse;
		GestionQuestion essai = new GestionQuestion();
		nbRéponse = essai.saisirNbQuestion();
		while (nbRéponse > questionnaire1.question.size()) {
			System.out.println("Le questionnaire est trop petit, il contient " + questionnaire1.question.size()
					+ " questions \n Veuillez ressaisir un nombre de question");
			nbRéponse = essai.saisirNbQuestion();
		}
		return nbRéponse;
	}

	public void passerTest(Questionnaire questionnaire1, int nbRéponse) {

		int[] index;
		Affichage affiche = new Affichage();
		GestionQuestion essai = new GestionQuestion();
		int score = 0;
		int count = 0;

		questionnaire1.question = questionnaire1.melangerQuestionnaire();

		while (count != nbRéponse) {
			affiche.afficherQuestion(questionnaire1.question.get(count));
			index = essai.répondreQuestion();
			score = essai.calculerScore(index, questionnaire1.question.get(count)) + score;
			count++;
		}
		affiche.afficherScore(score, nbRéponse);
	}
}
