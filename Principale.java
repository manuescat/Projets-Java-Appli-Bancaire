public class Principale {

    public static void main(String[] args) {
        Banque banque = new Banque();
        //création d'une liste de titulaires et de comptes afin de pouvoir réaliser les tests
        banque.ajouterTitulaire("Parker", "Tony", "rue du bas", 69000, "LYON", "0655997733", 20211, "abcd");
        banque.ajouterTitulaire("Parker", "Whitney", "rue du bas", 69000, "LYON", "0655997733", 20212, "abcd");
        banque.ajouterTitulaire("Petit", "Jean", "rue du haut", 59000, "LILLE", "0359668877", 20213, "abcd");
        banque.ajouterTitulaire("Dupont", "Alain", "rue du milieu", 75000, "PARIS", "0159668877", 20214, "abcd");
        banque.ajouterCompte(20211, "Compte épargne", 23501, 25698, 50);
        banque.ajouterCompte(20211, "Livret A", 23502, 300, 50);
        banque.ajouterCompte(20211, "Compte courant", 23503, 2569, 100);
        banque.ajouterCompte(20212, "Compte courant", 23503, 2569, 100);
        banque.ajouterCompte(20213, "Compte épargne", 23504, 4698, 50);
        banque.ajouterCompte(20213, "Compte courant", 23505, 569, 100);
        banque.ajouterCompte(20214, "Compte épargne", 23506, 974, 50);
        banque.ajouterCompte(20214, "Compte courant", 23507, 112, 100);
        banque.ajouterCompte(20214, "Compte courant", 23508, -200, 100);

        new FenetreMenu(banque);
    }
}