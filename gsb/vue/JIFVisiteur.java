/*
 * Créé le 22 mars 2012
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.vue;

import gsb.modele.Medecin;
import gsb.modele.Visiteur;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

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
	
    public JIFVisiteur() {
    	p = new JPanel();  // panneau principal de la fenêtre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(9,2));
    	
    	 JLmatricule = new JLabel("Matricule");
         JLnom = new JLabel("Nom");
         JLprenom = new JLabel("Prénom");
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
         JTadresse = new JTextField();    
         JTcp = new JTextField();
         JTtelephone = new JTextField();
         
         pTexte.add(JLmatricule);
         pTexte.add(JTmatricule);
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
    
    public void remplirText(Visiteur unVisiteur) 	
    {  // méthode qui permet de remplir les zones de texte à partir des valeurs passées en paramètres
        JTmatricule.setText(unVisiteur.getMatricule());        
        JTnom.setText(unVisiteur.getNom());
        JTprenom.setText(unVisiteur.getPrenom());
        JTadresse.setText(unVisiteur.getAdresse());    
        JTcp.setText(unVisiteur.getLogin());
        JTville.setText(unVisiteur.getMdp());
        JTtelephone.setText(unVisiteur.getAdresse());
        JTpotentiel.setText(unVisiteur.getUneLocalite());
        JTspecialite.setText(unVisiteur.getSpecialite());
     }
     
      public void viderText()
    {  // méthode qui permet de vider les zones de texte 
        JTmatricule.setText("");        
        JTnom.setText("");
        JTprenom.setText("");
        JTadresse.setText("");    
        JTcp.setText("");
        JTville.setText("");
        JTtelephone.setText("");
        JTpotentiel.setText("");
        JTspecialite.setText("");
     }


    
}

