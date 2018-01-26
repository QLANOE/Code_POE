package garage;

public class Application {

	public static void main(String[] args) {

		Voiture monstre;
		Voiture brouette;
		monstre = new Voiture();
		brouette = new Voiture();

		monstre.marque = "Airbus";
		monstre.modele = "Ariane";

		Moteur vulcain = new Moteur();
		vulcain.puissance = 1000;
		Moteur coucou = new Moteur();
		coucou.puissance = 40;

		brouette.moteur = coucou;

		monstre.moteur = vulcain;

		Roue roueavtgauche = new Roue();
		Roue roueavtdroite = new Roue();
		Roue rouearrgauche = new Roue();
		Roue rouearrdroite = new Roue();

		Roue[] roues = new Roue[4];

		roues[0] = roueavtgauche;
		roues[1] = roueavtdroite;
		roues[2] = rouearrgauche;
		roues[3] = rouearrdroite;

		Roue[] roue = new Roue[4];

		for (int i = 0; i < 4; i++) {
			Roue pneu = new Roue();
			pneu.typePneu = "firestone";
			roue[i] = pneu;
		}

		monstre.roues = roues;

		System.out.println(monstre.marque);

	}

}
