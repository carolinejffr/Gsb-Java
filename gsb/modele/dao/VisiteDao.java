package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Visite;

/**
 * Dao Visite
 * 
 * @author Gouault Lucas
 * @author Caroline Jaffré
 */
public class VisiteDao {
    /**
     * Recherche une visite dans la base à partir d'un identifiant
     *
     * @param  reference  L'identifiant de la visite à rechercher
     * @return            null => Pas trouvé, une visite => OK
     */
    public static Visite rechercher(String reference) {
        Visite visite = null;
        ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from Visite where REFERENCE ='" + reference + "'");
        
        try {
            if (reqSelection.next()) {
                visite = new Visite(   
                    reqSelection.getString(1),
                    reqSelection.getString(2),
                    reqSelection.getString(3),
                    MedecinDao.rechercher(reqSelection.getString(5)),
                    VisiteurDao.rechercher(reqSelection.getString(4))
                );
            }
        } catch(Exception e) {
            System.out.println("erreur reqSelection.next() pour la requête - select * from Visite where REFERENCE ='" + reference + "'");
            e.printStackTrace();
        }
        ConnexionMySql.fermerConnexionBd();
        return visite;
    }

    /**
     * Retourne la liste des visiteurs de la base
     *
     * @return         	La liste des visiteurs
     */
    public static ArrayList<Visite> retournerCollection() {
        ArrayList<Visite> listeVisite = new ArrayList<Visite>();
        ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from Visite");

        try {
            while (reqSelection.next()) {
                Visite uneVisite = new Visite(
                    reqSelection.getString(1),
                    reqSelection.getString(2),
                    reqSelection.getString(3),
                    MedecinDao.rechercher(reqSelection.getString(5)),
                    VisiteurDao.rechercher(reqSelection.getString(4))
                );
                listeVisite.add(uneVisite);
            }
        }
        catch(Exception e) {
            System.out.println("erreur reqSelection.next() pour la requête - select * from Visite");
            e.printStackTrace();
        }
        ConnexionMySql.fermerConnexionBd();
        return listeVisite;
    }

    /**
     * Ajoute une visite à la base
     *
     * @param  uneVisite  La visite à ajouter
     * @return            0 => Erreur, 1 => OK
     */
    public static int ajouter(Visite uneVisite) {
        int retour = ConnexionMySql.execReqMaj(
            "INSERT INTO Visite VALUES ('" +
            uneVisite.getReference() +"', '" +
            uneVisite.getDate()+ "', '" +
            uneVisite.getCommentaire() + "', '" +
            uneVisite.getUnVisiteur().getMatricule() + "', '" +
            uneVisite.getUnMedecin().getCodeMed() +
            "');"
        );

        ConnexionMySql.fermerConnexionBd();
        return retour;
    }
}
