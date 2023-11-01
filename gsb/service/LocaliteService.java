package gsb.service;

import java.sql.ResultSet;

import gsb.modele.Localite;
import gsb.modele.dao.ConnexionMySql;

public class LocaliteService {
    public static String getCodePostal(String uneVille)
    {
        String leCodePostal = null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT CODEPOSTAL FROM LOCALITE WHERE VILLE='"+ uneVille+"'");
		try {
			if (reqSelection.next()) {
				leCodePostal = reqSelection.getString(1);	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - SELECT CODEPOSTAL FROM LOCALITE WHERE VILLE='"+ uneVille+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return leCodePostal;
    }
    
    
}
