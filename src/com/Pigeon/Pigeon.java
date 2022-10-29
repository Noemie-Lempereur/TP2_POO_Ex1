public class Pigeon extends Thread {
    private int coordonnee;

    public enum etatPigeon {
        Endormi, Reveille
    };

    private Pigeon.etatPigeon etat;

    public Pigeon(int coordonneeNew) {
        this.etat = etatPigeon.Reveille;
        this.coordonnee = coordonneeNew;
    }

    public int getCoordonnee() {
        return coordonnee;
    }

    public etatPigeon getEtat() {
        return etat;
    }

    public void setCoordonnee(int coordonneeNew) {
        coordonnee = coordonneeNew;
    }

    public void setEtat(etatPigeon etatNew) {
        etat = etatNew;
    }

    /*
     * public void start() {
     * threadPigeon = new Thread();
     * threadPigeon.start();
     * }
     */

    public void run() {
        try {
            while (this.isAlive()) {
                if (Main.plusFraiche.getCoordonneeN() != 0) {
                    Thread.sleep(500);
                    System.out.println("Hola " + this.getCoordonnee());
                    int coord = this.getCoordonnee();
                    if (coord == Main.plusFraiche.getCoordonneeN()) {
                        Main.nourritures.remove(Main.plusFraiche);
                        this.interrupt();
                    }
                    if (coord < Main.plusFraiche.getCoordonneeN()) {
                        coord++;
                    } else {
                        coord--;
                    }
                    this.setCoordonnee(coord);
                    if (coord == Main.plusFraiche.getCoordonneeN()) {
                        Main.nourritures.remove(Main.plusFraiche);
                        this.interrupt();
                    }
                }
            }

        } catch (Exception e) {

        }
    }

    /*
     * public void arret(){
     * threadPigeon.interrupt();
     * }
     */
}
