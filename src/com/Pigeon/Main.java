import java.util.ArrayList;

public class Main {
    public static ArrayList<Nourriture> nourritures = new ArrayList<Nourriture>();
    public static ArrayList<Pigeon> pigeons = new ArrayList<Pigeon>();
    public static Nourriture plusFraiche = new Nourriture(0);

    public static void main(String[] args) {
        // Test de nourriture
        Nourriture nourritureTest = new Nourriture(3);
        plusFraiche = nourritureTest;
        nourritures.add(nourritureTest);
        // Test de pigeon
        Pigeon pigeonTest = new Pigeon(11);
        pigeonTest.start();
        pigeons.add(pigeonTest);
        Pigeon pigeonTest2 = new Pigeon(13);
        pigeonTest2.start();
        pigeons.add(pigeonTest2);
        Pigeon pigeonTest3 = new Pigeon(1);
        pigeonTest3.start();
        pigeons.add(pigeonTest3);

        try {
            while (true) {
                // Nourriture
                int coordoonneeNourriture = 0; // à modifier par rapport à l'endroit où clique l'utilisateur
                boolean rajoutNourriture = true;
                int nbNourriture = nourritures.size();

                // Update de la nourriture
                for (Nourriture n : nourritures) {

                    if (n.getEtat() != Nourriture.etatNourriture.PlusFraiche) {
                        n.setEtat();
                    }
                    /*
                     * if (n.getEtat() == Nourriture.etatNourriture.Perimee) {
                     * nourritures.remove(n);
                     * }
                     */

                    // Verification que la coordonnée est libre pour ajouter la nouvelle nourriture
                    if (coordoonneeNourriture != 0 && n.getCoordonneeN() == coordoonneeNourriture && rajoutNourriture) {
                        rajoutNourriture = false;
                    }
                }
                // Ajout de nouvelle nourriture si aucune nourriture à la même place
                if (coordoonneeNourriture != 0 && rajoutNourriture) {
                    if (nbNourriture != 0) {
                        plusFraiche.setEtat();
                    }
                    Nourriture nourriture = new Nourriture(coordoonneeNourriture);
                    plusFraiche = nourriture;
                    nourritures.add(nourriture);

                }

                // Pigeon

                int ajout = 1 + (int) (Math.random() * 500000000);
                if (ajout == 1) {
                    boolean rajoutPigeon = true;
                    int coordAleatoire = 1 + (int) (Math.random() * (Fenetre.TAILLE));
                    for (Pigeon p : pigeons) {
                        // Verification que la coordonnée est libre pour ajouter le nouveau pigeon
                        if (p.getCoordonnee() == coordAleatoire && rajoutPigeon) {
                            rajoutPigeon = false;
                            break;
                        }

                    }
                    if (rajoutPigeon) {
                        Pigeon pigeon = new Pigeon(coordAleatoire);
                        pigeon.start();
                        pigeons.add(pigeon);
                        System.out.println("Ajout pigeon :" + coordAleatoire);
                    }
                }

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
        } catch (Exception e) {
            System.out.println("Erreur dans le main : " + e);
        }
    }
}
