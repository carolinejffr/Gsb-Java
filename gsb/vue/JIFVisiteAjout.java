package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.service.MedecinService;
import gsb.service.VisiteService;
import gsb.service.VisiteurService;
import gsb.utils.ValidationUtils;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import javax.swing.JTextArea;

/**
 * Vue Ajout Visite
 * 
 * @author Gouault Lucas
 */
public class JIFVisiteAjout extends JInternalFrame implements ActionListener 
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
						      JTDate;
								
	protected JTextArea JTCommentaire;

	protected JComboBox<String> JCMatricule,
							  JCCodeMedecin;

	// Bouton
	protected JButton JBAjouter,
						JBVider;

	public JIFVisiteAjout()
	{
		// Panels
		p = new JPanel();  		// panneau principal de la fenêtre
		pChamps = new JPanel(new GridLayout(5, 2));	// panneau des champs
		pBoutons = new JPanel();	// panneau des boutons
		
		// Labels
		JLreference = new JLabel("Reference");
		JLdate = new JLabel("Date");
		JLcommentaire = new JLabel("Commentaire");
		JLMatricule = new JLabel("Matricule");
		JLMedecin = new JLabel("Code Medecin");

		// Champs
		JTReference = new JTextField(20);
		JTDate = new JTextField(20);
		JTCommentaire = new JTextArea();
		JTCommentaire.setLineWrap(true);
		JTCommentaire.setWrapStyleWord(true);

		JCMatricule = new JComboBox<String>();
		JCCodeMedecin = new JComboBox<String>();

		// Ajout des données dans les boîtes de sélection
		ArrayList<String> visiteurs = VisiteurService.getListeVisiteurs();
		ArrayList<Medecin> medecins = MedecinService.retournerCollectionDesMedecins();

		for(String visiteur : visiteurs) {
			JCMatricule.addItem(visiteur);
		}

		for(Medecin medecin : medecins) {
			JCCodeMedecin.addItem(medecin.getCodeMed());
		}

		// Bouton
		JBAjouter = new JButton("Ajouter");
		JBVider = new JButton("Vider");

		// Ajout des composants au panneau principal
		pChamps.add(JLreference);
		pChamps.add(JTReference);

		pChamps.add(JLdate);
		pChamps.add(JTDate);

		JScrollPane scroll = new JScrollPane(JTCommentaire);

		pChamps.add(JLcommentaire);
		pChamps.add(scroll);

		pChamps.add(JLMatricule);
		pChamps.add(JCMatricule);

		pChamps.add(JLMedecin);
		pChamps.add(JCCodeMedecin);

		pBoutons.add(JBAjouter);
		pBoutons.add(JBVider);

		// Ajout du panneau principal dans la fenêtre
		p.add(pChamps);
		p.add(pBoutons);

		Container contentPane = getContentPane();
        contentPane.add(p);

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Ajout Visite");

		// Ecouteurs d'évènements
		JBAjouter.addActionListener(this);
		JBVider.addActionListener(this);

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
	 * Exécuté quand l'utilisateur fait quelque chose dans la fenêtre
	 *
	 * @param  evt	L'évènement
	 */
	public void actionPerformed(ActionEvent evt)
	{ 
		Object source = evt.getSource();

		if(source == JBAjouter) {
			Visite uneVisite = new Visite(
				JTReference.getText(),
				JTDate.getText(),
				JTCommentaire.getText(),
				MedecinService.rechercherMedecin(JCCodeMedecin.getSelectedItem().toString()),
				VisiteurService.rechercher(JCMatricule.getSelectedItem().toString())
			);

			if(visiteValide(uneVisite)) {
				VisiteService.ajouter(uneVisite);

				JOptionPane.showMessageDialog(
					null,
					"Visite ajoutée avec succès",
					"Visite ajoutée",
					JOptionPane.INFORMATION_MESSAGE
				);

				vider();
			}
			
			
		} else if(source == JBVider) {
			vider();
		}
	}

	protected boolean visiteValide(Visite uneVisite) {
		boolean JTReferenceValide = testerLongueur(uneVisite.getReference(), 1, 5);
		boolean JTDateValide = ValidationUtils.isDateValide(uneVisite.getDate());
		boolean JTCommentaireValide = testerLongueur(uneVisite.getCommentaire(), 0, 100);
		boolean JTMatriculeValide = testerLongueur(uneVisite.getUnVisiteur().getMatricule(), 1, 4);
		boolean JTCodeMedecinValide = testerLongueur(uneVisite.getUnMedecin().getCodeMed(), 1, 4);

		if(!JTReferenceValide) {
			JOptionPane.showMessageDialog(
				null,
				"La référence doit avoir une longueur comprise entre 1 et 5 caractères",
				"Erreur dans la saisie",
				JOptionPane.ERROR_MESSAGE
				);
		} else if(!JTDateValide) {
			JOptionPane.showMessageDialog(
				null,
				"La date doit être au format JJ/MM/AAAA",
				"Erreur dans la saisie",
				JOptionPane.ERROR_MESSAGE
				);
		} else if(!JTCommentaireValide) {
			JOptionPane.showMessageDialog(
				null,
				"Le commentaire doit avoir une longueur comprise entre 0 et 100 caractères",
				"Erreur dans la saisie",
				JOptionPane.ERROR_MESSAGE
				);
		} else if(!JTMatriculeValide) {
			JOptionPane.showMessageDialog(
				null,
				"Le matricule doit avoir une longueur comprise entre 1 et 4 caractères",
				"Erreur dans la saisie",
				JOptionPane.ERROR_MESSAGE
			);
		} else if(!JTCodeMedecinValide) {
			JOptionPane.showMessageDialog(
				null,
				"Le code medecin doit avoir une longueur comprise entre 1 et 4 caractères",
				"Erreur dans la saisie",
				JOptionPane.ERROR_MESSAGE
			);
		}

		return JTReferenceValide && JTDateValide && JTCommentaireValide && JTMatriculeValide && JTCodeMedecinValide;
	}

	protected void vider() {
		JTReference.setText("");
		JTDate.setText("");
		JTCommentaire.setText("");
		JCMatricule.setSelectedIndex(0);
		JCCodeMedecin.setSelectedIndex(0);
	}

	protected boolean testerLongueur(String chaine, int min, int max) {
		return (chaine.length() >= min && chaine.length() <= max);
	}
}