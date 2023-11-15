import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//3ème niveau de fenètre accès banque : ce formulaire permet d'afficher les informations d'un titulaire dans la console

public class FormulaireInfoTitulaire extends JFrame{

    Banque banque;
    private JLabel label1 = new JLabel(" Identifiant titulaire :");
    private JComboBox txtIdentifiant;
    private JButton valider = new JButton("Afficher");

    public class Gerer implements ActionListener {

        public void actionPerformed(ActionEvent e) {
                //ici on prend les 5 caractères à droite de la chaine afin de ne sélectionner que le numéro de titulaire (en effet la Jcombobox affiche nom, prénom titulaire et numéro titulaire)
                String txtId=(txtIdentifiant.getSelectedItem().toString()).substring((txtIdentifiant.getSelectedItem().toString().length())-5,(txtIdentifiant.getSelectedItem().toString().length()));
                int ident = Integer.parseInt(txtId);
                banque.afficherUnTitulaire(ident);
        }
    }

    public FormulaireInfoTitulaire(Banque banque){
        this.banque=banque;
        txtIdentifiant=new JComboBox();//la combobox prend la liste des identifiants titulaire dans la liste des titulaires
        for (Titulaire listeTtulaire : banque.getListeTitulaires()) {
            txtIdentifiant.addItem(listeTtulaire.getNomTitulaire()+" "+listeTtulaire.getPrenomTitulaire()+" - "+listeTtulaire.getIdentifiantTitulaire());
        }

        JPanel contenufenetre = new JPanel();
        contenufenetre.add(label1);
        contenufenetre.add(txtIdentifiant);
        contenufenetre.add(valider);

        this.setTitle("Interrogation titulaire");
        this.setLocation(800, 500);
        this.setContentPane(contenufenetre);
        this.getContentPane().setBackground(new Color(120,130,100));
        this.pack();
        this.setVisible(true);

        valider.addActionListener(new Gerer());
     }
}
