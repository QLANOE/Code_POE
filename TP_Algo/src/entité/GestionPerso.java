package entité;

import java.util.Arrays;

public class GestionPerso {

	public static void main(String[] args) {

		PNJ squelette = new PNJ();
		squelette.nom = "Squelette";
		squelette.FP = 1;
		squelette.stat = new int[6];
		for (int i = 0; i < squelette.stat.length; i++) {

			squelette.stat[i] = 10 + i;
		}
		System.out.println(Arrays.toString(squelette.stat));

		PNJ goule = new PNJ("goule", 2);
		System.out.println(goule.nom + " " + goule.FP);
	}

}
