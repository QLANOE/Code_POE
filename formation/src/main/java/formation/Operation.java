package formation;

import java.util.Date;

public class Operation {

	public Date dateOperation = new Date();
	public Date dateValeur = null;
	public String libelle = "test";
	public double montant = 0;

	Operation() {
		dateOperation = new Date();
		dateValeur = null;
		montant = 0;
	}

	double calculeMontantTTC(double taux) {
		return montant * (1 + taux);
	}

}
