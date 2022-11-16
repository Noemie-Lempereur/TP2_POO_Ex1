import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        Fenetre frame = new Fenetre();
    }
}
        /*



                // Pigeons effrayés
                int proba = (pigeons.size() - nourritures.size())
                        + (int) (Math.random() * ((999999999 - (pigeons.size() - nourritures.size())) + 1));
                if (proba <= 5) {
                    System.out.println("Les pigeons sont effrayés");
                    for (Pigeon p : pigeons) {
                        boolean[] tab = new boolean[Fenetre.TAILLE];
                        int coordAleatoire = 1 + (int) (Math.random() * (Fenetre.TAILLE));
                        while (tab[coordAleatoire - 1]) {
                            coordAleatoire = 1 + (int) (Math.random() * (Fenetre.TAILLE));
                            tab[coordAleatoire - 1] = true;
                        }
                        p.setCoordonnee(coordAleatoire);
                        System.out.println("p :" + coordAleatoire);
                    }
                }
    }
}*/
