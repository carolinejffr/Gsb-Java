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
			
			VisiteService.ajouter(uneVisite);
		} else if(source == JBVider) {
			JTReference.setText("");
			JTDate.setText("");
			JTCommentaire.setText("");

			JCMatricule.setSelectedIndex(0);
			JCCodeMedecin.setSelectedIndex(0);
		}
	}
	
}
