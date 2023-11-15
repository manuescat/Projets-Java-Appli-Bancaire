public class Compte extends Titulaire {
    public String nomCompte;
    public int numeroCompte;
    public double solde;
    public double decouvert;

    public Compte(){
    }

    public Compte(String nomCompte, int numeroCompte, double solde, double decouvert) {
        this.nomCompte = nomCompte;
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.decouvert = decouvert;
    }

    public Compte(String nomTitulaire, String prenomTitulaire, String adresseTitulaire, int codePostalTitulaire, String villeTitulaire, String telTitulaire, int identifiantTitulaire, String mdpTitulaire, String nomCompte, int numeroCompte, double solde, double decouvert) {
        super(nomTitulaire, prenomTitulaire, adresseTitulaire, codePostalTitulaire, villeTitulaire, telTitulaire, identifiantTitulaire, mdpTitulaire);
        this.nomCompte = nomCompte;
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.decouvert = decouvert;
    }

    public Compte(String nomTitulaire, String prenomTitulaire, String adresseTitulaire, int codePostalTitulaire, String villeTitulaire, String telTitulaire, int identifiantTitulaire, String mdpTitulaire) {
        super(nomTitulaire, prenomTitulaire, adresseTitulaire, codePostalTitulaire, villeTitulaire, telTitulaire, identifiantTitulaire, mdpTitulaire);
    }
    public Compte(int identifiantTitulaire, String nomCompte, int numeroCompte, double solde, double decouvert) {
        super(identifiantTitulaire);
        this.nomCompte = nomCompte;
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.decouvert = decouvert;
    }
    public Compte(int identifiantTitulaire) {
        super(identifiantTitulaire);
    }

    public String getNomCompte() {
        return nomCompte;
    }

    public void setNomCompte(String nomCompte) {
        this.nomCompte = nomCompte;
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}

