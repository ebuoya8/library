package models;

import java.util.Date;

public class Emprunt {
    private Date date ;
    private Livre livre ;
    private Adherent adherent;

    public Emprunt(Date date, Livre livre, Adherent adherent) {
        this.date = date;
        this.livre = livre;
        this.adherent = adherent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Adherent getAdhérent() {
        return adherent;
    }

    public void setAdhérent(Adherent adherent) {
        this.adherent = adherent;
    }

    public void afficherInfos (){
        System.out.println("les infos sur l'emprunt :"+ this);
    }


    @Override
    public String toString() {
        return "entities.Emprunt{" +
                "date=" + date +
                ", livre=" + livre +
                ", adhérent=" + adherent +
                '}';
    }
}






