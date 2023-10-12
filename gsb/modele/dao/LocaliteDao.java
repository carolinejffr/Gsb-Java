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
    // public static int creer(Localite uneLocalite)
    // {

    // }
    // // retourner
    // public static ArrayList<Localite> retournerLesLocalites()
    // {

    // }
}
