import java.util.ArrayList;
import java.util.Iterator;

public class Banque extends Compte implements Operations {

    private ArrayList<Compte> listeComptes;
    private ArrayList<Titulaire> listeTitulaires;

    public Banque() {
        listeComptes = new ArrayList<>();
        listeTitulaires = new ArrayList<>();
    }

    public ArrayList<Compte> getListeComptes() {
        return listeComptes;
    }

    public ArrayList<Compte> setListeComptes(ArrayList<Compte> listeComptes) {
        this.listeComptes = listeComptes;
        return listeComptes;
    }

    public ArrayList<Titulaire> getListeTitulaires() {
        return listeTitulaires;
    }

    public void setListeTitulaires(ArrayList<Titulaire> listeTitulaires) {
        this.listeTitulaires = listeTitulaires;
    }

    //*****Opérations de la banque sur les comptes*****
        //Affichage de la liste des comptes
    public void afficherListeComtes() {
        System.out.println("Liste des comptes");
        for (Compte listeCompte : listeComptes) {
            System.out.println("identifiant: "+ listeCompte.getIdentifiantTitulaire() + " - " + listeCompte.getNomCompte() + " n°" + listeCompte.getNumeroCompte() + " - solde: " + listeCompte.getSolde() + "€ - découvert autorisé: " + listeCompte.getDecouvert()+"€");
        }
    }
        //Affichage d'un compte à partir de son numéro
    public void afficherUnCompte(int numeroCompte) {
        for (Compte listeCompte : listeComptes) {
            if (numeroCompte == listeCompte.getNumeroCompte()) {
                System.out.println("Informations associées à un compte");
                System.out.println("identifiant du titulaire : " + listeCompte.getIdentifiantTitulaire());
                System.out.println("informations compte : "+listeCompte.getNomCompte() + " n°" + listeCompte.getNumeroCompte());
                System.out.println("solde :" + listeCompte.getSolde()+"€");
                System.out.println("découvert autorisé :" + listeCompte.getDecouvert()+"€");
            }
        }
    }
        //Ajout d'une compte
    public void ajouterCompte(int identifiant, String nomCompte, int numeroCompte, double solde, double decouvert) {
        listeComptes.add(new Compte(identifiant,nomCompte, numeroCompte, solde, decouvert));
        System.out.println("Le compte n°"+numeroCompte+" a bien été ajouté.");
    }
        //Suppression d'une compte
    public void supprimerCompte(int numeroCompte) {
        Iterator<Compte> itr = listeComptes.iterator();
        while (itr.hasNext()) {
            Compte listeCompte = itr.next();
            if (listeCompte.getNumeroCompte() == numeroCompte){
                itr.remove();
                System.out.println("Le compte n°"+numeroCompte+" a bien été supprimé.");
            }
        }
    }
    //*****Opérations de la banque sur la liste titulaires*****
        //Affichage de la liste des titulaires
    public void afficherTitulaires(){
        System.out.println("Liste des titulaires");
        for (Titulaire listeTitulaire : listeTitulaires) {
            System.out.println("Titulaire: "+listeTitulaire.getNomTitulaire() + " " + listeTitulaire.getPrenomTitulaire() + " - adresse: "  + listeTitulaire.getadresseTitulaire() + " " + listeTitulaire.getCodePostalTitulaire() + " " + listeTitulaire.getVilleTitulaire() + " - tél : " + listeTitulaire.getTelTitulaire() + " - identifiant : " + listeTitulaire.getIdentifiantTitulaire());
        }
    }
        //Affichage d'un titulaire à partir de son identifiant
    public void afficherUnTitulaire(int IdentifiantTitulaire){
        for (Titulaire listeTitulaire : listeTitulaires) {
            if (IdentifiantTitulaire == listeTitulaire.getIdentifiantTitulaire()) {
                System.out.println("Informations associées à un titulaire");
                System.out.println(listeTitulaire.getNomTitulaire() + " " + listeTitulaire.getPrenomTitulaire());
                System.out.println(listeTitulaire.getadresseTitulaire() + " " + listeTitulaire.getCodePostalTitulaire() + " " + listeTitulaire.getVilleTitulaire());
                System.out.println("Tél : " + listeTitulaire.getTelTitulaire());
                System.out.println("identifiant :" + listeTitulaire.getIdentifiantTitulaire());
            }
        }
    }
        //Ajouter un titulaire
    public void ajouterTitulaire(String nomTitulaire, String prenomTitulaire, String adresseTitulaire, int codePostalTitulaire, String villeTitulaire, String telTitulaire, int identifiantTitulaire, String mdpTitulaire){
        listeTitulaires.add(new Titulaire(nomTitulaire.toUpperCase(),prenomTitulaire,adresseTitulaire,codePostalTitulaire,villeTitulaire.toUpperCase(),telTitulaire,identifiantTitulaire,mdpTitulaire));
        System.out.println("Le titulaire n°"+identifiantTitulaire+" a bien été ajouté.");
    }
        //Supprimer un titulaire et ses comptes associés
    public void supprimerTitulaire(int IdentifiantTitulaire){
        Iterator<Titulaire> itr = listeTitulaires.iterator();
        while (itr.hasNext()) {
            Titulaire listeTitulaire =itr.next();
            if (listeTitulaire.getIdentifiantTitulaire() == IdentifiantTitulaire){
                itr.remove();
                System.out.println("Le titulaire n°" + IdentifiantTitulaire + " et les comptes associés ont bien été supprimés.");
            }
        }
        Iterator<Compte> itr2 = listeComptes.iterator();
        while (itr2.hasNext()) {
            Compte listeCompte =itr2.next();
            if ((listeCompte.getIdentifiantTitulaire() == IdentifiantTitulaire)){
                itr2.remove();
            }
        }
    }
    //*****Opérations des tituliaires sur les comptes*****
        //Retrait d'argent
    public void retrait(int numeroCompte, double montant) {
        double retraitSolde;
        for (Compte listeCompte : listeComptes) {
            if (numeroCompte == listeCompte.getNumeroCompte()) {
                retraitSolde = listeCompte.getSolde() - montant;
                if (montant <= listeCompte.getDecouvert() + listeCompte.getSolde()) {
                    listeCompte.setSolde(retraitSolde);
                    System.out.println("Voici votre argent, votre solde restant est de " + listeCompte.getSolde() + "€");
                } else {
                    System.out.println("Retrait impossible");
                }
            }
        }
    }
        //Depot d'argent
    public void depot(int numeroCompte, double montant) {
        for (Compte listeCompte : listeComptes) {
            if (numeroCompte == listeCompte.getNumeroCompte()) {
                listeCompte.setSolde(montant + listeCompte.getSolde());
                System.out.println("Nous avons bien enregistré votre dépot.");
                System.out.println("Votre solde est de " + listeCompte.getSolde() + "€.");
            }
        }
    }
        //Vérification du solde du compte par rapport au découvert (utilisé lors de la consultation du solde d'un compte)
    public void infoDecouvert(int idTitulaire) {
        for (Compte listeCompte : listeComptes) {
            if (idTitulaire == listeCompte.getIdentifiantTitulaire()) {
                if (listeCompte.getSolde() < -(listeCompte.getDecouvert())) {
                    System.out.println("Attention, votre compte " + listeCompte.getNomCompte() + " n°" + listeCompte.getNumeroCompte() + " est à découvert.");
                }
            }
        }
    }
        //Virement d'un compte vers un compte de la liste des comptes (affichage du solde restant)
    public void virement(int numeroCompte, int montant, int numComteDestinataire){
        double retraitSolde;
        for (int i =0;i<listeComptes.size();i++) {
            if (numeroCompte == listeComptes.get(i).getNumeroCompte()) {
                retraitSolde = listeComptes.get(i).getSolde() - montant;
                if (montant <= listeComptes.get(i).getDecouvert() + listeComptes.get(i).getSolde()) {
                    listeComptes.get(i).setSolde(retraitSolde);
                    for (Compte listeCompte : listeComptes) {
                        if (numComteDestinataire == listeCompte.getNumeroCompte()) {
                            listeCompte.setSolde(montant + listeCompte.getSolde());
                        }
                    }
                System.out.println("Vous venez de réaliser un virement de " +montant+"€ du compte "+listeComptes.get(i).getNomCompte()+" n°"+numeroCompte+" vers le compte n°"+numComteDestinataire+".");
                System.out.println("Le solde de votre compte "+listeComptes.get(i).getNomCompte()+" n°" + numeroCompte + " est de: " +listeComptes.get(i).getSolde()+"€");
                } else {
                    System.out.println("Virement impossible");
                }
            }
        }
    }
        //Affichage du solde du compte lors de la consultation d'un compte
    public void afficherSolde(int numeroCompte){
        for (Compte listeCompte : listeComptes) {
            if (numeroCompte == listeCompte.getNumeroCompte()) {
                System.out.println("Le solde du compte " + listeCompte.getNomCompte() + " n°" + numeroCompte + " est de: " + listeCompte.getSolde() + "€");
                break;
            }
        }
    }
}