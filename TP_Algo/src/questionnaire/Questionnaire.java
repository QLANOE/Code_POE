package questionnaire;

import java.util.ArrayList;
import java.util.Collections;

public class Questionnaire {

	ArrayList<Question> question;

	public ArrayList melangerQuestionnaire() {

		ArrayList nouvelle = new ArrayList(question);
		Collections.shuffle(nouvelle);
		return nouvelle;
	}
}
