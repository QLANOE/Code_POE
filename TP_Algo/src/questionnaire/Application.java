package questionnaire;

import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {

		Questionnaire questionnaire1 = new Questionnaire();
		questionnaire1.question = new ArrayList<>();

		Question questiontest = new Question();
		questiontest.intitulé = "Combien font 2+2 ?";
		questiontest.reponse = new ArrayList<>();
		questiontest.bonnereponse = new ArrayList<>();

		questiontest.reponse.add("42");
		questiontest.reponse.add("4");
		questiontest.reponse.add("23");
		questiontest.reponse.add("pamplemousse");

		questiontest.bonnereponse.add(false);
		questiontest.bonnereponse.add(true);
		questiontest.bonnereponse.add(false);
		questiontest.bonnereponse.add(false);

		questionnaire1.question.add(questiontest);

		GestionApplication ge = new GestionApplication();

		boolean identification = false;
		String motDePasse = "123";

		ge.identifierFormateur(identification, motDePasse);

		ge.demanderSiAjouterQuestion(questionnaire1);

		int nbRéponse = ge.demanderNbQuestion(questionnaire1);

		ge.passerTest(questionnaire1, nbRéponse);

	}

}
