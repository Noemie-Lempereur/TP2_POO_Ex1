
import javax.swing.*;
import java.util.Date;

public class Nourriture {
    final int tempsPeremption = 5000;
    private int coordonnee;
    private Fenetre fenetre;

    public enum etatNourriture {
        PlusFraiche, Fraiche, Perimee
    }

    private etatNourriture etat;
    private final Date date;

    public Nourriture(int coordonneeNew,Fenetre fenetre) {
        this.etat = etatNourriture.PlusFraiche;
        this.date = new Date();
        this.coordonnee = coordonneeNew;
        this.fenetre = fenetre;
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
            if(fenetre.getCells()[coordonnee].getEtat()!=1) {
                fenetre.getCells()[coordonnee].setIcon(new ImageIcon("img/grainesPerimees.png"));
            }
        } else {
            etat = etatNourriture.Fraiche;
        }
    }

    public void setEtatPlusFraiche() {
        etat = etatNourriture.PlusFraiche;
    }
}
