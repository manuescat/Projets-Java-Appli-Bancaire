public class Titulaire{
    private String nomTitulaire;
    private String prenomTitulaire;
    private String adresseTitulaire;
    private int codePostalTitulaire;
    private String villeTitulaire;
    private String telTitulaire;
    private int identifiantTitulaire;
    private String mdpTitulaire;

    public Titulaire() {
    }

    public Titulaire(String nomTitulaire, String prenomTitulaire, String adresseTitulaire, int codePostalTitulaire, String villeTitulaire, String telTitulaire, int identifiantTitulaire, String mdpTitulaire) {
        this.nomTitulaire = nomTitulaire;
        this.prenomTitulaire = prenomTitulaire;
        this.adresseTitulaire = adresseTitulaire;
        this.codePostalTitulaire = codePostalTitulaire;
        this.villeTitulaire = villeTitulaire;
        this.telTitulaire = telTitulaire;
        this.identifiantTitulaire = identifiantTitulaire;
        this.mdpTitulaire = mdpTitulaire;
    }

    public Titulaire(int identifiantTitulaire) {
        this.identifiantTitulaire = identifiantTitulaire;
    }

    public String getNomTitulaire() {
        return nomTitulaire;
    }

    public void setNomTitulaire(String nomTitulaire) {
        this.nomTitulaire = nomTitulaire;
    }

    public String getPrenomTitulaire() {
        return prenomTitulaire;
    }

    public void setPrenomTitulaire(String prenomTitulaire) {
        this.prenomTitulaire = prenomTitulaire;
    }

    public String getadresseTitulaire() {
        return adresseTitulaire;
    }

    public void setadresseTitulaire(String adresseNomVoieTitulaire) {
        this.adresseTitulaire = adresseTitulaire;
    }

    public int getCodePostalTitulaire() {
        return codePostalTitulaire;
    }

    public void setCodePostalTitulaire(int codePostalTitulaire) {
        this.codePostalTitulaire = codePostalTitulaire;
    }

    public String getVilleTitulaire() {
        return villeTitulaire;
    }

    public void setVilleTitulaire(String villeTitulaire) {
        this.villeTitulaire = villeTitulaire;
    }

    public String getTelTitulaire() {
        return telTitulaire;
    }

    public void setTelTitulaire(String telTitulaire) {
        this.telTitulaire = telTitulaire;
    }

    public int getIdentifiantTitulaire() {
        return identifiantTitulaire;
    }

    public void setIdentifiantTitulaire(int identifiantTitulaire) {
        this.identifiantTitulaire = identifiantTitulaire;
    }

    public String getMdpTitulaire() {
        return mdpTitulaire;
    }

    public void setMdpTitulaire(String mdpTitulaire) {
        this.mdpTitulaire = mdpTitulaire;
    }

}
