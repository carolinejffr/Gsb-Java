/*
 * Créé le 22 mars 2012
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.vue;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.ConnexionMySql;
import gsb.modele.dao.LocaliteDao;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFMedecin extends JInternalFrame  {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	

	protected JLabel JLcode;
	protected JLabel JLnom;
	protected JLabel JLprenom;
	protected JLabel JLadresse;
	protected JLabel JLcp;
    protected JLabel JLville;
    protected JLabel JLtelephone;
    protected JLabel JLpotentiel;
    protected JLabel JLspecialite
    ;
    
	protected JTextField JTcode;
	protected JTextField JTnom;
	protected JTextField JTprenom;
	protected JTextField JTadresse;
	protected JTextField JTcp;
    protected JTextField JTville;
    protected JTextField JTtelephone;
    protected JTextField JTpotentiel;
    protected JTextField JTspecialite;

    // Ajout d'une liste pour faciliter la verifChamps -Caroline
    protected ArrayList<JTextField> champs;
	
    public JIFMedecin() {
    	p = new JPanel();  // panneau principal de la fenêtre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(9,2));
    	
    	 JLcode = new JLabel("Code");
         JLnom = new JLabel("Nom");
         JLprenom = new JLabel("Prénom");
         JLadresse = new JLabel("Adresse rue");
         JLcp = new JLabel("Code postal");
         JLville = new JLabel("Ville");
         JLtelephone = new JLabel("Téléphone");
         JLpotentiel = new JLabel("potentiel");
         JLspecialite = new JLabel("ASpecialite");
         
         JTcode = new JTextField(20);
         JTcode.setMaximumSize(JTcode.getPreferredSize());
         JTnom = new JTextField();
         JTprenom = new JTextField();
         JTadresse = new JTextField();    
         JTcp = new JTextField();
         JTville = new JTextField();
         JTtelephone = new JTextField();
         JTpotentiel = new JTextField();
         JTspecialite = new JTextField();

         // Instanciation de l'ArrayList et ajouts de tous les champs utilisés pour l'ajout d'un médecin.
         champs = new ArrayList<JTextField>();
         champs.add(JTnom);
         champs.add(JTprenom);
         champs.add(JTadresse);
         champs.add(JTcp);
         champs.add(JTtelephone);
         champs.add(JTpotentiel);
         champs.add(JTspecialite);
         
         pTexte.add(JLcode);
         pTexte.add(JTcode);
         pTexte.add(JLnom);
         pTexte.add(JTnom);
         pTexte.add(JLprenom);
         pTexte.add(JTprenom);
         pTexte.add(JLadresse);
         pTexte.add(JTadresse);
         pTexte.add(JLcp);
         pTexte.add(JTcp);
         pTexte.add(JLville);
         pTexte.add(JTville);
         pTexte.add(JLtelephone);
         pTexte.add(JTtelephone);
         pTexte.add(JLpotentiel);
         pTexte.add(JTpotentiel);
         pTexte.add(JLspecialite);
         pTexte.add(JTspecialite);
		
        // mise en forme de la fenêtre

         p.add(pTexte);
         p.add(pBoutons);
         Container contentPane = getContentPane();
         contentPane.add(p);

	}
    
    public void remplirText(Medecin unMedecin) 	
    {  // méthode qui permet de remplir les zones de texte à partir des valeurs passées en paramètres
        JTcode.setText(unMedecin.getCodeMed());        
        JTnom.setText(unMedecin.getNom());
        JTprenom.setText(unMedecin.getPrenom());
        JTadresse.setText(unMedecin.getAdresse());    
        JTcp.setText(unMedecin.getLaLocalite().getCodePostal());
        JTville.setText(unMedecin.getLaLocalite().getVille());
        JTtelephone.setText(unMedecin.getTelephone());
        JTpotentiel.setText(unMedecin.getPotentiel());
        JTspecialite.setText(unMedecin.getSpecialite());
     }
     
      public void viderText() 	
    {  // méthode qui permet de vider les zones de texte 
        JTcode.setText("");        
        JTnom.setText("");
        JTprenom.setText("");
        JTadresse.setText("");    
        JTcp.setText("");
        JTville.setText("");
        JTtelephone.setText("");
        JTpotentiel.setText("");
        JTspecialite.setText("");
     }

    /*
    * Vérifie si tous les champs ont été correctement rempli
    * @author Caroline Jaffré
    * @return true si tous les champs sont bons, false s'il y a un champ vide.
    */
    public boolean verifChamps()
    {
        boolean verif = true;
        // On vérifie qu'aucun champ n'est null
        for (int i = 0; i < champs.size(); i++)
        {
            // A l'exception du champ potentiel car visiblement dans la base de données c'est vide par défaut.
            if (champs.get(i).getText().isEmpty() == true && champs.get(i) != JTpotentiel)
            {
                // S'il est null, return false et print index
                verif = false;
                System.out.println("Le champ à l'index numéro " + i + " est vide !");
                System.out.println(i + " : " + champs.get(i).getText());
            }
        }
        return verif;
    }

    /*
    * Cette méthode est appellée si VerifChamp est correct, dans JIFMedecinAjout.
    * Elle récupère toutes les valeurs des champs et envoie la requête SQL d'insertion du médecin
    * @author Caroline Jaffré
    */
    public int ajoutMedecinBDD()
    {
        int codeRequete = 0;
        // On commence par récupérer toutes les valeurs
        ArrayList<String> StringChamps = new ArrayList<String>();

        for (int i = 0; i < champs.size(); i++)
        {
            StringChamps.add(champs.get(i).getText());
        }
        
        // On a besoin de générer le CodeMed.
        ArrayList<Medecin> lesMedecins = MedecinDao.retournerCollectionDesMedecins();
        int numCode = lesMedecins.size() + 1;
        String codeMed = ("m" + String.format("%03d", numCode));
        System.out.println(codeMed);

        // On créé la requête SQL. J'utilise String.format car je trouve ça plus lisible quand il y a autant de variables.
        String laRequete = String.format("INSERT INTO `medecin` (`CODEMED`, `NOM`, `PRENOM`, `ADRESSE`, `CODEPOSTAL`, `TELEPHONE`, `POTENTIEL`, `SPECIALITE`) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
         codeMed, StringChamps.get(0), StringChamps.get(1), StringChamps.get(2), StringChamps.get(3), StringChamps.get(4), StringChamps.get(5), StringChamps.get(6));
        System.out.println(laRequete);
        int reqMaj = ConnexionMySql.execReqMaj(laRequete);

        // Si la requête a aboutie, on ajoute le médecin en local.
        if (reqMaj == 1)
        {
            codeRequete = 1;
            Medecin leMedecin = MedecinDao.rechercher(codeMed);
            if (leMedecin != null)
            {
                codeRequete = 2;
            }
        }
        return codeRequete;
    }

    /*
     * Cette fonction vérifié si la localité existe. Elle est utilisé dans JIFMedecinAjout.
     * @author Caroline Jaffré
     */
    public Localite testLocalite()
    {
        Localite laLocalite = null;
        laLocalite = LocaliteDao.rechercher(JTcp.getText());

        return laLocalite;
    }

    /*
     * Cette fonction vérifié si le contenu des champs est de la bonne longueur, pour respecter ce qui est en BDD.
     * @author Caroline Jaffré
     */
    public String testLongueur()
    {
        String laString = null;

        // Pas besoin de tester codeMed (généré par le code)
        // Pas besoin de tester code postal (testé avant)
        // Nom, prenom, adresse, potentiel et specialite sont des VARCHAR(50)
        if (JTnom.getText().length() > 50)
        {
            laString = "Nom";
        }
        else if (JTprenom.getText().length() > 50)
        {
            laString = "Prenom";
        }
        else if (JTadresse.getText().length() > 50)
        {
            laString = "Adresse";
        }
        else if (JTpotentiel.getText().length() > 50)
        {
            laString = "Potentiel";
        }
        else if (JTspecialite.getText().length() > 50)
        {
            laString = "Specialite";
        }
        // telephone est un VARCHAR(15)
        else if (JTtelephone.getText().length() > 15)
        {
            laString = "Telephone";
        }


        return laString;
    }

    
}
