package gsb.service;

import java.util.ArrayList;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

/**
 * Service Visite
 * 
 * @author Gouault Lucas
 */
public class VisiteService {
    /**
     * Renvoie la liste des visiteurs de la base
     *
     * @return         	La liste des visiteurs
     */
    public static ArrayList<Visite> getListeVisiteurs() {
        ArrayList<Visite> laListe = new ArrayList<Visite>();
        try
        {
            ArrayList<Visite> visites = VisiteDao.retournerCollection();
            for (Visite visite : visites)
            {
                laListe.add(visite);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return laListe;
    }

    /**
     * Ajoute une visite à la base
     *
     * @param  uneVisite  La visite à ajouter
     * @return            0 => Erreur, 1 => OK
     */
    public static int ajouterVisite(Visite uneVisite) {
        return VisiteDao.ajouter(uneVisite);
    }

    /**
     * Recherche une visite dans la base
     *
     * @param  reference    Identifiant de la visite à rechercher
     * @return              null => Pas trouvé, une visite => OK
     */
    public static Visite rechercherVisite(String reference) {
        return VisiteDao.rechercher(reference);
    }
}
