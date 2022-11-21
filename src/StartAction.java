import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartAction implements ActionListener {
    private final Fenetre fenetre;

    public StartAction(Fenetre fenetre){
        this.fenetre=fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.setStartGame(true);
        CreationPigeon creationPigeon = new CreationPigeon(fenetre);
        creationPigeon.start();
        fenetre.getStartButton().setEnabled(false);
        fenetre.getStartButton().setText("Partie commencée");
        fenetre.getStartButton().setOpaque(false);
    }
}
