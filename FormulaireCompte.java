import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//3ème niveau de fenètre accès banque : ce formulaire permet d'ajouter un nouveau compte

public class FormulaireCompte extends JFrame{

    Banque banque;
    private JLabel lblNomCpt = new JLabel("Nom Compte", JLabel.RIGHT);
    private JComboBox txtNomCpt;
    private JLabel lblnumCpt = new JLabel("Numéro Compte", JLabel.RIGHT);
    private JTextField txtnumCpt;
    private JLabel lblSolde = new JLabel("Solde de départ", JLabel.RIGHT);
    private JTextField txtSolde = new JTextField(10);
    private JLabel lblDecouvert = new JLabel("Découvert autorisé", JLabel.RIGHT);
    private JComboBox txtDecouvert;
    private JLabel lblIdentifiant = new JLabel("Identifiant titulaire", JLabel.RIGHT);
    private JComboBox txtIdentifiant;
    private JButton valider = new JButton("Ajouter");

    public class Gerercomptes implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //le try catch affiche un message si le champ solde de départ reste vide
            try {
                String nomCpt = txtNomCpt.getSelectedItem().toString();
                int numCpt = Integer.parseInt(txtnumCpt.getText());
                int solde = Integer.parseInt(txtSolde.getText());
                int decouvert = Integer.parseInt(txtDecouvert.getSelectedItem().toString());
                //ici on prend les 5 caractères à droite de la chaine afin de ne sélectionner que le numéro de compte (en effet la Jcombobox affiche nom compte et numéro compte)
                String txtid = (txtIdentifiant.getSelectedItem().toString()).substring((txtIdentifiant.getSelectedItem().toString().length()) - 5);
                int id = Integer.parseInt(txtid);
                banque.ajouterCompte(id, nomCpt, numCpt, solde, decouvert);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Veuillez indiquer le solde de départ");
            }
        }
    }

    public FormulaireCompte(Banque banque) {

        this.banque=banque;
        //on récupère dans la liste le dernier numéro de compte afin de l'intégrer au formulaire
        int i = banque.getListeComptes().size()-1;
        int newNumCpt = banque.getListeComptes().get(i).getNumeroCompte()+1;
        String txtNumCpt=Integer.toString(newNumCpt);
        txtnumCpt = new JTextField(txtNumCpt);

        txtNomCpt = new JComboBox();
        txtNomCpt.addItem("Livret A");
        txtNomCpt.addItem("Compte courant");
        txtNomCpt.addItem("Compte épargne");
        txtNomCpt.addItem("PEL");

        txtDecouvert = new JComboBox();
        txtDecouvert.addItem(100);
        txtDecouvert.addItem(200);
        txtDecouvert.addItem(300);
        txtDecouvert.addItem(400);
        txtDecouvert.addItem(500);

        txtIdentifiant=new JComboBox();//la combobox prend la liste des identifiants titulaire dans la liste des titulaires
        for (Titulaire listeTtulaire : banque.getListeTitulaires()) {
            txtIdentifiant.addItem(listeTtulaire.getNomTitulaire()+" "+listeTtulaire.getPrenomTitulaire()+" - "+listeTtulaire.getIdentifiantTitulaire());
        }

        JPanel contenufenetre = new JPanel( );
        contenufenetre.setLayout(new GridLayout(6, 4, 7, 7));
        contenufenetre.add(lblNomCpt);
        contenufenetre.add(txtNomCpt);
        contenufenetre.add(lblnumCpt);
        contenufenetre.add(txtnumCpt);
        contenufenetre.add(lblSolde);
        contenufenetre.add(txtSolde);
        contenufenetre.add(lblDecouvert);
        contenufenetre.add(txtDecouvert);
        contenufenetre.add(lblIdentifiant);
        contenufenetre.add(txtIdentifiant);
        contenufenetre.add(valider);

        this.setTitle("Enregistrer un nouveau compte");
        this.setLocation(400, 300);
        this.setContentPane(contenufenetre);
        this.pack( );
        this.setSize(400,300);
        this.setVisible(true);

        valider.addActionListener(new Gerercomptes());
    }
}

