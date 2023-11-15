import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//3ème niveau de fenètre accès client : ce formulaire permet de retirer de l'argent d'un compte

public class FenetreRetrait extends JFrame {
    Banque banque;
    private JLabel lblident = new JLabel("Numéro Titulaire :", JLabel.RIGHT);
    private JLabel ident;
    private JLabel lblCptDeb = new JLabel(" Compte à débiter :");
    private JComboBox txtCptDeb;
    private JLabel lblMontant = new JLabel(" Montant :");
    private JTextField txtMontant = new JTextField(11);
    private JButton valider = new JButton("Valider");

    public class Gerer implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            //Le tray catch permet de gérer l'absence de saisie d'un montant
            try {
                //ici on prend les 5 caractères à droite de la chaine afin de ne sélectionner que le numéro de compte (en effet la Jcombobox affiche nomcompte et numéro compte)
                String txtid=(txtCptDeb.getSelectedItem().toString()).substring((txtCptDeb.getSelectedItem().toString().length())-5,(txtCptDeb.getSelectedItem().toString().length()));
                int cptDeb = Integer.parseInt(txtid);
                int montant = Integer.parseInt(txtMontant.getText());
                banque.retrait(cptDeb,montant);
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Veuillez saisir un montant");
            }
        }
    }

    public FenetreRetrait(Banque banque,final String identifiant){

        this.banque=banque;
        ident=new JLabel(identifiant);//on récupère l'identifiant venant du formulaire précédent
        txtCptDeb=new JComboBox();//on affiche la liste des comptes associés à ce numéro de titulaire
        for (Compte listeCompte : banque.getListeComptes()) {
            if (Integer.parseInt(identifiant) == listeCompte.getIdentifiantTitulaire()) {
                txtCptDeb.addItem(listeCompte.getNomCompte()+" n°"+listeCompte.getNumeroCompte());
            }
        }

        JPanel contenufenetre = new JPanel();
        contenufenetre.setLayout(new GridLayout(4, 2, 7, 7));
        contenufenetre.add(lblident);
        contenufenetre.add(ident);
        contenufenetre.add(lblCptDeb);
        contenufenetre.add(txtCptDeb);
        contenufenetre.add(lblMontant);
        contenufenetre.add(txtMontant);
        contenufenetre.add(valider);

        this.setTitle("Réaliser un retrait");
        this.setLocation(400, 440);
        this.setContentPane(contenufenetre);
        this.pack();
        this.setVisible(true);
        valider.addActionListener(new Gerer());
    }
}
