package gsb.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import gsb.modele.Localite;

public class JIFVisiteurAjout extends JIFVisiteur implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JButton vider;
    private JButton ajouter;
    private JLabel labelErreur;
    private JPanel pErreur;

    public JIFVisiteurAjout(){
        setTitle("Ajout d'un Visiteur");

        // déclaration des écoutes des boutons
        Vider.addActionListener(this);
        Valider.addActionListener(this);
    }
    public void actionPerformed(ActionEvent evenement) 
    { 
        { 
            Object source = evenement.getSource();
            if (source == vider)
            {
                viderText();
            }
            else if (source == ajouter){
                boolean verification = verifChamps();
                if verification = 1
            }
    }
}
