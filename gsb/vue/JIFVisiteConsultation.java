package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import gsb.modele.Visite;
import gsb.service.VisiteService;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

/**
 * Vue Ajout Visite
 * 
 * @author Gouault Lucas
 */
public class JIFVisiteConsultation extends JInternalFrame implements ActionListener 
{
	// Panels
	protected JPanel p, 
			   pChamps,
			  pBoutons,
			   pErreur;

	// Labels
	protected JLabel JLreference,
						  JLdate,
				   JLcommentaire,
					 JLMatricule,
					   JLMedecin;

	// Champs
	protected JTextField JTReference,
						      JTDate,
						 JTMatricule,
					   JTCodeMedecin;
								
	protected JTextArea JTCommentaire;

	// Bouton
	protected JButton JBPremier,
						JBPrecedent,
						JBSuivant,
						JBDernier;

	// Liste de données
	protected ArrayList<Visite> visites;
	protected int pointeur;

	public JIFVisiteConsultation()
	{
		// Panels
		p = new JPanel(new GridLayout(2, 1));  		// panneau principal de la fenêtre
		pChamps = new JPanel(new GridLayout(5, 2));	// panneau des champs
		pBoutons = new JPanel();	// panneau des boutons
		
		// Labels
		JLreference = new JLabel("Reference");
		JLdate = new JLabel("Date");
		JLcommentaire = new JLabel("Commentaire");
		JLMatricule = new JLabel("Matricule");
		JLMedecin = new JLabel("Code Medecin");

		// Champs
		JTReference = new JTextField();
		JTDate = new JTextField();
		JTMatricule = new JTextField();
		JTCodeMedecin = new JTextField();
		JTCommentaire = new JTextArea();

		// On paramètre les champs
		JTReference.setEditable(false);
		JTDate.setEditable(false);
		JTMatricule.setEditable(false);
		JTCodeMedecin.setEditable(false);
		JTCommentaire.setEditable(false);
		JTCommentaire.setLineWrap(true);
		JTCommentaire.setWrapStyleWord(true);

		// Bouton
		JBPremier = new JButton("Premier");
		JBPrecedent = new JButton("Précédent");
		JBSuivant = new JButton("Suivant");
		JBDernier = new JButton("Dernier");

		// Ajout des composants au panneau principal
		pChamps.add(JLreference);
		pChamps.add(JTReference);

		pChamps.add(JLdate);
		pChamps.add(JTDate);

		JScrollPane scroll = new JScrollPane(JTCommentaire);

		pChamps.add(JLcommentaire);
		pChamps.add(scroll);

		pChamps.add(JLMatricule);
		pChamps.add(JTMatricule);

		pChamps.add(JLMedecin);
		pChamps.add(JTCodeMedecin);

		pBoutons.add(JBPremier);
		pBoutons.add(JBPrecedent);
		pBoutons.add(JBSuivant);
		pBoutons.add(JBDernier);

		// On initialise les données
		visites = VisiteService.getListeVisites();
		pointeur = 0;
		if(visites.size() > 0) remplir();

		// Ajout du panneau principal dans la fenêtre
		p.add(pChamps);
		p.add(pBoutons);

		Container contentPane = getContentPane();
        contentPane.add(p);

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Ajout Visite");

		// Ecouteurs d'évènements
		JBPremier.addActionListener(this);
		JBPrecedent.addActionListener(this);
		JBSuivant.addActionListener(this);
		JBDernier.addActionListener(this);

		addInternalFrameListener(new InternalFrameAdapter() {
			/**
			 * Exécute du code lorsque l'utilisateur ferme la fenêtre
			 * 
			 * @param  e InternalFrameEvent object representing the event
			 * @return   void
			 */
			public void internalFrameClosing(InternalFrameEvent e) {
				
			}
		});
	}
	/**
	 * Remplit les champs de la fenêtre avec les données de la visite pointée par le pointeur dans la liste
	 *
	 * @param  none
	 * @return none
	 */
	protected void remplir() {
		JTReference.setText(visites.get(pointeur).getReference());
		JTDate.setText(visites.get(pointeur).getDate());
		JTCommentaire.setText(visites.get(pointeur).getCommentaire());
		JTMatricule.setText(visites.get(pointeur).getUnVisiteur().getMatricule());
		JTCodeMedecin.setText(visites.get(pointeur).getUnMedecin().getCodeMed());
	}
	/**
	 * Exécuté quand l'utilisateur fait quelque chose dans la fenêtre
	 *
	 * @param  evt	L'évènement
	 */
	public void actionPerformed(ActionEvent evt)
	{ 
		Object source = evt.getSource();

		if(visites.size() > 0) {
			if(source == JBPremier) {
				pointeur = 0;
			} else if(source == JBPrecedent) {
				if(pointeur > 0) pointeur--;
				else JOptionPane.showMessageDialog(
					p,
					"Vous êtes au début de la liste.",
					"Impossible d'afficher la page précédente",
					JOptionPane.INFORMATION_MESSAGE,
					null
					);
			} else if(source == JBSuivant) {
				if(visites.size() - 1 > pointeur) pointeur++;
				else JOptionPane.showMessageDialog(
					p,
					"Vous ne trouverez rien plus loin.",
					"Impossible d'afficher la page suivante",
					JOptionPane.INFORMATION_MESSAGE,
					null
					);
			} else if(source == JBDernier) {
				pointeur = visites.size() - 1;
			}

			remplir();
		}
		else JOptionPane.showMessageDialog(
				p,
				"Aucune donnée n'a été trouvée.\nVeuillez d'abord ajouter une visite.",
				"Impossible d'afficher la page",
				JOptionPane.INFORMATION_MESSAGE,
				null
				);
	}
	
}