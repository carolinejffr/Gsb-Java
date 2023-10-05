package gsb.tests;

import gsb.utils.sgdb;

public class AffichageModele 
{
    public static void main(String[] args) 
    {
        System.out.println("Bienvenue dans l'application GSB Java.");
        System.out.println("-----------------------------------");
        System.out.println("Test de connexion :");
        sgdb.utiliserSgdb("SELECT * FROM gsbv2.LOCALITE", true);
        sgdb.utiliserSgdb("SELECT * FROM gsbv2.MEDECIN", true);
        sgdb.utiliserSgdb("SELECT * FROM gsbv2.MEDICAMENT", true);
        sgdb.utiliserSgdb("SELECT * FROM gsbv2.VISITE", true);
        sgdb.utiliserSgdb("SELECT * FROM gsbv2.VISITEUR", true);



    }
}
