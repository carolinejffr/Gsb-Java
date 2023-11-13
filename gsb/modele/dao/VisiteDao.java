package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

/*
 * VisiteDao
 * @author Caroline et Lucas
 */
public class VisiteDao 
{
    public static Visite rechercher(String refVisite){
		Visite uneVisite = null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from VISITE where REFERENCE ='"+ uneVisite +"'");
		try {
			if (reqSelection.next()) {
                Medecin unMedecin = MedecinDao.rechercher(reqSelection.getString(4));
                Visiteur unVisiteur = VisiteurDao.rechercher(reqSelection.getString(5));
				uneVisite = new Visite(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), unMedecin, unVisiteur);
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from VISITE where REFERENCE ='"+ uneVisite +"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return uneVisite;
	}

    public static ArrayList<Visite> retournerLesVisites()
    {
        ArrayList<Visite> lesVisites = new ArrayList<Visite>();
        ResultSet reqSelection = ConnexionMySql.execReqSelection("select REFERENCE from VISITE");
        try 
        {
             while (reqSelection.next()) 
            {
                String refVisite = reqSelection.getString(1);
                lesVisites.add(VisiteDao.rechercher(refVisite));
            }
        } 
        catch (Exception e) 
        {
           e.printStackTrace();
           System.out.println("Erreur : retournerLesVisites()");
        }
        return lesVisites;
    }
}
