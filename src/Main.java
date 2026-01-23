import models.Livre;

import java.util.List;

public static void main(String[] args) {
    List<Livre> listeLivre = new ArrayList<>();


    for (double  i =1 ; i<=10 ; i++) {
        Livre livre = new Livre(i, "titre"+i, true, "auteur"+i);
        listeLivre.add(livre);
    }

   for (int i =0 ; i<10 ; i++) {
       System.out.println( listeLivre.get(i));
   }

}