import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//2ème niveau de fenètre : Choix des opérations possibles pour la banque sur les titulaires et les comptes

public class OperationsBanque extends JFrame{
    Banque banque;

    private JButton ajoutTitulaire = new JButton("Ajouter un titulaire");
    private JButton ajoutCompte = new JButton("Ajouter un compte");
    private JButton listeTitulaire = new JButton("Liste des titulaires");
    private JButton listeCmpt = new JButton("Liste des comptes");
    private JButton supprTitulaire = new JButton("Supprimer un titulaire");
    private JButton supprCompte = new JButton("Supprimer un compte");
    private JButton infoTitulaire = new JButton("Interroger un titulaire");
    private JButton infoCompte = new JButton("Interroger un Compte");

    public class AjoutTitulaire implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            new FormulaireTitulaire(banque);
        }
    }
    public class AjoutCompte implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            new FormulaireCompte(banque);
        }
    }
    public class ListeTitulaire implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            banque.afficherTitulaires();
        }
    }

    public class listeCmpt implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            banque.afficherListeComtes();
        }
    }
    public class SupprTitulaire implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            new FormulaireSupprTitulaire(banque);
        }
    }
    public class SupprCompte implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            new FormulaireSupprCompte(banque);
        }
    }
    public class InfoTitulaire implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            new FormulaireInfoTitulaire(banque);
        }
    }
    public class InfoCompte implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            new FormulaireInfoCompte(banque);
        }
    }

    public OperationsBanque(Banque banque)
    {
        this.banque=banque;

        JPanel contenuFenetre = new JPanel();
        contenuFenetre.add(ajoutTitulaire);
        contenuFenetre.add(ajoutCompte);
        contenuFenetre.add(listeTitulaire);
        contenuFenetre.add(listeCmpt);
        contenuFenetre.add(supprTitulaire);
        contenuFenetre.add(supprCompte);
        contenuFenetre.add(infoTitulaire);
        contenuFenetre.add(infoCompte);

        this.setTitle("Espace banque");
        this.setContentPane(contenuFenetre);
        this.setLocation(350, 200);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ajoutTitulaire.addActionListener(new AjoutTitulaire());
        ajoutCompte.addActionListener(new AjoutCompte());
        listeTitulaire.addActionListener(new ListeTitulaire());
        listeCmpt.addActionListener(new listeCmpt());
        supprTitulaire.addActionListener(new SupprTitulaire());
        supprCompte.addActionListener(new SupprCompte());
        infoTitulaire.addActionListener(new InfoTitulaire());
        infoCompte.addActionListener(new InfoCompte());

    }
}




