package lundi;

import java.util.Scanner;

public class Devinette {

	public static void main(String[] args) {

		Scanner saisieUser = new Scanner(System.in);
		
		int tirage = (int)(Math.random()*10+1);

		System.out.println("Veuillez choisir un nombre entre 1 et 10:");
		int nombre = saisieUser.nextInt();

		testNombre(saisieUser, tirage, nombre);
		
		saisieUser.close();
	}

	
	
	
	
	private static void testNombre(Scanner saisieUtilisateur, int tirage, int nombre) {
		while (nombre != tirage){
			if (nombre<tirage){
				System.out.println("Faux, plus grand");
			}
			else{
				System.out.println("Faux, plus petit");
			}
			nombre = saisieUtilisateur.nextInt();
		}
		System.out.println("Bravo,vous avez trouvé, le nombre est bien: "+tirage);
	}
	
}
