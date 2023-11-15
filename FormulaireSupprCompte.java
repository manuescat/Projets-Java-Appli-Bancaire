import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//3ème niveau de fenètre accès banque : ce formulaire permet de supprimer un compte

public class FormulaireSupprCompte extends JFrame{

    Banque banque;
    private JLabel label1 = new JLabel(" Numéro de compte :");
    private JComboBox txtCpt;
    private JButton valider = new JButton("Supprimer");

    public class Gerer implements ActionListener {

        public void actionPerformed(ActionEvent e) {
                //ici on prend les 5 caractères à droite de la chaine afin de ne sélectionner que le numéro de compte (en effet la Jcombobox affiche nomcompte et numéro compte)
                String txtNumCpt=(txtCpt.getSelectedItem().toString()).substring((txtCpt.getSelectedItem().toString().length())-5);
                int NumCompte = Integer.parseInt(txtNumCpt);
                banque.supprimerCompte(NumCompte);
        }
    }

    public FormulaireSupprCompte(Banque banque){

        this.banque=banque;
        txtCpt=new JComboBox();//la combobox récupère la liste des noms comptes et numéros de comptes
        for (Compte listeCompte : banque.getListeComptes()) {
            txtCpt.addItem(listeCompte.getNomCompte()+" n°"+listeCompte.getNumeroCompte());
        }

        JPanel contenufenetre = new JPanel();
        contenufenetre.add(label1);
        contenufenetre.add(txtCpt);
        contenufenetre.add(valider);

        this.setTitle("Supression compte");
        this.setLocation(800, 400);
        this.setContentPane(contenufenetre);
        this.getContentPane().setBackground(new Color(155,120, 200));
        this.pack();
        this.setVisible(true);

        valider.addActionListener(new Gerer());
    }
}
