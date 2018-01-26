package mercredi;

import java.util.Arrays;
import java.util.Scanner;

public class TriBulle {

	public static void main(String[] args) {
		
		int jet[];
		
		int tailleTab = askTabSize();
		
		jet=new int[tailleTab];
		
		generator(jet);
		
		System.out.println(Arrays.toString(jet));
		
		triBulle(jet);
		
		System.out.println(Arrays.toString(jet));
	}


	private static void triBulle(int[] jet) {
		for(int i=0;i<jet.length-1;i++){
			for(int j=0;j<jet.length-1-i;j++){
				if(jet[j]>jet[j+1]){
					int temp=jet[j];
					jet[j]=jet[j+1];
					jet[j+1]=temp;
				}
			}
			
		}
	}


	private static int askTabSize() {
		Scanner saisieUser = new Scanner(System.in);//création de l'objet scanner

		System.out.println("Veuillez saisir la taille du tableau :");
		int tailleTab = saisieUser.nextInt();
		saisieUser.close();
		return tailleTab;
	}


	private static void generator(int[] jet) {
		for(int j=0;j<jet.length;j++){
			jet[j]=(int)(Math.random()*100+1);		
		}
	}
}
