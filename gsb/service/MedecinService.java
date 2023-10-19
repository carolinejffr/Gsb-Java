/*
 * Créé le 23 févr. 2015
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.service;

import gsb.modele.Medecin;
import gsb.modele.dao.MedecinDao;

/**
 * @author Isabelle
 * 23 févr. 2015
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
public class MedecinService {
	
	public static Medecin rechercherMedecin(String unCodeMedecin){
		Medecin unMedecin = null;
		try{
		if (unCodeMedecin==null) {
            throw new Exception("Donnée obligatoire : code");
        }
		unMedecin = MedecinDao.rechercher(unCodeMedecin);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unMedecin;
	}
	
}
