import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//3ème niveau de fenètre accès banque : ce formulaire permet d'ajouter un titulaire

public class FormulaireTitulaire extends JFrame {

        Banque banque;
        private JLabel lblNom = new JLabel("Nom", JLabel.RIGHT);
        private JTextField txtNom = new JTextField(10);
        private JLabel lblPrenom = new JLabel("Prénom", JLabel.RIGHT);
        private JTextField txtPrenom = new JTextField(10);
        private JLabel lblAdresse = new JLabel("Adresse:", JLabel.RIGHT);
        private JTextField txtAdresse = new JTextField(10);
        private JLabel lblCP = new JLabel("Code postal:", JLabel.RIGHT);
        private JTextField txtCP = new JTextField(10);
        private JLabel lblVille = new JLabel("Ville", JLabel.RIGHT);
        private JTextField txtVille = new JTextField(10);
        private JLabel lblTel = new JLabel("Téléphone", JLabel.RIGHT);
        private JTextField txtTel = new JTextField(10);
        private JLabel lblIdentifiant = new JLabel("Identifiant", JLabel.RIGHT);
        private JTextField txtIdentifiant;//ce champs est généré automatiquement à partir du dernier élément saisi en liste
        private JLabel lblMdp = new JLabel("Mot de passe", JLabel.RIGHT);
        private JTextField txtMdp = new JTextField(10);
        private JButton valider = new JButton("Ajouter");

        public class Gerer implements ActionListener {

                public void actionPerformed(ActionEvent e) {
                        //le try catch permet d'afficher un message en cas de champ laissé vide
                        try{
                                //insertion des champs de saisie dans la méthode ajouterTitulaire
                                banque.ajouterTitulaire(txtNom.getText(), txtPrenom.getText(), txtAdresse.getText(), Integer.parseInt(txtCP.getText()), txtVille.getText(), txtTel.getText(), Integer.parseInt(txtIdentifiant.getText()), txtMdp.getText());
                        }catch(Exception ex){
                                JOptionPane.showMessageDialog(null, "Veuillez compléter tous les champs svp");
                        }
                }
        }

        public FormulaireTitulaire(Banque banque) {
                this.banque=banque;
                //on récupère dans la liste le dernier identifiant afin de l'intégrer au formulaire
                int i = banque.getListeTitulaires().size()-1;
                int newIdent = banque.getListeTitulaires().get(i).getIdentifiantTitulaire()+1;
                String txtIdent=Integer.toString(newIdent);
                txtIdentifiant = new JTextField(txtIdent);

                JPanel contenufenetre = new JPanel( );
                contenufenetre.setLayout(new GridLayout(9, 4, 7, 7));
                contenufenetre.add(lblNom);
                contenufenetre.add(txtNom);
                contenufenetre.add(lblPrenom);
                contenufenetre.add(txtPrenom);
                contenufenetre.add(lblAdresse);
                contenufenetre.add(txtAdresse);
                contenufenetre.add(lblCP);
                contenufenetre.add(txtCP);
                contenufenetre.add(lblVille);
                contenufenetre.add(txtVille);
                contenufenetre.add(lblTel);
                contenufenetre.add(txtTel);
                contenufenetre.add(lblIdentifiant);
                contenufenetre.add(txtIdentifiant);
                contenufenetre.add(lblMdp);
                contenufenetre.add(txtMdp);
                contenufenetre.add(valider);

                this.setTitle("Enregistrer un nouveau titulaire");
                this.setLocation(0, 300);
                this.setContentPane(contenufenetre);
                this.pack( );
                this.setSize(400,400);
                this.setVisible(true);

                valider.addActionListener(new Gerer());
        }
}



