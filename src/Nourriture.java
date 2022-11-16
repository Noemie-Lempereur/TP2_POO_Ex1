
import java.util.Date;

public class Nourriture {
    //final int tempsPeremption = 500000000;
    private int coordonnee;

    public enum etatNourriture {
        PlusFraiche, Fraiche, Perimee
    }

    private etatNourriture etat;
    private final Date date;

    public Nourriture(int coordonneeNew) {
        this.etat = etatNourriture.PlusFraiche;
        this.date = new Date();
        this.coordonnee = coordonneeNew;
    }

    public etatNourriture getEtat() {
        return etat;
    }

    public Date getDate() {
        return date;
    }

    public int getCoordonneeN() {
        return coordonnee;
    }

    public void setEtat(etatNourriture etat) {
        this.etat = etat;
    }

}
