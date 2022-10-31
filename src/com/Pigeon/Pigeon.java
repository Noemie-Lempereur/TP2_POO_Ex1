import java.util.Calendar;
import java.util.Date;

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

    public void run() {
        try {
            while (!this.isInterrupted()) {
                System.out.println("Hola " + this.getCoordonnee());
                if (Main.nourritures.size() > 0) {
                    this.setEtat(etatPigeon.Reveille);
                    Thread.sleep(500);
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

                    System.out.println("Hola " + this.getCoordonnee());
                    if (coord == Main.plusFraiche.getCoordonneeN()) {
                        Main.nourritures.remove(Main.plusFraiche);
                        Main.plusFraiche.setCoordonnee(0);

                        Calendar calendrier = Calendar.getInstance();
                        calendrier.set(Calendar.YEAR, 2000);
                        calendrier.set(Calendar.MONTH, 1);
                        calendrier.set(Calendar.DAY_OF_MONTH, 1);
                        Date DatePlusFraiche = calendrier.getTime();

                        Nourriture NourritureFraiche = new Nourriture(0);
                        for (Nourriture n : Main.nourritures) {
                            if (n.getDate().getTime() - DatePlusFraiche.getTime() > 0) {
                                DatePlusFraiche = n.getDate();
                                NourritureFraiche = n;
                            }
                        }
                        NourritureFraiche.setEtatPlusFraiche();

                        Main.pigeons.remove(this);
                        this.interrupt();
                    }
                } else {
                    this.setEtat(etatPigeon.Endormi);
                }
            }

        } catch (Exception e) {

        }
    }
}
