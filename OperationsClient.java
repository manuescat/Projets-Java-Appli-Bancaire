import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//2ème niveau de fenètre : Choix des opérations possibles pour le client sur ses comptes

public class OperationsClient extends JFrame{
    Banque banque;
    private JLabel lblid = new JLabel("Identifiant :");
    private JTextField textid = new JTextField(11);
    private JLabel lblmdp = new JLabel("mot de passe :");
    private JTextField textmdp = new JTextField(11);
    private JButton SoldeCpt = new JButton("Solde des comptes");
    private JButton retrait = new JButton("Faire un retrait");
    private JButton depot = new JButton("Faire un dépot");
    private JButton virement = new JButton("faire un virement");


    public class SoldeCpt implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //le try catch permet de gérer les exceptions en cas d'identifiant laissé vide
            try {
                int cpt=0;
                int id = Integer.parseInt(textid.getText());
                //Cette boucle permet de tester si le couple identifiant titulaire et mot de passe existe
                for (int i =0;i<banque.getListeTitulaires().size();i++) {
                    cpt++;
                    if (id == banque.getListeTitulaires().get(i).getIdentifiantTitulaire()) {
                        if (textmdp.getText().equals(banque.getListeTitulaires().get(i).getMdpTitulaire())) {
                            new FenetreConsultation(banque, textid.getText());
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Mot de passe incorrect");
                            break;
                        }
                    //ici on vérifie si l'identifiant appartient à la liste, si l'extrémité de la liste et atteinte que la condition précédente n'est pas remplie, le message s'affiche
                    }else if (cpt == banque.getListeTitulaires().size()){
                        JOptionPane.showMessageDialog(null, "Identifiant incorrect");
                    }
                }
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Veuillez saisir votre identifiant");

            }
        }
    }
    public class retrait implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //les mêmes tests que précédement sont réalisés
            try {
                int cpt=0;
                int id = Integer.parseInt(textid.getText());
                for (int i =0;i<banque.getListeTitulaires().size();i++) {
                    cpt++;
                    if (id == banque.getListeTitulaires().get(i).getIdentifiantTitulaire()) {
                        if (textmdp.getText().equals(banque.getListeTitulaires().get(i).getMdpTitulaire())) {
                            new FenetreRetrait(banque, textid.getText());
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Mot de passe incorrect");
                            break;
                        }
                    }else if (cpt == banque.getListeTitulaires().size()){
                        JOptionPane.showMessageDialog(null, "Identifiant incorrect");
                    }
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Veuillez saisir votre identifiant");

            }
        }
    }
    public class depot implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //les mêmes tests que précédement sont réalisés
            try {
                int cpt=0;
                int id = Integer.parseInt(textid.getText());
                for (int i =0;i<banque.getListeTitulaires().size();i++) {
                    cpt++;
                    if (id == banque.getListeTitulaires().get(i).getIdentifiantTitulaire()) {
                        if (textmdp.getText().equals(banque.getListeTitulaires().get(i).getMdpTitulaire())) {
                            new FenetreDepot(banque, textid.getText());
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Mot de passe incorrect");
                            break;
                        }
                    }else if (cpt == banque.getListeTitulaires().size()){
                        JOptionPane.showMessageDialog(null, "Identifiant incorrect");
                    }
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Veuillez saisir votre identifiant");
            }
        }
    }
    public class virement implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //les mêmes tests que précédement sont réalisés
            try {
                int cpt=0;
                int id = Integer.parseInt(textid.getText());
                for (int i =0;i<banque.getListeTitulaires().size();i++) {
                    cpt++;
                    if (id == banque.getListeTitulaires().get(i).getIdentifiantTitulaire()) {
                        if (textmdp.getText().equals(banque.getListeTitulaires().get(i).getMdpTitulaire())) {
                            new FenetreVirement(banque, textid.getText());
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Mot de passe incorrect");
                            break;
                        }
                    }else if (cpt == banque.getListeTitulaires().size()){
                        JOptionPane.showMessageDialog(null, "Identifiant incorrect");
                    }
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Veuillez saisir votre identifiant");
            }
        }
    }
    public OperationsClient(Banque banque){

        this.banque=banque;

        JPanel contenufenetre = new JPanel();
        contenufenetre.add(lblid);
        contenufenetre.add(textid);
        contenufenetre.add(lblmdp);
        contenufenetre.add(textmdp);
        contenufenetre.add(SoldeCpt);
        contenufenetre.add(retrait);
        contenufenetre.add(depot);
        contenufenetre.add(virement);

        this.setTitle("Espace client");
        this.setContentPane(contenufenetre);
        this.setLocation(530, 300);
        this.getContentPane().setBackground(new Color(188, 117, 203));
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SoldeCpt.addActionListener(new SoldeCpt());
        retrait.addActionListener(new retrait());
        depot.addActionListener(new depot());
        virement.addActionListener(new virement());
    }
}

