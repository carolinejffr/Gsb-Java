package gsb;

import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.modele.Medicament;

import gsb.utils.sgdb;

public class app 
{
    public static void main(String[] args) 
    {
        sgdb.utiliserSgdb("Select * From gsbV2.medecin", true);
        System.out.println("Bienvenue dans l'application GSB Java.");
    }
}

