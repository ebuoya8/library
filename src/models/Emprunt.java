package models;

import java.util.Date;

public class Emprunt {
    private Date date ;
    private Livre livre ;
    private Adhérent adhérent;

    public Emprunt(Date date, Livre livre, Adhérent adhérent) {
        this.date = date;
        this.livre = livre;
        this.adhérent = adhérent;
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

    public Adhérent getAdhérent() {
        return adhérent;
    }

    public void setAdhérent(Adhérent adhérent) {
        this.adhérent = adhérent;
    }

    public void afficherInfos (){
        System.out.println("les infos sur l'emprunt :"+ this);
    }


    @Override
    public String toString() {
        return "entities.Emprunt{" +
                "date=" + date +
                ", livre=" + livre +
                ", adhérent=" + adhérent +
                '}';
    }
}






