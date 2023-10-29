package gsb.vue;

import gsb.modele.Medecin;
import gsb.modele.dao.MedecinDao;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class JIFMedecinAjout extends JIFMedecin  implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JButton vider;
    private JButton ajouter;
    private JLabel labelErreur;
    private JPanel pErreur;

        
    public JIFMedecinAjout() {
        super();

        // On n'a pas besoin de ces champs pour le formulaire, donc on les rends invisibles.
        JTcode.setVisible(false);
        JLcode.setVisible(false);
        JTville.setVisible(false);
        JLville.setVisible(false);

        vider = new JButton("Vider les champs");
        pBoutons.add(vider);
        ajouter = new JButton("Ajouter");
        pBoutons.add(ajouter);

        pErreur = new JPanel();
        p.add(pErreur);
        labelErreur = new JLabel("");
        pErreur.add(labelErreur);

        // déclaration des sources d'évènements
        vider.addActionListener(this);
        ajouter.addActionListener(this);

        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Ajout d'un Medecin");
    
        
        // ajout d'un écouteur d'évènement pour la fermeture de la fenêtre
        addInternalFrameListener(new InternalFrameAdapter(){
            public void  internalFrameClosing(InternalFrameEvent e) {
                          //le code que tu veux exécuter à la fermeture de la JInternalFrame
            }
        });
    }
	public void actionPerformed(ActionEvent evt) 
    { 
		Object source = evt.getSource();
        if (source == vider)
        {
            viderText();
        }
        else if (source == ajouter)
        {
            boolean verif = verifChamps();
            System.out.println("Verif = " + verif);

            if (verif == true)
            {
                int reqMaj = ajoutMedecinBDD();
                if (reqMaj == 0)
                {
                    labelErreur.setText("Echec requête. Vérifiez le contenu de vos champs. (Est-ce que la localité existe ?)");
                }
                else if (reqMaj == 1)
                {
                    labelErreur.setText("Insertion réussie !");
                    viderText();
                }
            }
            else
            {
                labelErreur.setText("Veuillez remplir tous les champs obligatoires (tous sauf potentiel)");
            }
        }
    }

}
