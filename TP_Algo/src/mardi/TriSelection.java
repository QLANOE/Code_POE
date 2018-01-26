package mardi;

import java.util.Arrays;
import java.util.Scanner;

public class TriSelection {

	public static void main(String[] args) {
		
		int jet[];
		
		int tailleTab = askTabSize();
		
		jet=new int[tailleTab];
		
		generator(jet);
		
		System.out.println(Arrays.toString(jet));
		
		triTableau(jet);
		
		isTableauOk(jet);
		
		System.out.println(Arrays.toString(jet));
	}


	private static int askTabSize() {
		Scanner saisieUser = new Scanner(System.in);//création de l'objet scanner

		System.out.println("Veuillez saisir la taille du tableau :");
		int tailleTab = saisieUser.nextInt();
		saisieUser.close();
		return tailleTab;
	}


	private static void isTableauOk(int[] jet) {
		for(int i=1;i>jet.length;i++)
		{
			if (jet[i-1]<jet[i]){
				System.out.println("Tu t'es foiré mon vieux");
			}
			
		}
	}


	private static void triTableau(int[] jet) {
		for(int i=0;i<jet.length;i++){
			int index = chercheMax(jet, i);
			int tampon=jet[jet.length-i-1];
			jet[jet.length-i-1]=jet[index];
			jet[index]=tampon;
		}
	}


	private static int chercheMax(int[] jet, int i) {
		int index=0;
		int max=0;
		for (int j=0;j<jet.length-i;j++){
			
			if (jet[j]>max){
				max=jet[j];
				index=j;
			}

		}
		return index;
	}

	
	private static void generator(int[] jet) {
		for(int j=0;j<jet.length;j++){
			jet[j]=(int)(Math.random()*10+1);		
		}
	}

}
