package models;

public class Adherent {
    private long ID;
    private String prenom;
    private String nom;
    private String cin;
    private long nmTelephone ;

    public Adherent(long ID, String prenom, String nom,String cin, long nmTelephone ) {
        this.ID = ID;
        this.prenom = prenom;
        this.nom = nom;
        this.cin = cin;
        this.nmTelephone = nmTelephone ;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public long getNmTelephone() {
        return nmTelephone;
    }

    public void setNmTelephone(long nmTelephone) {
        this.nmTelephone = nmTelephone;
    }

    public void afficherInfos() {
        System.out.println("Les infos sur l'entities.Adhérent : "+ this);
    }

    @Override
    public String toString() {
        return "entities.Adhérent{" +
                "idAdh=" + ID +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", cin=" + cin +
                ", nmTéléphone=" + nmTelephone +
                '}';
    }
}
