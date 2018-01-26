package jframe;

public class Execution {

	public static void main(String[] args) {

		Demineur demineur = new Demineur(10, 10, 50);
		demineur.afficher();

		demineur.placerBombes();
		demineur.afficher();

	}

}
