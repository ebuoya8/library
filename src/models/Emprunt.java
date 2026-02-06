package models;

import java.time.LocalDate;
import java.util.Date;

public class Emprunt {
    private LocalDate date ;
    public Livre livre ;
    public Adherent adherent;


    public Emprunt(LocalDate date, Livre livre, Adherent adherent) {
        this.date = date;
        this.livre = livre;
        this.adherent = adherent;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
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






