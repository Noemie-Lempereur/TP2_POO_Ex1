import javax.swing.*;

public class Pigeon extends Thread {
    private int coordonnee;
    private final int numero;
    static int num;

    private final Fenetre fenetre;

    public Pigeon(int coordonneeNew,Fenetre fenetre) {
        this.coordonnee = coordonneeNew;
        this.fenetre=fenetre;
        this.numero=num;
        num++;
    }

    public int getCoordonnee() {
        return coordonnee;
    }

    public void setCoordonnee(int coordonneeNew) {
        coordonnee = coordonneeNew;
    }

    public void run() {
        try {
            while (!this.isInterrupted()) {
                if (fenetre.getNourritures().size() > 0) {
                    //le pigeon est réveillé
                    Thread.sleep(1000);
                    fenetre.resetPlusFraiche();
                    int coord = this.getCoordonnee();
                    fenetre.getCells()[coord].setIcon(new ImageIcon("img/pigeon.png"));
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
                        boolean deplacementPossible = true;
                        if (coord < fenetre.getPlusFraiche().getCoordonneeN()) {
                            for (Pigeon p : fenetre.getPigeons()) {
                                if (p.getCoordonnee() == coord + 1) {
                                    deplacementPossible = false;
                                    break;
                                }
                            }
                            if (deplacementPossible) {
                                fenetre.getCells()[coord].setEtat(0);
                                fenetre.getCells()[coord].setIcon(new ImageIcon());
                                fenetre.getNumeroPig()[coord].setText("");
                                coord++;
                                fenetre.getCells()[coord].setEtat(1);
                                fenetre.getCells()[coord].setIcon(new ImageIcon("img/pigeon.png"));
                                fenetre.getNumeroPig()[coord].setText(""+numero);
                            }
                        } else {
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
                                fenetre.getNumeroPig()[coord].setText("");
                                coord--;
                                fenetre.getCells()[coord].setEtat(1);
                                fenetre.getCells()[coord].setIcon(new ImageIcon("img/pigeon.png"));
                                fenetre.getNumeroPig()[coord].setText(""+numero);
                            }
                        }
                    }
                    this.setCoordonnee(coord);
                    fenetre.resetPlusFraiche();
                }else{
                    //Le pigeon est endormi
                    fenetre.getCells()[this.getCoordonnee()].setIcon(new ImageIcon("img/pigeonDort.png"));
                }
                // Pigeon effrayé
                int aleatoire = (int) (Math.random() * 9999);
                int proba = (int) (Math.random() * (999999999 - aleatoire));
                if (proba <= 3) {
                    int coordAleatoire = (int) (Math.random() * (fenetre.getTAILLE()));
                    while (fenetre.getCells()[coordAleatoire].getEtat()==1) {
                        coordAleatoire = (int) (Math.random() * (fenetre.getTAILLE()));
                    }
                    fenetre.getCells()[this.getCoordonnee()].setEtat(0);
                    fenetre.getCells()[this.getCoordonnee()].setIcon(new ImageIcon(""));
                    this.setCoordonnee(coordAleatoire);
                    fenetre.getCells()[this.getCoordonnee()].setEtat(1);
                    fenetre.getCells()[this.getCoordonnee()].setIcon(new ImageIcon("img/pigeon.png"));
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getNumero() {
        return numero;
    }
}
