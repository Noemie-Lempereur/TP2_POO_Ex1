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
        Pigeon pigeonTest = new Pigeon(12);
        pigeonTest.start();
        pigeons.add(pigeonTest);

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
                    // if (n.getEtat() == Nourriture.etatNourriture.Perimee) {
                    // nourritures.remove(n);
                    /// }
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

            }
        } catch (Exception e) {
            System.out.println("Erreur dans le main : " + e);
        }
    }
}
