package gsb.tests;

import java.util.ArrayList;

import gsb.modele.Localite;
import gsb.modele.dao.LocaliteDao;
import gsb.utils.sgdb;
// import gsb.vue.myFrame;

public class AffichageModele 
{
    public static void main(String[] args) 
    {
        System.out.println("Bienvenue dans l'application GSB Java.");
        //myFrame frame = new myFrame();
        System.out.println("-----------------------------------");
        //System.out.println("Test de connexion :");
        //System.out.println(sgdb.retournerString("SELECT VILLE FROM gsbv2.LOCALITE WHERE CODEPOSTAL = 75011"));
        //sgdb.utiliserSgdb("SELECT * FROM gsbv2.LOCALITE", true);
        // sgdb.utiliserSgdb("SELECT * FROM gsbv2.MEDECIN", true);
        // sgdb.utiliserSgdb("SELECT * FROM gsbv2.MEDICAMENT", true);
        // sgdb.utiliserSgdb("SELECT * FROM gsbv2.VISITE", true);
        // sgdb.utiliserSgdb("SELECT * FROM gsbv2.VISITEUR", true);

        // Localite guilli = new Localite("29300", "Guilligomarc\\'h");
        // ArrayList<Localite> listeLocalite = new ArrayList<Localite>();
        // LocaliteDao.creer(guilli, listeLocalite);
        ArrayList<Localite> laListe = LocaliteDao.retournerLesLocalites();

        for (int i = 0; i < laListe.size(); i++)
        {
            System.out.println(laListe.get(i).getCodePostal());
            System.out.println(laListe.get(i).getVille());
        }

    }
}
