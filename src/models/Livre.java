package models;

public class Livre {
    private long id;
    private String titre;
    private boolean disponible;
    private String auteur;
    private long reference ;

    public Livre() {
    }

    public Livre(long id, String titre, boolean disponible, String auteur, long ref) {
        this.id = id;
        this.titre = titre;
        this.disponible = disponible;
        this.auteur = auteur;
        this.reference = ref;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public long getReference() {
        return reference;
    }

    public void setReference(long reference) {
        this.reference = reference;
    }

    public void afficherInfos() {
        System.out.println("Les infos sur le livre : " + this);

    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", disponible=" + disponible +
                ", auteur='" + auteur + '\'' +
                ", reference=" + reference +
                '}';
    }

}
