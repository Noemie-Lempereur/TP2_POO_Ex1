public class Pigeon extends Thread{
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

    /*public void start() {
        threadPigeon = new Thread();
        threadPigeon.start();
    }*/

    public void run() {
        try {
            while(this.isAlive()) {
                this.sleep(500);
                System.out.println("Hola");
            }

        } catch (Exception e) {

        }
    }

    /*public void arret(){
        threadPigeon.interrupt();
    }*/
}
