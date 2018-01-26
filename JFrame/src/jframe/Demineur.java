package jframe;

public class Demineur {

	private int[][] grille;
	private int nbBombes;
	private int largeur;
	private int longueur;

	public Demineur() {

	}

	public Demineur(int largeur, int longueur, int nbBombes) {

		this.largeur = largeur;
		this.longueur = longueur;
		this.nbBombes = nbBombes;

		this.grille = new int[largeur][longueur];
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < longueur; j++) {
				grille[i][j] = 0;
			}
		}

	}

	public void afficher() {

		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < longueur; j++) {
				System.out.print(grille[i][j] + "\t");
			}
			System.out.println("");

		}

		System.out.println("\n\n\n");
	}

	public void placerBombes() {

		for (int i = 0; i < this.nbBombes; i++) {
			int x = (int) Math.floor((Math.random() * largeur));
			int y = (int) Math.floor((Math.random() * longueur));
			if (this.grille[x][y] == -1) {
				i--;
			} else {
				this.grille[x][y] = -1;
				incrementerCase(x, y);
			}
		}
	}

	public void incrementerCase(int x, int y) {

		int[] definitionBoucle = testerCasesAdjacentes(x, y);

		for (int i = definitionBoucle[0]; i < definitionBoucle[1]; i++) {
			for (int j = definitionBoucle[2]; j < definitionBoucle[3]; j++) {
				if (this.grille[x + i][y + j] != -1) {
					this.grille[x + i][y + j] += 1;
				}
			}
		}
	}

	public int[] testerCasesAdjacentes(int x, int y) {

		int[] definitionBoucle = new int[4];
		definitionBoucle[0] = -1;
		definitionBoucle[1] = 2;
		definitionBoucle[2] = -1;
		definitionBoucle[3] = 2;
		if (x - 1 < 0) {
			definitionBoucle[0] = 0;
		}
		if (x + 1 > largeur - 1) {
			definitionBoucle[1] = 1;
		}
		if (y - 1 < 0) {
			definitionBoucle[2] = 0;
		}
		if (y + 1 > longueur - 1) {
			definitionBoucle[3] = 1;
		}

		return definitionBoucle;

	}

	public int[][] getGrille() {
		return grille;
	}

	public void setGrille(int[][] grille) {
		this.grille = grille;
	}

	public int getNbBombes() {
		return nbBombes;
	}

	public void setNbBombes(int nbBombes) {
		this.nbBombes = nbBombes;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

}
