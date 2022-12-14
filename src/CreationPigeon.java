public class CreationPigeon extends Thread {
    private final Fenetre fenetre;

    public CreationPigeon(Fenetre fenetre) {
        this.fenetre = fenetre;
    }

    public void run() {
        while (Thread.currentThread().isAlive()) {
            try {
                int ajout = 1 + (int) (Math.random() * 65000000);
                if (ajout == 1) {
                    int coordonnee = (int) (Math.random() * fenetre.getTAILLE());
                    boolean ajoutPossible = true;
                    for (Pigeon p:fenetre.getPigeons()) {
                        if (p.getCoordonnee() == coordonnee) {
                            ajoutPossible = false;
                            break;
                        }
                    }
                    if(ajoutPossible) {
                        Pigeon pigeon = new Pigeon(coordonnee, fenetre);
                        pigeon.start();
                        fenetre.addPigeon(pigeon);
                    }
                }
            } catch (Exception excep) {
                System.out.println(excep);
            }
        }
    }
}
