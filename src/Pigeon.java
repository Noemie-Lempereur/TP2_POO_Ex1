import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

public class Pigeon extends Thread {
    private int coordonnee;

    public enum etatPigeon {
        Endormi, Reveille
    };

    private etatPigeon etat;
    private final Fenetre fenetre;

    public Pigeon(int coordonneeNew,Fenetre fenetre) {
        this.etat = etatPigeon.Reveille;
        this.coordonnee = coordonneeNew;
        this.fenetre=fenetre;
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
                if (fenetre.getNourritures().size() > 0) {
                    this.setEtat(etatPigeon.Reveille);
                    Thread.sleep(1000);
                    int coord = this.getCoordonnee();
                    for (Nourriture n : fenetre.getNourritures()) {
                        if (coord == n.getCoordonneeN() && n.getEtat() != Nourriture.etatNourriture.Perimee) {
                            fenetre.removeNourriture(n);
                            fenetre.removePigeon(this);
                            fenetre.getCells()[coord].setEtat(0);
                            this.interrupt();
                            return;
                        }
                    }
                    if(fenetre.getPlusFraiche()!=null) {
                        if (coord < fenetre.getPlusFraiche().getCoordonneeN()) {
                            boolean deplacementPossible = true;
                            for (Pigeon p : fenetre.getPigeons()) {
                                if (p.getCoordonnee() == coord + 1) {
                                    deplacementPossible = false;
                                    break;
                                }
                            }
                            if (deplacementPossible) {
                                fenetre.getCells()[coord].setEtat(0);
                                fenetre.getCells()[coord].setIcon(new ImageIcon());
                                coord++;
                                fenetre.getCells()[coord].setEtat(1);
                                fenetre.getCells()[coord].setIcon(new ImageIcon("img/pigeon.png"));
                            }
                        } else {
                            boolean deplacementPossible = true;
                            for (Pigeon p : fenetre.getPigeons()) {
                                if (p.getCoordonnee() == coord - 1) {
                                    if (p != this) {
                                        deplacementPossible = false;
                                        break;
                                    }
                                }
                            }
                            if (deplacementPossible) {
                                fenetre.getCells()[coord].setEtat(0);
                                fenetre.getCells()[coord].setIcon(new ImageIcon());
                                coord--;
                                fenetre.getCells()[coord].setEtat(1);
                                fenetre.getCells()[coord].setIcon(new ImageIcon("img/pigeon.png"));
                            }
                        }
                    }
                    this.setCoordonnee(coord);
                    fenetre.resetPlusFraiche();
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
