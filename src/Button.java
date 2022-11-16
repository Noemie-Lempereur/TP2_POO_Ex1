import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Button extends JButton {
    private Fenetre fenetre;
    private int coordonnee;

    public Button(int coordonnee, Fenetre fenetre) {
        this.fenetre=fenetre;
        this.coordonnee = coordonnee;
        this.setText("Add");
        this.setPreferredSize(new Dimension(62,32));
        this.setBackground(Color.yellow);
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fenetre.isStartGame()) {
                    ArrayList<Nourriture> nourritures = fenetre.getNourritures();
                    for (Nourriture n:nourritures) {
                        if(n.getCoordonneeN()==coordonnee){
                            fenetre.removeNourriture(n);
                            break;
                        }
                    }
                    fenetre.addNourriture(new Nourriture(coordonnee));
                    fenetre.getCells()[coordonnee].setIcon(new ImageIcon("img/graines.png"));
                }
            }
        };
        this.addActionListener(buttonListener);
    }

}
