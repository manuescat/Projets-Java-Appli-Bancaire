import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Création de la 1ère fenètre permettant de de chosir entre les opérations banque et les opérations client

public class FenetreMenu extends JFrame{
    Banque banque;
    private JButton boutonBanque = new JButton("Accés banque");
    private JButton boutonClient = new JButton("Accés client");

    public class accesBanque implements ActionListener {

        public void actionPerformed(ActionEvent e)
        {
            new OperationsBanque(banque);
        }
    }
    public class accesClient implements ActionListener {

        public void actionPerformed(ActionEvent e)
        {
            new OperationsClient(banque);
        }
    }

    public FenetreMenu(Banque banque) {

        this.banque=banque;

        JPanel contenuFenetre = new JPanel();
        contenuFenetre.add(boutonBanque);
        contenuFenetre.add(boutonClient);

        this.setLocation(800, 100);
        this.setContentPane(contenuFenetre);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boutonBanque.addActionListener(new accesBanque());
        boutonClient.addActionListener(new accesClient());
    }
}
