
import java.util.Date;

public class Nourriture {
    final int tempsPeremption = 5000000;
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

    public void setEtat() {
        Date dateActuelle = new Date();
        long difference = dateActuelle.getTime() - getDate().getTime();
        if (difference > tempsPeremption) {
            etat = etatNourriture.Perimee;
        } else {
            etat = etatNourriture.Fraiche;
        }
    }

    public void setEtatPlusFraiche() {
        etat = etatNourriture.PlusFraiche;
    }

    public void setCoordonnee(int coordonneeNew) {
        coordonnee = coordonneeNew;
    }
}
