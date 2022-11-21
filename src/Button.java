import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Button extends JButton {

    public Button(int coordonnee, Fenetre fenetre) {
        this.setText("Add");
        this.setPreferredSize(new Dimension(62,33));
        this.setBackground(Color.yellow);
        ActionListener buttonListener = e -> {
            if(fenetre.isStartGame()) {
                ArrayList<Nourriture> nourritures = fenetre.getNourritures();
                for (Nourriture n:nourritures) {
                    if(n.getCoordonneeN()==coordonnee){
                        fenetre.removeNourriture(n);
                        break;
                    }
                }
                fenetre.addNourriture(new Nourriture(coordonnee,fenetre));
                fenetre.getCells()[coordonnee].setIcon(new ImageIcon("img/graines.png"));
            }
        };
        this.addActionListener(buttonListener);
    }

}
