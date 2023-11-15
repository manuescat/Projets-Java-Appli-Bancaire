public interface Operations {
    // Fonction retirer de l'argent au compte
    void retrait(int numeroCompte, double montant);

    // Fonction ajouter de l'argent au compte
    void depot(int numeroCompte, double montant);

    // Fonction vérification découvert
    void infoDecouvert(int idTitulaire);

    // Virement de compte à compte
    void virement(int numeroCompte, int montant, int numComteDestinataire);

    //Affichage du solde
    void afficherSolde(int numeroCompte);

}
