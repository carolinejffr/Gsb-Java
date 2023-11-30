/*
 * Créé le 3 mars 2015
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.tests.dao;

import gsb.modele.Medecin;
import gsb.modele.dao.MedecinDao;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Isabelle
 * 3 mars 2015
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
public class MedecinDaoTestRetournerDictionnaire {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HashMap<String,Medecin> unDicco = new HashMap<String,Medecin>();
		unDicco =	MedecinDao.retournerDictionnaireDesMedecins();
		if (unDicco.containsKey("m002")){
			System.out.println(unDicco.get("m002").getNom());
		}

	}

}
