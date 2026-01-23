package models;

public class Adhérent {
    private double idAdh;
    private String prenom;
    private String nom;
    private double cin;
    private double nmTéléphone ;

    public Adhérent(double idAdh, String prenom,String nom,double cin,double nmTéléphone ) {
        this.idAdh= idAdh;
        this.prenom = prenom;
        this.nom = nom;
        this.cin = cin;
        this.nmTéléphone = nmTéléphone ;
    }

    public double getIdAdh() {
        return idAdh;
    }

    public void setIdAdh(double idAdh) {
        this.idAdh = idAdh;
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

    public double getCin() {
        return cin;
    }

    public void setCin(double cin) {
        this.cin = cin;
    }

    public double getNmTéléphone() {
        return nmTéléphone;
    }

    public void setNmTéléphone(double nmTéléphone) {
        this.nmTéléphone = nmTéléphone;
    }

    public void afficherInfos() {
        System.out.println("Les infos sur l'entities.Adhérent : "+ this);
    }

    @Override
    public String toString() {
        return "entities.Adhérent{" +
                "idAdh=" + idAdh +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", cin=" + cin +
                ", nmTéléphone=" + nmTéléphone +
                '}';
    }
}
