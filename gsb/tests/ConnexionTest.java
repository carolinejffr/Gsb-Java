/*
 * Créé le 23 févr. 2015
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.tests;

import gsb.modele.dao.ConnexionMySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Isabelle
 * 23 févr. 2015
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
public class ConnexionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Raccord de méthode auto-généré
		ResultSet resultat = ConnexionMySql
				.execReqSelection("select * from LOCALITE");
		try {
			while (resultat.next()) {
				System.out.println(resultat.getString(1) + "  "
						+ resultat.getString(2));
			}
			;
			System.out.println("fin");
		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
		}
	}

}


