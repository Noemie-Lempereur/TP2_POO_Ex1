import javax.swing.*;

public class Cell extends JLabel {
    private int etat;   //etat = 0 : rien sur la case, etat = 1 : pigeon sur la case, etat = 2 : nourriture sur la case

    public Cell() {
        this.setOpaque(false);
        this.setIcon(new ImageIcon());
        this.setText("");
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.BOTTOM);
        this.etat = 0;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
