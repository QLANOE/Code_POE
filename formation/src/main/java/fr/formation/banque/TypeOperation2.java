package fr.formation.banque;

public enum TypeOperation2 {

	CB("CB"), CHEQUE("Cheque"), ESPECE("Espece"), VIREMENT("Virement"), PRELEVEMENT("Prelevement");

	private String libelle = "";

	private TypeOperation2(String libelle) {
		this.libelle = libelle;
	}

	public String toString() {
		return libelle;
	}

	public static TypeOperation2 getValue(String value) throws NullPointerException, ExceptionValeurIndefinie {

		if (value == null) {
			throw new NullPointerException("'value' est null");
		}

		for (TypeOperation2 v : TypeOperation2.values()) {
			if (value.equals(v.toString())) {
				return v;
			}
		}
		throw new ExceptionValeurIndefinie("T'ES MAUVAIS GUILLAUME");
	}

	public static void afficherListeOperation() {
		System.out.println(
				"Veuillez choisir un type d'opération: \n -CB \n -Cheque \n -Espece \n -Virement \n -Prelevement");
	}

}
