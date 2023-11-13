/*
 * Créé le 22 mars 2012
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.vue;

import gsb.modele.Medecin;
import gsb.modele.dao.VisiteurDao;
import gsb.modele.Visiteur;
import gsb.modele.dao.ConnexionMySql;
import gsb.modele.dao.MedecinDao;
import gsb.service.LocaliteService;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFVisiteur extends JInternalFrame  {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	

	protected JLabel JLmatricule;
	protected JLabel JLnom;
	protected JLabel JLprenom;
    protected JLabel JLlogin;
    protected JLabel JLmdp;
    protected JLabel JLtelephone;
	protected JLabel JLadresse;
    protected JLabel JLcp;
    protected JLabel JLdateEntree;
    protected JLabel JLprime;
    protected JLabel JLcodeUnite;
    protected JLabel JLnomUnite;
    
	protected JTextField JTmatricule;
	protected JTextField JTnom;
	protected JTextField JTprenom;
    protected JTextField JTlogin;
    protected JTextField JTmdp;
    protected JTextField JTtelephone;
	protected JTextField JTadresse;
    protected JTextField JTcp;
    protected JTextField JTdateEntree;
    protected JTextField JTprime;
    protected JTextField JTcodeUnite;
    protected JTextField JTnomUnite;
	protected ArrayList<JTextField> champs;
    protected JButton Valider;
    protected JButton Vider;

    public JIFVisiteur() {
    	p = new JPanel();  // panneau principal de la fenêtre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(12,2));
    	
    	 JLmatricule = new JLabel("Matricule");
         JLnom = new JLabel("Nom");
         JLprenom = new JLabel("Prénom");
         JLlogin = new JLabel("Login");
         JLmdp = new JLabel("Mot De Passe");
         JLadresse = new JLabel("Adresse rue");
         JLcp = new JLabel("Code postal");
         JLtelephone = new JLabel("Téléphone");
         JLadresse = new JLabel("Adresse");
         JLcp = new JLabel("Code Postal");
         JLdateEntree = new JLabel("Date Entrée");
         JLprime = new JLabel("Prime");
         JLcodeUnite = new JLabel("Code Unite");
         JLnomUnite = new JLabel("Nom Unite");
         
         
         JTmatricule = new JTextField(20);
         JTmatricule.setMaximumSize(JTmatricule.getPreferredSize());
         JTnom = new JTextField();
         JTprenom = new JTextField();
         JTlogin = new JTextField();
         JTmdp = new JTextField();
         JTtelephone = new JTextField();
         JTadresse = new JTextField();    
         JTcp = new JTextField();
         JTdateEntree = new JTextField();
         JTprime = new JTextField();
         JTcodeUnite = new JTextField();
         JTnomUnite = new JTextField();
         
         pTexte.add(JLmatricule);
         pTexte.add(JTmatricule);
         pTexte.add(JLnom);
         pTexte.add(JTnom);
         pTexte.add(JLprenom);
         pTexte.add(JTprenom);
         pTexte.add(JLlogin);
         pTexte.add(JTlogin);
         pTexte.add(JLmdp);
         pTexte.add(JTmdp);
         pTexte.add(JLtelephone);
         pTexte.add(JTtelephone);
         pTexte.add(JLadresse);
         pTexte.add(JTadresse);
         pTexte.add(JLcp);
         pTexte.add(JTcp);
         pTexte.add(JLdateEntree);
         pTexte.add(JTdateEntree);
         pTexte.add(JLprime);
         pTexte.add(JTprime);
         pTexte.add(JLcodeUnite);
         pTexte.add(JTcodeUnite);
         pTexte.add(JLnomUnite);
         pTexte.add(JTnomUnite);
         Valider = new JButton("Ajouter");
         Vider = new JButton("Vider les champs");	
         pBoutons.add(Vider);
         pBoutons.add(Valider);
        // mise en forme de la fenêtre
        
         p.add(pTexte);
         p.add(pBoutons);
         Container contentPane = getContentPane();
         contentPane.add(p);
        // Ajout d'une liste pour faciliter la verifChamps -Caroline
        champs = new ArrayList<JTextField>();
         champs.add(JTnom);
         champs.add(JTprenom);
         champs.add(JTlogin);
         champs.add(JTmdp);
         champs.add(JTtelephone);
         champs.add(JTadresse);
         champs.add(JTcp);
         champs.add(JTdateEntree);
         champs.add(JTprime);
         champs.add(JTcodeUnite);
         champs.add(JTnomUnite);
         
         pTexte.add(JLmatricule);
         pTexte.add(JTmatricule);
         pTexte.add(JLnom);
         pTexte.add(JTnom);
         pTexte.add(JLprenom);
         pTexte.add(JTprenom);
         pTexte.add(JLlogin);
         pTexte.add(JTlogin);
         pTexte.add(JLmdp);         
         pTexte.add(JTmdp);
         pTexte.add(JLtelephone);     
         pTexte.add(JTtelephone);
         pTexte.add(JLadresse);
         pTexte.add(JTadresse);
         pTexte.add(JLcp);
         pTexte.add(JTcp);
         pTexte.add(JLdateEntree);
         pTexte.add(JTdateEntree);
         pTexte.add(JLprime);
         pTexte.add(JTprime);
         pTexte.add(JLcodeUnite);
         pTexte.add(JTcodeUnite);
         pTexte.add(JLnomUnite);
         pTexte.add(JTnomUnite);
	}
    
    public void remplirText(Visiteur unVisiteur) 	
    {  // méthode qui permet de remplir les zones de texte à partir des valeurs passées en paramètres
        JTmatricule.setText(unVisiteur.getMatricule());        
        JTnom.setText(unVisiteur.getNom());
        JTprenom.setText(unVisiteur.getPrenom());
        JTlogin.setText(unVisiteur.getLogin());
        JTmdp.setText(unVisiteur.getMdp());
        JTtelephone.setText(unVisiteur.getAdresse());
        JTadresse.setText(unVisiteur.getAdresse());    
        JTcp.setText(unVisiteur.getLogin());
        JTdateEntree.setText(unVisiteur.getDateEntree());
        JTprime.setText(String.format("%d", unVisiteur.getPrime()));
        JTcodeUnite.setText(unVisiteur.getCodeUnite());
        JTnomUnite.setText(unVisiteur.getNomUnite());
     }
     
      public void viderText()
    {  // méthode qui permet de vider les zones de texte 
        JTmatricule.setText("");        
        JTnom.setText("");
        JTprenom.setText("");
        JTlogin.setText("");
        JTmdp.setText("");
        JTtelephone.setText("");
        JTadresse.setText("");    
        JTcp.setText("");
        JTdateEntree.setText("");
        JTprime.setText("");
        JTcodeUnite.setText("");
        JTnomUnite.setText("");
     }

      public int ajoutVisiteurBDD()
    {
        int codeRequete = 0;
        // On commence par récupérer toutes les valeurs
        ArrayList<String> StringChamps = new ArrayList<String>();

        for (int i = 0; i < champs.size(); i++)
        {
            StringChamps.add(champs.get(i).getText());
            // Ceci permet d'éviter un bug SQL si l'un des champs contient une apostrophe
            if (StringChamps.get(i).contains("'"))
            {
                StringChamps.set(i, StringChamps.get(i).replace("'", "\\'"));
            }
        }

        // Le champ à l'index 3 contient la ville. Hors, nous avons besoin du code postal !
        String leCodePostal = LocaliteService.getCodePostal(StringChamps.get(7));
        

        // On créé la requête SQL. J'utilise String.format car je trouve ça plus lisible quand il y a autant de variables.
        String laRequete = String.format("INSERT INTO `VISITEUR` (`MATRICULE`, `NOM`, `PRENOM`,`LOGIN`,`MDP`,`TELEPHONE`, `ADRESSE`, `CODEPOSTAL`, `DATEENTRE`, `CODEUNIT`,`NOMUNIT`) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s','%s','%s');",
         StringChamps.get(0),//Matricule
         StringChamps.get(1),//Nom
         StringChamps.get(2),//Prenom
         StringChamps.get(3),//Login
         StringChamps.get(4),//Mdp
         StringChamps.get(5),//Telephone
         StringChamps.get(6),//Adresse
         leCodePostal,//Code Postal
         StringChamps.get(8),//Date Entrée
         StringChamps.get(9),//Code Unit
         StringChamps.get(10));//Nom Unit

        System.out.println(laRequete);
        int reqMaj = ConnexionMySql.execReqMaj(laRequete);
        ConnexionMySql.fermerConnexionBd();

        
        // Si la requête a aboutie, on ajoute le visiteur en local.
        if (reqMaj == 1)
        {
            codeRequete = 1;
            Visiteur leVisiteur = VisiteurDao.rechercher(StringChamps.get(0));
            if (leVisiteur != null)
            {
                codeRequete = 2;
            }
        }
        
        return codeRequete; 
    }
    
}

