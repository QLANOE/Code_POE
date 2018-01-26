package fr.formation.banque;

public class TypeOperation {

	public static final int TYPE_CB = 0;
	public static final int TYPE_CHEQUE = 1;
	public static final int TYPE_ESPECE = 2;
	public static final int TYPE_VIREMENT = 3;
	public static final int TYPE_PRELEVEMENT = 4;

	public static String getValue(int value) {
		switch (value) {
		case TYPE_CB:
			return "CB";
		case TYPE_CHEQUE:
			return "Ch�que";
		case TYPE_ESPECE:
			return "Esp�ce";
		case TYPE_VIREMENT:
			return "Virement";
		case TYPE_PRELEVEMENT:
			return "Pr�l�vement";
		}

		return "#ERR";
	}

	public static int getValue(String value) {
		switch (value) {
		case "CB":
			return TYPE_CB;
		case "Ch�que":
			return TYPE_CHEQUE;
		case "Esp�ce":
			return TYPE_ESPECE;
		case "Virement":
			return TYPE_VIREMENT;
		case "Pr�l�vement":
			return TYPE_PRELEVEMENT;
		}

		return 5;

	}

	public static void main(String args[]) {
		System.out.println(TypeOperation.getValue(TypeOperation.TYPE_CHEQUE));
		System.out.println(TypeOperation.getValue(5));

		System.out.println(TypeOperation.getValue("CB"));
		System.out.println(TypeOperation.getValue("skdhfk"));

		System.out.println(TypeOperation.getValue(getValue(new String("Virement"))));

	}

}
