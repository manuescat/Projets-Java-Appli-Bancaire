import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//3ème niveau de fenètre accès client : ce formulaire permet de déposer de l'argent sur un compte

    public class FenetreDepot extends JFrame {
        Banque banque;
        private JLabel lblident = new JLabel("Numéro Titulaire :", JLabel.RIGHT);
        private JLabel ident;
        private JLabel lblCptCred = new JLabel(" Compte à Créditer :");
        private JComboBox txtCptCred;
        private JLabel lblMontant = new JLabel(" Montant :");
        private JTextField txtMontant = new JTextField(11);
        private JButton valider = new JButton("Valider");

        public class Gerer implements ActionListener {
            public void actionPerformed(ActionEvent e)
            {
                //Le tray catch permet de gérer l'absence de saisie d'un montant
                try {
                    //ici on prend les 5 caractères à droite de la chaine afin de ne sélectionner que le numéro de compte (en effet la Jcombobox affiche nomcompte et numéro compte)
                    String txtid = (txtCptCred.getSelectedItem().toString()).substring((txtCptCred.getSelectedItem().toString().length()) - 5);
                    int cptCred = Integer.parseInt(txtid);
                    int montant = Integer.parseInt(txtMontant.getText());
                    banque.depot(cptCred, montant);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Veuillez saisir un montant");
                }
            }
        }

        public FenetreDepot(Banque banque,final String identifiant)
        {
            this.banque=banque;
            ident=new JLabel(identifiant);//on récupère l'identifiant venant du formulaire précédent
            txtCptCred=new JComboBox();//on affiche la liste des comptes associés à ce numéro de titulaire
            for (Compte listeCompte : banque.getListeComptes()) {
                if (Integer.parseInt(identifiant) == listeCompte.getIdentifiantTitulaire()) {
                    txtCptCred.addItem(listeCompte.getNomCompte()+" n°"+listeCompte.getNumeroCompte());
                }
            }

            JPanel contenufenetre = new JPanel();
            contenufenetre.setLayout(new GridLayout(4, 2, 7, 7));
            contenufenetre.add(lblident);
            contenufenetre.add(ident);
            contenufenetre.add(lblCptCred);
            contenufenetre.add(txtCptCred);
            contenufenetre.add(lblMontant);
            contenufenetre.add(txtMontant);
            contenufenetre.add(valider);

            this.setTitle("Réaliser un dépot");
            this.setLocation(800, 440);
            this.setContentPane(contenufenetre);
            this.pack();
            this.setVisible(true);
            valider.addActionListener(new Gerer());
        }
    }

