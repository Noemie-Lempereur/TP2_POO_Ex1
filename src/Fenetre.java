import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Fenetre extends JFrame {
    private ArrayList<Nourriture> nourritures;
    private ArrayList<Pigeon> pigeons;
    private Nourriture plusFraiche;
    private Cell[] cells;
    private final int TAILLE = 15;
    private boolean startGame;
    private JButton startButton;

    public Fenetre(){
        super();
        this.startGame=false;
        this.nourritures = new ArrayList<>();
        this.pigeons = new ArrayList<>();
        this.plusFraiche = null;
        this.cells = new Cell[TAILLE];

        try {
            final Image backgroundImage = javax.imageio.ImageIO.read(
                    new File("img/fenetre.png"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override
                public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            });
        }catch(Exception e){
            System.out.println(e);
        }
        JPanel panel = new JPanel();
        panel.setBounds(0, 50, 1000, 650);
        JPanel gamePanel = new JPanel(new GridLayout(8, getTAILLE()));

        JPanel start = new JPanel();
        start.setOpaque(false);
        this.startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(100,30));
        startButton.setOpaque(true);
        startButton.setPreferredSize(new Dimension(200,31));
        StartAction startAction = new StartAction(this);
        startButton.addActionListener(startAction);
        start.add(startButton);

        JPanel vide = new JPanel();
        vide.setOpaque(false);
        JPanel vide2 = new JPanel();
        vide2.setOpaque(false);
        JPanel vide3 = new JPanel();
        vide3.setOpaque(false);
        JPanel vide4 = new JPanel();
        vide4.setOpaque(false);
        JPanel vide5 = new JPanel();
        vide5.setOpaque(false);


        JPanel imgPanel = new JPanel(new GridLayout(1, TAILLE, 2,2));
        imgPanel.setOpaque(false);

        for (int i = 0; i < TAILLE ; i++){
            Cell button = new Cell(i,this);
            cells[i]=button;
            imgPanel.add(button);
        }

        JPanel buttonPanel = new JPanel(new GridLayout(1,TAILLE,2,2));
        for(int i=0; i<TAILLE ; i++){
            Button btn = new Button(i,this);
            buttonPanel.add(btn);
        }

        gamePanel.add(vide);
        gamePanel.add(vide2);
        gamePanel.add(vide3);
        gamePanel.add(vide4);
        gamePanel.add(vide5);
        gamePanel.add(imgPanel);
        gamePanel.add(buttonPanel);
        gamePanel.add(start);
        gamePanel.setOpaque(false);
        panel.add(gamePanel);
        panel.setOpaque(false);
        this.add(panel);
        this.setPreferredSize(new Dimension(1500,390));
        this.pack();
        this.setTitle("Pigeon");
        this.setIconImage(new ImageIcon("img/pigeon.png").getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public int getTAILLE() {
        return TAILLE;
    }

    public ArrayList<Nourriture> getNourritures() {
        return nourritures;
    }

    public ArrayList<Pigeon> getPigeons() {
        return pigeons;
    }

    public Nourriture getPlusFraiche() {
        return plusFraiche;
    }

    public void setPlusFraiche(Nourriture plusFraiche) {
        this.plusFraiche = plusFraiche;
    }

    public void addNourriture(Nourriture nourriture){
        for (Nourriture n:nourritures) {
            if(n == plusFraiche){
                n.setEtat();
            }
        }
        nourritures.add(nourriture);
        setPlusFraiche(nourriture);
        cells[nourriture.getCoordonneeN()].setEtat(2);
    }

    public void removeNourriture(Nourriture n){
        nourritures.remove(n);
        cells[n.getCoordonneeN()].setIcon(new ImageIcon());
        cells[n.getCoordonneeN()].setEtat(0);
    }

    public void addPigeon(Pigeon pigeon){
        pigeons.add(pigeon);
        cells[pigeon.getCoordonnee()].setIcon(new ImageIcon("img/pigeon.png"));
        cells[pigeon.getCoordonnee()].setEtat(1);
    }

    public void removePigeon(Pigeon p){
        try {
            cells[p.getCoordonnee()].setIcon(new ImageIcon());
            cells[p.getCoordonnee()].setEtat(0);
            pigeons.remove(p);
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean isStartGame() {
        return startGame;
    }

    public void setStartGame(boolean startGame) {
        this.startGame = startGame;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public Cell[] getCells() {
        return cells;
    }


    public void resetPlusFraiche() {
        if(nourritures.size()>0){
            plusFraiche.setEtat();
            for (Nourriture n:nourritures) {
                n.setEtat();
            }
            plusFraiche=nourritures.get(nourritures.size()-1);
            nourritures.get(nourritures.size()-1).setEtatPlusFraiche();
        }else{
            plusFraiche=null;
        }
    }
}
