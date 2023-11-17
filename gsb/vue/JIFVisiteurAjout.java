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
    private JLabel labelErreur;
    private JPanel pErreur;
    private JButton Vider;
    private JButton Valider;
    // Ce label sert à la mise en page et s'assure que les erreurs soient bien en-dessous des boutons
    private JLabel labelBreak;

    public JIFVisiteurAjout(){
        super();
        setTitle("Ajout d'un Visiteur");

        Vider = new JButton("Vider les champs");
        pBoutons.add(Vider);

        Valider = new JButton("Ajouter");
        pBoutons.add(Valider);

        pErreur = new JPanel();
        p.add(pErreur);

        labelBreak = new JLabel("<html><br/></html>");
        pErreur.add(labelBreak);

        labelErreur = new JLabel("");
        pErreur.add(labelErreur);


        // déclaration des écoutes des boutons
        Vider.addActionListener(this);
        Valider.addActionListener(this);
    }
    public void actionPerformed(ActionEvent evenement) 
    { 
        
            Object source = evenement.getSource();
            if (source == Vider)
            {
                viderText();
            }
            else if (source == Valider){
                boolean verification = true;
                //verification = verifChamps();

                if (verification = true){
                    int codeRequete = ajoutVisiteurBDD();
                    if (codeRequete == 0){
                        Localite laLocalite = testLocalite();
                        if (laLocalite == null){
                            labelErreur.setText("<html>La ville indiquée n'existe pas dans la base de données.<br/>Veuillez l'ajouter avant de réessayer.</html>");
                        }
                        else{
                            boolean temp = verification ; 
                            
                            }
                            labelErreur.setText("<html>Erreur a implémenté </html>");
                        }
                    }
                }
            }
    
    }

