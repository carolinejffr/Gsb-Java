package gsb.modele.dao;

import java.util.ArrayList;

import gsb.modele.Localite;
import gsb.utils.sgdb;

public class LocaliteDao 
{
    // rechercher
    public static Localite rechercher(String codeLocalite, ArrayList<Localite> listeLocalite)
    {
        // On vérifie que la localité existe en DB.
        System.out.println("La ville qui correspond au code " + codeLocalite + " est : " + sgdb.retournerString("SELECT VILLE FROM gsbV2.LOCALITE WHERE CODEPOSTAL =" + codeLocalite));

        // Retourner la localité
        Localite laLocalite = null;
        for (int i = 0; i < listeLocalite.size(); i++)
        {
            if (listeLocalite.get(i).getCodePostal() == codeLocalite)
            {
                laLocalite = listeLocalite.get(i);
            }
        }
        if (laLocalite == null)
        {
            System.out.println("Attention, laLocalite est null.");
        }
        else
        {
            System.out.println("laLocalite a été retournée avec succès.");
        }
        return laLocalite;
    }
    // creer
    public static int creer(Localite uneLocalite, ArrayList<Localite> listeLocalite)
    {
        try
        {
            // Insertion dans la base de données
            sgdb.utiliserSgdb("INSERT INTO gsbV2.LOCALITE VALUES ('" + uneLocalite.getCodePostal() + "', '" + uneLocalite.getVille() + "')", false);
            listeLocalite.add(uneLocalite);
            return 1;
        }
        catch (Exception e)
        {
            return 0;
        }
    }
    // retourner
     public static ArrayList<Localite> retournerLesLocalites()
    {
        ArrayList<Localite> listeLocalites = new ArrayList<Localite>();

        ArrayList<String> stringLocalite = sgdb.RequeteListString("SELECT * FROM gsbV2.LOCALITE");
        for (int i = 0; i < stringLocalite.size(); i++)
        {
            String laLocalite[] = stringLocalite.get(i).split(" ");
            Localite uneLocalite = new Localite(laLocalite[0], laLocalite[1]);
            listeLocalites.add(uneLocalite);
        }
        return listeLocalites;
    }
}
