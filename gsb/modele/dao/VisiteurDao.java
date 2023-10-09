package gsb.modele.dao;
import gsb.modele.*;
import gsb.utils.*;

public class VisiteurDao {
    public static void Creation(Visiteur unVisiteur){
        sgdb.utiliserSgdb("INSERT INTO `VISITEUR` (`MATRICULE`, `NOM`, `PRENOM`, `LOGIN`, `MDP`, `ADRESSE`, `CODEPOSTAL`, `DATEENTREE`, `CODEUNIT`, `NOMUNIT`) VALUES("+unVisiteur.getMatricule()+","+unVisiteur.getNom()+","+unVisiteur.getPrenom()+","+unVisiteur.getLogin()+","+unVisiteur.getMdp()+","+unVisiteur.getUneLocalite().getVille()+","+unVisiteur.getUneLocalite().getCodePostal()+","+unVisiteur.getDateEntree()+","+unVisiteur.getCodeUnite()+","+unVisiteur.getNomUnite(),false);
    }
}
