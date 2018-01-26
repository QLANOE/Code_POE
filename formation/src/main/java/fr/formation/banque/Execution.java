package fr.formation.banque;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Execution {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		GestionDonnees traitement = new GestionDonnees();

		Map<String, Portefeuille> portefeuilles = new HashMap<>();

		Portefeuille portefeuille = new Portefeuille();
		Portefeuille portefeuille2 = new Portefeuille("bob", "bnp");
		traitement.ajoutPortefeuille(portefeuilles, portefeuille2);
		traitement.ajoutPortefeuille(portefeuilles, portefeuille.creerNouveauPortefeuille());
		traitement.lecturePortefeuille("bob", portefeuilles);

		Compte compte = new Compte();
		Compte compte2 = new Compte("316215");
		traitement.ajoutCompte(portefeuilles.get("bob").getComptes(), compte.creerNouveauCompte());
		traitement.ajoutCompte(portefeuilles.get("bob").getComptes(), compte2);

		traitement.lectureCompte(portefeuilles.get("bob").getComptes().get("123"));

		traitement.ajoutOperation(portefeuilles.get("bob").getComptes().get("123").getOperations(),
				traitement.creerNouvelleOperation());
		traitement.ajoutOperation(portefeuilles.get("bob").getComptes().get("316215").getOperations(),
				traitement.creerNouvelleOperation());

		// fichier

		FileOutputStream fichier = new FileOutputStream("test.op");
		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(fichier);
			oos.writeObject(portefeuilles);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		FileInputStream bis = new FileInputStream("test.op");
		ObjectInputStream ios = null;

		try {
			ios = new ObjectInputStream(bis);
			portefeuilles = (Map<String, Portefeuille>) ios.readObject();

			System.out.println(portefeuilles.get("bob").toString() + "\n"
					+ portefeuilles.get("bob").getComptes().get("123").toString());
			System.out.println(portefeuilles.get("bob").getComptes().get("123").getOperations().get(0).toString());
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// sql

		Class.forName("com.mysql.jdbc.Driver");

		System.out.println("Connecting to database ...");
		Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/formation", "root",
				"Imiraadrossas96");
		System.out.println("Connection done ...");

		PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(
				"insert into `Operation`(`DateOperation`, `DateValeur`, `Libelle`, `Type`) " + "values (?, ?, ?, ?)");
		preparedStmt.setDate(1, new java.sql.Date((new SimpleDateFormat("dd-MM-yyyy")).parse("12-04-2017").getTime()));
		preparedStmt.setDate(2, null);
		preparedStmt.setString(3, "Nouvelle ligne");
		preparedStmt.setInt(4, 1);

		preparedStmt.execute();

		preparedStmt.close();

		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt
				.executeQuery("Select `Id`, `DateOperation`, `DateValeur`, `Libelle`, `Type` " + "from `Operation`");

		while (rs.next())
			System.out.println(rs.getInt("Id") + " - " + rs.getDate("DateOperation") + " - " + rs.getDate("DateValeur")
					+ " - " + rs.getString("Libelle") + " - " + rs.getInt("Type"));

		rs.close();
		stmt.close();

		conn.close();

		double sum = portefeuilles.get("bob").getComptes().get("123").getOperations().stream()
				.filter(o -> o.getMontant() > 0).mapToDouble(Operation::getMontant).sum();
		System.out.println("Somme positive:" + sum);

		System.out.println(portefeuilles.values().toString());

		// double sum1 =
		// portefeuilles.values().stream().mapToDouble(Compte::getMontant).sum();
		// System.out.println("Somme positive:" + sum1);

		// ancien

		/*
		 * 
		 * Virement op = new Virement(-10.56);
		 * 
		 * Depot depot = new Depot(100, "CB");
		 * System.out.println(depot.calculMontantTTC(1));
		 * 
		 * op = null; System.gc();
		 * 
		 * Prelevement prelevement = new Prelevement(45);
		 * prelevement.setLigne("Drogue", 45, 2);
		 * System.out.println(prelevement.toString());
		 * 
		 * Operation operation1 = new Operation() {
		 * 
		 * private double montant;
		 * 
		 * @Override public double getMontant() { return this.montant; }
		 * 
		 * @Override public TypeOperation2 getTypeOperation() { // TODO
		 * Auto-generated method stub return TypeOperation2.CHEQUE; }
		 * 
		 * @Override public void setMontant(double montant) { this.montant =
		 * montant;
		 * 
		 * } };
		 * 
		 * operation1.setLigne("Anonymous", 100, 0.1);
		 * System.out.println(operation1.toString());
		 * 
		 * ICalculTaux monTaux = new ICalculTaux() {
		 * 
		 * @Override public double calcule(IOperation operation, double taux) {
		 * return operation.getMontant() * taux; } };
		 * 
		 * System.out.println("Montant du taux � 20% :" +
		 * monTaux.calcule(operation1, 0.2)); System.out.println(
		 * "Montant du taux � 20% :" + operation1.calculeTaux(0.5, monTaux));
		 * System.out.println( "Montant du taux � 20% :" +
		 * operation1.calculeTaux(0.8, (oper, taux) -> oper.getMontant() *
		 * taux));
		 * 
		 * System.out.println(TypeOperation2.getValue(prelevement.
		 * getTypeOperation().toString()));
		 * System.out.println(depot.getTypeOperation().toString());
		 * 
		 * System.out.println(TypeOperation2.CB.toString());
		 * System.out.println(TypeOperation2.ESPECE.toString());
		 * 
		 * /* try { TypeOperation2.getValue("bob"); } catch
		 * (NullPointerException ex) { System.out.println("NULL NULL NULL");
		 * ex.printStackTrace(); } catch (ExceptionValeurIndefinie ex) {
		 * System.out.println(
		 * "Impossible de traiter une chaine en TypeOperation2");
		 * ex.printStackTrace(); }
		 * 
		 * try { TypeOperation2.getValue(null); } catch (NullPointerException e)
		 * { System.out.println("NULLLLLLLLLLLLLLLLLLLLLLLl");
		 * e.printStackTrace(); } catch (ExceptionValeurIndefinie e) {
		 * System.out.println( "La valeur n'existe pas"); e.printStackTrace(); }
		 * 
		 * 
		 * try {
		 * System.out.println(TypeOperation2.getValue("Virement").toString()); }
		 * catch (NullPointerException |
		 * 
		 * ExceptionValeurIndefinie e)
		 * 
		 * { System.out.println("T'as foir� quelque part Guillaume");
		 * e.printStackTrace(); }
		 * System.out.println(TypeOperation2.getValue("bob").toString());
		 * 
		 */

	}

}
