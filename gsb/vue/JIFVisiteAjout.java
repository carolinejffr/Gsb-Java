package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 * Vue Ajout Visite
 * 
 * @author Gouault Lucas
 */
public class JIFVisiteAjout extends JInternalFrame  implements ActionListener 
{
    // Panels
    protected JPanel p;  
	protected JPanel pTexte;
    protected JPanel pBoutons;
    protected JPanel pErreur;
    // Labels
    // Champs
	protected JComboBox<String> JCCodeMedecin;
    protected JComboBox<String> JCCodeVisiteur;
    // Bouton
    protected JButton ajouter;
    protected JButton vider;

    public JIFVisiteAjout()
    {
        p = new JPanel(new GridLayout(5,1));  // panneau principal de la fenêtre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(3,2));
        


        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Ajout Visite");
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
    }
    
}
