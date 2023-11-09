/*
 * Créé le 22 mars 2012
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.vue;

//import gsb.modele.Medecin;
import gsb.modele.Visiteur;

import java.awt.Container;
import java.awt.GridLayout;
//import java.awt.event.ActionEvent;

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
	
    protected JButton Valider;
    protected JButton Vider;

    public JIFVisiteur() {
    	p = new JPanel();  // panneau principal de la fenêtre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(12,2));
    	
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
         Valider = new JButton("Valider");
         Vider = new JButton("Vider");	
         pBoutons.add(Valider);
         pBoutons.add(Vider);
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
        JTtelephone.setText("");
        JTadresse.setText("");    
        JTcp.setText("");
        JTdateEntree.setText("");
        JTprime.setText("");
        JTcodeUnite.setText("");
        JTnomUnite.setText("");
     }


    /*
    * Vérifie si tous les champs ont été correctement rempli
    * Elle permet aussi de mettre en forme les champs
    * @author Tallec--Even Léo
    * @return true si tous les champs sont bons, false s'il y a un champ vide.
    
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
         // Mise en forme des champs
         // Nom et prenom en majuscule
         JTnom.setText(JTnom.getText().toUpperCase());
         JTprenom.setText(JTprenom.getText().toUpperCase());
         // Majuscule au début du nom de la ville
         if (JTville.getText().isEmpty() == false)
         {
             JTville.setText(JTville.getText().substring(0 , 1).toUpperCase() + JTville.getText().substring(1));
         }
 
         // tirets automatiques dans le numero de telephone
         if (JTtelephone.getText().length() == 10)
         {
             String ancienNumero = JTtelephone.getText();
             StringBuilder numeroFormat = new StringBuilder();
             for (int i = 0; i < ancienNumero.length(); i++)
             {
                 if (i % 2 == 0 && i > 0) 
                 {
                     numeroFormat.append('-');
                 }
                 numeroFormat.append(ancienNumero.charAt(i));
             }
             JTtelephone.setText(numeroFormat.toString());
         }
         
         return verif;
     }*/
    
}

