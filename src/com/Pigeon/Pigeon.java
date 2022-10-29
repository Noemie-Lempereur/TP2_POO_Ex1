public class Pigeon extends Thread{
    private int coordonnee;
    public enum etatPigeon {
        Endormi, Reveille
    };
    private Pigeon.etatPigeon etat;
    public Thread threadPigeon;
    public Pigeon(int coordonneeNew) {
        this.etat = etatPigeon.Reveille;
        this.coordonnee = coordonneeNew;
        this.threadPigeon = new Thread();
        threadPigeon.start();
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

    public void start() {
        threadPigeon = new Thread();
        threadPigeon.start();
    }

    public void run() {
        try {
            Thread threadPigeo = currentThread();


        } catch (Exception e) {

        }
    }

    public void arret(){
        threadPigeon.interrupt();
    }
}
