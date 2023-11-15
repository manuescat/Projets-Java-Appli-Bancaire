import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//3ème niveau de fenètre accès client : ce formulaire permet de consulter le solde d'un compte

public class FenetreConsultation extends JFrame {

    Banque banque;
    private JLabel lblident = new JLabel("Numéro Titulaire :", JLabel.RIGHT);
    private JLabel ident;
    private JLabel lblnumcpt = new JLabel("Numéro de compte :", JLabel.RIGHT);
    private JComboBox numcpt;
    private JButton valider = new JButton("Ok");

    public class Gerer implements ActionListener {

        public void actionPerformed(ActionEvent e)
        {
            //ici on prend les 5 caractères à droite de la chaine afin de ne sélectionner que le numéro de compte (en effet la Jcombobox affiche nomcompte et numéro compte)
            String txtid=(numcpt.getSelectedItem().toString()).substring((numcpt.getSelectedItem().toString().length())-5,(numcpt.getSelectedItem().toString().length()));
            int id = Integer.parseInt(txtid);
            int identifiant = Integer.parseInt(ident.getText());
            banque.afficherSolde(id);
            //si le titulaire a un de ses comptes à découvert, la fonction montantDecouvert affiche dans la console un message
            banque.infoDecouvert(identifiant);
        }
    }

    public FenetreConsultation(Banque banque,final String identifiant){

        this.banque=banque;
        ident=new JLabel(identifiant);//on récupère l'identifiant venant du formulaire précédent
        numcpt=new JComboBox();//on affiche la liste des comptes associés à ce numéro de titulaire
                for (Compte listeCompte : banque.getListeComptes()) {
            if (Integer.parseInt(identifiant) == listeCompte.getIdentifiantTitulaire()) {

                numcpt.addItem(listeCompte.getNomCompte()+" n°"+listeCompte.getNumeroCompte());
            }
        }

        JPanel contenufenetre = new JPanel();
        contenufenetre.setLayout(new GridLayout(3, 2, 7, 7));
        contenufenetre.add(lblident);
        contenufenetre.add(ident);
        contenufenetre.add(lblnumcpt);
        contenufenetre.add(numcpt);
        contenufenetre.add(valider);

        this.setTitle("Consultation du solde");
        this.setLocation(000, 440);
        this.setContentPane(contenufenetre);
        this.pack();
        this.setVisible(true);

        valider.addActionListener(new Gerer());
    }
}
